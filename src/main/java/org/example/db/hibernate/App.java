package org.example.db.hibernate;

import jakarta.persistence.EntityManager;
import org.example.db.hibernate.dao.CommentDao;
import org.example.db.hibernate.dao.PostDao;
import org.example.db.hibernate.mapper.CommentMapper;
import org.example.db.hibernate.model.dto.PostCommentRs;
import org.example.db.hibernate.model.entity.Comment;
import org.example.db.hibernate.model.entity.Post;
import org.example.db.hibernate.model.entity.Subscriber;
import org.example.db.hibernate.service.CommentService;
import org.example.db.hibernate.utils.HibernateUtils;

import java.util.List;
import java.util.Random;

@SuppressWarnings({"PMD.SystemPrintln", "ExecutableStatementCount"})
public class App {
    private static final Random RANDOM = new Random();

    public static void main(final String[] args) {
        PostDao postDao = new PostDao();
        CommentDao commentDao = new CommentDao();
        CommentMapper commentMapper = new CommentMapper();
        CommentService commentService = new CommentService(commentDao, postDao, commentMapper);
        long randomId;

        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            entityManager.getTransaction().begin();

            entityManager.persist(Post.builder()
                .title("Альберт Камю1")
                .content("Тест")
                .build()
                .withComment(Comment.builder()
                    .content("comment1")
                    .build())
                .withSubscriber(Subscriber.builder()
                    .nickName("Basil").build()));

            entityManager.persist(Post.builder()
                .title("Альберт Камю2")
                .content("Тест")
                .build()
                .withComment(Comment.builder()
                    .content("comment2")
                    .build())
                .withSubscriber(Subscriber.builder()
                    .nickName("Serega")
                    .build())
                .withSubscriber(Subscriber.builder()
                    .nickName("beeMaya").build()));

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
        //Создание коммента к посту
        try (EntityManager entityManager = HibernateUtils.getEntityManager()) {
            entityManager.getTransaction().begin();
            PostCommentRs request = PostCommentRs.builder()
                .content("comment4")
                .postId(1L)
                .build();

            commentService.savePostId(request);

            //Получение поста с комментами
            List<Post> fromPost;
            fromPost = entityManager.createQuery("from Post pst join fetch pst.commentList", Post.class)
                .getResultList();

            for (Post post : fromPost) {
                for (Comment comment : post.getCommentList()) {
                    System.out.print(post + " ");
                    System.out.println(comment);
                }

            }

            randomId = (long) (RANDOM.nextInt(fromPost.size() - 1 + 1) + 1);

            //Получение рандомного поста с комментами
            List<Post> postList;
            postList = entityManager.createQuery("""
                    from Post pst
                    left join fetch pst.commentList
                    where pst.id = :postId""", Post.class)
                .setParameter("postId", randomId)
                .getResultList();
            postList = entityManager.createQuery("""
                    select pst
                    from Post pst
                    left join fetch pst.subscriberList
                    where pst in :postList""", Post.class)
                .setParameter("postList", postList)
                .getResultList();

            for (Post post : postList) {
                for (int i = 0; i < Math.max(post.getCommentList().size(), post.getSubscriberList().size()); i++) {
                    System.out.print(post + " ");
                    if (i < post.getCommentList().size()) {
                        System.out.print(post.getCommentList().get(i) + " ");
                    } else {
                        System.out.print("      ");

                    }
                    if (i < post.getSubscriberList().size()) {
                        System.out.println(post.getSubscriberList().get(i) + " ");
                    } else {
                        System.out.println("      ");
                    }
                }
            }

        }

    }

}

