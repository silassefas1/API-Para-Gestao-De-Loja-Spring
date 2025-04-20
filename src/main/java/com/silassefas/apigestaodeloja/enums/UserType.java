package com.silassefas.apigestaodeloja.enums;

import lombok.Getter;

@Getter
public enum UserType {
    INDIVIDUAL("INDIVIDUAL"),
    BUSINESS("BUSINESS");

    private final String value;

    UserType(String value) {
        this.value = value;
    }

    public static UserType fromValue(String value) {
        for (UserType type : UserType.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Tipo de cliente inválido: " + value);
    }
}
