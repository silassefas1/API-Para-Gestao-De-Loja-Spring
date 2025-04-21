package com.silassefas.apigestaodeloja.enums;

import lombok.Getter;

@Getter
public enum UserRole {
    VISITOR("VISITOR"),
    USER("USER"),
    ADMIN("ADMIN");
    private final String value;

    UserRole(String value) {
        this.value = value;
    }

    public static UserRole fromValue(String value) {
        for (UserRole type : UserRole.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Tipo de cliente inválido: " + value);
    }
}
