package io.github.antkdi.url_shortner.controller;

import io.github.antkdi.url_shortner.entity.ShortUrl;
import io.github.antkdi.url_shortner.service.UrlConvertService;
import io.github.antkdi.url_shortner.vo.ShortUrlResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@CrossOrigin
@RestController
public class ConvertController {

    private final UrlConvertService urlConvertService;

    @Autowired
    public ConvertController(UrlConvertService urlConvertService){
        this.urlConvertService = urlConvertService;
    }

    @GetMapping(value = "/rest/convert")
    ShortUrlResult convert(@RequestParam(defaultValue = "") String urlStr) {
        return urlConvertService.getShortenUrl(urlStr.trim());
    }
}
