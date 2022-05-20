package application.DAO;

import application.Entities.RelationshipType;
import application.Entities.RoleType;
import application.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

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

    public RoleType getRoleTypeByName(String role_name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<RoleType> query = session.createQuery("FROM RoleType"+
                " WHERE role_name = :gotName", RoleType.class);
        query.setParameter("gotName", role_name);
        if (query.getResultList().size() == 0){
            return null;
        }
        return query.getResultList().get(0);
    }

    public List<RoleType> getRoleTypeAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<RoleType> query = session.createQuery("FROM RoleType", RoleType.class);
        if (query.getResultList().size() == 0) {
            return null;
        }
        return query.getResultList();
    }
}
