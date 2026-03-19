package ap1.carlos.caycho.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ap1.carlos.caycho.model.Category;

public interface CategoryRepository extends ReactiveCrudRepository<Category, Long> {
}