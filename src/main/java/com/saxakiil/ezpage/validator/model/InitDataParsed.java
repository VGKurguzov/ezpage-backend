package com.saxakiil.ezpage.validator.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


public class InitDataParsed {

    @JsonProperty("auth_date")
    private Long authDate;
    @JsonProperty("can_send_after")
    private Long canSendAfter;
    private Chat chat;
    @JsonProperty("chat_type")
    private String chatType;
    @JsonProperty("chat_instance")
    private String chatInstance;
    private String hash;
    @JsonProperty("query_id")
    private String queryId;
    private com.saxakiil.ezpage.validator.model.User receiver;
    @JsonProperty("start_param")
    private String startParam;
    private com.saxakiil.ezpage.validator.model.User user;

    public Long getAuthDate() {
        return authDate;
    }

    public void setAuthDate(Long authDate) {
        this.authDate = authDate;
    }

    public Long getCanSendAfter() {
        return canSendAfter;
    }

    public void setCanSendAfter(Long canSendAfter) {
        this.canSendAfter = canSendAfter;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public String getChatType() {
        return chatType;
    }

    public void setChatType(String chatType) {
        this.chatType = chatType;
    }

    public String getChatInstance() {
        return chatInstance;
    }

    public void setChatInstance(String chatInstance) {
        this.chatInstance = chatInstance;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public com.saxakiil.ezpage.validator.model.User getReceiver() {
        return receiver;
    }

    public void setReceiver(com.saxakiil.ezpage.validator.model.User receiver) {
        this.receiver = receiver;
    }

    public String getStartParam() {
        return startParam;
    }

    public void setStartParam(String startParam) {
        this.startParam = startParam;
    }

    public com.saxakiil.ezpage.validator.model.User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InitDataParsed that = (InitDataParsed) o;
        return Objects.equals(authDate, that.authDate) && Objects.equals(canSendAfter, that.canSendAfter)
               && Objects.equals(chat, that.chat) && Objects.equals(chatType, that.chatType)
               && Objects.equals(chatInstance, that.chatInstance)
               && Objects.equals(hash, that.hash) && Objects.equals(queryId, that.queryId)
               && Objects.equals(receiver, that.receiver) && Objects.equals(startParam, that.startParam)
               && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authDate, canSendAfter, chat, chatType, chatInstance, hash, queryId,
                receiver, startParam, user);
    }
}
