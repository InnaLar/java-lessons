package org.example.db.hibernate.service;

import lombok.RequiredArgsConstructor;
import org.example.db.hibernate.dao.CommentDao;
import org.example.db.hibernate.dao.PostDao;
import org.example.db.hibernate.exception.ErrorCode;
import org.example.db.hibernate.exception.ServiceException;
import org.example.db.hibernate.mapper.CommentMapper;
import org.example.db.hibernate.model.dto.PostCommentRs;
import org.example.db.hibernate.model.dto.UpdateCommentDto;
import org.example.db.hibernate.model.entity.Comment;
import org.example.db.hibernate.model.entity.Post;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CommentService {
    private final CommentDao commentDao;
    private final PostDao postDao;
    private final CommentMapper commentMapper;

    public List<Comment> findAll() {
        return commentDao.findAll();
    }

    public Comment findById(final Long id) {
        return commentDao.findById(id)
            .orElseThrow(() -> new ServiceException(ErrorCode.ERR_CODE_002, id));
    }

    public Comment save(final Comment comment) {
        if (comment.getPost() == null) {
            throw new ServiceException(ErrorCode.ERR_CODE_001, (Object) null);
        }
        return commentDao.save(comment);
    }

    public Comment update(final UpdateCommentDto request) {
        return commentDao.update(request);
    }

    public void deleteById(final Long id) {
        commentDao.deleteById(id);
    }

    public void savePostId(final PostCommentRs request) {
        Optional<Post> post = postDao.findById(request.getPostId());
        if (post.isEmpty()) {
            throw new ServiceException(ErrorCode.ERR_CODE_001, request.getPostId());
        }
        Comment comment = commentMapper.toComment(request, post.get());
        commentDao.save(comment);
    }
}
