package asu.edu.ru.inventory.app.controller;

import asu.edu.ru.inventory.api.WorkplaceApi;
import asu.edu.ru.inventory.api.model.WorkplaceDTO;
import asu.edu.ru.inventory.app.mapper.WorkplaceMapper;
import asu.edu.ru.inventory.constant.model.WorkplaceStatus;
import asu.edu.ru.inventory.item.data.model.Workplace;
import asu.edu.ru.inventory.item.service.WorkplaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class WorkplaceController implements WorkplaceApi {

    private final WorkplaceService workplaceService;
    private final WorkplaceMapper workplaceMapper;

    @Autowired
    WorkplaceController(WorkplaceService workplaceService, WorkplaceMapper workplaceMapper){
        this.workplaceService = workplaceService;
        this.workplaceMapper = workplaceMapper;
    }

    @Override
    public ResponseEntity<WorkplaceDTO> create(WorkplaceDTO workplaceDTO) {
        Workplace workplace = workplaceMapper.map(workplaceDTO, Workplace.class);
        return ResponseEntity.ok(workplaceMapper.map(workplaceService.create(workplace), WorkplaceDTO.class));
    }

    @Override
    public ResponseEntity<List<WorkplaceDTO>> getAll() {
        return ResponseEntity.ok(workplaceService.getAll().stream()
                .map(workplace -> workplaceMapper.map(workplace, WorkplaceDTO.class))
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<WorkplaceDTO> findById(Integer id) {
        return ResponseEntity.ok(workplaceMapper.map(workplaceService.getById(id), WorkplaceDTO.class));
    }

    @Override
    public ResponseEntity<List<WorkplaceDTO>> getAllByStatus(WorkplaceStatus status) {
        List<WorkplaceDTO> workplaces = workplaceService.getByStatus(status).stream()
                .map(wp -> workplaceMapper.map(wp, WorkplaceDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(workplaces);
    }

    @Override
    public ResponseEntity<List<WorkplaceDTO>> getAllByLocation(String building) {
        List<WorkplaceDTO> workplaces = workplaceService.getByLocation(building).stream()
                .map(wp -> workplaceMapper.map(wp, WorkplaceDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(workplaces);
    }

    @Override
    public ResponseEntity<List<WorkplaceDTO>> getAllByLocation(String building, Integer floor) {
        List<WorkplaceDTO> workplaces = workplaceService.getByLocation(building, floor).stream()
                .map(wp -> workplaceMapper.map(wp, WorkplaceDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(workplaces);
    }

    @Override
    public ResponseEntity<List<WorkplaceDTO>> getAllByLocation(String building, Integer floor, Integer auditory) {
        List<WorkplaceDTO> workplaces = workplaceService.getByLocation(building, floor, auditory).stream()
                .map(wp -> workplaceMapper.map(wp, WorkplaceDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(workplaces);
    }

    @Override
    public ResponseEntity<WorkplaceDTO> update(Integer id, WorkplaceDTO newWorkplace) {
        Workplace workplace = workplaceMapper.map(newWorkplace, Workplace.class);

        return ResponseEntity.ok(workplaceMapper.map(workplaceService.update(id, workplace), WorkplaceDTO.class));
    }

    @Override
    public ResponseEntity<WorkplaceDTO> deleteById(Integer id) {
        return ResponseEntity.ok(workplaceMapper.map(workplaceService.delete(id), WorkplaceDTO.class));
    }
}
