package p2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.ArrayList;
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
	    
	    // Print all widgets
	    for (Widget w : widgetList)
	      System.out.println( w );
	    
	    
	    // Create a number of Orders
	    List<CustomerOrder> orderList = new ArrayList<CustomerOrder>();
	    orderList.add( new CustomerOrder( "Customer 1" ) );
	    orderList.add( new CustomerOrder( "Customer 2" ) );
	    orderList.add( new CustomerOrder( "Customer 3" ) );
	    orderList.add( new CustomerOrder( "Customer 4" ) );
	    orderList.get(0).addItem( widgetList.get(0) );
	    orderList.get(0).addItem( widgetList.get(1) );
	    orderList.get(1).addItem( widgetList.get(2) );
	    orderList.get(1).addItem( widgetList.get(3) );
	    orderList.get(2).addItem( widgetList.get(0) );
	    orderList.get(2).addItem( widgetList.get(1) );
	    orderList.get(2).addItem( widgetList.get(2) );
	    orderList.get(3).addItem( widgetList.get(3) );
	    orderList.get(3).addItem( widgetList.get(0) );
	    orderList.get(3).addItem( widgetList.get(1) );	    
	    
	    // Print all orders
	    for (CustomerOrder or : orderList)
	      System.out.println( or );

	    

		final String PERSISTENCE_UNIT_NAME = "WidgetsAndOrders";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
	    EntityManager em = factory.createEntityManager();

	    // create new widget to persist into the db
	    em.getTransaction().begin();
	    
	    // Persist all widgets
	    for (Widget w : widgetList)
	    	em.persist( w  );

	    // Persist all orders
	    for (CustomerOrder or : orderList)
	    	em.persist( or );

	    em.getTransaction().commit();

	    
	    // Get the entire Inventory of Widgets from the database
	    Query q = em.createQuery("select w from Widget w");
	    List<Widget> widgetInventory = q.getResultList();
	    q = em.createQuery("select o from CustomerOrder o");
	    List<CustomerOrder> ordersFromDB = q.getResultList();
	    em.close();
	    
	    // Print all widgets from the database
	    for (Widget w : widgetInventory)
	      System.out.println( w );
	    // Print all orders from the database
	    for (CustomerOrder or : ordersFromDB)
	    	System.out.println( or );
	    
	    System.out.println("There are " + widgetInventory.size() + " widgets and " + ordersFromDB.size() + " orders in the database");
	}
}
