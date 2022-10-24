package am.itspace.productcategoryservice.mapper;

import am.itspace.productcategoryservice.dto.CreateProductDto;
import am.itspace.productcategoryservice.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product map(CreateProductDto createProductDto);



}
