package application.controllers;

import application.Entities.Person;
import application.Entities.Relationship;
import application.Entities.RelationshipType;
import application.Entities.RoleType;
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
public class PersonController {
    private final PersonService personService = new PersonService();
    private final ResidenceService residenceService = new ResidenceService();
    private final RelationshipService relationshipService = new RelationshipService();
    private final RoleTypeService roleTypeService = new RoleTypeService();
    private final RelationshipTypeService relationshipTypeService = new RelationshipTypeService();

    @GetMapping("/persons")
    public String peopleListPage(Model model) {
        List<Person> people = personService.getPersonAll();
//        List<Relationship> relationships = null;
//        model.addAttribute(relationships);
        RelationshipType mother = relationshipTypeService.getRelationshipTypeByName("Mother");
        RelationshipType father = relationshipTypeService.getRelationshipTypeByName("Father");
        model.addAttribute("mother",mother);
        model.addAttribute("father",father);
        model.addAttribute("people",people);
        model.addAttribute(personService);
        model.addAttribute(relationshipService);
        return "persons";
    }

    @GetMapping("/person")
    public String personPage(@RequestParam(name = "personId") Long personId, Model model) {
        Person person = personService.getPersonById(personId);
        if(person == null){
            return "errorPage";
        }
        model.addAttribute(personService);
        model.addAttribute(residenceService);
        model.addAttribute("person",person);
        return "person";
    }

    @GetMapping("/relatives")
    public String relativesPage(@RequestParam(name = "personId") Long personId, Model model) {
        Person person = personService.getPersonById(personId);
        List<Relationship> relationships = relationshipService.getRelationshipByPerson2(personId);
        model.addAttribute("relationships",relationships);
        RelationshipType mother_id = relationshipTypeService.getRelationshipTypeByName("Mother");
        RelationshipType father_id = relationshipTypeService.getRelationshipTypeByName("Father");
        RelationshipType sister_id = relationshipTypeService.getRelationshipTypeByName("Sister");
        RelationshipType brother_id = relationshipTypeService.getRelationshipTypeByName("Brother");
        RelationshipType daughter_id = relationshipTypeService.getRelationshipTypeByName("Daughter");
        RoleType spouse_id = roleTypeService.getRoleTypeByName("marriage");

        RelationshipType son_id = relationshipTypeService.getRelationshipTypeByName("Son");
        RelationshipType mother = relationshipTypeService.getRelationshipTypeByName("Mother");
        RelationshipType father = relationshipTypeService.getRelationshipTypeByName("Father");
        model.addAttribute("mother",mother);
        model.addAttribute("father",father);
        List<Relationship> sisters = relationshipService.getIdOfPersonByRoleId(person.getId(), sister_id.getId());
        List<Relationship> brothers = relationshipService.getIdOfPersonByRoleId(person.getId(),brother_id.getId());
        List<Relationship> daughters = relationshipService.getIdOfPersonByRoleId(person.getId(),daughter_id.getId());
        List<Relationship> sons = relationshipService.getIdOfPersonByRoleId(person.getId(),son_id.getId());
        List<Relationship> spouses = relationshipService.getIdOfPersonByRoleTypeId(person.getId(),spouse_id.getId());

        model.addAttribute("sisters",sisters);
        model.addAttribute("brothers",brothers);
        model.addAttribute("daughters",daughters);
        model.addAttribute("sons",sons);
        model.addAttribute("mother",mother);
        model.addAttribute("father",father);
        model.addAttribute("spouses",spouses);
        model.addAttribute(personService);
        model.addAttribute(residenceService);
        model.addAttribute(relationshipService);
        model.addAttribute("person",person);
        return "relatives";

    }

    @GetMapping("/addPerson")
    public String addPerson(Model model) {
        return "addPerson";
    }

    @PostMapping("/savePerson")
    public String savePerson(
            @RequestParam(name = "FullName") String name,
            @RequestParam(name = "birthday") String birthday,
            @RequestParam(name = "deathday") String deathday,
            Model model
    ) {
        Person person;
        if(Objects.equals(deathday, birthday)){
            person = new Person(name, Date.valueOf(birthday));
        }
        else {
            person = new Person(name, Date.valueOf(birthday), Date.valueOf(deathday));
        }
        personService.addPerson(person);
        return personPage(person.getId(), model);
    }

    @GetMapping("/editPerson")
    public String editPerson(
            @RequestParam(name = "personId") Long id,
            Model model
    ) {
        model.addAttribute("person", personService.getPersonById(id));
        return "/editPerson";
    }

    @PostMapping("/saveEditPerson")
    public String saveEditPerson(
            @RequestParam(name = "personId") Long id,
            @RequestParam(name = "fullName") String name,
            @RequestParam(name = "birthday") String birthday,
            @RequestParam(name = "deathday") String deathday,
            Model model
    ) {
        Person person;
        if(Objects.equals(deathday, birthday)){
            person = new Person(id,name,Date.valueOf(birthday),null);
        }
        else {
            person = new Person(id,name, Date.valueOf(birthday), Date.valueOf(deathday));
        }
        personService.updatePerson(person);
        return personPage(person.getId(), model);
    }


    @PostMapping("/deletePerson")
    public String deletePlace(
            @RequestParam(name = "personId") Long personId,
            Model model
    ) {
        personService.deletePerson(personService.getPersonById(personId));
        return peopleListPage(model);
    }

}