package com.silassefas.apigestaodeloja.repository;

import com.silassefas.apigestaodeloja.dto.UserResponseDTO;
import com.silassefas.apigestaodeloja.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT c FROM User c WHERE c.cpfCnpj = :cpfCnpj")
    Optional<User> findUserByCpfCnpj(String cpfCnpj);

    List<User> findByNameContainingIgnoreCase(String userName);

    User findByName(String userName);


}