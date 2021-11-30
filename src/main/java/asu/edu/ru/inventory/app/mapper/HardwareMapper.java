package asu.edu.ru.inventory.app.mapper;

import asu.edu.ru.inventory.api.model.HardwareDTO;
import asu.edu.ru.inventory.item.data.model.Hardware;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class HardwareMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory mapperFactory){
        mapperFactory.classMap(Hardware.class, HardwareDTO.class)
                .byDefault()
                .register();
    }
}
