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
public class RelationshipController {
    private final PersonService personService = new PersonService();
    private final ResidenceService residenceService = new ResidenceService();
    private final RelationshipService relationshipService = new RelationshipService();
    private final RoleTypeService roleTypeService = new RoleTypeService();
    private final RelationshipTypeService relationshipTypeService = new RelationshipTypeService();
    private final PersonController personController = new PersonController();


    @GetMapping("/addRelationship")
    public String addRelationship(
            @RequestParam(name = "personId") Long id,
            Model model) {
        List<Person> persons = personService.getPersonAll();
        List<RelationshipType> relationshipTypes = relationshipTypeService.getRelationshipTypeAll();
        List<RoleType> roleTypes = roleTypeService.getRoleTypeAll();
        model.addAttribute("person", personService.getPersonById(id));
        model.addAttribute("persons", persons);
        model.addAttribute("relationshipTypes",relationshipTypes);
        model.addAttribute("roleTypes",roleTypes);

        return "addRelationship";
    }

    @PostMapping("/saveRelationship")
    public String saveRelationship(
            @RequestParam(name = "id_person_1") long id_person_1,
            @RequestParam(name = "id_person_2") long id_person_2,
            @RequestParam(name = "relationshipTypes_2") long relationshipTypes_2,
            @RequestParam(name = "relationshipTypes_1") long relationshipTypes_1,
            @RequestParam(name = "roleType_2") long roleType_2,
            @RequestParam(name = "roleType_1") long roleType_1,
            Model model) {
        model.addAttribute(personService);
        model.addAttribute(relationshipService);
        Person person1 = personService.getPersonById(id_person_1);
        Person person2 = personService.getPersonById(id_person_2);
        RoleType roleType1 = roleTypeService.getRoleTypeById(roleType_1);
        RoleType roleType2 = roleTypeService.getRoleTypeById(roleType_2);
        RelationshipType relationshipType1 = relationshipTypeService.getRelationshipTypeById(relationshipTypes_1);
        RelationshipType relationshipType2 = relationshipTypeService.getRelationshipTypeById(relationshipTypes_2);

        Relationship relationship = new Relationship(person1,person2,roleType1,roleType2,relationshipType1,relationshipType2);
        Relationship relationship2 = new Relationship(person2,person1,roleType2,roleType1,relationshipType2,relationshipType1);

        relationshipService.addRelationship(relationship);
        relationshipService.addRelationship(relationship2);
        return personController.relativesPage(person1.getId(),model);
    }

    @GetMapping("/deleteRelationship")
    public String deleteRelationship(
            @RequestParam(name = "personId") Long id,
            Model model) {
        List<Relationship> relationships = relationshipService.getRelationshipByPerson2(id);
        if(relationships == null){
            return personController.relativesPage(id,model);
        }
        model.addAttribute("person",personService.getPersonById(id));
        model.addAttribute("relationships",relationships);
        return "/deleteRelationship";
    }

    @PostMapping("/deleteRelationship")
    public String postDeleteRelationship(
            @RequestParam(name = "id_person_1") Long id,
            @RequestParam(name = "id_relationship") Long id_relationship,
            Model model) {
        Person person1 = personService.getPersonById(id);
        Person person2 = relationshipService.getRelationshipById(id_relationship).getPerson_2();
        relationshipService.deleteRelationship(relationshipService.getRelationshipById(id_relationship));
        List<Relationship> relationships = relationshipService.getRelationshipBetweenPerson1Person2(person2,person1);
        if(relationships!=null){
            relationshipService.deleteRelationship(relationships.get(0));
        }
        relationships = relationshipService.getRelationshipBetweenPerson1Person2(person1,person2);
        if(relationships!=null){
            relationshipService.deleteRelationship(relationships.get(0));
        }
        return personController.relativesPage(id,model);
    }

}