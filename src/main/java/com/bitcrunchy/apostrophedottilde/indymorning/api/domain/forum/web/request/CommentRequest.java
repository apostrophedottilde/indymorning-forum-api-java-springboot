package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.request;

public class CommentRequest {

    private String text;

    private Long postId;

    public CommentRequest() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
