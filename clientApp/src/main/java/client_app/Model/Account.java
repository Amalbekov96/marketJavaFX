package client_app.Model;

import lombok.Data;

@Data
public class Account extends BaseEntity {
    private String username;
    private String password;
    private Boolean active;
    private User user;

}
