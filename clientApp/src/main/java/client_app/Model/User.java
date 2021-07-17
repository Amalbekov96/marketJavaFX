package client_app.Model;

import lombok.Data;

@Data
public class User extends BaseEntity{
    private Long id;
    private String name;
}
