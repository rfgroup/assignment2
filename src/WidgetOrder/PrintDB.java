package WidgetOrder;

import Entity.Widget;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/4/13
 * Time: 12:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrintDB {

    public static void main(String[] args) {
        final String PERSISTENCE_UNIT_NAME = "Widgets";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        EntityManager em = factory.createEntityManager();

        // Get the entire Inventory of Widgets from the database
        Query q = em.createQuery("select w from Widget w");
        List<Widget> widgets = q.getResultList();
        
        // Print all
        for (Widget w : widgets)
            System.out.println( w );
        
        em.close();

    }
}
