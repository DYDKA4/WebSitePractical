package services;

import application.Entities.Person;
import application.Entities.Relationship;
import application.Entities.RelationshipType;
import application.Entities.RoleType;
import application.services.PersonService;
import application.services.RelationshipService;
import application.services.RelationshipTypeService;
import application.services.RoleTypeService;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RelationshipServiceTest {

    @Test
    void addRelationship() {
        PersonService personService = new PersonService();
        Person person1 = new Person("Test 1", Date.valueOf("1999-12-12"));
        Person person2 = new Person("Test 2", Date.valueOf("1999-12-12"));
        personService.addPerson(person1);
        personService.addPerson(person2);

        RoleTypeService roleTypeService = new RoleTypeService();
        RoleType roleType1 = new RoleType("Test 1");
        RoleType roleType2 = new RoleType("Test 2");
        roleTypeService.addRoleType(roleType1);
        roleTypeService.addRoleType(roleType2);

        RelationshipTypeService relationshipTypeService = new RelationshipTypeService();
        RelationshipType relationshipType1 = new RelationshipType("Test 1");
        RelationshipType relationshipType2 = new RelationshipType("Test 2");
        relationshipTypeService.addRelationshipType(relationshipType1);
        relationshipTypeService.addRelationshipType(relationshipType2);

        RelationshipService relationshipService = new RelationshipService();
        Relationship expected_relationship = new Relationship(person1, person2,roleType1,roleType2,
                relationshipType1,relationshipType2);
        relationshipService.addRelationship(expected_relationship);
        Relationship actual_relationship = relationshipService.getRelationshipById(expected_relationship.getId());
        assertEquals(expected_relationship.getId(),actual_relationship.getId());
        assertEquals(expected_relationship.getType_relationship_1().getId(),actual_relationship.getType_relationship_1().getId());
        assertEquals(expected_relationship.getType_relationship_2().getId(),actual_relationship.getType_relationship_2().getId());
        assertEquals(expected_relationship.getRole_1().getId(),actual_relationship.getRole_1().getId());
        assertEquals(expected_relationship.getRole_2().getId(),actual_relationship.getRole_2().getId());
        assertEquals(expected_relationship.getPerson_1().getId(),actual_relationship.getPerson_1().getId());
        assertEquals(expected_relationship.getPerson_2().getId(),expected_relationship.getPerson_2().getId());

        relationshipService.deleteRelationship(expected_relationship);
        personService.deletePerson(person1);
        personService.deletePerson(person2);
        roleTypeService.deleteRoleType(roleType1);
        roleTypeService.deleteRoleType(roleType2);
        relationshipTypeService.deleteRelationshipType(relationshipType1);
        relationshipTypeService.deleteRelationshipType(relationshipType2);
    }

    @Test
    void updateRelationship() {
        PersonService personService = new PersonService();
        Person person1 = new Person("Test 1", Date.valueOf("1999-12-12"));
        Person person2 = new Person("Test 2", Date.valueOf("1999-12-12"));
        personService.addPerson(person1);

        personService.addPerson(person2);

        RoleTypeService roleTypeService = new RoleTypeService();
        RoleType roleType1 = new RoleType("Test 1");
        RoleType roleType2 = new RoleType("Test 2");
        roleTypeService.addRoleType(roleType1);
        roleTypeService.addRoleType(roleType2);

        RelationshipTypeService relationshipTypeService = new RelationshipTypeService();
        RelationshipType relationshipType1 = new RelationshipType("Test 1");
        RelationshipType relationshipType2 = new RelationshipType("Test 2");
        relationshipTypeService.addRelationshipType(relationshipType1);
        relationshipTypeService.addRelationshipType(relationshipType2);

        RelationshipService relationshipService = new RelationshipService();
        Relationship expected_relationship = new Relationship(person1, person2,roleType1,roleType2,
                relationshipType1,relationshipType2);
        relationshipService.addRelationship(expected_relationship);

        Person person3 = new Person("UPDATE TEST", Date.valueOf("1999-12-12"));
        personService.addPerson(person3);
        RoleType roleType3 = new RoleType("UPDATE TEST");
        roleTypeService.addRoleType(roleType3);
        RelationshipType relationshipType3 = new RelationshipType("UPDATE TEST");
        relationshipTypeService.addRelationshipType(relationshipType3);
        expected_relationship.setType_relationship_1(relationshipType3);
        expected_relationship.setRole_2(roleType3);
        expected_relationship.setPerson_1(person3);

        relationshipService.updateRelationship(expected_relationship);

        Relationship actual_relationship = relationshipService.getRelationshipById(expected_relationship.getId());
        assertEquals(expected_relationship.getId(),actual_relationship.getId());
        assertEquals(expected_relationship.getType_relationship_1().getId(),actual_relationship.getType_relationship_1().getId());
        assertEquals(expected_relationship.getType_relationship_1().getName(),actual_relationship.getType_relationship_1().getName());
        assertEquals(expected_relationship.getType_relationship_2().getId(),actual_relationship.getType_relationship_2().getId());
        assertEquals(expected_relationship.getRole_1().getId(),actual_relationship.getRole_1().getId());
        assertEquals(expected_relationship.getRole_2().getId(),actual_relationship.getRole_2().getId());
        assertEquals(expected_relationship.getRole_2().getName(),actual_relationship.getRole_2().getName());
        assertEquals(expected_relationship.getPerson_1().getId(),actual_relationship.getPerson_1().getId());
        assertEquals(expected_relationship.getPerson_1().getName(),actual_relationship.getPerson_1().getName());
        assertEquals(expected_relationship.getPerson_2().getId(),expected_relationship.getPerson_2().getId());

        relationshipService.deleteRelationship(expected_relationship);
        personService.deletePerson(person1);
        personService.deletePerson(person2);
        personService.deletePerson(person3);
        roleTypeService.deleteRoleType(roleType1);
        roleTypeService.deleteRoleType(roleType2);
        roleTypeService.deleteRoleType(roleType3);
        relationshipTypeService.deleteRelationshipType(relationshipType1);
        relationshipTypeService.deleteRelationshipType(relationshipType2);
        relationshipTypeService.deleteRelationshipType(relationshipType3);
    }


    @Test
    void getRelationshipByPerson2() {
        PersonService personService = new PersonService();
        Person person1 = new Person("Test 1", Date.valueOf("1999-12-12"));
        Person person2 = new Person("Test 2", Date.valueOf("1999-12-12"));
        personService.addPerson(person1);
        personService.addPerson(person2);

        RoleTypeService roleTypeService = new RoleTypeService();
        RoleType roleType1 = new RoleType("Test 1");
        RoleType roleType2 = new RoleType("Test 2");
        roleTypeService.addRoleType(roleType1);
        roleTypeService.addRoleType(roleType2);

        RelationshipTypeService relationshipTypeService = new RelationshipTypeService();
        RelationshipType relationshipType1 = new RelationshipType("Test 1");
        RelationshipType relationshipType2 = new RelationshipType("Test 2");
        relationshipTypeService.addRelationshipType(relationshipType1);
        relationshipTypeService.addRelationshipType(relationshipType2);

        RelationshipService relationshipService = new RelationshipService();
        Relationship expected_relationship = new Relationship(person1, person2,roleType1,roleType2,
                relationshipType1,relationshipType2);
        relationshipService.addRelationship(expected_relationship);

        Relationship actual_relationship = relationshipService.getRelationshipByPerson2(person2.getId()).get(0);
        assertEquals(expected_relationship.getId(),actual_relationship.getId());
        assertEquals(expected_relationship.getType_relationship_1().getId(),actual_relationship.getType_relationship_1().getId());
        assertEquals(expected_relationship.getType_relationship_2().getId(),actual_relationship.getType_relationship_2().getId());
        assertEquals(expected_relationship.getRole_1().getId(),actual_relationship.getRole_1().getId());
        assertEquals(expected_relationship.getRole_2().getId(),actual_relationship.getRole_2().getId());
        assertEquals(expected_relationship.getPerson_1().getId(),actual_relationship.getPerson_1().getId());
        assertEquals(expected_relationship.getPerson_2().getId(),expected_relationship.getPerson_2().getId());

        relationshipService.deleteRelationship(expected_relationship);
        personService.deletePerson(person1);
        personService.deletePerson(person2);
        roleTypeService.deleteRoleType(roleType1);
        roleTypeService.deleteRoleType(roleType2);
        relationshipTypeService.deleteRelationshipType(relationshipType1);
        relationshipTypeService.deleteRelationshipType(relationshipType2);
    }

    @Test
    void getRelationshipBetweenPerson1Person2() {
        PersonService personService = new PersonService();
        Person person1 = new Person("Test 1", Date.valueOf("1999-12-12"));
        Person person2 = new Person("Test 2", Date.valueOf("1999-12-12"));
        personService.addPerson(person1);
        personService.addPerson(person2);

        RoleTypeService roleTypeService = new RoleTypeService();
        RoleType roleType1 = new RoleType("Test 1");
        RoleType roleType2 = new RoleType("Test 2");
        roleTypeService.addRoleType(roleType1);
        roleTypeService.addRoleType(roleType2);

        RelationshipTypeService relationshipTypeService = new RelationshipTypeService();
        RelationshipType relationshipType1 = new RelationshipType("Test 1");
        RelationshipType relationshipType2 = new RelationshipType("Test 2");
        relationshipTypeService.addRelationshipType(relationshipType1);
        relationshipTypeService.addRelationshipType(relationshipType2);

        RelationshipService relationshipService = new RelationshipService();
        Relationship expected_relationship = new Relationship(person1, person2,roleType1,roleType2,
                relationshipType1,relationshipType2);
        relationshipService.addRelationship(expected_relationship);

        Relationship actual_relationship = relationshipService.getRelationshipBetweenPerson1Person2(person1,person2).get(0);
        assertEquals(expected_relationship.getId(),actual_relationship.getId());
        assertEquals(expected_relationship.getType_relationship_1().getId(),actual_relationship.getType_relationship_1().getId());
        assertEquals(expected_relationship.getType_relationship_2().getId(),actual_relationship.getType_relationship_2().getId());
        assertEquals(expected_relationship.getRole_1().getId(),actual_relationship.getRole_1().getId());
        assertEquals(expected_relationship.getRole_2().getId(),actual_relationship.getRole_2().getId());
        assertEquals(expected_relationship.getPerson_1().getId(),actual_relationship.getPerson_1().getId());
        assertEquals(expected_relationship.getPerson_2().getId(),expected_relationship.getPerson_2().getId());

        relationshipService.deleteRelationship(expected_relationship);
        personService.deletePerson(person1);
        personService.deletePerson(person2);
        roleTypeService.deleteRoleType(roleType1);
        roleTypeService.deleteRoleType(roleType2);
        relationshipTypeService.deleteRelationshipType(relationshipType1);
        relationshipTypeService.deleteRelationshipType(relationshipType2);
    }

    @Test
    void getRelationshipByPerson2NULL() {

        RelationshipService relationshipService = new RelationshipService();

        List<Relationship> actual_relationship = relationshipService.getRelationshipByPerson2(-1L);
        assertNull(actual_relationship);


    }

    @Test
    void getRelationshipBetweenPerson1Person2NULL() {

        RelationshipService relationshipService = new RelationshipService();
        Person person1 = new Person("Test 1", Date.valueOf("1999-12-12"));
        person1.setId(-1L);
        Person person2 = new Person("Test 2", Date.valueOf("1999-12-12"));
        person2.setId(-2L);
        List<Relationship> actual_relationship = relationshipService.getRelationshipBetweenPerson1Person2(person1, person2);
        assertNull(actual_relationship);
    }

    @Test
    void getRelationshipBetweenPerson1Person2Reversed() {
        PersonService personService = new PersonService();
        Person person1 = new Person("Test 1", Date.valueOf("1999-12-12"));
        Person person2 = new Person("Test 2", Date.valueOf("1999-12-12"));
        personService.addPerson(person1);
        personService.addPerson(person2);

        RoleTypeService roleTypeService = new RoleTypeService();
        RoleType roleType1 = new RoleType("Test 1");
        RoleType roleType2 = new RoleType("Test 2");
        roleTypeService.addRoleType(roleType1);
        roleTypeService.addRoleType(roleType2);

        RelationshipTypeService relationshipTypeService = new RelationshipTypeService();
        RelationshipType relationshipType1 = new RelationshipType("Test 1");
        RelationshipType relationshipType2 = new RelationshipType("Test 2");
        relationshipTypeService.addRelationshipType(relationshipType1);
        relationshipTypeService.addRelationshipType(relationshipType2);

        RelationshipService relationshipService = new RelationshipService();
        Relationship expected_relationship = new Relationship(person1, person2,roleType1,roleType2,
                relationshipType1,relationshipType2);
        relationshipService.addRelationship(expected_relationship);

        Relationship actual_relationship = relationshipService.getRelationshipBetweenPerson1Person2(person2,person1).get(0);
        assertEquals(expected_relationship.getId(),actual_relationship.getId());
        assertEquals(expected_relationship.getType_relationship_1().getId(),actual_relationship.getType_relationship_1().getId());
        assertEquals(expected_relationship.getType_relationship_2().getId(),actual_relationship.getType_relationship_2().getId());
        assertEquals(expected_relationship.getRole_1().getId(),actual_relationship.getRole_1().getId());
        assertEquals(expected_relationship.getRole_2().getId(),actual_relationship.getRole_2().getId());
        assertEquals(expected_relationship.getPerson_1().getId(),actual_relationship.getPerson_1().getId());
        assertEquals(expected_relationship.getPerson_2().getId(),actual_relationship.getPerson_2().getId());


        relationshipService.deleteRelationship(expected_relationship);
        personService.deletePerson(person1);
        personService.deletePerson(person2);
        roleTypeService.deleteRoleType(roleType1);
        roleTypeService.deleteRoleType(roleType2);
        relationshipTypeService.deleteRelationshipType(relationshipType1);
        relationshipTypeService.deleteRelationshipType(relationshipType2);
    }

    @Test
    void getRelationshipBetweenPerson1Person2LIST() {
        PersonService personService = new PersonService();
        Person person1 = new Person("Test 1", Date.valueOf("1999-12-12"));
        Person person2 = new Person("Test 2", Date.valueOf("1999-12-12"));
        personService.addPerson(person1);
        personService.addPerson(person2);

        RoleTypeService roleTypeService = new RoleTypeService();
        RoleType roleType1 = new RoleType("Test 1");
        RoleType roleType2 = new RoleType("Test 2");
        roleTypeService.addRoleType(roleType1);
        roleTypeService.addRoleType(roleType2);

        RelationshipTypeService relationshipTypeService = new RelationshipTypeService();
        RelationshipType relationshipType1 = new RelationshipType("Test 1");
        RelationshipType relationshipType2 = new RelationshipType("Test 2");
        relationshipTypeService.addRelationshipType(relationshipType1);
        relationshipTypeService.addRelationshipType(relationshipType2);

        RelationshipService relationshipService = new RelationshipService();
        Relationship expected_relationship1 = new Relationship(person1, person2,roleType1,roleType2,
                relationshipType1,relationshipType2);
        Relationship expected_relationship2 = new Relationship(person1, person2,roleType1,roleType2,
                relationshipType1,relationshipType2);
        relationshipService.addRelationship(expected_relationship1);

        List<Relationship> actual_relationships = relationshipService.getRelationshipBetweenPerson1Person2(person1,person2);
        for (Relationship actual_relationship: actual_relationships) {
            assertEquals(expected_relationship1.getId(), actual_relationship.getId());
            assertEquals(expected_relationship1.getType_relationship_1().getId(), actual_relationship.getType_relationship_1().getId());
            assertEquals(expected_relationship1.getType_relationship_2().getId(), actual_relationship.getType_relationship_2().getId());
            assertEquals(expected_relationship1.getRole_1().getId(), actual_relationship.getRole_1().getId());
            assertEquals(expected_relationship1.getRole_2().getId(), actual_relationship.getRole_2().getId());
            assertEquals(expected_relationship1.getPerson_1().getId(), actual_relationship.getPerson_1().getId());
            assertEquals(expected_relationship1.getPerson_2().getId(), expected_relationship1.getPerson_2().getId());
        }
        relationshipService.deleteRelationship(expected_relationship1);
        relationshipService.deleteRelationship(expected_relationship2);
        personService.deletePerson(person1);
        personService.deletePerson(person2);
        roleTypeService.deleteRoleType(roleType1);
        roleTypeService.deleteRoleType(roleType2);
        relationshipTypeService.deleteRelationshipType(relationshipType1);
        relationshipTypeService.deleteRelationshipType(relationshipType2);
    }


}