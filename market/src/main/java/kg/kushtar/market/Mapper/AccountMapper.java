package kg.kushtar.market.Mapper;

import kg.kushtar.market.Model.Account;
import kg.kushtar.market.Model.Dto.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper extends BaseMapper<Account, AccountDto>{
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
}
