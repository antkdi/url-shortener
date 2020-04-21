package io.github.antkdi.url_shortner.vo;

import io.github.antkdi.url_shortner.entity.ShortUrl;
import lombok.Data;

@Data
public class ShortUrlResult {

    private ShortUrl shortUrl;
    private ShortUrlType shortUrlType;
    private boolean successFlag;
}

