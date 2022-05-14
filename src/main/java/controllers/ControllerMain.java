package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ControllerMain {


    @GetMapping(value = "/")
    public String MainPage(Model model) {
        return "index";
    }

    @GetMapping("/error")
    public String error(Model model){
        return "error";
    }

//    @RequestMapping(value = "/allPersons" )
//    public String allPersons() {
//        return "persons";
//    }
//
//    @RequestMapping(value = "/generateTree")
//    public String generateTree() {
//        return "generateTree";
//    }
}
