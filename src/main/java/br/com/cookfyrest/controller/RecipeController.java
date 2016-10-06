package br.com.cookfyrest.controller;

import br.com.cookfyrest.model.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei Andrade on 06/10/2016.
 */
public class RecipeController {
    public List<Recipe> list() {
        return mockList();
    }

    private List<Recipe> mockList() {
        Long id = 1L;
        List<Recipe> recipes = new ArrayList<>();
        Recipe recipe = new Recipe();

        recipe.setId(id++);
        recipe.setName("Bolo");
        recipe.setDescription("Modo de preparo: misture os ingredientes, asse e coma!");
        recipe.setDifficulty("Fácil");
        recipe.setExecutionTime("2h");
        recipes.add(recipe);

        recipe = new Recipe();
        recipe.setId(id++);
        recipe.setName("Massa");
        recipe.setDescription("Modo de preparo: misture massa agua e oleo, tasty!");
        recipe.setDifficulty("Fácil");
        recipe.setExecutionTime("2h");
        recipes.add(recipe);

        recipe = new Recipe();
        recipe.setId(id++);
        recipe.setName("Pastel");
        recipe.setDescription("Modo de preparo: Pegue 2,50 e compre um pastel e um pretinho!");
        recipe.setDifficulty("Easy");
        recipe.setExecutionTime("0,5h");
        recipes.add(recipe);

        recipe = new Recipe();
        recipe.setId(id++);
        recipe.setName("Panqueca");
        recipe.setDescription("Modo de preparo: pega farinha, agua, sal e ovos!");
        recipe.setDifficulty("Medio");
        recipe.setExecutionTime("3h");
        recipes.add(recipe);

        recipe = new Recipe();
        recipe.setId(id++);
        recipe.setName("Trapézio Descendente");
        recipe.setDescription("Modo de preparo: Batata doce com way, birl, pré-treino, negativa!");
        recipe.setDifficulty("Hard");
        recipe.setExecutionTime("60h");
        recipes.add(recipe);

        return recipes;
    }
}
