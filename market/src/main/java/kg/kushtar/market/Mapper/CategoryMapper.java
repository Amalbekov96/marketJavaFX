package kg.kushtar.market.Mapper;

import kg.kushtar.market.Model.Category;
import kg.kushtar.market.Model.Dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper extends BaseMapper<Category, CategoryDto>{
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
}
