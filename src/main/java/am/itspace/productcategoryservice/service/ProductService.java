package am.itspace.productcategoryservice.service;

import am.itspace.productcategoryservice.dto.CreateProductDto;
import am.itspace.productcategoryservice.dto.ProductResponseDto;
import am.itspace.productcategoryservice.mapper.ProductMapper;
import am.itspace.productcategoryservice.model.Product;
import am.itspace.productcategoryservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;


    public void saveProduct(CreateProductDto createProductDto) {
        if (createProductDto == null){
            throw new RuntimeException("Product  be null");

        }
        productRepository.save(productMapper.map(createProductDto));
    }

    public Product update(Product product) {
       return productRepository.save(product);
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAllByCategoryId(int id) {
        return productRepository.findAllByCategoryId(id);
    }

    public List<ProductResponseDto> findAll() {
        return productMapper.map(productRepository.findAll());
    }

    public Optional<Product> findById(int id) {
        return productRepository.findById(id);

    }
}
