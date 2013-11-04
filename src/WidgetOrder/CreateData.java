package WidgetOrder;

import Entity.Order;
import Entity.Widget;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import p2.CustomerOrder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateData {

    public static void main(String[] args) {
       deleteExistingDB();
        setUpWidgets();
      //  createOrder();
    }

    private static void createOrder() {
        
    	//creating order object
    	Entity.Order order = new Entity.Order("Aaron Cook");
    	
        //getting widget list from database
        final String PERSISTENCE_UNIT_NAME = "WidgetOrders";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		Query x = em.createQuery("select w from Widget w");
	    List<Widget> widgetInventory = (List<Widget>) x.getResultList();
		
		//adding widgets to the order
		order.addItem(widgetInventory.get(0) );
		order.addItem(widgetInventory.get(1) );
		order.addItem(widgetInventory.get(2) );
		order.addItem(widgetInventory.get(3) );
		
		//updating database
		em.getTransaction().begin();
		em.persist( order );
		em.getTransaction().commit();
		em.close();

        
    }

    public static void deleteExistingDB() {
        File directory = new File("widgetorders.db");
        //make sure directory exists
        if(!directory.exists()){

            System.out.println("Directory does not exist.");
            System.exit(0);

        }else{

            try{

                delete(directory);

            }catch(IOException e){
                e.printStackTrace();
                System.exit(0);
            }
        }
    }

    public static void setUpWidgets() {
        List<Widget> widgets = new ArrayList<Widget>();

        widgets.add(new Widget(20,"Widget#1","Widget 1 Description"));
        widgets.add(new Widget(20,"Widget#2","Widget 2 Description"));
        widgets.add(new Widget(20,"Widget#3","Widget 3 Description"));
        widgets.add(new Widget(20,"Widget#4","Widget 4 Description"));
        
        List<Order> orderList = new ArrayList<Order>();
	    orderList.add( new Order( "Aaron Cook" ) );
	    orderList.add( new Order( "Michael Haas" ) );
	    orderList.add( new Order( "Kyle Kornetzke" ) );
	    orderList.add( new Order( "Kyle Kolstad" ) );
	    orderList.get(0).addItem( widgets.get(0) );
	    orderList.get(0).addItem( widgets.get(1) );
	    orderList.get(1).addItem( widgets.get(2) );
	    orderList.get(1).addItem( widgets.get(3) );
	    orderList.get(2).addItem( widgets.get(0) );
	    orderList.get(2).addItem( widgets.get(1) );
	    orderList.get(2).addItem( widgets.get(2) );
	    orderList.get(3).addItem( widgets.get(3) );
	    orderList.get(3).addItem( widgets.get(0) );
	    orderList.get(3).addItem( widgets.get(1) );	    
        
        final String PERSISTENCE_UNIT_NAME = "WidgetOrders";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        EntityManager em = factory.createEntityManager();

        // create new widget to persist into the db
        em.getTransaction().begin();

        // Persist all
        for (Widget w : widgets)
            em.persist(w);
        
        for (Order or : orderList)
	    	em.persist( or );

        em.getTransaction().commit();
        
        
        Query q = em.createQuery("select w from Widget w");
	    List<Widget> widgetInventory = q.getResultList();
	    q = em.createQuery("select o from CustomerOrder o");
	    List<CustomerOrder> ordersFromDB = q.getResultList();
	    em.close();
	    for (Widget w : widgetInventory)
		      System.out.println( w );
	    for (CustomerOrder or : ordersFromDB)
	    	System.out.println( or );
    }

    public static void delete(File file)
            throws IOException {

        if(file.isDirectory()){

            //directory is empty, then delete it
            if(file.list().length==0){

                file.delete();
                System.out.println("Directory is deleted : "
                        + file.getAbsolutePath());

            }else{

                //list all the directory contents
                String files[] = file.list();

                for (String temp : files) {
                    //construct the file structure
                    File fileDelete = new File(file, temp);

                    //recursive delete
                    delete(fileDelete);
                }

                //check the directory again, if empty then delete it
                if(file.list().length==0){
                    file.delete();
                    System.out.println("Directory is deleted : "
                            + file.getAbsolutePath());
                }
            }

        }else{
            //if file, then delete it
            file.delete();
            System.out.println("File is deleted : " + file.getAbsolutePath());
        }
    }

}
