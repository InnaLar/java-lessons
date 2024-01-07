package org.example.db.hibernate;

import jakarta.persistence.EntityManager;
import org.example.db.hibernate.dao.PostDao;
import org.example.db.hibernate.model.Post;
import org.example.db.hibernate.service.PostService;
import org.example.db.hibernate.utils.HibernateUtils;

import java.util.List;

public class App {
    public static void main(final String[] args) {
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            Post post = Post.builder()
                .title("Альберт Камю")
                .content("Посторонние")
                .build();
            PostDao postDao = new PostDao();
            PostService postService = new PostService(postDao);
            postService.save(post);
            printTablePost(postService);
            try {
                postService.deleteById(1L);
                postService.deleteById(2L);
                postService.deleteById(3L);
            } catch (Exception ignored) {

            }
        Post postToUpdate = Post.builder()
            .id(4L)
                .title("Альберт Камю")
                .content("Чума")
                .build();
        postService.update(postToUpdate);
        printTablePost(postService);
     } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void printTablePost(PostService postService) {
        List<Post> postList = postService.findAll();
        for (Post postTable: postList) {
            System.out.println(postTable.ToString());
        }
    }
    }

