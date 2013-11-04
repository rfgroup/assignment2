package WidgetOrder;

import Entity.Order;
import Entity.Widget;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateData {

    public static void main(String[] args) {
        deleteExistingDB();
        setUpWidgets();
        createOrder();
    }

    private static void createOrder() {
        Order order = new Order();

        Collection<Widget> widgets = new ArrayList<Widget>();

        widgets.add(new Widget(20));

        order.setCustomerName("Mike Haas").setWidgets(widgets);
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

        widgets.add(new Widget(34));

        final String PERSISTENCE_UNIT_NAME = "WidgetOrders";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        EntityManager em = factory.createEntityManager();

        // create new widget to persist into the db
        em.getTransaction().begin();

        // Persist all
        for (Widget w : widgets)
            em.persist(w);

        em.getTransaction().commit();
        em.close();
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
