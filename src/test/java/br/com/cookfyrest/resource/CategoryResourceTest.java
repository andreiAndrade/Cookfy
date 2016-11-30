package br.com.cookfyrest.resource;

import br.com.cookfyrest.Main;
import br.com.cookfyrest.model.entity.Category;
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
 * Created by Andrei Andrade on 27/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebAppConfiguration
public class CategoryResourceTest extends AbstractTest {

    @Before
    public void setup() throws Exception {
        super.mockMvc = webAppContextSetup(super.webApplicationContext).build();

//        this.bookmarkRepository.deleteAllInBatch();
//        this.accountRepository.deleteAllInBatch();
//
//        this.account = accountRepository.save(new Account(userName, "password"));
//        this.bookmarkList.add(bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/" + userName, "A description")));
//        this.bookmarkList.add(bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/2/" + userName, "A description")));
    }

    @Test
    public void readCategories() throws Exception {
        super.mockMvc.perform(get("/categories")
                .content(super.json(new Category()))
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }

    @Test
    public void readSingleCategory() throws Exception {
        super.mockMvc.perform(get("/categories/1")
                .content(this.json(new Category()))
                .contentType(super.contentType))
                .andExpect(status().isOk());
    }

    @Test
    public void singleCategoryNotFound() throws Exception {
        super.mockMvc.perform(get("/categories/100")
                .content(this.json(new Category()))
                .contentType(super.contentType))
                .andExpect(status().isNoContent());
    }
//    @Test
//    public void readSingleBookmark() throws Exception {
//        mockMvc.perform(get("/" + userName + "/bookmarks/"
//                + this.bookmarkList.get(0).getId()))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(contentType))
//                .andExpect(jsonPath("$.id", is(this.bookmarkList.get(0).getId().intValue())))
//                .andExpect(jsonPath("$.uri", is("http://bookmark.com/1/" + userName)))
//                .andExpect(jsonPath("$.description", is("A description")));
//    }
//
//    @Test
//    public void readBookmarks() throws Exception {
//        mockMvc.perform(get("/" + userName + "/bookmarks"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(contentType))
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].id", is(this.bookmarkList.get(0).getId().intValue())))
//                .andExpect(jsonPath("$[0].uri", is("http://bookmark.com/1/" + userName)))
//                .andExpect(jsonPath("$[0].description", is("A description")))
//                .andExpect(jsonPath("$[1].id", is(this.bookmarkList.get(1).getId().intValue())))
//                .andExpect(jsonPath("$[1].uri", is("http://bookmark.com/2/" + userName)))
//                .andExpect(jsonPath("$[1].description", is("A description")));
//    }
//
//    @Test
//    public void createBookmark() throws Exception {
//        String bookmarkJson = json(new Bookmark(
//                this.account, "http://spring.io", "a bookmark to the best resource for Spring news and information"));
//
//        this.mockMvc.perform(post("/" + userName + "/bookmarks")
//                .contentType(contentType)
//                .content(bookmarkJson))
//                .andExpect(status().isCreated());
//    }

}
