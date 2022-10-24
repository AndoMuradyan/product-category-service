package am.itspace.productcategoryservice.service;

import am.itspace.productcategoryservice.dto.CreateProductDto;
import am.itspace.productcategoryservice.mapper.ProductMapper;
import am.itspace.productcategoryservice.model.Product;
import am.itspace.productcategoryservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public void saveProduct(CreateProductDto createProductDto) {
        productRepository.save(productMapper.map(createProductDto));
    }

    public void update(Product product) {
        productRepository.save(product);
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAllByCategoryId(int id) {
        return productRepository.findAllByCategoryId(id);
    }



    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void findById(int id) {
        productRepository.findById(id);
    }
}
