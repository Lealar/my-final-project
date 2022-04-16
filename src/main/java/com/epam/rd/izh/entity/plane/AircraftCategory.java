package com.epam.rd.izh.entity.plane;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "aircraft_categories")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AircraftCategory {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_category")
    private String nameCategory;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aircraftCategory")
    @ToString.Exclude
    private List<Aircraft> aircraftList;

    public void addAircraftToAircraftList(Aircraft aircraft){
        if (aircraftList == null){
            aircraftList = new ArrayList<>();
        }
        aircraftList.add(aircraft);
        aircraft.setAircraftCategory(this);
    }



    public AircraftCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AircraftCategory that = (AircraftCategory) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
