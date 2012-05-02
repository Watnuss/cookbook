package hibernate;
import model.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
 
public class HibernateUtil
{
    private static SessionFactory sessionFactory;
 
    static
    {
        try
        {
            sessionFactory = new Configuration()
                                .addPackage("model")
                                .addAnnotatedClass(Receipt.class)
                                .addAnnotatedClass(Ingredient.class)
                                .addAnnotatedClass(Equipment.class)
                                .configure()
                                .buildSessionFactory();
        }
        catch (RuntimeException ex)
        {
            System.out.println(ex.getMessage());            
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}