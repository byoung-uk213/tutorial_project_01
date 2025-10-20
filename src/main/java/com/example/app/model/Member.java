package com.example.app.model;

import java.time.LocalDateTime;

public class Member {
    String  id;
    String  password;
    String  email;
    String  name;
    String  nickname;
    String  interest;
    boolean agree;
    LocalDateTime joinAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public boolean isAgree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }

    public LocalDateTime getJoinAt() {
        return joinAt;
    }

    public void setJoinAt(LocalDateTime joinAt) {
        this.joinAt = joinAt;
    }
}

