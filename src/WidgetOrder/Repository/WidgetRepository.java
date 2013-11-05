package WidgetOrder.Repository;

/**
 * <p>Title: Widget Inventory s</p>
 * <p>Description: CS 343 Assignment #2</p>
 * @author Aaron Cook, Kyle Kornetske, Michael Haas, Kyle Kolstad
 * @email aaron.cook@my.uwrf.edu, michael.haas@my.uwrf.edu,
 * 			kyle.kornetske@my.uwrf.edu kyle.kolstad@my.uwrf.edu
 * @date November 5th 2013
 * @team Group 4
 */ 
import WidgetOrder.Entity.Widget;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;

// Probably won't need to use this anymore. JPA has named queries which I started using which means
// we do not have to use the Repository pattern.
public class WidgetRepository {
    private EntityManager em;

    public WidgetRepository(EntityManager em) {
        this.em = em;
    }

    //public Collection<Widget> find(long ID) {
    //    Query q = em.createNamedQuery("das");
    //}

    public Collection<Widget> findAll() {
        Query q = em.createQuery("select w from Widget w");
        return (Collection<Widget>) q.getResultList();
    }
}
