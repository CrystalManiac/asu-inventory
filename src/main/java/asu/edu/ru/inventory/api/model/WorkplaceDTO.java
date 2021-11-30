package asu.edu.ru.inventory.api.model;

import asu.edu.ru.inventory.constant.model.WorkplaceStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class WorkplaceDTO {

    @ApiModelProperty(value = "ID рабочего места")
    private Integer id;

    @ApiModelProperty(value = "Название рабочего места")
    private String name;

    @ApiModelProperty(value = "Местоположение рабочего места")
    private LocationDTO location;

    @ApiModelProperty(value = "Статус рабочего места")
    private WorkplaceStatus status;

    @ApiModelProperty(value = "Список оборудования")
    private List<HardwareDTO> hardware;

    @ApiModelProperty(value = "Список ПО")
    private List<SoftwareDTO> software;
}
