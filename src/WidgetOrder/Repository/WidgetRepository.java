package WidgetOrder.Repository;


import WidgetOrder.Entity.Widget;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;

public class WidgetRepository {
    private EntityManager em;

    public WidgetRepository(EntityManager em) {
        this.em = em;
    }

    //public Collection<Widget> find(long ID) {
    //}

    public Collection<Widget> findAll() {
        Query q = em.createQuery("select w from Widget w");
        return (Collection<Widget>) q.getResultList();
    }
}
