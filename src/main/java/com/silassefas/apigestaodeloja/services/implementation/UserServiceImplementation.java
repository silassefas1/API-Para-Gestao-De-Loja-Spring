package com.silassefas.apigestaodeloja.services.implementation;

import com.silassefas.apigestaodeloja.configuration.SecurityConfig;
import com.silassefas.apigestaodeloja.dto.UserRequestDTO;
import com.silassefas.apigestaodeloja.dto.UserResponseDTO;
import com.silassefas.apigestaodeloja.model.User;
import com.silassefas.apigestaodeloja.repository.UserRepository;
import com.silassefas.apigestaodeloja.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SecurityConfig securityConfig;

    @Override
    public User createUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setPassword(securityConfig.passwordEncoder().encode(userRequestDTO.getPassword()));
        user.setUserType(userRequestDTO.getUserType());
        user.setCpfCnpj(userRequestDTO.getCpfCnpj());
        user.setEmail(userRequestDTO.getEmail());
        user.setPhone(userRequestDTO.getPhone());
        user.setAddress(userRequestDTO.getAddress());

        return userRepository.save(user);
    }

    @Override
    public List<UserResponseDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(
                user -> new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getUserType(),
                        user.getCpfCnpj(),
                        user.getEmail(),
                        user.getPhone(),
                        user.getAddress(),
                        user.getRegistrationDate(),
                        user.getLastUpdateDate()
                )
        ).toList();
    }

    @Override
    public UserResponseDTO deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado!"));
        userRepository.delete(user);
        UserResponseDTO userDeleted = new UserResponseDTO();
        userDeleted.setId(user.getId());
        userDeleted.setName(user.getName());

        return userDeleted;
    }

    @Override
    public User updateUser(Long id, UserRequestDTO userRequestDTO) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado!"));
        if(userRequestDTO.getName() != null && !userRequestDTO.getName().isEmpty()){
            existingUser.setName(userRequestDTO.getName());
        }
        if(userRequestDTO.getPassword() != null && !userRequestDTO.getPassword().isEmpty()){
            existingUser.setPassword(userRequestDTO.getPassword());
        }
        if(userRequestDTO.getCpfCnpj() != null && !userRequestDTO.getCpfCnpj().isEmpty()){
            existingUser.setCpfCnpj(userRequestDTO.getCpfCnpj());
        }
        if(userRequestDTO.getEmail() != null && !userRequestDTO.getEmail().isEmpty()){
            existingUser.setEmail(userRequestDTO.getEmail());
        }
        if(userRequestDTO.getPhone() != null && !userRequestDTO.getPhone().isEmpty()){
            existingUser.setPhone(userRequestDTO.getPhone());
        }
        if(userRequestDTO.getAddress() != null && !userRequestDTO.getAddress().isEmpty()){
            existingUser.setAddress(userRequestDTO.getAddress());
        }
        if(userRequestDTO.getUserType() != null){
            existingUser.setUserType(userRequestDTO.getUserType());
        }
        existingUser.setLastUpdateDate(ZonedDateTime.now());

        return userRepository.save(existingUser);
    }

    @Override
    public UserResponseDTO findById(Long id) {
        User user = new User();
        user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado!"));
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setName(user.getName());
        userResponseDTO.setUserType(user.getUserType());
        userResponseDTO.setCpfCnpj(user.getCpfCnpj());
        userResponseDTO.setEmail( user.getEmail());
        userResponseDTO.setPhone(user.getPhone());
        userResponseDTO.setAddress(user.getAddress());
        userResponseDTO.setRegistrationDate(user.getRegistrationDate());
        userResponseDTO.setLastUpdateDate(user.getLastUpdateDate());
        return userResponseDTO;
    }

    @Override
    public User findUserByCpfCnpj(String cpfCnpj) {
        Optional<User> user = userRepository.findUserByCpfCnpj(cpfCnpj);
        return user.orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado!"));
    }

    @Override
    public List<User> findByNameContainingIgnoreCaseAndAccents(String userName) {
        return userRepository.findByNameContainingIgnoreCase(userName);
    }
}