package services;

import DAO.PersonDAO;
import Entities.Person;

import java.util.List;

public class PersonService {
    private PersonDAO personsDAO = new PersonDAO();

    public PersonService(){
    }
    public void deletePerson(Person person){ personsDAO.deletePerson(person); }
    public void updatePerson(Person person){ personsDAO.updatePerson(person); }
    public void addPerson(Person person){
        personsDAO.addPerson(person);
    }
    public Person getPersonById(int id){
        return personsDAO.getPersonById(id);
    }
    public List<Person> getPersonByName(String name){
        return personsDAO.getPersonByName(name);
    }

    public List<Person> getPersonAll(){
        return personsDAO.getPersonAll();
    }

}