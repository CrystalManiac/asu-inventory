package asu.edu.ru.inventory.item.data.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"building", "auditory", "floor"})})
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "building")
    private String building;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "auditory")
    private Integer auditory;

    @OneToMany (mappedBy = "location", fetch = FetchType.LAZY)
    private List<Workplace> workplaces;
}
