package io.github.antkdi.url_shortner.controller;

import io.github.antkdi.url_shortner.service.UrlConvertService;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by IntelliJ IDEA on 2020-04-20 18:42 </br>
 * PROJECT : "url-shortner"  </br>
 * Department : Matching Technology </br>
 * Cell : AI Part </br>
 * ClassName : UrlShortControllerTest </br>
 * Descrption :   </br>
 *
 * @author <a href="mailto:antkdi@saramin.co.kr">hyungeun.jung</a>
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
class UrlShortControllerTest {


    @Mock
    UrlConvertService urlConvertService;

    @InjectMocks
    private UrlShortController urlShortController;

    private MockMvc mockMvc;
    private ModelAndView mv;

    private String urlStr;
    private Map<String, Object> model;
    private MockHttpSession session;
    private MockHttpServletRequest request;

    @BeforeEach
    void setUp() {
        urlStr = "www.naver.com";
        model = new HashMap<>();
        mv = new ModelAndView();
        session = new MockHttpSession();
        System.out.println("??:"+session.toString());
        request = new MockHttpServletRequest();
        request.setSession(session);
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(urlShortController).build();
    }

    @Test
    void home() throws Exception {

        String urlStr = "www.naver.com";
        Map<String, Object> model = new HashMap<>();
        model.put("result","");
        mockMvc.perform(get("/").session(session)).andExpect(status().isOk())
                .andExpect(content().json(""));

    }

    @Test
    void test1() {
    }
}