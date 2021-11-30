package asu.edu.ru.inventory.api;

import asu.edu.ru.inventory.api.model.SoftwareDTO;
import asu.edu.ru.inventory.constant.model.SoftwareStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "software", tags = {"software"})
@RequestMapping(value = "/inventory/sw", produces = {APPLICATION_JSON_VALUE})
public interface SoftwareApi {
    @ApiOperation(value = "Создание нового ПО")
    @PostMapping()
    ResponseEntity<SoftwareDTO> create(@RequestBody SoftwareDTO software);

    @ApiOperation(value = "Поиск всего ПО")
    @GetMapping()
    ResponseEntity<List<SoftwareDTO>> getAll();

    @ApiOperation(value = "Поиск ПО по ID")
    @GetMapping("/{id}")
    ResponseEntity<SoftwareDTO> findById(@PathVariable("id") Integer id);

    @ApiOperation(value = "Поиск ПО по статусу")
    @GetMapping("/status/{status}")
    ResponseEntity<List<SoftwareDTO>> getAllByStatus(@PathVariable("status") SoftwareStatus status);

    @ApiOperation(value = "Обновить ПО по ID")
    @PutMapping("/{id}")
    ResponseEntity<SoftwareDTO> update(@PathVariable("id") Integer id,
                                       @RequestBody SoftwareDTO software);

    @ApiOperation(value = "Удалить ПО по ID")
    @DeleteMapping("/{id}")
    ResponseEntity<SoftwareDTO> delete(@PathVariable("id") Integer id);
}
