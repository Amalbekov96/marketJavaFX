package kg.kushtar.market.Model.Dto;

import kg.kushtar.market.Model.User;
import lombok.Data;

@Data
public class AccountDto extends BaseEntityDto{
    private String username;
    private String password;
    private Boolean active;

    private User user;
}
