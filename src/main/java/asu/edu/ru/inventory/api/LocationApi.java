package asu.edu.ru.inventory.api;

import asu.edu.ru.inventory.api.model.LocationDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "location", tags = {"location"})
@RequestMapping(value = "/inventory/location", produces = {APPLICATION_JSON_VALUE})
public interface LocationApi {

    @ApiOperation(value = "Создать новую аудиторию")
    @PostMapping()
    ResponseEntity<LocationDTO> create(@RequestBody LocationDTO location);

    @ApiOperation(value = "Список всех аудиторий")
    @GetMapping()
    ResponseEntity<List<LocationDTO>> getAll();

    @ApiOperation(value = "Список всех аудиторий в указанном здании")
    @GetMapping("/{building}")
    ResponseEntity<List<LocationDTO>> getByBuilding(@PathVariable("building") String building);

    @ApiOperation(value = "Поиск аудитории по ID")
    @GetMapping("/{id}")
    ResponseEntity<LocationDTO> findById(@PathVariable("id") Integer id);

    @ApiOperation(value = "Обновить аудиторию")
    @PutMapping("/{id}")
    ResponseEntity<LocationDTO> update(@PathVariable("id") Integer id,
                                       @RequestBody LocationDTO location);

    @ApiOperation(value = "Удалить аудиторию по ID")
    @DeleteMapping("/{id}")
    ResponseEntity<LocationDTO> delete(@PathVariable("id") Integer id);
}
