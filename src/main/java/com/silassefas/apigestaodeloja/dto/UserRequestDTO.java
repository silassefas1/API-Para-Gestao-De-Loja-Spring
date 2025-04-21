package com.silassefas.apigestaodeloja.dto;

import com.silassefas.apigestaodeloja.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRequestDTO {

    private String name;
    private String password;
    private String cpfCnpj;
    private String email;
    private String phone;
    private String address;
    private UserType userType;

    public UserRequestDTO() {
    }


}
