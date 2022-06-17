package guru.springframework.repositories;

import guru.springframework.domain.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by robertZ on 2022-06-17.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
