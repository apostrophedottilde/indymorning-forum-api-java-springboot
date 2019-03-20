package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonFormat(pattern = "dd::MM::yyyy")
    private LocalDateTime createdOn;

    @JsonFormat(pattern = "dd::MM::yyyy")
    private LocalDateTime updatedOn;

    private String createdBy;

    private String updatedBy;

    @PrePersist
    public void prePersist() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        createdOn = LocalDateTime.now();
        createdBy = auth.getName();
        updatedOn = LocalDateTime.now();
        updatedBy = auth.getName();
    }

    @PreUpdate
    public void preUpdate() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        createdOn = LocalDateTime.now();
        createdBy = auth.getName();
        updatedOn = LocalDateTime.now();
        updatedBy = auth.getName();
    }


    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Long getId() {
        return id;
    }
}
