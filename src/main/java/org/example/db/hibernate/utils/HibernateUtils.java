package org.example.db.hibernate.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HibernateUtils {
    private static EntityManager entityManager;
    public static EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JAVA");
            entityManager = entityManagerFactory.createEntityManager();
            return entityManager;
    }
        return entityManager;
    }
}
