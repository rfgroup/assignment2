package WidgetOrder.Entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created with IntelliJ IDEA.
 * User: mike
 * Date: 11/5/13
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class EntityManagerContainer {
    private final String PERSISTENCE_UNIT_NAME = "WidgetOrders";
    private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public EntityManagerContainer() { }

    public EntityManager getEm() {
        return emFactory.createEntityManager();
    }
}
