package org.example.db.hibernate.dao;

import jakarta.persistence.EntityManager;
import org.example.db.hibernate.model.entity.Post;
import org.example.db.hibernate.utils.HibernateUtils;
import org.example.hw6.dao.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class PostDao implements CrudRepository<Post, Long> {

    @Override
    public List<Post> findAll() {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            return entityManager.createQuery("from Post", Post.class).getResultList();
        }
    }

    @Override
    public Optional<Post> findById(final Long id) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            Post value = entityManager.find(Post.class, id);
            return Optional.ofNullable(value);
        }
    }

    @Override
    public Post save(final Post t) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
            return t;
        }
    }

    @Override
    public void deleteById(final Long id) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            entityManager.getTransaction().begin();
            Post post = entityManager.find(Post.class, id);
            entityManager.remove(post);
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public Post update(final Post newPost) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            entityManager.getTransaction().begin();
            Post post = entityManager.find(Post.class, newPost.getId());

            post.setTitle(newPost.getTitle());
            post.setContent(newPost.getContent());

            entityManager.getTransaction().commit();
            return post;
        }
    }
}
