package kg.kushtar.market.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity

public class Account extends BaseEntity {

    private String username;
    private String password;
    private Boolean active;
    @ManyToOne
    private User user;

}
