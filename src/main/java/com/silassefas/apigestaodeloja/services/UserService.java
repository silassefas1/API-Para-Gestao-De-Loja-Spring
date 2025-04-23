package com.silassefas.apigestaodeloja.services;

import com.silassefas.apigestaodeloja.dto.UserRequestDTO;
import com.silassefas.apigestaodeloja.dto.UserResponseDTO;
import com.silassefas.apigestaodeloja.model.User;

import java.util.List;

public interface UserService {

    User createUser(UserRequestDTO user);

    User updateUser(Long userId, UserRequestDTO userDateToUpdate);

    UserResponseDTO deleteUser(Long userId);

    UserResponseDTO findById(Long id);

    UserResponseDTO findUserByCpfCnpj(String cpf);

    List<UserResponseDTO> findAll();

    List<UserResponseDTO> findByNameContainingIgnoreCaseAndAccents(String userName);

}
