package org.example.db.hibernate;

import jakarta.persistence.EntityManager;
import org.example.db.hibernate.model.Post;
import org.example.db.hibernate.utils.HibernateUtils;

public class App {
    public static void main(String[] args) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            entityManager.getTransaction().begin();

            Post post = Post.builder()
                .title("title")
                .content("content")
                .build();
            entityManager.persist(post);

            entityManager.getTransaction().commit();
        }
    }
}
