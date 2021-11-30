package asu.edu.ru.inventory.item.service;

import asu.edu.ru.inventory.constant.model.WorkplaceStatus;
import asu.edu.ru.inventory.item.data.model.Workplace;
import asu.edu.ru.inventory.item.data.repository.WorkplaceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class WorkplaceService {

    private final WorkplaceRepository workplaceRepository;

    public Workplace create(Workplace workplace) {
        return workplaceRepository.save(workplace);
    }

    public Workplace getById(Integer id){
        return workplaceRepository.findById(id).get();
    }

    public List<Workplace> getByStatus(WorkplaceStatus status){
        return workplaceRepository.findWorkplacesByStatus(status).get();
    }

    public List<Workplace> getByLocation(String building){
        return workplaceRepository.findWorkplacesByLocationBuilding(building).get();
    }

    public List<Workplace> getByLocation(String building, Integer floor){
        return workplaceRepository.findWorkplacesByLocationBuildingAndFloor(building, floor).get();
    }

    public List<Workplace> getByLocation(String building, Integer floor, Integer auditory){
        return workplaceRepository.findWorkplacesByLocation(building, floor, auditory).get();
    }

    public List<Workplace> getAll(){
        return workplaceRepository.findAll();
    }

    public Workplace update(Integer id, Workplace newWorkplace){
        Workplace workplace =  workplaceRepository.findById(id).get();
        workplace.setName(newWorkplace.getName());
        workplace.setLocation(newWorkplace.getLocation());
        workplace.setHardware(newWorkplace.getHardware());
        workplace.setSoftware(newWorkplace.getSoftware());
        workplace.setStatus(newWorkplace.getStatus());
        return workplaceRepository.save(workplace);
    }

    public Workplace delete(Integer id){
        Workplace deletedWorkplace = workplaceRepository.getById(id);
        workplaceRepository.deleteById(id);
        return deletedWorkplace;
    }
}
