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
}
