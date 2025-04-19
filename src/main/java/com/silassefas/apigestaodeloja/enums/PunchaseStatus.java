package com.silassefas.apigestaodeloja.enums;

import lombok.Getter;

@Getter
public enum PunchaseStatus {
    ORDERED("ORDERED"),
    RECEIVED("RECEIVED"),
    CANCELED("CANCELED");

    private final String value;

    PunchaseStatus(String value) {
        this.value = value;
    }

    public static PunchaseStatus fromValue(String value) {
        for (PunchaseStatus status : PunchaseStatus.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status de compra inválido: " + value);
    }
}
