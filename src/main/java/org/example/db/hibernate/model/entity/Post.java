package org.example.db.hibernate.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "content", nullable = false)
    private String content;

    @CreationTimestamp
    @Column(name = "create_date_time", nullable = false, updatable = false)
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    @Column(name = "update_date_time")
    private LocalDateTime updateDateTime;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    private List<Subscriber> subscriberList = new ArrayList<>();

    public Post withComment(final Comment comment) {
        this.commentList.add(comment);
        comment.setPost(this);
        return this;
    }

    public Post withSubscriber(final Subscriber subscriber) {
        this.subscriberList.add(subscriber);
        subscriber.setPost(this);
        return this;
    }
}
