package com.saxakiil.ezpage.validator.model;

public enum ChatType {

    SENDER("sender"),
    PRIVATE("private"),
    GROUP("group"),
    SUPER_GROUP("supergroup"),
    CHANNEL("channel");

    private final String value;

    ChatType(String value) {
        this.value = value;
    }

    public String valueAsEnum(ChatType chatType) {
        for (ChatType chatTypeValue : ChatType.values()) {
            if (chatTypeValue == chatType) {
                return chatTypeValue.value;
            }
        }
        return null;
    }
}
