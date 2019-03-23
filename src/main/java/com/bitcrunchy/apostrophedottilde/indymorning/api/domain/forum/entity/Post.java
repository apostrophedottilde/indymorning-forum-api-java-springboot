package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity {

    @Column(name = "text")
    private String text;

    @ManyToOne
    private Thread thread;

    public Post() { }

    @PrePersist
    public void prePersist() {
        super.prePersist();
    }

    @PreUpdate
    public void preUpdate() {
        super.preUpdate();
    }


    public Thread getThread() { return thread; }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}