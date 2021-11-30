package asu.edu.ru.inventory.item.data.model;

import asu.edu.ru.inventory.constant.model.SoftwareStatus;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "software")
@Data
@TypeDefs({
        @TypeDef(
            name = "pgsql_enum_status",
            typeClass = PostgreSQLEnumType.class,
            defaultForType = SoftwareStatus.class
        )
})
public class Software {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "software_name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum_status")
    @Column(name = "status", columnDefinition = "software_status")
    private SoftwareStatus status;

    @Column(name = "expiration_date")
    private ZonedDateTime expirationDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "workplace_id")
    private Workplace workplace;
}
