package kg.kushtar.market.Mapper.Impl;

import kg.kushtar.market.Mapper.ProductMapper;
import kg.kushtar.market.Model.Dto.ProductDto;
import kg.kushtar.market.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMapperImpl implements ProductMapper {
    @Override
    public Product toEntity(ProductDto productDto) {
        return ProductMapper.INSTANCE.toEntity(productDto);
    }

    @Override
    public ProductDto toDto(Product product) {
        return ProductMapper.INSTANCE.toDto(product);
    }

    @Override
    public List<Product> toEntityList(List<ProductDto> dtoList) {
        return ProductMapper.INSTANCE.toEntityList(dtoList);
    }

    @Override
    public List<ProductDto> toDtoList(List<Product> entityList) {
        return ProductMapper.INSTANCE.toDtoList(entityList);
    }
}
