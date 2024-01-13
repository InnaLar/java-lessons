package org.example.db.hibernate.service;

import lombok.RequiredArgsConstructor;
import org.example.db.hibernate.dao.PostDao;
import org.example.db.hibernate.exception.ErrorCode;
import org.example.db.hibernate.exception.ServiceException;
import org.example.db.hibernate.model.entity.Post;

import java.util.List;

@RequiredArgsConstructor
public class PostService {
    private final PostDao postDao;

    public List<Post> findAll() {
        return postDao.findAll()
            .stream()
            .toList();
    }

    public Post findById(final Long id) {
        return postDao.findById(id)
            .orElseThrow(() -> new ServiceException(ErrorCode.ERR_CODE_001, id));
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
