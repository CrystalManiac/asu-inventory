package asu.edu.ru.inventory.api.model;

import asu.edu.ru.inventory.constant.model.HardwareStatus;
import asu.edu.ru.inventory.constant.model.HardwareType;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class HardwareDTO {

    @ApiModelProperty(value = "ID техники")
    private Integer id;

    @ApiModelProperty(value = "Название оборудование")
    private String name;

    @ApiModelProperty(value = "Категория техники")
    private HardwareType type;

    @ApiModelProperty(value = "Статус оборудования")
    private HardwareStatus status;
}
