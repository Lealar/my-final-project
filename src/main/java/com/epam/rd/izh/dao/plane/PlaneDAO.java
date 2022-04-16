package com.epam.rd.izh.dao.plane;


import com.epam.rd.izh.entity.plane.AircraftCategory;
import com.epam.rd.izh.entity.plane.Aircraft;

import java.util.List;

public interface PlaneDAO {
    List<Aircraft> getAllAircraft();

    List<AircraftCategory> getAircraftCategories();

    void saveAircraft(Aircraft users);

    void saveAircraftCategories(AircraftCategory aircraftCategory);

    Aircraft getAircraft (long id);

    AircraftCategory getAircraftCategories(long id);

    void deleteAircraft(long id);

    void deleteCategories(long id);



}
