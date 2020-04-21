package io.github.antkdi.url_shortner;

import com.samskivert.mustache.Mustache;
import org.springframework.boot.autoconfigure.mustache.MustacheEnvironmentCollector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by IntelliJ IDEA on 2020-04-18 20:17 </br>
 * PROJECT : "url-shortner"  </br>
 * Department : Matching Technology </br>
 * Cell : AI Part </br>
 * ClassName : MustacheConfig </br>
 * Descrption :   </br>
 *
 * @author <a href="mailto:antkdi@saramin.co.kr">hyungeun.jung</a>
 * @version 1.0
 */

@Configuration
public class MustacheConfig {

    @Bean
    public Mustache.Compiler mustacheCompiler(Mustache.TemplateLoader mustacheTemplateLoader, Environment environment){
        MustacheEnvironmentCollector collector = new MustacheEnvironmentCollector();
        collector.setEnvironment(environment);

        // default value
        Mustache.Compiler compiler = Mustache.compiler().defaultValue("")
                .withLoader(mustacheTemplateLoader)
                .withCollector(collector);
        return compiler;
    }
}
