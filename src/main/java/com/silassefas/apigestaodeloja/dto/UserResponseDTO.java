package com.silassefas.apigestaodeloja.dto;

import com.silassefas.apigestaodeloja.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseDTO {

    private Long id;
    private String name;
    private UserType userType;
    private String cpfCnpj;
    private String email;
    private String phone;
    private String address;
    private ZonedDateTime registrationDate;
    private ZonedDateTime lastUpdateDate;


    public UserResponseDTO() {
    }
}
