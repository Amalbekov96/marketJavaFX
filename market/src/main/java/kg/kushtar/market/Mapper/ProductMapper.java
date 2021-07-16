package kg.kushtar.market.Mapper;

import kg.kushtar.market.Model.Dto.ProductDto;
import kg.kushtar.market.Model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper extends BaseMapper<Product, ProductDto>{

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
}
