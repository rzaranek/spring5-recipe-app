package guru.springframework.services;

import guru.springframework.domain.Recipe;

import java.util.Set;

/**
 * Created by robertZ on 2022-07-03.
 */
public interface RecipeService {
    Set<Recipe> getRecipes();

}
