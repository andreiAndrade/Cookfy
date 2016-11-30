package br.com.cookfyrest.resource;

import br.com.cookfyrest.Main;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by Andrei Andrade on 29/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebAppConfiguration
public class RecipeResourceTest extends AbstractTest {
    @Before
    public void setup() throws Exception {
        super.mockMvc = webAppContextSetup(super.webApplicationContext).build();
    }

    @Test
    public void readRecipes() throws Exception {
        super.mockMvc.perform(get("/recipes")
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }

    @Test
    public void readSingleRecipes() throws Exception {
        super.mockMvc.perform(get("/recipes/1")
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }

    @Test
    public void writeReactToRecipes() throws Exception {
        super.mockMvc.perform(post("/recipes/1/reacts?user=1&react=FAVORITY")
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteReactToRecipes() throws Exception {
        super.mockMvc.perform(post("/recipes/1/reacts?user=2&react=FAVORITY")
                .contentType(super.contentType));
        super.mockMvc.perform(delete("/recipes/1/reacts?user=2&react=FAVORITY")
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }

    @Test
    public void readRecipeByIngredient() throws Exception {
        super.mockMvc.perform(get("/recipes?ingredient=arroz")
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }
    @Test
    public void readRecipeByName() throws Exception {
        super.mockMvc.perform(get("/recipes/search?name=Sopa%20Caipira")
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }
}
