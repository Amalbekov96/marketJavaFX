package kg.kushtar.market.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "category")
public class Category extends BaseEntity{

    private String name;
    private Boolean active;
}
