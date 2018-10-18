package ho.felix.fhwebfluxrest.controllers;

import ho.felix.fhwebfluxrest.domain.Category;
import ho.felix.fhwebfluxrest.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    Flux<Category> list() {
        return categoryRepository.findAll();
    }

    @GetMapping({"/{id}"})
    Mono<Category> getById(@PathVariable String id) {
        return categoryRepository.findById(id);
    }
}
