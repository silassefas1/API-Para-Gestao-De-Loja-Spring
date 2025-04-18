package com.silassefas.apigestaodeloja.enums;

import lombok.Getter;

@Getter
public enum PaymentStatus {
    PENDING("PENDING"),
    PAID("PAID"),
    REFUNDED("REFUNDED");

    private final String value;

    PaymentStatus(String value){
        this.value = value;
    }
    public static PaymentStatus fromValue(String value){
        for(PaymentStatus type: PaymentStatus.values()){
            if(type.getValue().equals(value)){
                return type;
            }
        }
        throw new IllegalArgumentException("Tipo de cliente inválido: " + value);
    }

}
