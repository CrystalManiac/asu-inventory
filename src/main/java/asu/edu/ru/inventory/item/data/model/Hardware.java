package asu.edu.ru.inventory.item.data.model;

import asu.edu.ru.inventory.constant.model.HardwareStatus;
import asu.edu.ru.inventory.constant.model.HardwareType;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name = "hardware")
@Data
@TypeDefs({
        @TypeDef(
                name = "pgsql_enum_status",
                typeClass = PostgreSQLEnumType.class,
                defaultForType = HardwareStatus.class
        ),
        @TypeDef(
                name = "pgsql_enum_type",
                typeClass = PostgreSQLEnumType.class,
                defaultForType = HardwareType.class
        )
})
public class Hardware {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "hardware_name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum_type")
    @Column(name = "type", columnDefinition = "hardware_type")
    private HardwareType type;

    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum_status")
    @Column(name = "status", columnDefinition = "hardware_status")
    private HardwareStatus status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "workplace_id")
    private Workplace workplace;
}
