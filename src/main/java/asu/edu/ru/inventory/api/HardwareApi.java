package asu.edu.ru.inventory.api;

import asu.edu.ru.inventory.api.model.HardwareDTO;
import asu.edu.ru.inventory.constant.model.HardwareStatus;
import asu.edu.ru.inventory.constant.model.HardwareType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "hardware", tags = {"hardware"})
@RequestMapping(value = "/inventory/hw", produces = {APPLICATION_JSON_VALUE})
public interface HardwareApi {

    @ApiOperation(value = "Создание нового оборудования")
    @PostMapping()
    ResponseEntity<HardwareDTO> create(@RequestBody HardwareDTO hardware);

    @ApiOperation(value = "Поиск всего оборудования")
    @GetMapping()
    ResponseEntity<List<HardwareDTO>> getAll();

    @ApiOperation(value = "Поиск оборудования по ID")
    @GetMapping("/{id}")
    ResponseEntity<HardwareDTO> findById(@PathVariable("id") Integer id);

    @ApiOperation(value = "Поиск оборудования по статусу")
    @GetMapping("/status/{status}")
    ResponseEntity<List<HardwareDTO>> getAllByStatus(@PathVariable("status") HardwareStatus status);

    @ApiOperation(value = "Поиск оборудования по статусу и типу")
    @GetMapping("/status/{status}/type/{type}")
    ResponseEntity<List<HardwareDTO>> getAllByStatusType(@PathVariable("status") HardwareStatus status,
                                                         @PathVariable("type") HardwareType type);

    @ApiOperation(value = "Обновить обрудование по ID")
    @PutMapping("/{id}")
    ResponseEntity<HardwareDTO> update(@PathVariable("id") Integer id,
                                       @RequestBody HardwareDTO hardware);

    @ApiOperation(value = "Удалить обрудование по ID")
    @DeleteMapping("/{id}")
    ResponseEntity<HardwareDTO> delete(@PathVariable("id") Integer id);


}
