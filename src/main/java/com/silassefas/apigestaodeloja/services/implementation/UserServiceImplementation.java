package com.silassefas.apigestaodeloja.services.implementation;

import com.silassefas.apigestaodeloja.model.User;
import com.silassefas.apigestaodeloja.repository.UserRepository;
import com.silassefas.apigestaodeloja.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User deleteUser(Long id) {
        User user = findById(id);
        userRepository.delete(user);
        return user;
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = findById(id);
        existingUser.setName(user.getName());
        existingUser.setUserType(user.getUserType());
        existingUser.setCpfCnpj(user.getCpfCnpj());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setAddress(user.getAddress());
        return userRepository.save(existingUser);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado!"));
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