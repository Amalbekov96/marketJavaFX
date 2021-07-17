package client_app.Service;

import client_app.Model.Category;
import client_app.Service.Impl.CategoryServiceImpl;

import java.util.List;

public interface CategoryService {
    CategoryService INSTANCE = new CategoryServiceImpl();
    List<Category> findAll();
    void save(Category category);
    void closeAddWindow();
    Category findById(Long id);
}
