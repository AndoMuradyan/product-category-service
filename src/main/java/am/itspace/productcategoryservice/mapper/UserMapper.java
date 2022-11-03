package am.itspace.productcategoryservice.mapper;

import am.itspace.productcategoryservice.dto.CreateUserDto;
import am.itspace.productcategoryservice.dto.ProductUserDto;
import am.itspace.productcategoryservice.dto.UserDto;
import am.itspace.productcategoryservice.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User map(CreateUserDto createUserDto);

    UserDto map(User user);

    ProductUserDto mapProduct(User user);

    List<ProductUserDto> map(List<User> users);
}
