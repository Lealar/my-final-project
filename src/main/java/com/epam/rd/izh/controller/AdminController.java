package com.epam.rd.izh.controller;

import com.epam.rd.izh.entity.plane.Aircraft;
import com.epam.rd.izh.entity.plane.AircraftCategory;
import com.epam.rd.izh.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    PlaneService planeService;

    @GetMapping()
    public String greetingAdmin(){
        return "admin/admin_start_page";
    }

    @GetMapping("/aircraft-management")
    public String aircraftManagement(Model model){
        List<Aircraft> aircraftList = planeService.getAllAircraft();
        model.addAttribute("planeList", aircraftList);
        return "admin/aircraft_management";
    }

    @GetMapping("/aircraft-management/create-plane")
    public String createAircraft(Model model){
        List<AircraftCategory> categoriesList = planeService.getAircraftCategories();
        model.addAttribute("planeToUpdate", new Aircraft());
        model.addAttribute("categoriesList", categoriesList);
        return "admin/updatePlane";
    }

    @GetMapping("/aircraft-management/create-category")
    public String createCategory(Model model){
        model.addAttribute("category", new AircraftCategory());
        return "/admin/create_new_category";
    }

    @PostMapping("/aircraft-management/create-category/save")
    public String createCategorySave(@ModelAttribute(name = "category") AircraftCategory category){
        planeService.saveAircraftCategories(category);
        return "redirect:/admin/aircraft-management";
    }

    @GetMapping("/aircraft-management/update")
    public String updateAircraft(Model model,
                                @RequestParam(name = "planeID") long id){

        Aircraft aircraft = planeService.getAircraft(id);
        List<AircraftCategory> categoriesList = planeService.getAircraftCategories();
        model.addAttribute("planeToUpdate", aircraft);
        model.addAttribute("categoriesList", categoriesList);
        return "admin/updatePlane";
    }

    @PostMapping("update/save-aircraft")
    public String saveUpdatedAircraft(@ModelAttribute("planeToUpdate") Aircraft aircraft,
                                      @RequestParam("photo")MultipartFile file){
        planeService.saveAircraft(aircraft, file);
        return "redirect:/admin/aircraft-management";
    }

    @PostMapping("/delete")
    public String deletePlane(@RequestParam("planeID") long id){
        System.out.println(id);
        planeService.deleteAircraft(id);
        return "redirect:/admin/aircraft-management";
    }

}
