package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.user.ApplicationUser;
import com.sun.deploy.association.utility.AppUtility;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "thread")
public class Thread extends BaseEntity {

    private String title;

    private String description;

    private String state;

    @OneToMany
    private List<Post> posts;

    @OneToOne
    private ApplicationUser creator;

    public Thread() { }

    @PrePersist
    public void prePersist() {
        super.prePersist();
        posts = new ArrayList<>();
        state = "OPEN";
    }

    @PreUpdate
    public void preUpdate() {
        super.preUpdate();
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void cancelForReason(String cancellationReason) {
        state = "CANCELLED";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ApplicationUser getCreator() {
        return creator;
    }

    public void setCreator(ApplicationUser creator) {
        this.creator = creator;
    }
}