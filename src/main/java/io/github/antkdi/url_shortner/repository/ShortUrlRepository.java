package io.github.antkdi.url_shortner.repository;

import io.github.antkdi.url_shortner.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA on 2020-04-18 20:42 </br>
 * PROJECT : "url-shortner"  </br>
 * Department : Matching Technology </br>
 * Cell : AI Part </br>
 * ClassName : ShortUrlRepository </br>
 * Descrption :   </br>
 *
 * @author <a href="mailto:antkdi@gmail.com">hyungeun.jung</a>
 * @version 1.0
 */

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {

    ShortUrl findFirstByShortUrlOrOriginUrlOrderBySeqDesc(String short_url, String origin_url);
    boolean existsByShortUrlOrOriginUrl(String short_url, String origin_url);
}
