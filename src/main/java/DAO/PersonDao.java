package DAO;

import Enteties.Person;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

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

    public Person getPersonById(int personId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Person> query = session.createQuery("FROM Person WHERE person_id = :param", Person.class)
                .setParameter("param", personId);
        if (query.getResultList().size() == 0) {
            return null;
        }
        return query.getResultList().get(0);
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
