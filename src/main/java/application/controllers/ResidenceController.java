package application.controllers;

import application.Entities.*;
import application.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class ResidenceController {
    private final PersonService personService = new PersonService();
    private final ResidenceService residenceService = new ResidenceService();
    private final RelationshipService relationshipService = new RelationshipService();
    private final RoleTypeService roleTypeService = new RoleTypeService();
    private final RelationshipTypeService relationshipTypeService = new RelationshipTypeService();
    private final PersonController personController = new PersonController();


    @GetMapping("/residence")
    public String Residence(
            @RequestParam(name = "placeId") Long id,
            Model model) {
        model.addAttribute("residence",residenceService.getResidenceById(id));

        return "residence";
    }

    @GetMapping("/editResidence")
    public String editPerson(
            @RequestParam(name = "residenceId") Long id,
            Model model
    ) {
        model.addAttribute("residence", residenceService.getResidenceById(id));
        return "/editResidence";
    }

    @PostMapping("/saveEditResidence")
    public String saveEditPerson(
            @RequestParam(name = "residenceId") Long id,
            @RequestParam(name = "address") String address,
            @RequestParam(name = "check_in") String check_in,
            @RequestParam(name = "check_out") String check_out,
            @RequestParam(name = "personId") Long personId,
            Model model
    ) {
        Residence residence;
        if(Objects.equals(check_out, "Неизвестно")){
            residence = new Residence(id,personService.getPersonById(personId),address,Date.valueOf(check_in),null);
        }
        else {
            residence = new Residence(id,personService.getPersonById(personId),address,Date.valueOf(check_in),Date.valueOf(check_out));
        }
        residenceService.updateResidence(residence);
        return personController.personPage(personId,model);
    }

    @PostMapping("/deleteResidence")
    public String deleteResidence(
            @RequestParam(name = "residenceId") Long residenceId,
            Model model
    ) {
        long personId = residenceService.getResidenceById(residenceId).getPerson().getId();
        residenceService.deleteResidence(residenceService.getResidenceById(residenceId));
        return personController.personPage(personId,model);
    }
    @GetMapping("/addResidence")
    public String addResidence(
            @RequestParam(name = "personId") Long personId,
            Model model
    ) {
        model.addAttribute("personId",personId);

        return "addResidence";
    }
    @PostMapping("/saveResidence")
    public String saveResidence(
            @RequestParam(name = "personId") Long personId,
            @RequestParam(name = "check_in") String check_in,
            @RequestParam(name = "check_out") String check_out,
            @RequestParam(name = "address") String address,
            Model model
    ) {
        Residence residence;
        if(Objects.equals(check_out,"неизвестно")){
            residence = new Residence(personService.getPersonById(personId),address,
                    Date.valueOf(check_in));
        }
        else {
            residence = new Residence(personService.getPersonById(personId),address,
                    Date.valueOf(check_in),Date.valueOf(check_out));
        }
        residenceService.addResidence(residence);

        return personController.personPage(personId,model);
    }
}