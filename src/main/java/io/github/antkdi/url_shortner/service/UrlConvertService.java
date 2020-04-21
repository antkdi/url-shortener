package io.github.antkdi.url_shortner.service;

import io.github.antkdi.url_shortner.entity.ShortUrl;

import java.util.Map;

/**
 * Created by IntelliJ IDEA on 2020-04-18 14:10 </br>
 * PROJECT : "url-shortner"  </br>
 * Department : Matching Technology </br>
 * Cell : AI Part </br>
 * ClassName : UrlConvertService </br>
 * Descrption :   </br>
 *
 * @author <a href="mailto:antkdi@saramin.co.kr">hyungeun.jung</a>
 * @version 1.0
 */


public interface UrlConvertService {

    ShortUrl getShortenUrl(String url) throws Exception;
}
