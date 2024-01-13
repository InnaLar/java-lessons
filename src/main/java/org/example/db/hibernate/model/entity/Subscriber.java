package org.example.db.hibernate.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Builder
@ToString

@Entity
@Table(name = "subscriber")
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nickName", nullable = false)
    private String nickName;
    @CreationTimestamp
    @Column(name = "create_date_time", nullable = false, updatable = false)
    private LocalDateTime createDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Post post;
}
