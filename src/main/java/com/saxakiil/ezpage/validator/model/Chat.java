package com.saxakiil.ezpage.validator.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Chat {
    private Long id;
    private String type;
    private String title;
    @JsonProperty("photo_url")
    private String photoUrl;
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return Objects.equals(id, chat.id) && Objects.equals(type, chat.type) && Objects.equals(title, chat.title)
               && Objects.equals(photoUrl, chat.photoUrl) && Objects.equals(username, chat.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, title, photoUrl, username);
    }
}
