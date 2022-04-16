package com.epam.rd.izh.entity.plane;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "aircraft_info")
@Getter
@Setter
@ToString
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "aircraft_name")
    private String aircraftName;

    @Column(name = "passenger_capacity")
    private Integer passengerCapacity;

    @Column(name = "flight_range")
    private Integer flightRange;

    @Column(name = "cruising_speed")
    private Integer cruisingSpeed;

    @Column(name = "image_path")
    private String imagePath;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aircraft_categories")
    private AircraftCategory aircraftCategory;

    public Aircraft(String aircraftName, Integer passengerCapacity, Integer flightRange,
                    Integer cruisingSpeed, AircraftCategory aircraftCategory) {
        this.aircraftName = aircraftName;
        this.passengerCapacity = passengerCapacity;
        this.flightRange = flightRange;
        this.cruisingSpeed = cruisingSpeed;
        this.aircraftCategory = aircraftCategory;
    }

    public Aircraft() {

    }

    public AircraftCategory getAircraftCategory() {
        return aircraftCategory;
    }

    public void setAircraftCategory(AircraftCategory aircraftCategory) {
        this.aircraftCategory = aircraftCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Aircraft aircraft = (Aircraft) o;
        return id != null && Objects.equals(id, aircraft.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
