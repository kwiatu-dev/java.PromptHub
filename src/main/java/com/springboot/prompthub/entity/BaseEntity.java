package com.springboot.prompthub.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @UuidGenerator
    private String id;

    @ManyToOne
    @CreatedBy
    @Column(name = "created_by")
    private User createdBy;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @LastModifiedBy
    @Column(name = "modified_by")
    private User modifiedBy;

    @LastModifiedDate
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @ManyToOne
    @Column(name = "deleted_by")
    private User deletedBy;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
