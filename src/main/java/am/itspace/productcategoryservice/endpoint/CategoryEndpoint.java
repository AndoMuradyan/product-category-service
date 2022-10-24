package am.itspace.productcategoryservice.endpoint;

import am.itspace.productcategoryservice.dto.CreateCategoryDto;
import am.itspace.productcategoryservice.model.Category;
import am.itspace.productcategoryservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryEndpoint {


    private final CategoryService categoryService;

    @GetMapping()
    public List<Category> getAllCategory() {
        return categoryService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryId(@PathVariable("id") int id) {
        categoryService.findById(id);
        return ResponseEntity.notFound().build();

    }

    @PostMapping()
    public ResponseEntity<?> createCategory(@RequestBody CreateCategoryDto createCategoryDto) {
        categoryService.saveCategory(createCategoryDto);
        return ResponseEntity.ok(createCategoryDto);
    }

    @PutMapping()
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        if (category.getId() == 0) {
            return ResponseEntity.badRequest().build();
        }
        categoryService.updateCategory(category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable("id") int id) {
        categoryService.deleteById(id);
        return ResponseEntity.notFound().build();
    }

}

