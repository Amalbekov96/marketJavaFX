package kg.kushtar.market.Controller;

import kg.kushtar.market.Mapper.AccountMapper;
import kg.kushtar.market.Model.Account;
import kg.kushtar.market.Model.Dto.AccountDto;
import kg.kushtar.market.Service.AccountService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController implements BaseCrudController<AccountDto, Long>{

    private AccountService accountService;
    private AccountMapper accountMapper;

    public AccountController(AccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountDto save(AccountDto accountDto) {
        return accountMapper.toDto(accountService.create(accountMapper.toEntity(accountDto)));
    }

    @Override
    public AccountDto update(AccountDto accountDto) {
        return accountMapper.toDto(accountService.create(accountMapper.toEntity(accountDto)));
    }

    @Override
    public List<AccountDto> findAll() {
        return accountMapper.toDtoList(accountService.findAll());
    }

    @Override
    public AccountDto findById(Long aLong) {
        return accountMapper.toDto(accountService.findById(aLong));
    }

    @Override
    public void deleteById(Long aLong) {
        accountService.deleteById(aLong);
    }

    @Override
    public AccountDto findByName(String name) {
        return null;
    }

}
