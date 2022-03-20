package DAO;

import Enteties.Residence;
import org.hibernate.Session;
import util.HibernateUtil;

public class ResidenceDAO {

    public void addResidence(Residence residence){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(residence);
        session.getTransaction().commit();
        session.close();
    }


}