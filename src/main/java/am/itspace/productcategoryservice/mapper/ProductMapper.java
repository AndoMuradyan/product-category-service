package am.itspace.productcategoryservice.mapper;

import am.itspace.productcategoryservice.dto.CreateCategoryDto;
import am.itspace.productcategoryservice.dto.CreateProductDto;
import am.itspace.productcategoryservice.dto.ProductResponseDto;
import am.itspace.productcategoryservice.dto.ProductUserDto;
import am.itspace.productcategoryservice.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product map(CreateProductDto createProductDto);

    Product map(ProductResponseDto productResponseDto);

    ProductResponseDto map(ProductUserDto productUserDto);

    ProductResponseDto map(CreateCategoryDto categoryDto);

    List<ProductResponseDto> map(List<Product> productList);

}
