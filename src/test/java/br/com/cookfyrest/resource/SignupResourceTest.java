package br.com.cookfyrest.resource;

import br.com.cookfyrest.Main;
import br.com.cookfyrest.model.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by Andrei Andrade on 29/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebAppConfiguration
public class SignupResourceTest extends AbstractTest {
    @Before
    public void setup() throws Exception {
        super.mockMvc = webAppContextSetup(super.webApplicationContext).build();
    }

    @Test
    public void doSignup() throws Exception {
        User user = new User();
        user.setName("Paulo");
        user.setUsername("paulo.paulo");
        user.setHash("paulo");
        user.setAdapter("application");
        user.setDateCreated(new Date());
        user.setDateCreated(new Date());
        user.setPicture("sahusahaushausahsuhsausahs");
        super.mockMvc.perform(post("/signup")
                .content(super.json(user))
                .contentType(super.contentType))
                .andExpect(status().isCreated());
    }
}
