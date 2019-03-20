package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource;

public class CommentResource extends BaseResource {

    private String text;

    public CommentResource() { }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}