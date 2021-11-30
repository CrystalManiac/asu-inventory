package asu.edu.ru.inventory.app.mapper;

import asu.edu.ru.inventory.api.model.LocationDTO;
import asu.edu.ru.inventory.item.data.model.Location;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory mapperFactory){
        mapperFactory.classMap(Location.class, LocationDTO.class)
                .byDefault()
                .register();
    }
}
