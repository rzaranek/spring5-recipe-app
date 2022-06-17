package guru.springframework.repositories;

import guru.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by robertZ on 2022-06-17.
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
