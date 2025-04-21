package com.silassefas.apigestaodeloja.controller;

import com.silassefas.apigestaodeloja.dto.UserRequestDTO;
import com.silassefas.apigestaodeloja.dto.UserResponseDTO;
import com.silassefas.apigestaodeloja.model.User;
import com.silassefas.apigestaodeloja.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping //feito
    public ResponseEntity<User> createUser(@RequestBody UserRequestDTO userRequestDTO){
        return ResponseEntity.ok(userService.createUser(userRequestDTO));
    }

    @GetMapping //feito
    public ResponseEntity<List<UserResponseDTO>> findAllUser(){
        return ResponseEntity.ok(userService.findAll());
    }

    @DeleteMapping("/{id}")//feito
    public ResponseEntity<UserResponseDTO> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @PutMapping("/{id}") //feito
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO){
        return ResponseEntity.ok(userService.updateUser(id, userRequestDTO));
    }

    @GetMapping("/id/{id}") //feito
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/cpfCnpj/{cpfCnpj}")
    public ResponseEntity<User> findUserByCpfCnpj(@PathVariable String cpfCnpj){
        return ResponseEntity.ok(userService.findUserByCpfCnpj(cpfCnpj));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<User>> findByNameContainingIgnoreCase(String userName){
        return ResponseEntity.ok(userService.findByNameContainingIgnoreCaseAndAccents(userName));
    }
}