package ap1.carlos.caycho.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ap1.carlos.caycho.model.Product;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
}