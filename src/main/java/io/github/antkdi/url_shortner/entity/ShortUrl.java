package io.github.antkdi.url_shortner.entity;

import lombok.Data;
import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA on 2020-04-18 20:34 </br>
 * PROJECT : "url-shortner"  </br>
 * Department : Matching Technology </br>
 * Cell : AI Part </br>
 * ClassName : ShortUrl </br>
 * Descrption :   </br>
 *
 * @author <a href="mailto:antkdi@gmail.com">hyungeun.jung</a>
 * @version 1.0
 */

@Data
@Entity
@Table(name = "short_url")
public class ShortUrl {

    @Id
    @SequenceGenerator(name="seq_generator", sequenceName = "url_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
    @Column(name = "seq")
    BigInteger seq;
    @Column(name = "short_url")
    private String shortUrl;
    @Column(name="origin_url", nullable = false)
    private String originUrl;
    @Column(name= "req_count")
    private long reqCount;


}
