package com.epam.rd.izh.controller;

import com.epam.rd.izh.entity.user.RegisteredUser;
import com.epam.rd.izh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class HrController {

    @Autowired
    UserService userService;

    @RequestMapping("/hr")
    public String showHrView(Model model) {
        List<RegisteredUser> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "hr/hr-information";
    }

    @RequestMapping("/hr/addNewUser")
    public String addNewUser(Model model) {
        model.addAttribute("newUser", new RegisteredUser());
        return "hr/userInfoHR";
    }

    @RequestMapping("/hr/addNewUser/saveUser")
    public String saveUser(@ModelAttribute("newUser") RegisteredUser users,
                           @RequestParam("photo") MultipartFile file) {

        userService.saveUserAndPic(users, file);
        return "redirect:/hr";
    }

    @GetMapping("/hr/updateInfo")
    public String updateUser(@RequestParam("userId") int id, Model model) {
        RegisteredUser user = userService.getUser(id);
        model.addAttribute("newUser", user);
        return "hr/userInfoHR";
    }

    @PostMapping("/hr/deleteUser")
    public String deleteUser(@RequestParam("userId") int id) {
        userService.deleteUser(id);
        return "redirect:/hr";

    }




}
