package kg.kushtar.market.Service.Impl;

import kg.kushtar.market.Model.Product;
import kg.kushtar.market.Repository.ProductRepo;
import kg.kushtar.market.Service.ProductService;
import kg.kushtar.market.Service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, ProductRepo> implements ProductService {
    public ProductServiceImpl(ProductRepo productRepo) {
        super(productRepo);
    }
}
