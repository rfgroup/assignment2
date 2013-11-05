package WidgetOrder.Repository;


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
