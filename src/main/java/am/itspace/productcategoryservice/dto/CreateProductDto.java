package am.itspace.productcategoryservice.dto;

import am.itspace.productcategoryservice.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProductDto {
    private String title;
    private int count;
    private double price;
    private Category category;
}
