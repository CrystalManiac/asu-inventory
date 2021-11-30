package asu.edu.ru.inventory.api.model;

import asu.edu.ru.inventory.constant.model.SoftwareStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class SoftwareDTO {
    @ApiModelProperty(value = "ID ПО")
    private Integer id;

    @ApiModelProperty(value = "Название ПО")
    private String name;

    @ApiModelProperty(value = "Статус ПО")
    private SoftwareStatus status;

    @ApiModelProperty(value = "Дата истечения лицензии")
    private ZonedDateTime expirationDate;
}
