package org.example.db.hibernate.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCommentRS {
    private Long idPost;
    private String content;

    @Override
    public String toString() {
        return "PostCommentRS{"
            + "idPost=" + idPost
            + ", content='" + content + '\''
            + '}';
    }
}
