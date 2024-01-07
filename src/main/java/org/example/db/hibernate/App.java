package org.example.db.hibernate;

import jakarta.persistence.EntityManager;
import org.example.db.hibernate.model.Comment;
import org.example.db.hibernate.model.Post;
import org.example.db.hibernate.utils.HibernateUtils;

import java.util.List;

public class App {
    public static void main(final String[] args) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            entityManager.getTransaction().begin();

            entityManager.persist(Post.builder()
                .title("Альберт Камю1")
                .content("Тест")
                .build()
                .withComment(Comment.builder()
                    .content("comment1")
                    .build()));

            entityManager.persist(Post.builder()
                .title("Альберт Камю2")
                .content("Тест")
                .build()
                .withComment(Comment.builder()
                    .content("comment2")
                    .build()));

            entityManager.persist(Post.builder()
                .title("Альберт Камю3")
                .content("Тест")
                .build()
                .withComment(Comment.builder()
                    .content("comment3")
                    .build()));

            entityManager.getTransaction().commit();
        }

        List<Comment> fromComment;
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            fromComment = entityManager.createQuery(
                    "from Comment com join fetch com.post ",
                    Comment.class)
                .getResultList();

        }

        fromComment.forEach(System.out::println);

    }

}

