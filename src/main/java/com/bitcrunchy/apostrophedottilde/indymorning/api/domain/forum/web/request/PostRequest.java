package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.request;

public class PostRequest {

    private String text;

    private Long threadId;

    public PostRequest() {
    }

    public PostRequest(String postText) {
        this.text = postText;
    }

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
