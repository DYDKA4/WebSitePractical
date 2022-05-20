package application.DAO;

import application.Entities.Person;
import application.Entities.Relationship;
import application.Entities.RelationshipType;
import application.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

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

    public RelationshipType getRelationshipTypeByName(String role_name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<RelationshipType> query = session.createQuery("FROM RelationshipType"+
                " WHERE name_of_relationship = :gotName", RelationshipType.class);
        query.setParameter("gotName", role_name);
        if (query.getResultList().size() == 0){
            return null;
        }
        return query.getResultList().get(0);
    }

    public List<RelationshipType> getRelationshipTypeAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<RelationshipType> query = session.createQuery("FROM RelationshipType", RelationshipType.class);
        if (query.getResultList().size() == 0) {
            return null;
        }
        return query.getResultList();
    }
}
