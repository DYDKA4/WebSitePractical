package controllers;

import Entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.*;

import java.sql.Date;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private final PersonService personService = new PersonService();

    @Autowired
    private final ResidenceService residenceService = new ResidenceService();

    @Autowired
    private final RelationshipService relationshipService = new RelationshipService();

    @Autowired
    private final RoleTypeService roleTypeService = new RoleTypeService();

    @Autowired
    private final RelationshipTypeService relationshipTypeService = new RelationshipTypeService();

    @GetMapping("/persons")
    public String peopleListPage(Model model) {
        return "persons";
    }

    @GetMapping("/person")
    public String personPage(@RequestParam(name = "personId") Long personId, Model model) {
        Person person = personService.getPersonById(personId);

//        if (person == null) {
//            model.addAttribute("error_msg", "В базе нет человека с ID = " + personId);
//            return "errorPage";
//        }

        return "person";
    }
}