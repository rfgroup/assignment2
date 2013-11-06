package WidgetOrder.Entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * <p>Title: EntityManagerContainer</p>
 * <p>Description: I'm using this class to sort of simulate a real life scenario where
 * you would get the EntityManager from a DIC container.</p>
 * @author Michael Haas
 * @email aaron.cook@my.uwrf.edu, michael.haas@my.uwrf.edu,
 * 			kyle.kornetske@my.uwrf.edu kyle.kolstad@my.uwrf.edu
 * @date November 5th 2013
 * @team Group 4
 */
public class EntityManagerContainer {
    private final String PERSISTENCE_UNIT_NAME = "WidgetOrders";
    private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public EntityManagerContainer() { }

    public EntityManager getEm() {
        return emFactory.createEntityManager();
    }
}
