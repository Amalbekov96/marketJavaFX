package kg.kushtar.market.Model.Dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public abstract class BaseEntityDto {

    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime updateDate = LocalDateTime.now();;
}
