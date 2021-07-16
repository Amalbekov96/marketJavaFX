package kg.kushtar.market.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "product")
public class Product extends BaseEntity{

    private String name;
    private Double price;
    private String barcode;
    private Boolean active;
    @ManyToOne
    private Category category;
}
