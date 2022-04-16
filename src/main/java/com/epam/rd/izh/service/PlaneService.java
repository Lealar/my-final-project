package com.epam.rd.izh.service;

import com.epam.rd.izh.entity.plane.AircraftCategory;
import com.epam.rd.izh.entity.plane.Aircraft;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PlaneService {

    List<Aircraft> getAllAircraft();

    List<AircraftCategory> getAircraftCategories();

    void saveAircraft(Aircraft aircraft, MultipartFile file);


    void saveAircraftCategories(AircraftCategory aircraftCategory);

    Aircraft getAircraft (long id);

    AircraftCategory getAircraftCategories(long id);

    void deleteAircraft(long id);

    void deleteCategories(long id);


}
