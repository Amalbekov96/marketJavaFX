package kg.kushtar.market.Mapper.Impl;

import kg.kushtar.market.Mapper.AccountMapper;
import kg.kushtar.market.Model.Account;
import kg.kushtar.market.Model.Dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountMapperImpl implements AccountMapper {
    @Override
    public Account toEntity(AccountDto accountDto) {
        return AccountMapper.INSTANCE.toEntity(accountDto);
    }

    @Override
    public AccountDto toDto(Account account) {
        return AccountMapper.INSTANCE.toDto(account);
    }

    @Override
    public List<Account> toEntityList(List<AccountDto> dtoList) {
        return AccountMapper.INSTANCE.toEntityList(dtoList);
    }

    @Override
    public List<AccountDto> toDtoList(List<Account> entityList) {
        return AccountMapper.INSTANCE.toDtoList(entityList);
    }
}
