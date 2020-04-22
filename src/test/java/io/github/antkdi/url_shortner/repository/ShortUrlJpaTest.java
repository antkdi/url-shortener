package io.github.antkdi.url_shortner.repository;

import io.github.antkdi.url_shortner.entity.ShortUrl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;


/**
 * Created by IntelliJ IDEA on 2020-04-22 20:25 </br>
 * PROJECT : "url-shortner"  </br>
 * Department : Matching Technology </br>
 * Cell : AI Part </br>
 * ClassName : ShortUrlJpaTest </br>
 * Descrption :   </br>
 *
 * @author <a href="mailto:antkdi@gmail.com">hyungeun.jung</a>
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ShortUrlJpaTest {

    @Autowired
    private ShortUrlRepository shortUrlRepository;

    /**
     * Jpa 테스트
     */
    @Test
    public void shortUrlSaveTest(){

        //given
        final String urlStr = "http://www.naver.com";
        final ShortUrl shortUrl = new ShortUrl();
        shortUrl.setReqCount(1);
        shortUrl.setOriginUrl(urlStr);
        shortUrl.setShortUrl("http://test.com/KlkvG");

        //when
        shortUrlRepository.save(shortUrl);
        final ShortUrl savedUrl = shortUrlRepository.findFirstByShortUrlOrOriginUrlOrderBySeqDesc(urlStr, urlStr);

        //then
        Assert.assertThat(shortUrl.getShortUrl(), is(savedUrl.getShortUrl()));
        Assert.assertThat(shortUrl.getOriginUrl(), is(savedUrl.getOriginUrl()));

        //rollback Transaction
    }
}
