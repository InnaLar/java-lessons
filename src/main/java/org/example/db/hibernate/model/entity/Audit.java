package org.example.db.hibernate.model.entity;

import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

public class Audit {
    @CreationTimestamp
    @Column(name = "create_date_time", nullable = false, updatable = false)
    private LocalDateTime createDateTime;
    @UpdateTimestamp
    @Column(name = "update_date_time")
    private LocalDateTime updateDateTime;
}
