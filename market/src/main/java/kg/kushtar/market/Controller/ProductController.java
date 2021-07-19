package kg.kushtar.market.Controller;

import kg.kushtar.market.Mapper.ProductMapper;
import kg.kushtar.market.Model.Dto.ProductDto;
import kg.kushtar.market.Model.Product;
import kg.kushtar.market.Service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController implements BaseCrudController<ProductDto, Long>{

    private ProductService productService;
    private ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        return productMapper.toDto(productService.create(productMapper.toEntity(productDto)));
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        return productMapper.toDto(productService.create(productMapper.toEntity(productDto)));
    }

    @Override
    public List<ProductDto> findAll() {
        return productMapper.toDtoList(productService.findAll());
    }

    @Override
    public ProductDto findById(Long aLong) {
        return productMapper.toDto(productService.findById(aLong));
    }

    @Override
    public void deleteById(Long aLong) {
        productService.deleteById(aLong);
    }

}
