package kg.kushtar.market.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity

public class Category extends BaseEntity{

    private String name;
    private Boolean active;
}
