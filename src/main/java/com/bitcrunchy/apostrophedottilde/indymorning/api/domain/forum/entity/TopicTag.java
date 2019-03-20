package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity;

import javax.persistence.*;

@Entity
public class TopicTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    protected TopicTag() { }

}