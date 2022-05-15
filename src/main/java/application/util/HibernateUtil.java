
package application.util;

import application.Entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory = null;
    static {
        try {
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Person.class)
                    .addAnnotatedClass(Residence.class)
                    .addAnnotatedClass(Relationship.class)
                    .addAnnotatedClass(RelationshipType.class)
                    .addAnnotatedClass(RoleType.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}