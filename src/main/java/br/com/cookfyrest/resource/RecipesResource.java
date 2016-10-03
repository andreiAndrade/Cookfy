package br.com.cookfyrest.resource;

import br.com.cookfyrest.model.Recipe;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Andrei Andrade on 02/10/2016.
 */
@Path("recipes")
public class RecipesResource {
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response recipesDetail(@PathParam("id") Integer id) {
        Recipe recipe = new Recipe();
        recipe.setId(id);
        recipe.setName("Bolo");
        recipe.setDescription("Modo de preparo: misture os ingredientes, asse e coma!");
        recipe.setDifficulty("Fácil");
        recipe.setExecutionTime("2h");

        return Response.ok(recipe).build();
    }

}
