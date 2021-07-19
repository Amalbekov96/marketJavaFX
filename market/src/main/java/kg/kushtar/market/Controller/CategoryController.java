package kg.kushtar.market.Controller;

import kg.kushtar.market.Mapper.CategoryMapper;
import kg.kushtar.market.Model.Category;
import kg.kushtar.market.Model.Dto.CategoryDto;
import kg.kushtar.market.Service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController implements BaseCrudController<CategoryDto, Long>{

    private CategoryService categoryService;
    private CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return categoryMapper.toDto(categoryService.create(categoryMapper.toEntity(categoryDto)));
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        return categoryMapper.toDto(categoryService.update(categoryMapper.toEntity(categoryDto)));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryMapper.toDtoList(categoryService.findAll());
    }

    @Override
    public CategoryDto findById(Long id) {
        return categoryMapper.toDto(categoryService.findById(id));
    }

    @Override
    public void deleteById(Long aLong) {
        System.out.println(aLong);
        categoryService.deleteById(aLong);
    }

}
