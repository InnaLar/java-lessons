package org.example.db.hibernate.service;

import lombok.RequiredArgsConstructor;
import org.example.db.hibernate.dao.PostDao;
import org.example.db.hibernate.exception.ErrorCode;
import org.example.db.hibernate.exception.ServiceException;
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
    public Post save(Post user) {
        return postDao.save(user);
    }
    public void deleteById(Long id) {
        Post post = postDao.findById(id)
            .orElseThrow(() -> new ServiceException(ErrorCode.ERR_CODE_001, id));
    }
    public Post update(Post user) {
        postDao.update(user);
        return user;
    }
}
