package io.github.antkdi.url_shortner.service;

import io.github.antkdi.url_shortner.vo.ShortUrlResult;

/**
 * Created by IntelliJ IDEA on 2020-04-18 14:10 </br>
 * PROJECT : "url-shortner"  </br>
 * Department : Matching Technology </br>
 * Cell : AI Part </br>
 * ClassName : UrlConvertService </br>
 * Descrption :   </br>
 *
 * @author <a href="mailto:antkdi@gmail.com">hyungeun.jung</a>
 * @version 1.0
 */


public interface UrlConvertService {

    ShortUrlResult getShortenUrl(String url);
}
