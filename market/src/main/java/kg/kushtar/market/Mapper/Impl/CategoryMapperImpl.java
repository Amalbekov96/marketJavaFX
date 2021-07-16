package kg.kushtar.market.Mapper.Impl;

import kg.kushtar.market.Mapper.CategoryMapper;
import kg.kushtar.market.Model.Category;
import kg.kushtar.market.Model.Dto.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public Category toEntity(CategoryDto categoryDto) {
        return CategoryMapper.INSTANCE.toEntity(categoryDto);
    }

    @Override
    public CategoryDto toDto(Category category) {
        return CategoryMapper.INSTANCE.toDto(category);
    }

    @Override
    public List<Category> toEntityList(List<CategoryDto> dtoList) {
        return CategoryMapper.INSTANCE.toEntityList(dtoList);
    }

    @Override
    public List<CategoryDto> toDtoList(List<Category> entityList) {
        return CategoryMapper.INSTANCE.toDtoList(entityList);
    }
}
