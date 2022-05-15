package application.DAO;

import application.Entities.Person;
import application.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PersonDAO {

    public void addPerson(Person person){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }

    public void updatePerson(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(person);
        session.getTransaction().commit();
        session.close();
    }

    public void deletePerson(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(person);
        session.getTransaction().commit();
        session.close();
    }

    public Person getPersonById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Person entity = (Person) session.get(Person.class, id);
        session.close();
        return entity;
    }

    public List<Person> getPersonByName(String personName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Person> query = session.createQuery("FROM Person WHERE name LIKE :gotName", Person.class)
                .setParameter("gotName", "%" + personName + "%");
        if (query.getResultList().size() == 0) {
            return null;
        }
        return query.getResultList();
    }

    public List<Person> getPersonAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Person> query = session.createQuery("FROM Person", Person.class);
        if (query.getResultList().size() == 0) {
            return null;
        }
        return query.getResultList();
    }
}
