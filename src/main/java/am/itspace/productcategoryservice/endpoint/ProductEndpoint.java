package am.itspace.productcategoryservice.endpoint;

import am.itspace.productcategoryservice.dto.CreateProductDto;
import am.itspace.productcategoryservice.model.Product;
import am.itspace.productcategoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductEndpoint {

    private final ProductService productService;

    @GetMapping()
    public List<Product> getAllProduct() {
        return productService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductId(@PathVariable("id") int id) {
        productService.findById(id);
        return ResponseEntity.notFound().build();


    }

    @PostMapping()
    public ResponseEntity<?> createProduct(@RequestBody CreateProductDto createProductDto) {
        productService.saveProduct(createProductDto);
        return ResponseEntity.ok(createProductDto);
    }

    @PutMapping()
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        if (product.getId() == 0) {
            return ResponseEntity.badRequest().build();
        }
        productService.update(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable("id") int id) {
        productService.deleteById(id);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/byCategory/{id}")
    public List<Product> CategoryById(@PathVariable("id") int id) {
        return productService.findAllByCategoryId(id);

    }
}
