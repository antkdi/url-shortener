package io.github.antkdi.url_shortner.service.impl;

import io.github.antkdi.url_shortner.common.CommonUtils;
import io.github.antkdi.url_shortner.dao.UrlShortDao;
import io.github.antkdi.url_shortner.entity.ShortUrl;
import io.github.antkdi.url_shortner.module.UrlEncoder;
import io.github.antkdi.url_shortner.service.UrlConvertService;
import io.github.antkdi.url_shortner.vo.ShortUrlResult;
import io.github.antkdi.url_shortner.vo.ShortUrlType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA on 2020-04-18 14:11 </br>
 * PROJECT : "url-shortner"  </br>
 * Department : Matching Technology </br>
 * Cell : AI Part </br>
 * ClassName : UrlConvertServiceImpl </br>
 * Descrption : URL Convert Service </br>
 *
 * @author <a href="mailto:antkdi@gmail.com">hyungeun.jung</a>
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
    public ShortUrlResult getShortenUrl(String url) {
        ShortUrlResult shortUrlResult = new ShortUrlResult();

        ShortUrl shortUrl = new ShortUrl();
        if(!url.isEmpty() && commonUtils.urlValidationCheck(url)){


            if(urlShortDao.exists(url)){
                shortUrl = urlShortDao.findByUrl(url);
                shortUrlResult.setShortUrlType(shortUrl.getShortUrl().equals(url) ? ShortUrlType.ORIGIN:ShortUrlType.SHORT);
                shortUrl.setReqCount(shortUrl.getReqCount()+1);
                shortUrlResult.setShortUrl(shortUrl);
                shortUrlResult.setShortUrlType(ShortUrlType.ORIGIN);
            }else{

                //save Object
                ShortUrl curShortUrl = new ShortUrl();
                curShortUrl.setOriginUrl(url);
                curShortUrl.setReqCount(1);

                //persist - generate sequence
                shortUrl =  urlShortDao.save(curShortUrl);
                //encoding seq
                String encodeUrl = "";
                try{
                    encodeUrl = encodingUrl(String.valueOf(shortUrl.getSeq()));
                }catch(Exception e){
                    e.printStackTrace();
                }finally {
                    shortUrl.setShortUrl(encodeUrl);
                }
                shortUrlResult.setShortUrl(shortUrl);
                shortUrlResult.setShortUrlType(ShortUrlType.SHORT);
            }
            shortUrlResult.setSuccessFlag(true);
        }
        //auto Commit;
        return shortUrlResult;
    }


    // Encode Sequence
    private String encodingUrl(String seqStr) throws Exception{
        return urlEncoder.urlEncoder(seqStr);
    }
}
