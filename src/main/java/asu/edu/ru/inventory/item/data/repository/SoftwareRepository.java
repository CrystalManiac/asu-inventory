package asu.edu.ru.inventory.item.data.repository;

import asu.edu.ru.inventory.constant.model.SoftwareStatus;
import asu.edu.ru.inventory.item.data.model.Software;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface SoftwareRepository  extends JpaRepository<Software, Integer>, JpaSpecificationExecutor<Software> {

    @Query("select distinct sw " +
            "from Software sw " +
            "where sw.status = :status")
    Optional<List<Software>> findSoftwareByStatus(@Param(value = "status") SoftwareStatus status);
}
