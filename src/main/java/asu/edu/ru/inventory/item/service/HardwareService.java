package asu.edu.ru.inventory.item.service;

import asu.edu.ru.inventory.constant.model.HardwareStatus;
import asu.edu.ru.inventory.constant.model.HardwareType;
import asu.edu.ru.inventory.item.data.model.Hardware;
import asu.edu.ru.inventory.item.data.repository.HardwareRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class HardwareService {

    private final HardwareRepository hardwareRepository;

    public Hardware create(Hardware hardware){
        return hardwareRepository.save(hardware);
    }

    public List<Hardware> getAll(){
        return hardwareRepository.findAll();
    }

    public Hardware getById(Integer id){
        return hardwareRepository.findById(id).get();
    }

    public List<Hardware> getByStatus(HardwareStatus status){
        return hardwareRepository.findHardwareByStatus(status).get();
    }

    public List<Hardware> getByStatusAndType(HardwareStatus status, HardwareType type){
        return hardwareRepository.findHardwareByStatusAndType(status, type).get();
    }

    public Hardware update(Integer id, Hardware newHardware){
        Hardware hardware = hardwareRepository.findById(id).get();
        hardware.setName(newHardware.getName());
        hardware.setStatus(newHardware.getStatus());
        hardware.setType(newHardware.getType());
        hardware.setWorkplace(newHardware.getWorkplace());
        return hardwareRepository.save(hardware);
    }

    public Hardware delete(Integer id){
        Hardware deletedHardware = hardwareRepository.findById(id).get();
        hardwareRepository.deleteById(id);
        return deletedHardware;
    }
}
