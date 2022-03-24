package DAO;

import Entities.RelationshipType;
import Entities.RoleType;
import org.hibernate.Session;
import util.HibernateUtil;

public class RoleTypeDAO {

    public void addRoleType(RoleType roleType){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(roleType);
        session.getTransaction().commit();
        session.close();
    }


    public void updateRoleType(RoleType roleType){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(roleType);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteRoleType(RoleType roleType){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(roleType);
        session.getTransaction().commit();
        session.close();
    }

    public RoleType getRoleTypeById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        RoleType entity = (RoleType) session.get(RoleType.class, id);
        session.close();
        return entity;
    }
}