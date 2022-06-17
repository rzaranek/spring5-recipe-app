package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by robertZ on 2022-06-17.
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasureRepository, Long> {
}
