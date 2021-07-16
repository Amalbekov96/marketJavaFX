package client_app.Service;

import client_app.Model.Account;
import client_app.Model.User;
import client_app.Service.Impl.AccountServiceImpl;
import client_app.Service.Impl.UserServiceImpl;

import java.util.List;

public interface AccountService {

    AccountService INSTANCE = new AccountServiceImpl();
    Account save(Account account);
    Account findById(Long id);
    Account update(Account account);
    void deleteById(Long id);
    List<Account> findAll();
}
