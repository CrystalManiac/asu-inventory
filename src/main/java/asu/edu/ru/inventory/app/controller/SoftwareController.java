package asu.edu.ru.inventory.app.controller;

import asu.edu.ru.inventory.api.SoftwareApi;
import asu.edu.ru.inventory.api.model.SoftwareDTO;
import asu.edu.ru.inventory.app.mapper.SoftwareMapper;
import asu.edu.ru.inventory.constant.model.SoftwareStatus;
import asu.edu.ru.inventory.item.data.model.Software;
import asu.edu.ru.inventory.item.service.SoftwareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class SoftwareController implements SoftwareApi {

    private final SoftwareService softwareService;
    private final SoftwareMapper softwareMapper;

    @Autowired
    SoftwareController(SoftwareService softwareService, SoftwareMapper softwareMapper){
        this.softwareMapper = softwareMapper;
        this.softwareService = softwareService;
    }
    
    @Override
    public ResponseEntity<SoftwareDTO> create(SoftwareDTO softwareDTO) {
        Software software = softwareMapper.map(softwareDTO, Software.class);

        return ResponseEntity.ok(softwareMapper.map(softwareService.create(software), SoftwareDTO.class));
    }

    @Override
    public ResponseEntity<List<SoftwareDTO>> getAll() {
        return ResponseEntity.ok(softwareService.getAll().stream()
                .map(hw -> softwareMapper.map(hw, SoftwareDTO.class))
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<SoftwareDTO> findById(Integer id) {
        return ResponseEntity.ok(softwareMapper.map(softwareService.getById(id), SoftwareDTO.class));
    }

    @Override
    public ResponseEntity<List<SoftwareDTO>> getAllByStatus(SoftwareStatus status) {
        return ResponseEntity.ok(softwareService.getByStatus(status).stream()
                .map(hw -> softwareMapper.map(hw, SoftwareDTO.class))
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<SoftwareDTO> update(Integer id, SoftwareDTO newSoftware) {
        Software software = softwareMapper.map(newSoftware, Software.class);

        return ResponseEntity.ok(softwareMapper.map(softwareService.update(id, software), SoftwareDTO.class));

    }

    @Override
    public ResponseEntity<SoftwareDTO> delete(Integer id) {
        return ResponseEntity.ok(softwareMapper.map(softwareService.delete(id), SoftwareDTO.class));
    }
}
