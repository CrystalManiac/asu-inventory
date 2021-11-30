package asu.edu.ru.inventory.item.data.repository;

import asu.edu.ru.inventory.item.data.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface LocationRepository extends JpaRepository<Location, Integer>, JpaSpecificationExecutor<Location> {

    @Query("select distinct l " +
            "from Location l " +
            "where l.building = :building")
    Optional<List<Location>> findByBuilding(@Param(value = "building") String building);
}
