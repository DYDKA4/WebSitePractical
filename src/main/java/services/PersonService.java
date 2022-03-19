package services;

import DAO.PersonDao;
import entities.Person;

import java.util.List;

public class PersonService {
    private PersonDao personsDao = new PersonDao();

    public PersonService(){
    }
    public Person findPerson(int id){
        return personsDao.findById(id);
    }
    public void savePerson(Person person){
        personsDao.save(person);
    }
    public void deletePerson(Person person){
        personsDao.delete(person);
    }
    public  void  updatePerson(Person person){
        personsDao.update(person);
    }
    public List<Person> findAllPersons(){
        return personsDao.findAll();
    }

}
