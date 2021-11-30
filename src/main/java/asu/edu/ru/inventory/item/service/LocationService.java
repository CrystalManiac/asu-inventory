package asu.edu.ru.inventory.item.service;

import asu.edu.ru.inventory.item.data.model.Location;
import asu.edu.ru.inventory.item.data.repository.LocationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class LocationService {
    private final LocationRepository locationRepository;

    public Location create(Location location){
        return locationRepository.save(location);
    }

    public Location getById(Integer id){
        return locationRepository.findById(id).get();
    }

    public List<Location> getAll(){
        return locationRepository.findAll();
    }

    public List<Location> getByBuilding(String building){
        return locationRepository.findByBuilding(building).get();
    }

    public Location update(Integer id, Location newLocation){
        Location location = locationRepository.findById(id).get();
        location.setAuditory(newLocation.getAuditory());
        location.setBuilding(newLocation.getBuilding());
        location.setFloor(newLocation.getFloor());
        return locationRepository.save(location);
    }

    public Location delete(Integer id){
        Location deletedLocation = locationRepository.findById(id).get();
        locationRepository.deleteById(id);
        return deletedLocation;
    }
}
