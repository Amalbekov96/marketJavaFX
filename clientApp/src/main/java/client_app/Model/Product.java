package client_app.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data

public class Product extends BaseEntity{

    private String name;
    private Double price;
    private String barcode;
    private Boolean active;
    private Category category;
    private Account account;

}
