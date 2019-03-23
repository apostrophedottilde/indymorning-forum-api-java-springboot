package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.shared.resource.BaseResource;

public class ThreadResource extends BaseResource {

    private String title;

    private String description;

    private String state;

    public ThreadResource() { }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

}