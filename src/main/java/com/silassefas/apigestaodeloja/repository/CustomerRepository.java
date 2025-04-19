package com.silassefas.apigestaodeloja.repository;

import com.silassefas.apigestaodeloja.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.cpfCnpj = :cpfCnpj")
    Optional<Customer> findCustomerByCpfCnpj(String cpfCnpj);

    List<Customer> findByNameContainingIgnoreCase(String customerName);

    Customer findByName(String customerName);
}