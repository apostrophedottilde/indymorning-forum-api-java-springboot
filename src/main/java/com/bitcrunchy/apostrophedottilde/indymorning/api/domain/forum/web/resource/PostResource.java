package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource;

public class PostResource extends BaseResource {

    private String text;

    private Long threadId;

    public PostResource() { }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }
}