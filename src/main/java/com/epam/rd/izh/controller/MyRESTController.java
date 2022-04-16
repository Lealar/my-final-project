package com.epam.rd.izh.controller;

import com.epam.rd.izh.entity.user.RegisteredUser;
import com.epam.rd.izh.exception_handler.NoSuchUserException;
import com.epam.rd.izh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<RegisteredUser> showAllUsers(){
        List<RegisteredUser> allUsers = userService.getAllUsers();
        return allUsers;
    }

    @GetMapping("/users/{id}")
    public RegisteredUser getUser(@PathVariable int id){
        RegisteredUser user = userService.getUser(id);
        if (user == null){
            throw new NoSuchUserException("There is no user with ID = " +
                    id + " in Database");
        }
        return user;
    }

    @PostMapping("/users")
    public RegisteredUser addNewUser(@RequestBody RegisteredUser user){
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/users")
    public RegisteredUser updateUser(@RequestBody RegisteredUser user){
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public  String deleteUser(@PathVariable int id){
        if (userService.getUser(id) == null){
            throw new NoSuchUserException("There is no User with ID= " +
                    id + " in db");
        }
        userService.deleteUser(id);
        return "User with ID= " + id + " was Delete";
    }


}
