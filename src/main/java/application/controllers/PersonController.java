package application.controllers;

import application.Entities.Person;
import application.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {
    private final PersonService personService = new PersonService();
    private final ResidenceService residenceService = new ResidenceService();
    private final RelationshipService relationshipService = new RelationshipService();
    private final RoleTypeService roleTypeService = new RoleTypeService();
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