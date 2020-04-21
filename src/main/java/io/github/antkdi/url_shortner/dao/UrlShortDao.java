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

    public boolean exists(String url){
        return shortUrlRepository.existsByShortUrlOrOriginUrl(url, url);
    }

    public ShortUrl findByUrl(String url){
        return shortUrlRepository.findFirstByShortUrlOrOriginUrlOrderBySeqDesc(url, url);
    }

    public ShortUrl save(ShortUrl shortUrl){
        return shortUrlRepository.save(shortUrl);
    }

}
