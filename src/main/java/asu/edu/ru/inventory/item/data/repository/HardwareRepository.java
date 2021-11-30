package asu.edu.ru.inventory.item.data.repository;

import asu.edu.ru.inventory.constant.model.HardwareStatus;
import asu.edu.ru.inventory.constant.model.HardwareType;
import asu.edu.ru.inventory.item.data.model.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface HardwareRepository extends JpaRepository<Hardware, Integer>, JpaSpecificationExecutor<Hardware> {

    @Query("select distinct hw " +
            "from Hardware hw " +
            "where hw.status = :status")
    Optional<List<Hardware>> findHardwareByStatus(@Param(value = "status") HardwareStatus status);

    @Query("select distinct hw " +
            "from Hardware hw " +
            "where hw.status = :status " +
            "and hw.type = :type")
    Optional<List<Hardware>> findHardwareByStatusAndType(@Param(value = "status") HardwareStatus status,
                                                         @Param(value = "type") HardwareType type);
}
