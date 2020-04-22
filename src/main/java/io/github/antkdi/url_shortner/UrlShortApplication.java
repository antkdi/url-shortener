package io.github.antkdi.url_shortner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by IntelliJ IDEA on 2020-04-18 12:54 </br>
 * PROJECT : "url-shortner"  </br>
 * Department : Matching Technology </br>
 * Cell : AI Part </br>
 * ClassName : UrlShortApplication </br>
 * Descrption :   </br>
 *
 * @author <a href="mailto:antkdi@gmail.com">hyungeun.jung</a>
 * @version 1.0
 */

@SpringBootApplication
@ComponentScan( basePackages = "io.github.antkdi")
public class UrlShortApplication {

    /** Main 메서드 */
    public static void main(String[] args) {
        SpringApplication.run(UrlShortApplication.class, args);
    }
}
