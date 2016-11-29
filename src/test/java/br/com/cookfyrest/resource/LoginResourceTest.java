package br.com.cookfyrest.resource;

import br.com.cookfyrest.Main;
import br.com.cookfyrest.model.dto.AuthenticationDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by Andrei.Richard on 29/11/2016.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Main.class)
//@WebAppConfiguration
public class LoginResourceTest extends AbstractTest {

//    @Before
    public void setup() throws Exception {
        super.mockMvc = webAppContextSetup(super.webApplicationContext).build();
    }

//    @Test
    public void successLogin() throws Exception {
        super.mockMvc.perform(get("/login?username=andrei&hash=andrei")
                .content(super.json(new AuthenticationDTO()))
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }

//    @Test
    public void failedLogin() throws Exception {
        super.mockMvc.perform(get("/login?username=jose&hash=jose")
                .content(super.json(new AuthenticationDTO()))
                .contentType(super.contentType))
                .andExpect(status().isNoContent());
    }

//    @Test
    public void requestWithoutParameter() throws Exception {
        super.mockMvc.perform(get("/login")
                .content(super.json(new AuthenticationDTO()))
                .contentType(super.contentType))
                .andExpect(status().isBadRequest());
    }
}
