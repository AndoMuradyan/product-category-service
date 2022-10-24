package am.itspace.productcategoryservice.service;

import am.itspace.productcategoryservice.dto.CreateCategoryDto;
import am.itspace.productcategoryservice.mapper.CategoryMapper;
import am.itspace.productcategoryservice.model.Category;
import am.itspace.productcategoryservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public void saveCategory(CreateCategoryDto createCategoryDto) {
        categoryRepository.save(categoryMapper.map(createCategoryDto));

    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }

    public List<Category> findAll() {
       return categoryRepository.findAll();
    }

    public void findById(int id) {
         categoryRepository.findById(id);

    }
}
