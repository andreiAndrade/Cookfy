package br.com.cookfyrest.resource;

import br.com.cookfyrest.Main;
import br.com.cookfyrest.model.dto.RecipeBookDTO;
import br.com.cookfyrest.model.entity.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by Andrei Andrade on 29/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebAppConfiguration
public class RecipeBookResourceTest extends AbstractTest {
    @Before
    public void setup() throws Exception {
        super.mockMvc = webAppContextSetup(super.webApplicationContext).build();
    }

    @Test
    public void readRecipeBooks() throws Exception {
        super.mockMvc.perform(get("/recipeBook")
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }
    @Test
    public void readSingleRecipeBook() throws Exception {
        super.mockMvc.perform(get("/recipeBook/1")
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }
    @Test
    public void writeSingleRecipeBook() throws Exception {
        RecipeBookDTO recipeBook = new RecipeBookDTO("Melhó Comida", 1L);
        super.mockMvc.perform(post("/recipeBook")
                .content(super.json(recipeBook))
                .contentType(super.contentType))
                .andExpect(status().isCreated());
    }
    @Test
    public void failedWriteSingleRecipeBook() throws Exception {
        super.mockMvc.perform(post("/recipeBook")
                .contentType(super.contentType))
                .andExpect(status().isBadRequest());
    }
    @Test
    public void failedReadSingleRecipeBooks() throws Exception {
        super.mockMvc.perform(get("/recipeBook/50")
                .contentType(super.contentType))
                .andExpect(status().isNoContent());
    }
    @Test
    public void readRecipeBooksByUser() throws Exception {
        super.mockMvc.perform(get("/recipeBook?userId=3")
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }
    @Test
    public void failedReadRecipeBooksByUser() throws Exception {
        super.mockMvc.perform(get("/recipeBook?userId=30")
                .contentType(super.contentType))
                .andExpect(status().isNoContent());
    }
    @Test
    public void writeRecipeInRecipeBook() throws Exception {
        super.mockMvc.perform(post("/recipeBook/1/recipes/1")
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }
    @Test
    public void deleteRecipeFromRecipeBook() throws Exception {
        super.mockMvc.perform(delete("/recipeBook/1/recipes/1")
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }
    @Test
    public void deleteRecipeBook() throws Exception {
        super.mockMvc.perform(delete("/recipeBook/2")
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }
}
