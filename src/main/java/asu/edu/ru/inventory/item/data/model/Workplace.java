package asu.edu.ru.inventory.item.data.model;

import asu.edu.ru.inventory.constant.model.WorkplaceStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "workplaces")
@Data
@TypeDefs({
        @TypeDef(
                name = "pgsql_enum_status",
                typeClass = PostgreSQLEnumType.class,
                defaultForType = WorkplaceStatus.class
        )
})
public class Workplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "workplace_name")
    private String name;

    @ManyToOne (optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name = "location_id", nullable = false)
    private Location location;

    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum_status")
    @Column(name = "status", columnDefinition = "software_status")
    private WorkplaceStatus status;

    @OneToMany (mappedBy = "workplace", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<Hardware> hardware;

    @OneToMany (mappedBy = "workplace", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<Software> software;
}
