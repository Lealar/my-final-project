package com.epam.rd.izh.dao.user;




import com.epam.rd.izh.entity.user.RegisteredUser;
import com.epam.rd.izh.entity.user.User;


import java.util.List;

public interface UsersDAO {

    List<RegisteredUser> getAllUsers();

    void saveUser(RegisteredUser users);


    RegisteredUser getUser(int id);

    void deleteUser(int id);

    boolean isUserRegisteredInService(User user);
}
