package p1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.List;

public class Main3Clear {

	public static void main(String[] args) {
		final String PERSISTENCE_UNIT_NAME = "Widgets";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
	    EntityManager em = factory.createEntityManager();
	    
	    // Get the entire Inventory of Widgets
	    Query q = em.createQuery("select w from Widget w");
	    List<Widget> widgetInventory = (List<Widget>) q.getResultList();
	    
	    // Print all
	    for (Widget w : widgetInventory)
	      System.out.println( w );
	    
	    System.out.println("There were " + widgetInventory.size() + " widgets in the inventory");

	    // create new widget to persist into the db
	    em.getTransaction().begin();
	    for (Widget w : widgetInventory){
	    	Widget wf = em.find( Widget.class, w.getID() );
	    	em.remove( wf );
	    }
	    	
	    em.getTransaction().commit();

	    // Get the entire Inventory of Widgets
	    q = em.createQuery("select w from Widget w");
	    widgetInventory = (List<Widget>) q.getResultList();
	    
	    System.out.println("There are " + widgetInventory.size() + " widgets in the inventory now.");

	    em.close();
	}
}
