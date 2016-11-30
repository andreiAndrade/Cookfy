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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by Andrei Andrade on 29/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebAppConfiguration
public class UserResourceTest extends AbstractTest{
    @Before
    public void setup() throws Exception {
        super.mockMvc = webAppContextSetup(super.webApplicationContext).build();
    }
    @Test
    public void deleteUser() throws Exception {
        super.mockMvc.perform(delete("/users")
                .content(super.json(getUser()))
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }
    @Test
    public void updateUser() throws Exception {
        User user = getUser();
        user.setPicture("aaaaaaaa");
        super.mockMvc.perform(put("/users")
                .content(super.json(user))
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }
    @Test
    public void updateUserWithUserId() throws Exception {
        User user = getUser();
        user.setPicture("aaaaaaaa");
        super.mockMvc.perform(put("/users/1")
                .content(super.json(user))
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }
    @Test
    public void readUser() throws Exception {
        super.mockMvc.perform(get("/users/1")
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }
    @Test
    public void failedReadUser() throws Exception {
        super.mockMvc.perform(get("/users/100")
                .contentType(super.contentType))
                .andExpect(status().isNoContent());
    }
    @Test
    public void failedReadReactsByUser() throws Exception {
        super.mockMvc.perform(get("/users/4/reacts")
                .contentType(super.contentType))
                .andExpect(status().isNoContent());
    }
    @Test
    public void readRecipesByUser() throws Exception {
        super.mockMvc.perform(get("/users/1/recipes")
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }
    @Test
    public void failedReadRecipesBooksByUser() throws Exception {
        super.mockMvc.perform(get("/users/4/recipebooks")
                .contentType(super.contentType))
                .andExpect(status().isNoContent());
    }

    private User getUser() {
        User user = new User();
        user.setName("Paulo");
        user.setUsername("paulo.paulo");
        user.setHash("paulo");
        user.setAdapter("application");
        user.setDateCreated(new Date());
        user.setDateCreated(new Date());
        user.setPicture("sahusahaushausahsuhsausahs");

        return user;
    }
}
