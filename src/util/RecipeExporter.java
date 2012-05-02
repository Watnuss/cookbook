package util;

import hibernate.HibernateUtil;
import model.Receipt;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RecipeExporter {
	public static void export(Receipt r1) {
		
		SessionFactory sf       = HibernateUtil.getSessionFactory();
        Session session         = null;
        Transaction transaction = null;
 
        try
        {
            session             = sf.getCurrentSession();
            //Datenmanipulation �ber Transaktionen
            transaction         = session.beginTransaction();
            session.save(r1);
            transaction.commit();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
	}
}
