package client_app.Model;

import lombok.Data;

@Data
public class Category extends BaseEntity{

    private String name;
    private Boolean active;
}
