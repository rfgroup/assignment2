package WidgetOrder;

import WidgetOrder.Entity.CustomerOrder;
import WidgetOrder.Entity.Widget;
import WidgetOrder.Repository.WidgetRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;

public class CreateData {
    private final String PERSISTENCE_UNIT_NAME = "WidgetOrders";
    private EntityManagerFactory emFactory;

    public CreateData() {
        this.emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public CreateData run() {
        EntityManager em = emFactory.createEntityManager();

        // Create a widget and persist
        em.getTransaction().begin();
        em.persist(new Widget(23, "Widget1", "description"));
        em.persist(new Widget(74, "WidgetCracker", "This widget cracks other widgets open."));
        em.getTransaction().commit();

        // Fetch widgets from the DB
        Collection<Widget> widgets = new WidgetRepository(em).findAll();

        // Create an order and persist
        CustomerOrder order = new CustomerOrder();

        for(Widget widget : widgets) {
            if(widget.getName() == "WidgetCracker") {
                order.setCustomerName("Mike Haas").addWidget(widget);
            }
        }

        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();

        em.close();

        return this;
    }

    //    private void createOrder() {
    //
    //    	//creating order object
    ////    	WidgetOrder.Entity.CustomerOrder order = new WidgetOrder.Entity.CustomerOrder("Aaron Cook");
    //
    //        //getting widget list from database
    //		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    //		EntityManager em = factory.createEntityManager();
    //		Query x = em.createQuery("select w from Widget w");
    //	    List<Widget> widgetInventory = (List<Widget>) x.getResultList();
    //
    //		//adding widgets to the order
    //		order.addItem(widgetInventory.get(0) );
    //		order.addItem(widgetInventory.get(1) );
    //		order.addItem(widgetInventory.get(2) );
    //		order.addItem(widgetInventory.get(3) );
    //
    //		//updating database
    //		em.getTransaction().begin();
    //		em.persist( order );
    //		em.getTransaction().commit();
    //		em.close();
    //
    //
    //    }

    //    private void setUpWidgets() {
    //
    //    	List<Widget> widgets = new ArrayList<Widget>();
    //
    //        widgets.add(new Widget(20,"Widget#1","Widget 1 Description"));
    //        widgets.add(new Widget(20,  "Widget#2","Widget 2 Description"));
    //        widgets.add(new Widget(20,"Widget#3","Widget 3 Description"));
    //        widgets.add(new Widget(20,"Widget#4","Widget 4 Description"));
    //
    //        List<CustomerOrder> orderList = new ArrayList<CustomerOrder>();
    //	    orderList.add( new CustomerOrder( "Aaron Cook" ) );
    //	    orderList.add( new CustomerOrder( "Michael Haas" ) );
    //	    orderList.add( new CustomerOrder( "Kyle Kornetzke" ) );
    //	    orderList.add( new CustomerOrder( "Kyle Kolstad" ) );
    //	    orderList.get(0).addItem( widgets.get(0) );
    //	    orderList.get(0).addItem( widgets.get(1) );
    //	    orderList.get(1).addItem( widgets.get(2) );
    //	    orderList.get(1).addItem( widgets.get(3) );
    //	    orderList.get(2).addItem( widgets.get(0) );
    //	    orderList.get(2).addItem( widgets.get(1) );
    //	    orderList.get(2).addItem( widgets.get(2) );
    //	    orderList.get(3).addItem( widgets.get(3) );
    //	    orderList.get(3).addItem( widgets.get(0) );
    //	    orderList.get(3).addItem( widgets.get(1) );
    //
    //	    // Print all orders
    //	    for (CustomerOrder or : orderList)
    //	      System.out.println( or );
    //
    //
    //        EntityManager em = emFactory.createEntityManager();
    //
    //
    //        // create new widget to persist into the db
    //        em.getTransaction().begin();
    //
    //        // Persist all
    //        for (Widget w : widgets)
    //            em.persist(w);
    //
    //        for (CustomerOrder or : orderList)
    //	    	em.persist( or );
    //
    //        em.getTransaction().commit();
    //
    //
    //        Query q = em.createQuery("select w from Widget w");
    //	    List<Widget> widgetInventory = q.getResultList();
    //	    q = em.createQuery("select o from CustomerOrder o");
    //	    List<CustomerOrder> ordersFromDB = q.getResultList();
    //	    em.close();
    //	    for (Widget w : widgetInventory)
    //		      System.out.println( w );
    //	    for (CustomerOrder or : ordersFromDB)
    //	    	System.out.println( or );
    //    }


}
