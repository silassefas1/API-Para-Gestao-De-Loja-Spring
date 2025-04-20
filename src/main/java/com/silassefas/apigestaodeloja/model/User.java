package com.silassefas.apigestaodeloja.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.silassefas.apigestaodeloja.enums.UserType;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tb_user")
@EqualsAndHashCode
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;

    @Column(unique = true)
    private String cpfCnpj;

    private String email;
    private String password;
    private String phone;
    private String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Order> orders = new ArrayList<>();
    private ZonedDateTime registrationDate;


    public User(){
        this.registrationDate = ZonedDateTime.now();
    }

    public User(Long id, String name, UserType userType, String cpfCnpj, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.userType = userType;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.registrationDate = ZonedDateTime.now();
        this.orders = new ArrayList<>();

    }
}
