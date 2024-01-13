package org.example.db.hibernate.mapper;

import org.example.db.hibernate.model.dto.PostCommentRS;
import org.example.db.hibernate.model.entity.Comment;
import org.example.db.hibernate.model.entity.Post;

public class CommentMapper {
    public Comment toComment(final PostCommentRS request, final Post post) {
        return Comment.builder()
            .content(request.getContent())
            .post(post)
            .build();
    }

}
