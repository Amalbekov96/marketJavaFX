package kg.kushtar.market.Model.Dto;

import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseEntityDto {

    private Long id;
    private Date createDate;
    private Date updateDate = new Date();
}
