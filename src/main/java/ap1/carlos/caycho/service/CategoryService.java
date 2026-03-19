package ap1.carlos.caycho.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ap1.carlos.caycho.model.Category;
import ap1.carlos.caycho.repository.CategoryRepository;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public Flux<Category> getAll() {
        return repository.findAll();
    }

    public Mono<Category> getById(Long id) {
        return repository.findById(id);
    }

    public Mono<Category> create(Category category) {
        return repository.save(category);
    }

    public Mono<Category> update(Long id, Category category) {
        return repository.findById(id)
                .flatMap(c -> {
                    c.setName(category.getName());
                    c.setDescription(category.getDescription());
                    c.setStatus(category.getStatus());
                    c.setCreatedAt(category.getCreatedAt());
                    return repository.save(c);
                });
    }

    public Mono<Void> delete(Long id) {
        return repository.deleteById(id);
    }
}