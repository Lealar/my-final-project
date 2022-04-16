package com.epam.rd.izh.service;

import com.epam.rd.izh.dao.plane.PlaneDAO;
import com.epam.rd.izh.entity.plane.AircraftCategory;
import com.epam.rd.izh.entity.plane.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
@Service
public class PlaneServiceImpl implements PlaneService{

    @Autowired
    PlaneDAO planeDAO;

    @Autowired
    PictureService pictureService;

    @Override
    @Transactional
    public List<Aircraft> getAllAircraft() {
        return planeDAO.getAllAircraft();
    }

    @Override
    @Transactional
    public List<AircraftCategory> getAircraftCategories() {
        return planeDAO.getAircraftCategories();
    }

    @Override
    @Transactional
    public void saveAircraft(Aircraft aircraft, MultipartFile file) {
        if (aircraft.getAircraftCategory().getId() == null) {
            aircraft.setAircraftCategory(planeDAO.getAircraftCategories(1));
        } else {
            aircraft.setAircraftCategory(planeDAO.getAircraftCategories(aircraft.getAircraftCategory().getId()));
        }
        planeDAO.saveAircraft(aircraft);
        if (file != null){
            String path = "/images/planeIMG/" + aircraft.getId() + ".png";
            aircraft.setImagePath(path);
            pictureService.pictureSaver(file, path);
            planeDAO.saveAircraft(aircraft);
        }

    }

    @Override
    @Transactional
    public void saveAircraftCategories(AircraftCategory aircraftCategory) {
        planeDAO.saveAircraftCategories(aircraftCategory);
    }

    @Override
    @Transactional
    public Aircraft getAircraft(long id) {
        return planeDAO.getAircraft(id);
    }

    @Override
    @Transactional
    public AircraftCategory getAircraftCategories(long id) {
        return planeDAO.getAircraftCategories(id);
    }

    @Override
    @Transactional
    public void deleteAircraft(long id) {
        planeDAO.deleteAircraft(id);

    }

    @Override
    @Transactional
    public void deleteCategories(long id) {
        planeDAO.deleteCategories(id);
    }
}
