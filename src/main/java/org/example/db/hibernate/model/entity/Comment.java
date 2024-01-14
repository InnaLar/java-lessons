package org.example.db.hibernate.model.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@SuperBuilder
@ToString

@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {
    private String content;

    @Embedded
    private Audit audit;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Post post;

}
