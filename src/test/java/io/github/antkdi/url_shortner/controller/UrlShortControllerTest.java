package io.github.antkdi.url_shortner.controller;

import io.github.antkdi.url_shortner.entity.ShortUrl;
import io.github.antkdi.url_shortner.repository.ShortUrlRepository;
import io.github.antkdi.url_shortner.service.UrlConvertService;
import io.github.antkdi.url_shortner.vo.ShortUrlResult;
import io.github.antkdi.url_shortner.vo.ShortUrlType;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by IntelliJ IDEA on 2020-04-20 18:42 </br>
 * PROJECT : "url-shortner"  </br>
 * Department : Matching Technology </br>
 * Cell : AI Part </br>
 * ClassName : UrlShortControllerTest </br>
 * Descrption :   </br>
 *
 * @author <a href="mailto:antkdi@gmail.com">hyungeun.jung</a>
 * @version 1.0
 */

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
class UrlShortControllerTest {


    @MockBean
    UrlConvertService urlConvertService;

    @Mock
    ShortUrlRepository shortUrlRepository;

    @Mock
    private ConvertController convertController;
    @MockBean
    MainController mainController;
    private MockMvc mockMvc;
    private ModelAndView mv;

    private String urlStr;
    private Map<String, Object> model;
    private MockHttpSession session;
    private MockHttpServletRequest request;

    @BeforeEach
    void setUp() {
        model = new HashMap<>();
        mv = new ModelAndView();
        session = new MockHttpSession();
        request = new MockHttpServletRequest();
        request.setSession(session);
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(convertController).build();
    }

    @Test
    void controllerTest() throws Exception {


        this.mockMvc.perform(get("/rest/convert").param("urlStr","test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(convertController.getClass()))
                .andExpect(handler().methodName("convert"));

    }

    @Test
    void serviceTest() throws Exception {

        this.mockMvc.perform(get("/rest/convert").param("urlStr", "test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(convertController.getClass()))
                //메소드 이름이 read인지 확인
                .andExpect(handler().methodName("read"));

    }

}