package WidgetOrder;
/**
 * <p>Title: Widget Inventory s</p>
 * <p>Description: CS 343 Assignment #2</p>
 * @author Aaron Cook, Kyle Kornetske, Michael Haas, Kyle Kolstad
 * @email aaron.cook@my.uwrf.edu, michael.haas@my.uwrf.edu,
 * 			kyle.kornetske@my.uwrf.edu kyle.kolstad@my.uwrf.edu
 * @date November 5th 2013
 * @team Group 4
 */ 

import WidgetOrder.Entity.CustomerOrder;
import WidgetOrder.Entity.Widget;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;

public class CreateFixtures {
    private final String PERSISTENCE_UNIT_NAME = "WidgetOrders";
    private EntityManagerFactory emFactory;

    public CreateFixtures() {
        this.emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public CreateFixtures run() {
        createWidgets();

        return this;
    }

    public void createWidgets() {
        EntityManager em = emFactory.createEntityManager();

        // Create some widgets and persist
        em.getTransaction().begin();
        em.persist(new Widget().setName("Widget Cracker")
            .setDescription("This is a widget that cracks open other widgets")
            .setQuantity(50));
        em.persist(new Widget().setName("Flying Widget")
            .setDescription("This is a widget that knows how to fly")
            .setQuantity(4700));
        em.persist(new Widget().setName("Widget Bin")
            .setDescription("Keep all of your widgets nice and organized by storing them in a widget bin!")
            .setQuantity(2));

        em.getTransaction().commit();

        em.close();
    }

    public CreateFixtures mikesTesting() {
        EntityManager em = emFactory.createEntityManager();

        // Create a widget and persist
        em.getTransaction().begin();
        em.persist(new Widget(23, "Widget1", "description"));
        em.persist(new Widget(74, "WidgetCracker", "This widget cracks other widgets open."));
        em.getTransaction().commit();

        // Fetch widgets from the DB
        Collection<Widget> widgets = em.createNamedQuery("Widget.findAll", Widget.class).getResultList();

        // Example showing how to retrieve one widget by the id
        //Collection<Widget> widgets = em.createNamedQuery("Widget.findById", Widget.class).setParameter("id", 2).getResultList();

        // Create an order and persist
        CustomerOrder order = new CustomerOrder();

        for(Widget widget : widgets) {
            if(widget.getName() == "WidgetCracker") {
                order.setCustomerName("Mike Haas").addWidget(widget);
            }
        }

        em.getTransaction().begin();
        em.persist(order);
        em.persist(new CustomerOrder().addWidget(new Widget(99, "Flying Widget", "A widget that flies.")));
        em.getTransaction().commit();

        order = new CustomerOrder();
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
