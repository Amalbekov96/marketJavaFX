package kg.kushtar.market.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity{
    private String name;
}
