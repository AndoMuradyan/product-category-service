package am.itspace.productcategoryservice.endpoint;

import am.itspace.productcategoryservice.dto.CreateProductDto;
import am.itspace.productcategoryservice.dto.ProductResponseDto;
import am.itspace.productcategoryservice.dto.UserDto;
import am.itspace.productcategoryservice.model.Product;
import am.itspace.productcategoryservice.security.CurrentUser;
import am.itspace.productcategoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductEndpoint {

    private final ProductService productService;

    @GetMapping()
    public List<ProductResponseDto> getAllProduct() {
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

//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteProductById(@PathVariable("id") int id, @AuthenticationPrincipal CurrentUser currentUser) {
//        Optional<Product> byId = productService.findById(id);
//        if (byId.isPresent()) {
//            Product product = byId.get();
//            if (product.getUser().getId() == currentUser.getUser().getId()) {
//                productService.deleteById(id);
//                return ResponseEntity.ok().build();
//            }
//        }
//
//        return ResponseEntity.noContent().build();
//    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable("id") int id){
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byCategory/{id}")
    public List<Product> CategoryById(@PathVariable("id") int id) {
        return productService.findAllByCategoryId(id);

    }
}
