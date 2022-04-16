package com.epam.rd.izh.service;

import com.epam.rd.izh.dao.user.UsersDAO;
import com.epam.rd.izh.entity.user.RegisteredUser;

import com.epam.rd.izh.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private PictureService pictureService;

    @Override
    @Transactional /*Открывает и закрывает транзакцию*/
    public List<RegisteredUser> getAllUsers() {
        return usersDAO.getAllUsers();
    }

    @Override
    public void saveUser(RegisteredUser user) {
        if (user.getRole() == null) {
            user.setRole("Customer");
        }
        usersDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void saveUserAndPic(RegisteredUser user, MultipartFile file) {
        if (user.getRole() == null) {
            user.setRole("Customer");
        }
        usersDAO.saveUser(user);
        if (!file.isEmpty()) {
            user.setAvatarPath("/images/usersAvatar/" + user.getId() + ".png");
            pictureService.pictureSaver(file, user.getAvatarPath());
            usersDAO.saveUser(user);
        }
    }

    @Override
    @Transactional
    public RegisteredUser getUser(int id) {
        return usersDAO.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        usersDAO.deleteUser(id);
    }

    @Override
    @Transactional
    public boolean isUserRegisteredInService(User user) {
        return usersDAO.isUserRegisteredInService(user);
    }
}
