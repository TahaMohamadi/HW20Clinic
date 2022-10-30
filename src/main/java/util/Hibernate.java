package util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Hibernate {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY;

    private Hibernate() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (ENTITY_MANAGER_FACTORY == null) {
            ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("clinic");
        }
        return ENTITY_MANAGER_FACTORY;
    }
}