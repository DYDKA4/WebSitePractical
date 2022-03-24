package DAO;

import Entities.Person;
import Entities.RelationshipType;
import org.hibernate.Session;
import util.HibernateUtil;

public class RelationshipTypeDAO {

    public void addRelationshipType(RelationshipType relationshipType){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(relationshipType);
        session.getTransaction().commit();
        session.close();
    }

    public void updateRelationshipType(RelationshipType relationshipType){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(relationshipType);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteRelationshipType(RelationshipType relationshipType){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(relationshipType);
        session.getTransaction().commit();
        session.close();
    }

    public RelationshipType getRelationshipTypeById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        RelationshipType entity = (RelationshipType) session.get(RelationshipType.class, id);
        session.close();
        return entity;
    }
}
