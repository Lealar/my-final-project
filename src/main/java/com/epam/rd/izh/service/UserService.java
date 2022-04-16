package com.epam.rd.izh.service;

import com.epam.rd.izh.entity.user.RegisteredUser;

import com.epam.rd.izh.entity.user.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    List<RegisteredUser> getAllUsers();

    void saveUser(RegisteredUser users);

    void saveUserAndPic(RegisteredUser users, MultipartFile file);

    RegisteredUser getUser(int id);

    void deleteUser(int id);

    boolean isUserRegisteredInService(User user);
}
