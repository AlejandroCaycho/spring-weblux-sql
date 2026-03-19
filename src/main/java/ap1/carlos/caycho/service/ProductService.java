package ap1.carlos.caycho.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ap1.carlos.caycho.model.Product;
import ap1.carlos.caycho.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Flux<Product> getAll() {
        return repository.findAll();
    }

    public Mono<Product> getById(Long id) {
        return repository.findById(id);
    }

    public Mono<Product> create(Product product) {
        return repository.save(product);
    }

    public Mono<Product> update(Long id, Product product) {
        return repository.findById(id)
                .flatMap(p -> {
                    p.setName(product.getName());
                    p.setDescription(product.getDescription());
                    p.setPrice(product.getPrice());
                    p.setStock(product.getStock());
                    p.setCategory(product.getCategory());
                    p.setBrand(product.getBrand());
                    p.setAvailable(product.getAvailable());
                    p.setCreatedAt(product.getCreatedAt());
                    return repository.save(p);
                });
    }

    public Mono<Void> delete(Long id) {
        return repository.deleteById(id);
    }
}