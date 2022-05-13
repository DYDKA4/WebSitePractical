package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ControllerMain {

//    @RequestMapping(value = { "/", "/index"})
//    public ModelAndView index() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("main_page.html");
//        return modelAndView;
//    }

    @GetMapping("/main_page")
    public String index(Model model) {
        return "main_page";
    }

    @GetMapping("/error")
    public String error(Model model){
        return "main_page";
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
