package com.saxakiil.ezpage.validator.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("added_to_attachment_menu")
    private Boolean addedToAttachmentMenu;
    @JsonProperty("allows_write_to_pm")
    private Boolean allowsWriteToPm;
    @JsonProperty("is_premium")
    private Boolean isPremium;
    @JsonProperty("first_name")
    private String firstName;
    private Long id;
    @JsonProperty("is_bot")
    private Boolean isBot;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("language_code")
    private String languageCode;
    @JsonProperty("photo_url")
    private String photoUrl;
    private String username;

    public Boolean getAddedToAttachmentMenu() {
        return addedToAttachmentMenu;
    }

    public void setAddedToAttachmentMenu(Boolean addedToAttachmentMenu) {
        this.addedToAttachmentMenu = addedToAttachmentMenu;
    }

    public Boolean getAllowsWriteToPm() {
        return allowsWriteToPm;
    }

    public void setAllowsWriteToPm(Boolean allowsWriteToPm) {
        this.allowsWriteToPm = allowsWriteToPm;
    }

    public Boolean getPremium() {
        return isPremium;
    }

    public void setPremium(Boolean premium) {
        isPremium = premium;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getBot() {
        return isBot;
    }

    public void setBot(Boolean bot) {
        isBot = bot;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
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
        User user = (User) o;
        return Objects.equals(addedToAttachmentMenu, user.addedToAttachmentMenu)
               && Objects.equals(allowsWriteToPm, user.allowsWriteToPm)
               && Objects.equals(isPremium, user.isPremium) && Objects.equals(firstName, user.firstName)
               && Objects.equals(id, user.id) && Objects.equals(isBot, user.isBot)
               && Objects.equals(lastName, user.lastName) && Objects.equals(languageCode, user.languageCode)
               && Objects.equals(photoUrl, user.photoUrl) && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addedToAttachmentMenu, allowsWriteToPm, isPremium, firstName, id, isBot, lastName,
                languageCode, photoUrl, username);
    }
}
