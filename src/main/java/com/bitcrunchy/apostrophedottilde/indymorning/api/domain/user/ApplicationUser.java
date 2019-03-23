package com.bitcrunchy.apostrophedottilde.indymorning.api.domain.user;

import com.bitcrunchy.apostrophedottilde.indymorning.api.domain.forum.entity.BaseEntity;

import javax.persistence.*;

@Entity(name = "app_user")
public class ApplicationUser extends BaseEntity {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}