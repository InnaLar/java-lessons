package org.example.db.hibernate.dao;

import jakarta.persistence.EntityManager;
import org.example.db.hibernate.model.dto.UpdateCommentDto;
import org.example.db.hibernate.model.entity.Comment;
import org.example.db.hibernate.utils.HibernateUtils;
import org.example.hw6.dao.CrudRepository;

import java.util.List;
import java.util.Optional;

public class CommentDao implements CrudRepository<Comment, Long> {
    @Override
    public List<Comment> findAll() {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            return entityManager.createQuery("from Comment com join fetch com.post ",
                    Comment.class)
                .getResultList();
        }
    }

    @Override
    public Optional<Comment> findById(final Long id) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            return Optional.ofNullable(entityManager.find(Comment.class, id));
        }
    }

    @Override
    public Comment save(final Comment comment) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(comment);
            entityManager.getTransaction().commit();
            return comment;
        }
    }

    @Override
    public void deleteById(final Long id) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            entityManager.getTransaction().begin();
            Comment comment = entityManager.find(Comment.class, id);
            entityManager.remove(comment);
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public Comment update(final Comment request) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            entityManager.getTransaction().begin();
            Comment comment = entityManager.find(Comment.class, request.getId());

            comment.setPost(request.getPost());
            comment.setContent(request.getContent());

            entityManager.getTransaction().commit();
            return comment;
        }
    }

    public Comment update(final UpdateCommentDto request) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            entityManager.getTransaction().begin();
            Comment comment = entityManager.find(Comment.class, request.getId());

            comment.setContent(request.getContent());

            entityManager.getTransaction().commit();
            return comment;
        }
    }
}
