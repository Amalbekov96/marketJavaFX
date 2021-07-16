package kg.kushtar.market.Model.Dto;

import lombok.Data;

@Data
public class CategoryDto extends BaseEntityDto {
    private String name;
    private Boolean active;
}
