package kg.kushtar.market.Service.Impl;

import kg.kushtar.market.Model.Category;
import kg.kushtar.market.Repository.CategoryRepo;
import kg.kushtar.market.Service.CategoryService;
import kg.kushtar.market.Service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, CategoryRepo> implements CategoryService {
}
