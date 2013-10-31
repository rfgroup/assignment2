package p1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.LinkedList;
import java.util.List;

public class Main1Create {

	public static void main(String[] args) {
	    // Create an inventory of Widgets
	    List<Widget> widgetList = new LinkedList<Widget>();
	    widgetList.add( new Widget( "Widget 1", "The first kind of widget") );
	    widgetList.add( new Widget( "Widget 2", "The second kind of widget") );
	    widgetList.add( new Widget( "Widget 3", "The third kind of widget") );
	    widgetList.add( new Widget( "Widget 4", "The fourth kind of widget") );
	    
	    // Print all
	    for (Widget w : widgetList)
	      System.out.println( w );

		final String PERSISTENCE_UNIT_NAME = "Widgets";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
	    EntityManager em = factory.createEntityManager();

	    // create new widget to persist into the db
	    em.getTransaction().begin();
	    
	    // Persist all
	    for (Widget w : widgetList)
	    	em.persist(w);
	    
	    em.getTransaction().commit();

	    
	    // Get the entire Inventory of Widgets from the database
	    Query q = em.createQuery("select w from Widget w");
	    List<Widget> widgetInventory = q.getResultList();
	    em.close();
	    
	    // Print all
	    for (Widget w : widgetInventory)
	      System.out.println( w );
	    
	    System.out.println("There are " + widgetInventory.size() + " widgets in the inventory");
	}
}
