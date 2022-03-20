package services;

import Entities.Person;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {


    @Test
    void addPersonAndPersonById() {
        PersonService personService = new PersonService();
        Person expected_person = new Person("Test", Date.valueOf("1999-12-12"));
        Person actual_person;
        personService.addPerson(expected_person);
        actual_person = personService.getPersonById(expected_person.getId());
        assertEquals(expected_person.getId(),actual_person.getId());
        assertEquals(expected_person.getName(),actual_person.getName());
        assertEquals(expected_person.getBorn(),actual_person.getBorn());
        assertEquals(expected_person.getDeath(),actual_person.getDeath());
        personService.deletePerson(expected_person);
    }

    @Test
    void updatePerson(){
        PersonService personService = new PersonService();
        Person expected_person = new Person("Test", Date.valueOf("1999-12-12"));
        Person actual_person;
        personService.addPerson(expected_person);
        expected_person.setName("TEST_UPDATE");
        personService.updatePerson(expected_person);
        actual_person = personService.getPersonById(expected_person.getId());
        assertEquals(expected_person.getId(),actual_person.getId());
        assertEquals(expected_person.getName(),actual_person.getName());
        assertEquals(expected_person.getBorn(),actual_person.getBorn());
        assertEquals(expected_person.getDeath(),actual_person.getDeath());
        personService.deletePerson(expected_person);
    }

    @Test
    void getPersonByName(){
        PersonService personService = new PersonService();
        Person expected_person = new Person("Test", Date.valueOf("1999-12-12"));
        for (int x = 0; x < 5; x++)
            personService.addPerson(expected_person);
        List<Person> persons = personService.getPersonByName(expected_person.getName());
        for (Person person : persons) {
            assertEquals(expected_person.getName(), person.getName());
            assertEquals(expected_person.getBorn(), person.getBorn());
            assertEquals(expected_person.getDeath(), person.getDeath());
            personService.deletePerson(person);
        }
        persons = personService.getPersonByName(expected_person.getName());
        assertNull(persons);
    }

    @Test
    void getPersonByIdNull(){
        PersonService personService = new PersonService();
        Person person = personService.getPersonById(-1);
        assertNull(person);
    }

    @Test
    void getPersonByNameNull(){
        PersonService personService = new PersonService();
        List<Person> persons = personService.getPersonByName("NoName");
        assertNull(persons);
    }

    @Test
    void deletePerson(){
        PersonService personService = new PersonService();
        Person expected_person = new Person("Test", Date.valueOf("1999-12-12"));
        Person actual_person;
        personService.addPerson(expected_person);
        personService.deletePerson(expected_person);
        actual_person = personService.getPersonById(expected_person.getId());
        assertNull(actual_person);
    }
}