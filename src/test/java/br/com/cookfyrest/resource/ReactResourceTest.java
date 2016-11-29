package br.com.cookfyrest.resource;

import br.com.cookfyrest.Main;
import br.com.cookfyrest.model.domain.ReactDomain;
import br.com.cookfyrest.model.entity.React;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by Andrei.Richard on 29/11/2016.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Main.class)
//@WebAppConfiguration
public class ReactResourceTest extends AbstractTest {

//    @Before
    public void setup() throws Exception {
        super.mockMvc = webAppContextSetup(super.webApplicationContext).build();
    }

//    @Test
    public void successReact() throws Exception {
        React react = new React();
        react.setReact(ReactDomain.FAVORITY);
        react.setRecipeId(1L);
        react.setUserId(1L);
        super.mockMvc.perform(post("/reacts")
                .content(super.json(react))
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }

//    @Test
    public void failedReact() throws Exception {
        super.mockMvc.perform(post("/reacts")
                .contentType(super.contentType))
                .andExpect(status().isBadRequest());
    }
}
