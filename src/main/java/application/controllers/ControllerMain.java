package application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerMain {


    @RequestMapping(value = "/")
    public String MainPage(Model model) {
        return "main_page";
    }

//    }
}
