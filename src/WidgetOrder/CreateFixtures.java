package WidgetOrder;

import WidgetOrder.Entity.Order;
import WidgetOrder.Entity.Widget;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;

/**
 * <p>Title: Widget Inventory s</p>
 * <p>Description: CS 343 Assignment #2</p>
 * @author Aaron Cook, Kyle Kornetske, Michael Haas, Kyle Kolstad
 * @email aaron.cook@my.uwrf.edu, michael.haas@my.uwrf.edu,
 * 			kyle.kornetske@my.uwrf.edu kyle.kolstad@my.uwrf.edu
 * @date November 5th 2013
 * @team Group 4
 */
public class CreateFixtures {
    private final String PERSISTENCE_UNIT_NAME = "WidgetOrders";
    private EntityManagerFactory emFactory;

    public CreateFixtures() {
        this.emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public CreateFixtures run() {
        createWidgets();
        createOrders();

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

    private void createOrders() {
        EntityManager em = emFactory.createEntityManager();

        Widget widget = em.createNamedQuery("Widget.findByName", Widget.class).setParameter("name", "Widget Bin").getSingleResult();

        em.getTransaction().begin();
        em.persist(new Order().setCustomerName("Mike Haas").addWidget(widget));
        em.getTransaction().commit();

        em.close();
    }

    //public CreateFixtures mikesTesting() {
    //    EntityManager em = emFactory.createEntityManager();
    //
    //    // Create a widget and persist
    //    em.getTransaction().begin();
    //    em.persist(new Widget(23, "Widget1", "description"));
    //    em.persist(new Widget(74, "WidgetCracker", "This widget cracks other widgets open."));
    //    em.getTransaction().commit();
    //
    //    // Fetch widgets from the DB
    //    Collection<Widget> widgets = em.createNamedQuery("Widget.findAll", Widget.class).getResultList();
    //
    //    // Example showing how to retrieve one widget by the id
    //    //Collection<Widget> widgets = em.createNamedQuery("Widget.findById", Widget.class).setParameter("id", 2).getResultList();
    //
    //    // Create an order and persist
    //    Order order = new Order();
    //
    //    for(Widget widget : widgets) {
    //        if(widget.getName() == "WidgetCracker") {
    //            order.setCustomerName("Mike Haas").addWidget(widget);
    //        }
    //    }
    //
    //    em.getTransaction().begin();
    //    em.persist(order);
    //    em.persist(new Order().addWidget(new Widget(99, "Flying Widget", "A widget that flies.")));
    //    em.getTransaction().commit();
    //
    //    order = new Order();
    //    for(Widget widget : widgets) {
    //        if(widget.getName() == "WidgetCracker") {
    //            order.setCustomerName("Mike Haas").addWidget(widget);
    //        }
    //    }
    //
    //    em.getTransaction().begin();
    //    em.persist(order);
    //    em.getTransaction().commit();
    //
    //    em.close();
    //
    //    return this;
    //}
}
