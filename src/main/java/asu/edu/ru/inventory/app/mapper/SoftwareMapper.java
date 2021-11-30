package asu.edu.ru.inventory.app.mapper;

import asu.edu.ru.inventory.api.model.SoftwareDTO;
import asu.edu.ru.inventory.item.data.model.Software;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class SoftwareMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory mapperFactory){
        mapperFactory.classMap(Software.class, SoftwareDTO.class)
                .byDefault()
                .register();
    }
}
