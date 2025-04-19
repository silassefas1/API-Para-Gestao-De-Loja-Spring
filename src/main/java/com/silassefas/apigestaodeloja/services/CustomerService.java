package com.silassefas.apigestaodeloja.services;

import com.silassefas.apigestaodeloja.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Long customerId, Customer customerDateToUpdate);

    Customer deleteCustomer(Long customerId);

    Customer findById(Long id);

    Customer findCustomerByCpfCnpj(String cpf);

    List<Customer> findAll();

    List<Customer> findByNameContainingIgnoreCaseAndAccents(String customerName);

}
