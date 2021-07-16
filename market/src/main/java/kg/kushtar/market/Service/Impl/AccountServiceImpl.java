package kg.kushtar.market.Service.Impl;

import kg.kushtar.market.Model.Account;
import kg.kushtar.market.Repository.AccountRepo;
import kg.kushtar.market.Service.AccountService;
import kg.kushtar.market.Service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends BaseServiceImpl<Account, AccountRepo> implements AccountService {
    public AccountServiceImpl(AccountRepo accountRepo) {
        super(accountRepo);
    }
}
