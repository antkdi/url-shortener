package io.github.antkdi.url_shortner.dao;

import io.github.antkdi.url_shortner.entity.ShortUrl;
import io.github.antkdi.url_shortner.repository.ShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA on 2020-04-18 20:42 </br>
 * PROJECT : "url-shortner"  </br>
 * Department : Matching Technology </br>
 * Cell : AI Part </br>
 * ClassName : UrlShortDao </br>
 * Descrption :   </br>
 *
 * @author <a href="mailto:antkdi@gmail.com">hyungeun.jung</a>
 * @version 1.0
 */

@Repository
public class UrlShortDao {

    private final ShortUrlRepository shortUrlRepository;

    @Autowired
    public UrlShortDao(ShortUrlRepository shortUrlRepository){
        this.shortUrlRepository = shortUrlRepository;
    }

    /**
     * Url을 입력 받아 데이터베이스에 존재 하는지 판단한다.
     * @param url
     * @return
     */
    public boolean exists(String url){
        return shortUrlRepository.existsByShortUrlOrOriginUrl(url, url);
    }

    /**
     * url을 입력받아 저장된 Record 를 가져온다.
     * @param url
     * @return
     */
    public ShortUrl findByUrl(String url){
        return shortUrlRepository.findFirstByShortUrlOrOriginUrlOrderBySeqDesc(url, url);
    }

    /**
     * ShortUrl 저장.
     * @param shortUrl
     * @return
     */
    public ShortUrl save(ShortUrl shortUrl){
        return shortUrlRepository.save(shortUrl);
    }

}
