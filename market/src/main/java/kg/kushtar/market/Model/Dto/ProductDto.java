package kg.kushtar.market.Model.Dto;

import kg.kushtar.market.Model.Account;
import kg.kushtar.market.Model.Category;
import lombok.Data;

@Data
public class ProductDto extends BaseEntityDto{

    private String name;
    private Double price;
    private String barcode;
    private Boolean active;
    private Category category;
    private Account account;
}
