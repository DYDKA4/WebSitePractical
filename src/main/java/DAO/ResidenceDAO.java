package DAO;

import Entities.Residence;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class ResidenceDAO {

    public void addResidence(Residence residence){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(residence);
        session.getTransaction().commit();
        session.close();
    }

    public void updateResidence(Residence residence) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(residence);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteResidence(Residence residence) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(residence);
        session.getTransaction().commit();
        session.close();
    }

    public Residence getResidenceById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Residence entity = (Residence) session.get(Residence.class, id);
        session.close();
        return entity;
    }

    public List<Residence> getResidenceByAddress(String residenceAddress) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Residence> query = session.createQuery("FROM Residence WHERE address LIKE :gotAddress", Residence.class)
                .setParameter("gotAddress", "%" + residenceAddress + "%");
        if (query.getResultList().size() == 0) {
            return null;
        }
        return query.getResultList();
    }
}