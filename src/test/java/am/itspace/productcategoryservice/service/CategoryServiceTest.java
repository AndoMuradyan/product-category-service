package am.itspace.productcategoryservice.service;


import am.itspace.productcategoryservice.dto.CreateCategoryDto;
import am.itspace.productcategoryservice.mapper.CategoryMapper;
import am.itspace.productcategoryservice.model.Category;
import am.itspace.productcategoryservice.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
class CategoryServiceTest {

    @MockBean
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void saveCategory() {
        CreateCategoryDto category = CreateCategoryDto.builder()
                .name("cat")
                .build();
        categoryService.saveCategory(category);
        verify(categoryRepository, times(1)).save(categoryMapper.map(category));
    }

    @Test
    void saveCategoryNull() {
        CreateCategoryDto category = CreateCategoryDto.builder()
                .name("cat")
                .build();
        when(categoryRepository.save(any())).thenReturn(category);
        assertThrows(RuntimeException.class, () -> {
            categoryService.saveCategory(null);
        });

        verify(categoryRepository, times(0)).save(any());
    }

    @Test
    void updateCategory() {
        Category category = Category.builder()
                .id(1)
                .name("category")
                .build();
        when(categoryRepository.save(any())).thenReturn(category);
        categoryService.updateCategory(category);
        verify(categoryRepository, times(1)).save(category);


    }

    @Test
    void deleteById() {
        Category category = Category.builder()
                .id(1)
                .name("cat")
                .build();
        categoryService.deleteById(category.getId());
        verify(categoryRepository, times(1)).deleteById(category.getId());
    }

    @Test
    void deleteByIdNull() {
        Category category = Category.builder()
                .id(1)
                .name("cat")
                .build();
        assertEquals(1, category.getId());
        verify(categoryRepository, times(0)).deleteById(any());
    }

    @Test
    void findAll() {
        categoryService.findAll();
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    void findById() {
    }
}