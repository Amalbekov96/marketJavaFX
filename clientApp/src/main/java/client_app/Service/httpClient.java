package client_app.Service;

import client_app.Model.*;
import client_app.Service.Impl.httpClientImpl;

import java.util.List;

public interface httpClient {

    httpClient INSTANCE = new httpClientImpl();
    void save(Account account);
    Account findByIdAc(Long id);
    Account update(Account account);
    void deleteById(Long id);
    List<Account> findAllAc();


    List<Category> findAllCa();
    void save(Category category);
    void update(Category category);
    void delete(Long id);
    Category findByIdCa(Long id);

    List<Product> findAllPr();
    void save(Product product);
    void update(Product product);
    void deleteByIdPr(Long id);
    Product findByIdPr(Long id);

    List<User> findAllUs();
    void save(User user);
    void update(User user);
    void deleteByIdUs(Long id);
    User findByIdUs(Long id);
    User findByNameUs(String name);
}
