package org.example.db.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Builder
@ToString

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String content;

    @CreationTimestamp
    @Column(name = "create_date_time", nullable = false, updatable = false)
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    @Column(name = "update_date_time")
    private LocalDateTime updateDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Post post;

}
