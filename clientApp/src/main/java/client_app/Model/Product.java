package client_app.Model;

import lombok.Data;

@Data
public class Product {

    private Long id;
    private String name;
    private Double price;
    private String barcode;
    private Boolean active;
    private Category category;

    @Override
    public String toString(){
        return name;
    }
}
