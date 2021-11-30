package asu.edu.ru.inventory.api;

import asu.edu.ru.inventory.api.model.WorkplaceDTO;
import asu.edu.ru.inventory.constant.model.WorkplaceStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "workplace", tags = {"workplace"})
@RequestMapping(value = "/inventory/workplace", produces = {APPLICATION_JSON_VALUE})
public interface WorkplaceApi {

    @ApiOperation(value = "Создать новое рабочее место")
    @PostMapping()
    ResponseEntity<WorkplaceDTO> create(@RequestBody WorkplaceDTO workplace);

    @ApiOperation(value = "Список всех рабочих мест")
    @GetMapping("/all")
    ResponseEntity<List<WorkplaceDTO>> getAll();

    @ApiOperation(value = "Поиск рабочего места по ID")
    @GetMapping("/{id}")
    ResponseEntity<WorkplaceDTO> findById(@PathVariable("id") Integer id);

    @ApiOperation(value = "Поиск оборудования по статусу")
    @GetMapping(value = "/getByStatus")
    ResponseEntity<List<WorkplaceDTO>> getAllByStatus(@RequestAttribute("status") WorkplaceStatus status);

    @ApiOperation(value = "Поиск рабочих мест по местонахождению")
    @GetMapping(value = "/getByBuilding")
    ResponseEntity<List<WorkplaceDTO>> getAllByLocation(@RequestAttribute("building") String building);

    @ApiOperation(value = "Поиск рабочих мест по местонахождению")
    @GetMapping(value = "/getByBuildingFloor")
    ResponseEntity<List<WorkplaceDTO>> getAllByLocation(@RequestAttribute("building") String building,
                                                        @RequestAttribute("floor") Integer floor);

    @ApiOperation(value = "Поиск рабочих мест по местонахождению")
    @GetMapping(value = "/getByLocation")
    ResponseEntity<List<WorkplaceDTO>> getAllByLocation(@RequestAttribute("building") String building,
                                                        @RequestAttribute("floor") Integer floor,
                                                        @RequestAttribute("auditory") Integer auditory);

    @ApiOperation(value = "Обновить рабочее место")
    @PutMapping("/{id}")
    ResponseEntity<WorkplaceDTO> update(@PathVariable("id") Integer id,
                                        @RequestBody WorkplaceDTO workplace);

    @ApiOperation(value = "Удалить рабочее место по ID")
    @DeleteMapping("/{id}")
    ResponseEntity<WorkplaceDTO> deleteById(@PathVariable("id") Integer id);

}
