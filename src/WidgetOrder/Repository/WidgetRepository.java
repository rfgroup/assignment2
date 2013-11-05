package WidgetOrder.Repository;


import WidgetOrder.Entity.Widget;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;

// Moved to using named queries, meaning we do not need to use the repository pattern
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
