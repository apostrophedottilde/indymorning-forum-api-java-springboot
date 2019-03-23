package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.user.ApplicationUser;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    private ApplicationUser creator;

    @JsonFormat(pattern = "dd::MM::yyyy")
    private LocalDateTime createdOn;

    @JsonFormat(pattern = "dd::MM::yyyy")
    private LocalDateTime updatedOn;


    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
        updatedOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        createdOn = LocalDateTime.now();
        updatedOn = LocalDateTime.now();
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


    public Long getId() {
        return id;
    }

    public ApplicationUser getCreator() {
        return creator;
    }

    public void setCreator(ApplicationUser creator) {
        this.creator = creator;
    }
}
