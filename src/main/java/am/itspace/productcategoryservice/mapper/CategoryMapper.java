package am.itspace.productcategoryservice.mapper;

import am.itspace.productcategoryservice.dto.CreateCategoryDto;
import am.itspace.productcategoryservice.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category map(CreateCategoryDto createCategoryDto);




}
