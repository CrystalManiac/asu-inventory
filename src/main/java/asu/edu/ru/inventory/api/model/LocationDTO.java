package asu.edu.ru.inventory.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class LocationDTO {
    @ApiModelProperty(value = "ID локации")
    private Integer id;

    @ApiModelProperty(value = "Строение")
    private String building;

    @ApiModelProperty(value = "Этаж")
    private Integer floor;

    @ApiModelProperty(value = "Номер аудитории")
    private Integer auditory;
}
