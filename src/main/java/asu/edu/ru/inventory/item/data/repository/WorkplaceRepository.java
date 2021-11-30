package asu.edu.ru.inventory.item.data.repository;

import asu.edu.ru.inventory.constant.model.WorkplaceStatus;
import asu.edu.ru.inventory.item.data.model.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface WorkplaceRepository extends JpaRepository<Workplace, Integer>, JpaSpecificationExecutor<Workplace> {

    @Query("select distinct w " +
            "from Workplace w " +
            "where w.status = :status")
    Optional<List<Workplace>> findWorkplacesByStatus(@Param(value = "status") WorkplaceStatus status);

    @Query("select distinct w " +
            "from Workplace w " +
            "where w.location.building = :building")
    Optional<List<Workplace>> findWorkplacesByLocationBuilding(@Param(value = "building") String building);

    @Query("select distinct w " +
            "from Workplace w " +
            "where w.location.building = :building " +
            "and w.location.floor = :floor ")
    Optional<List<Workplace>> findWorkplacesByLocationBuildingAndFloor(@Param(value = "building") String building,
                                                                       @Param(value = "floor") Integer floor);

    @Query("select distinct w " +
            "from Workplace w " +
            "where w.location.building = :building " +
            "and w.location.floor = :floor " +
            "and w.location.auditory = :auditory ")
    Optional<List<Workplace>> findWorkplacesByLocation(@Param(value = "building") String building,
                                                       @Param(value = "floor") Integer floor,
                                                       @Param(value = "auditory") Integer auditory);
}
