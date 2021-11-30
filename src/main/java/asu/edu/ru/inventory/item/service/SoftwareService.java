package asu.edu.ru.inventory.item.service;

import asu.edu.ru.inventory.constant.model.SoftwareStatus;
import asu.edu.ru.inventory.item.data.model.Software;
import asu.edu.ru.inventory.item.data.repository.SoftwareRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class SoftwareService {

    private final SoftwareRepository softwareRepository;

    public Software create(Software software){
        return softwareRepository.save(software);
    }

    public List<Software> getAll(){
        return softwareRepository.findAll();
    }

    public Software getById(Integer id){
        return softwareRepository.findById(id).get();
    }

    public List<Software> getByStatus(SoftwareStatus status){
        return softwareRepository.findSoftwareByStatus(status).get();
    }

    public Software update(Integer id, Software newSoftware){
        Software software = softwareRepository.findById(id).get();
        software.setName(newSoftware.getName());
        software.setStatus(newSoftware.getStatus());
        software.setExpirationDate(newSoftware.getExpirationDate());
        software.setWorkplace(newSoftware.getWorkplace());
        return softwareRepository.save(software);
    }

    public Software delete(Integer id){
        Software deletedSoftware = softwareRepository.findById(id).get();
        softwareRepository.deleteById(id);
        return deletedSoftware;
    }
}
