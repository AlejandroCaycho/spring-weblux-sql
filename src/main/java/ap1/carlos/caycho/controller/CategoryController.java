package ap1.carlos.caycho.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ap1.carlos.caycho.model.Category;
import ap1.carlos.caycho.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    public Flux<Category> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Category> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Mono<Category> create(@RequestBody Category category) {
        return service.create(category);
    }

    @PutMapping("/{id}")
    public Mono<Category> update(@PathVariable Long id, @RequestBody Category category) {
        return service.update(id, category);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return service.delete(id);
    }
}