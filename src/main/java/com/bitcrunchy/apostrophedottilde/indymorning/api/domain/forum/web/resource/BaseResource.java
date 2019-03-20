package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.web.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public abstract class BaseResource extends ResourceSupport {

    private Long id;

    @JsonFormat(pattern = "dd::MM::yyyy")
    private LocalDateTime createdOn;

    @JsonFormat(pattern = "dd::MM::yyyy")
    private LocalDateTime updatedOn;

    private String createdBy;

    private String updatedBy;

    @JsonProperty("id")
    public Long getThisId() {
        return id;
    }

    public void setThisId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
