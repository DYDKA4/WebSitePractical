package services;

import Entities.Person;
import Entities.Residence;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class ResidenceServiceTest {


    @Test
    void updateResidence() {
        PersonService personService = new PersonService();
        Person expected_person = new Person("Test", Date.valueOf("1999-12-12"));
        personService.addPerson(expected_person);
        ResidenceService residenceService = new ResidenceService();
        Residence expected_residence = new Residence(expected_person,"Test Address", Date.valueOf("2022-03-24"));
        residenceService.addResidence(expected_residence);
        expected_residence.setAddress("UPDATE ON ADDRESS");
        residenceService.updateResidence(expected_residence);
        Residence actual_residence = residenceService.getResidenceById(expected_residence.getId());
        assertEquals(expected_residence.getId(),actual_residence.getId());
        assertEquals(expected_residence.getAddress(),actual_residence.getAddress());
        assertEquals(expected_residence.getCheck_in(),actual_residence.getCheck_in());
        assertEquals(expected_residence.getCheck_out(),actual_residence.getCheck_out());
        residenceService.deleteResidence(expected_residence);
        personService.deletePerson(expected_person);
    }

    @Test
    void addResidence() {
        PersonService personService = new PersonService();
        Person expected_person = new Person("Test", Date.valueOf("1999-12-12"));
        personService.addPerson(expected_person);
        ResidenceService residenceService = new ResidenceService();
        Residence expected_residence = new Residence(expected_person,"Test Address", Date.valueOf("2022-03-24"));
        residenceService.addResidence(expected_residence);
        Residence actual_residence = residenceService.getResidenceById(expected_residence.getId());
        assertEquals(expected_residence.getId(),actual_residence.getId());
        assertEquals(expected_residence.getAddress(),actual_residence.getAddress());
        assertEquals(expected_residence.getCheck_in(),actual_residence.getCheck_in());
        assertEquals(expected_residence.getCheck_out(),actual_residence.getCheck_out());
        residenceService.deleteResidence(expected_residence);
        personService.deletePerson(expected_person);
    }

    @Test
    void getResidenceByAddress() {
        PersonService personService = new PersonService();
        Person expected_person = new Person("Test", Date.valueOf("1999-12-12"));
        personService.addPerson(expected_person);
        ResidenceService residenceService = new ResidenceService();
        Residence expected_residence = new Residence(expected_person,"Test Address", Date.valueOf("2022-03-24"));
        residenceService.addResidence(expected_residence);
        Residence actual_residence = residenceService.getResidenceByAddress("Test Address").get(0);
        assertEquals(expected_residence.getId(),actual_residence.getId());
        assertEquals(expected_residence.getAddress(),actual_residence.getAddress());
        assertEquals(expected_residence.getCheck_in(),actual_residence.getCheck_in());
        assertEquals(expected_residence.getCheck_out(),actual_residence.getCheck_out());
        residenceService.deleteResidence(expected_residence);
        personService.deletePerson(expected_person);
    }

    @Test
    void deleteResidence(){
        PersonService personService = new PersonService();
        Person expected_person = new Person("Test", Date.valueOf("1999-12-12"));
        personService.addPerson(expected_person);
        ResidenceService residenceService = new ResidenceService();
        Residence expected_residence = new Residence(expected_person,"Test Address", Date.valueOf("2022-03-24"));
        residenceService.addResidence(expected_residence);
        residenceService.deleteResidence(expected_residence);
        personService.deletePerson(expected_person);
        Residence actual_residence = residenceService.getResidenceById(expected_residence.getId());
        assertNull(actual_residence);

    }
}