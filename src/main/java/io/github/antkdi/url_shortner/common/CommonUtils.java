package io.github.antkdi.url_shortner.common;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA on 2020-04-18 19:56 </br>
 * PROJECT : "url-shortner"  </br>
 * Department : Matching Technology </br>
 * Cell : AI Part </br>
 * ClassName : CommonUtils </br>
 * Descrption :   </br>
 *
 * @author <a href="mailto:antkdi@gmail.com">hyungeun.jung</a>
 * @version 1.0
 */

@Component
public class CommonUtils {

    /**
     * Url을 입력받아 url 형식인지 판단한다.
     * @param urlStr
     * @return
     */
    public boolean urlValidationCheck(String urlStr){
        return new UrlValidator().isValid(urlStr);
    }
}
