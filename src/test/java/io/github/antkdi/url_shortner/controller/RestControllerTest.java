package io.github.antkdi.url_shortner.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by IntelliJ IDEA on 2020-04-22 20:30 </br>
 * PROJECT : "url-shortner"  </br>
 * Department : Matching Technology </br>
 * Cell : AI Part </br>
 * ClassName : RestControllerTest </br>
 * Descrption :   </br>
 *
 * @author <a href="mailto:antkdi@gmail.com">hyungeun.jung</a>
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * 컨트롤러 테스트
     * @throws Exception
     */
    @Test
    public void rest_test() throws Exception {

        //given
        String urlStr = "www.naver.com";
        String ret = "{\"shortUrl\":null,\"shortUrlType\":null,\"successFlag\":false}";

        //when
        ResultActions actions = mockMvc.perform(get("/rest/convert")
                .param("urlStr", urlStr)
                .content(ret))
                .andDo(print());

        //then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.shortUrl").isEmpty())
                .andExpect(jsonPath("$.shortUrlType").isEmpty())
                .andExpect(jsonPath("$.successFlag").isBoolean())
        ;
    }

}
