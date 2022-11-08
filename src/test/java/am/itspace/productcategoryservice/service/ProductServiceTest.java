package am.itspace.productcategoryservice.service;

import am.itspace.productcategoryservice.dto.CreateProductDto;
import am.itspace.productcategoryservice.mapper.ProductMapper;
import am.itspace.productcategoryservice.model.Category;
import am.itspace.productcategoryservice.model.Product;
import am.itspace.productcategoryservice.model.User;
import am.itspace.productcategoryservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductServiceTest {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;

    @Test
    void saveProduct() {
        CreateProductDto product = CreateProductDto.builder()
                .title("pro")
                .count(12)
                .price(152)
                .category(new Category())
                .build();
        productService.saveProduct(product);
        verify(productRepository, times(1)).save(productMapper.map(product));

    }

    @Test
    void saveProductNull() {
        CreateProductDto product = CreateProductDto.builder()
                .title("pro")
                .count(12)
                .price(152)
                .category(new Category())
                .build();
        when(productRepository.save(any())).thenReturn(product);
        assertThrows(RuntimeException.class, () -> {
            productService.saveProduct(null);
        });

        verify(productRepository, times(0)).save(any());
    }

    @Test
    void update() {
        Product product = Product.builder()
                .id(1)
                .title("pro")
                .count(12)
                .price(152)
                .category(new Category())
                .user(new User())
                .build();
        when(productRepository.save(any())).thenReturn(product);
        Product productUpdate = Product.builder()
                .id(1)
                .title("prod")
                .count(122)
                .price(1502)
                .category(new Category())
                .user(new User())
                .build();
        productService.update(productUpdate);
        verify(productRepository, times(1)).save(any());
    }

    @Test
    void deleteById() {
        Product product = Product.builder()
                .id(1)
                .title("pro")
                .count(12)
                .price(152)
                .category(new Category())
                .user(new User())
                .build();
        productService.deleteById(product.getId());
        verify(productRepository, times(1)).deleteById(product.getId());
    }

    @Test
    void deleteByIdNull() {
        Product product = Product.builder()
                .id(1)
                .title("pro")
                .count(12)
                .price(152)
                .category(new Category())
                .user(new User())
                .build();
        assertEquals(1, product.getId());
        verify(productRepository, times(0)).deleteById(any());
    }

    @Test
    void findAll() {
        productService.findAll();
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void findById() {
    }
}