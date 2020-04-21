package io.github.antkdi.url_shortner.service.impl;

import io.github.antkdi.url_shortner.common.CommonUtils;
import io.github.antkdi.url_shortner.dao.UrlShortDao;
import io.github.antkdi.url_shortner.entity.ShortUrl;
import io.github.antkdi.url_shortner.module.UrlEncoder;
import io.github.antkdi.url_shortner.service.UrlConvertService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA on 2020-04-18 14:11 </br>
 * PROJECT : "url-shortner"  </br>
 * Department : Matching Technology </br>
 * Cell : AI Part </br>
 * ClassName : UrlConvertServiceImpl </br>
 * Descrption : URL Convert Service </br>
 *
 * @author <a href="mailto:antkdi@gmail.">hyungeun.jung</a>
 * @version 1.0
 */

@Slf4j
@Service("urlConvertService")
public class UrlConvertServiceImpl implements UrlConvertService {

    private final CommonUtils commonUtils;
    private final UrlEncoder urlEncoder;
    private final UrlShortDao urlShortDao;

    @Autowired
    public UrlConvertServiceImpl(CommonUtils commonUtils, UrlEncoder urlEncoder, UrlShortDao urlShortDao){
        this.commonUtils = commonUtils;
        this.urlEncoder = urlEncoder;
        this.urlShortDao = urlShortDao;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ShortUrl getShortenUrl(String url) throws Exception {

        ShortUrl shortUrl = new ShortUrl();
        if(!url.isEmpty() && commonUtils.urlValidationCheck(url)){

            if(urlShortDao.exists(url)){

                shortUrl = urlShortDao.findByUrl(url);
                shortUrl.setReqCount(shortUrl.getReqCount()+1);
            }else{

                //save Object
                ShortUrl curShortUrl = new ShortUrl();
                curShortUrl.setOriginUrl(url);
                curShortUrl.setReqCount(1);

                //persist - generate sequence
                shortUrl =  urlShortDao.save(curShortUrl);
                //encoding seq
                shortUrl.setShortUrl(encodingUrl(String.valueOf(shortUrl.getSeq())));
            }
        }
        //auto Commit;
        return shortUrl;
    }


    // Encode Sequence
    private String encodingUrl(String seqStr) throws Exception{
        return urlEncoder.urlEncoder(seqStr);
    }
}
