package com.saxakiil.ezpage.validator.model;

public enum Type {

    GROUP("group"),
    SUPER_GROUP("supergroup"),
    CHANNEL("channel");

    private final String value;

    Type(String value) {
        this.value = value;
    }

    public String valueAsEnum(Type type) {
        for (Type typeValue : Type.values()) {
            if (typeValue == type) {
                return typeValue.value;
            }
        }
        return null;
    }

}
