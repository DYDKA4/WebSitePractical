package DAO;

import Entities.Person;
import Entities.Relationship;
import lombok.NonNull;
import org.hibernate.Session;
import util.HibernateUtil;
import org.hibernate.query.Query;

import java.util.List;

public class RelationshipDAO {

    public void addRelationship(Relationship relationship) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(relationship);
        session.getTransaction().commit();
        session.close();
    }

    public void updateRelationship(Relationship relationship){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(relationship);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteRelationship(Relationship relationship){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(relationship);
        session.getTransaction().commit();
        session.close();
    }

    public Relationship getRelationshipById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Relationship relationship = (Relationship) session.get(Relationship.class, id);
        session.close();
        return relationship;
    }

    public List<Relationship> getRelationshipByPerson2(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Relationship> query = session.createQuery("FROM Relationship WHERE id_person_person_2 = :gotID",
                Relationship.class).setParameter("gotID", id);
        if (query.getResultList().size() == 0) {
            return null;
        }
        return query.getResultList();
    }

    public List<Relationship> getRelationshipBetweenPerson1Person2(@NonNull Person person1, @NonNull Person person2){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Relationship> query = session.createQuery("FROM Relationship WHERE id_person_person_2 = :gotID1" +
                        " AND id_person_person_1 = :gotID2", Relationship.class);
        query.setParameter("gotID1", person1.getId());
        query.setParameter("gotID2", person2.getId());
        if (query.getResultList().size() == 0) {
            query = session.createQuery("FROM Relationship WHERE id_person_person_2 = :gotID1" +
                    " AND id_person_person_1 = :gotID2", Relationship.class);
            query.setParameter("gotID1", person2.getId());
            query.setParameter("gotID2", person1.getId());
            if (query.getResultList().size() == 0) {
                return null;
            }
        }
        return query.getResultList();
    }

}
