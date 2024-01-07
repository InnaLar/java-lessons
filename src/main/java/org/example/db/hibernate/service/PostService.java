package org.example.db.hibernate.service;

import lombok.RequiredArgsConstructor;
import org.example.db.hibernate.dao.PostDao;
import org.example.db.hibernate.model.Post;

import java.util.List;

@RequiredArgsConstructor
public class PostService {
    private final PostDao postDao;

    public List<Post> findAll() {
        return postDao.findAll()
            .stream()
            .toList();
    }

    public Post save(final Post user) {
        return postDao.save(user);
    }

    public void deleteById(final Long id) {
        postDao.deleteById(id);
    }

    public Post update(final Post user) {
        return postDao.update(user);
    }
}
