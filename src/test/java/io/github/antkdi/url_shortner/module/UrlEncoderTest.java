package io.github.antkdi.url_shortner.module;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA on 2020-04-22 21:09 </br>
 * PROJECT : "url-shortner"  </br>
 * Department : Matching Technology </br>
 * Cell : AI Part </br>
 * ClassName : UrlEncoderTest </br>
 * Descrption :   </br>
 *
 * @author <a href="mailto:antkdi@gmail.com">hyungeun.jung</a>
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlEncoderTest {

    @Autowired
    UrlEncoder urlEncoder;

    /**
     * 모듈 테스트
     * @throws NoSuchAlgorithmException
     */
    @Test
    public void encodingTest() throws NoSuchAlgorithmException {

        //given
        final String url1 = "http://www.gmail.com";
        final String url2 = "https://www.facebook.com";
        final String url3 = "www.korea.com";
        final Map<String, String> keyMap = new HashMap<String, String>(){
            {
                put(url1,"12345");
                put(url2,"23456");
                put(url3,"34567");
            }
        };

        //when
        String result1 = urlEncoder.urlEncoder(keyMap.get(url1));
        String result2 = urlEncoder.urlEncoder(keyMap.get(url2));
        String result3 = urlEncoder.urlEncoder(keyMap.get(url3));

        //then
        Assert.assertEquals(result1, "http://test.com/HND");
        Assert.assertEquals(result2, "http://test.com/UGG");
        Assert.assertEquals(result3, "http://test.com/h9I");

    }
}
