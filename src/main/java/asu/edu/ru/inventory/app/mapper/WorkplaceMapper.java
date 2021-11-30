package asu.edu.ru.inventory.app.mapper;

import asu.edu.ru.inventory.api.model.WorkplaceDTO;
import asu.edu.ru.inventory.item.data.model.Workplace;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class WorkplaceMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory mapperFactory){
        mapperFactory.classMap(Workplace.class, WorkplaceDTO.class)
                .byDefault()
                .register();
    }
}
