package io.github.antkdi.url_shortner.controller;

import io.github.antkdi.url_shortner.entity.ShortUrl;
import io.github.antkdi.url_shortner.module.UrlEncoder;
import io.github.antkdi.url_shortner.service.UrlConvertService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * Created by IntelliJ IDEA on 2020-04-18 13:27 </br>
 * PROJECT : "url-shortner"  </br>
 * Department : Matching Technology </br>
 * Cell : AI Part </br>
 * ClassName : UrlShortController </br>
 * Descrption :   </br>
 *
 * @author <a href="mailto:antkdi@saramin.co.kr">hyungeun.jung</a>
 * @version 1.0
 */

@Slf4j
@Controller
public class UrlShortController {

    private final UrlConvertService urlConvertService;

    @Autowired
    UrlEncoder urlEncoder;

    @Autowired
    public UrlShortController(UrlConvertService urlConvertService){
        this.urlConvertService = urlConvertService;
    }

    @RequestMapping(value = "/" , method = {RequestMethod.GET, RequestMethod.POST})
    public String home(@RequestParam(defaultValue = "") String urlStr, Map<String, Object> model) {
        try{
            ShortUrl convertUrl = urlConvertService.getShortenUrl(urlStr);
            model.put("result", urlStr.equals(convertUrl.getOriginUrl()) ? convertUrl.getShortUrl() : convertUrl.getOriginUrl());
            model.put("reqCount", convertUrl.getReqCount());
        }catch(Exception e){
            log.error("Convert Exception For:" + e.getMessage() +", urlStr:" + urlStr);
        }
        return "home";
    }

    @ResponseBody
    @RequestMapping(value = "/test" , method = {RequestMethod.GET, RequestMethod.POST})
    public String test(@RequestParam(defaultValue = "0") String urlStr, Map<String, Object> model) throws Exception{
        return urlEncoder.urlEncoder(urlStr);
    }
}
