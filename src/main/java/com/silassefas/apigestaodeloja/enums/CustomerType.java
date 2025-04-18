package com.silassefas.apigestaodeloja.enums;

import lombok.Getter;

@Getter
public enum CustomerType {
    INDIVIDUAL("INDIVIDUAL"),
    BUSINESS("BUSINESS");

    private final String value;

    CustomerType(String value) {
        this.value = value;
    }

    public static CustomerType fromValue(String value) {
        for (CustomerType type : CustomerType.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Tipo de cliente inválido: " + value);
    }
}
