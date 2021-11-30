package asu.edu.ru.inventory.app.controller;

import asu.edu.ru.inventory.api.LocationApi;
import asu.edu.ru.inventory.api.model.LocationDTO;
import asu.edu.ru.inventory.app.mapper.LocationMapper;
import asu.edu.ru.inventory.item.data.model.Location;
import asu.edu.ru.inventory.item.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class LocationController implements LocationApi {
    private final LocationService locationService;
    private final LocationMapper locationMapper;

    @Autowired
    LocationController(LocationService locationService, LocationMapper locationMapper){
        this.locationMapper = locationMapper;
        this.locationService = locationService;
    }

    @Override
    public ResponseEntity<LocationDTO> create(LocationDTO locationDTO) {
        Location location = locationMapper.map(locationDTO, Location.class);
        return ResponseEntity.ok(locationMapper.map(locationService.create(location), LocationDTO.class));
    }

    @Override
    public ResponseEntity<List<LocationDTO>> getAll() {
        return ResponseEntity.ok(locationService.getAll().stream()
                .map(hw -> locationMapper.map(hw, LocationDTO.class))
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<List<LocationDTO>> getByBuilding(String building) {
        return ResponseEntity.ok(locationService.getByBuilding(building).stream()
                .map(hw -> locationMapper.map(hw, LocationDTO.class))
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<LocationDTO> findById(Integer id) {
        return ResponseEntity.ok(locationMapper.map(locationService.getById(id), LocationDTO.class));
    }

    @Override
    public ResponseEntity<LocationDTO> update(Integer id, LocationDTO newLocation) {
        Location location = locationMapper.map(newLocation, Location.class);

        return ResponseEntity.ok(locationMapper.map(locationService.update(id, location), LocationDTO.class));
    }

    @Override
    public ResponseEntity<LocationDTO> delete(Integer id) {
        return ResponseEntity.ok(locationMapper.map(locationService.delete(id), LocationDTO.class));
    }
}
