package io.github.antkdi.url_shortner.vo;

import io.github.antkdi.url_shortner.entity.ShortUrl;
import lombok.Data;

@Data
public class ShortUrlResult {

    //url Entity
    private ShortUrl shortUrl;
    //result Data
    private ShortUrlType shortUrlType;
    //flag
    private boolean successFlag;
}

