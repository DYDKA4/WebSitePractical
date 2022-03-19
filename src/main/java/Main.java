import entities.Person;
import services.PersonService;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws SQLException {

        PersonService personService = new PersonService();
        Person person = new Person("Maria A.N", Date.valueOf("2001-03-22"));
        personService.savePerson(person);
    }
}