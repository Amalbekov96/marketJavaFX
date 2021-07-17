package client_app.Service;

import client_app.Model.Category;
import client_app.Model.Product;
import client_app.Service.Impl.CategoryServiceImpl;
import client_app.Service.Impl.ProductServiceImpl;

import java.util.List;

public interface ProductService {
    ProductService INSTANCE = new ProductServiceImpl();

    List<Product> findAll();
    void save(Product product);

}
