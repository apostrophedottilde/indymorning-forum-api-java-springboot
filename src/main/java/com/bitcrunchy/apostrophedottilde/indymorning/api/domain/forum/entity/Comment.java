package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    @Column(name = "text")
    private String text;

    @ManyToOne
    private Post post;

    public Comment() { }

    @PrePersist
    public void prePersist() {
        super.prePersist();
    }

    @PreUpdate
    public void preUpdate() {
        super.preUpdate();
    }


    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}