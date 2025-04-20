package com.silassefas.apigestaodeloja.services;

import com.silassefas.apigestaodeloja.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User updateUser(Long userId, User userDateToUpdate);

    User deleteUser(Long userId);

    User findById(Long id);

    User findUserByCpfCnpj(String cpf);

    List<User> findAll();

    List<User> findByNameContainingIgnoreCaseAndAccents(String userName);

}
