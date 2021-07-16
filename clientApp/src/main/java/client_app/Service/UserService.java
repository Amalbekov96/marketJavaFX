package client_app.Service;

import client_app.Model.User;
import client_app.Service.Impl.UserServiceImpl;

import java.util.List;

public interface UserService {
    UserService INSTANCE = new UserServiceImpl();

    User save(User user);
    User findById(Long id);
    User update(User user);
    void deleteById(Long id);
    List<User> findAll();

}
