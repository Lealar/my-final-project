package com.epam.rd.izh.dao.plane;

import com.epam.rd.izh.entity.plane.AircraftCategory;
import com.epam.rd.izh.entity.plane.Aircraft;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class PlaneDAOImpl implements PlaneDAO {

    @Autowired
    EntityManager entityManager;


    @Override
    public List<Aircraft> getAllAircraft() {
        Session session = entityManager.unwrap(Session.class);
        Query<Aircraft> query =
                session.createQuery("from Aircraft ", Aircraft.class);
        return query.getResultList();
    }

    @Override
    public List<AircraftCategory> getAircraftCategories() {
        Session session = entityManager.unwrap(Session.class);
        Query<AircraftCategory> query = session.createQuery(
                "from AircraftCategory", AircraftCategory.class);

        return query.getResultList();
    }

    @Override
    public void saveAircraft(Aircraft aircraft) {
        entityManager.unwrap(Session.class).saveOrUpdate(aircraft);
    }

    @Override
    public void saveAircraftCategories(AircraftCategory aircraftCategory) {
        entityManager.unwrap(Session.class).saveOrUpdate(aircraftCategory);
    }

    @Override
    public Aircraft getAircraft(long id) {
        return entityManager.unwrap(Session.class).get(Aircraft.class, id);
    }

    @Override
    public AircraftCategory getAircraftCategories(long id) {
        return entityManager.unwrap(Session.class).get(AircraftCategory.class,id);
    }

    @Override
    public void deleteAircraft(long id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Aircraft> query= session.createQuery("delete from Aircraft where id =: aircraftID");
        query.setParameter("aircraftID", id);
        query.executeUpdate();

    }

    @Override
    public void deleteCategories(long id) {
        Session session = entityManager.unwrap(Session.class);
        Query<AircraftCategory> query = session.
                createQuery("delete from AircraftCategory where id =: categoryID");
        query.setParameter("categoryID", id);
        query.executeUpdate();
    }
}

