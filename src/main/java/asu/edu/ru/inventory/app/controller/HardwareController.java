package asu.edu.ru.inventory.app.controller;

import asu.edu.ru.inventory.api.HardwareApi;
import asu.edu.ru.inventory.api.model.HardwareDTO;
import asu.edu.ru.inventory.app.mapper.HardwareMapper;
import asu.edu.ru.inventory.constant.model.HardwareStatus;
import asu.edu.ru.inventory.constant.model.HardwareType;
import asu.edu.ru.inventory.item.data.model.Hardware;
import asu.edu.ru.inventory.item.service.HardwareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class HardwareController implements HardwareApi {

    private final HardwareService hardwareService;
    private final HardwareMapper hardwareMapper;

    @Autowired
    HardwareController(HardwareService hardwareService, HardwareMapper hardwareMapper){
        this.hardwareMapper = hardwareMapper;
        this.hardwareService = hardwareService;
    }

    @Override
    public ResponseEntity<HardwareDTO> create(HardwareDTO hardwareDTO) {
        Hardware hardware = hardwareMapper.map(hardwareDTO, Hardware.class);
        return ResponseEntity.ok(hardwareMapper.map(hardwareService.create(hardware), HardwareDTO.class));
    }

    @Override
    public ResponseEntity<List<HardwareDTO>> getAll() {
        return ResponseEntity.ok(hardwareService.getAll().stream()
                .map(hw -> hardwareMapper.map(hw, HardwareDTO.class))
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<HardwareDTO> findById(Integer id) {
        return ResponseEntity.ok(hardwareMapper.map(hardwareService.getById(id), HardwareDTO.class));
    }

    @Override
    public ResponseEntity<List<HardwareDTO>> getAllByStatus(HardwareStatus status) {
        return ResponseEntity.ok(hardwareService.getByStatus(status).stream()
                .map(hw -> hardwareMapper.map(hw, HardwareDTO.class))
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<List<HardwareDTO>> getAllByStatusType(HardwareStatus status, HardwareType type) {
        return ResponseEntity.ok(hardwareService.getByStatusAndType(status, type).stream()
                .map(hw -> hardwareMapper.map(hw, HardwareDTO.class))
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<HardwareDTO> update(Integer id, HardwareDTO newHardware) {
        Hardware hardware = hardwareMapper.map(newHardware, Hardware.class);

        return ResponseEntity.ok(hardwareMapper.map(hardwareService.update(id, hardware), HardwareDTO.class));
    }

    @Override
    public ResponseEntity<HardwareDTO> delete(Integer id) {
        return ResponseEntity.ok(hardwareMapper.map(hardwareService.delete(id), HardwareDTO.class));
    }
}
