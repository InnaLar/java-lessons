package org.example.db.hibernate.dao;

import jakarta.persistence.EntityManager;
import org.example.db.hibernate.model.Post;
import org.example.db.hibernate.utils.HibernateUtils;
import org.example.hw6.dao.CrudRepository;

import java.util.List;
import java.util.Optional;

public class PostDao implements CrudRepository<Post, Long> {
    /**
     * @return
     */
    @Override
    public List<Post> findAll() {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            entityManager.getTransaction().begin();
            return entityManager.createQuery("from Post", Post.class).getResultList();
            }
      }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Post> findById(Long id) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            entityManager.getTransaction().begin();
            return Optional.ofNullable(entityManager.find(Post.class, id));
        }
    }

    /**
     * @param user
     * @return
     */
    @Override
    public Post save(Post user) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return user;
        }
    }

    /**
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            entityManager.getTransaction().begin();
            Post post = entityManager.find(Post.class, id);
            entityManager.remove(post);
            entityManager.getTransaction().commit();
            }
    }

    /**
     * @param user
     * @return
     */
    @Override
    public Post update(Post user) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            entityManager.getTransaction().begin();
            Post post = entityManager.find(Post.class, user.getId());
            post = user;
            entityManager.getTransaction().commit();
            return post;
        }
    }
}
