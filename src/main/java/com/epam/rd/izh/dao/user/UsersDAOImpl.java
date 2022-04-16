package com.epam.rd.izh.dao.user;


import com.epam.rd.izh.entity.user.RegisteredUser;

import com.epam.rd.izh.entity.user.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class UsersDAOImpl implements UsersDAO {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<RegisteredUser> getAllUsers() {
        Session session = entityManager.unwrap(Session.class);
        Query<RegisteredUser> query = session.createQuery("from RegisteredUser", RegisteredUser.class);
        return query.getResultList();

    }

    @Override
    public void saveUser(RegisteredUser user) {
        entityManager.unwrap(Session.class).saveOrUpdate(user);
    }

    @Override
    public RegisteredUser getUser(int id) {
        return entityManager.unwrap(Session.class).get(RegisteredUser.class, id);
    }

    @Override
    public void deleteUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<RegisteredUser> query = session.
                createQuery("delete from RegisteredUser where id =: userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }

    @Override
    public boolean isUserRegisteredInService(User user) {
        List<RegisteredUser> registeredUsers = getAllUsers();

        return registeredUsers.stream().anyMatch(usr -> usr.getLogin().equals(user.getLogin())
                && usr.getPassword().equals(user.getPassword()));
    }

}
