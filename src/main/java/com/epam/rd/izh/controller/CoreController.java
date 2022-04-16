package com.epam.rd.izh.controller;


import com.epam.rd.izh.entity.plane.Aircraft;
import com.epam.rd.izh.entity.plane.AircraftCategory;
import com.epam.rd.izh.entity.user.LoginUser;
import com.epam.rd.izh.entity.user.RegisteredUser;
import com.epam.rd.izh.service.PlaneService;
import com.epam.rd.izh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.util.List;


@Controller
public class CoreController {

    @Autowired
    private UserService usersServices;

    @Autowired
    private PlaneService planeService;

    @GetMapping("/")
    public String startPage() {
        return "core/welcomeNew";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        List<AircraftCategory> categoryList = planeService.getAircraftCategories();
        model.addAttribute("categoryList",categoryList);
        List<Aircraft> aircraftList = planeService.getAllAircraft();
        model.addAttribute("aircraftList", aircraftList);
        return "core/home";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("loginUser", new LoginUser());
        return "core/login";
    }


    @RequestMapping("/registration")
    public String registrationView(Model model) {
        model.addAttribute("newRegisteredUser", new RegisteredUser());
        return "core/registration/registration";
    }

    @PostMapping("/registration/success-registration")
    public String successRegistration(@Valid @ModelAttribute("newRegisteredUser") RegisteredUser registeredUser
            , BindingResult bindingResult, MultipartFile file) {
        /*Проверка на валидацию*/
        if (bindingResult.hasErrors()) {
            return "core/registration/registration";
        }
        usersServices.saveUser(registeredUser);
        return "core/registration/successRegistrationNEW";
    }

    @PostMapping("/login/success-login")
    public String congratulationUser(@ModelAttribute("loginUser") LoginUser loginUser) {
        if (usersServices.isUserRegisteredInService(loginUser)) {
            return "core/registration/successLoginNEW";
        }
        return "redirect:/login";

    }

}
