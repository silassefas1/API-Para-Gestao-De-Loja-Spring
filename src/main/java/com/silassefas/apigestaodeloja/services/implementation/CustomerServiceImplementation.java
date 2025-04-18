package com.silassefas.apigestaodeloja.services.implementation;

import com.silassefas.apigestaodeloja.model.Customer;
import com.silassefas.apigestaodeloja.repository.CustomerRepository;
import com.silassefas.apigestaodeloja.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Customer customer = findById(id);
        customerRepository.delete(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer existingCustomer = findById(id);
        existingCustomer.setName(customer.getName());
        existingCustomer.setCustomerType(customer.getCustomerType());
        existingCustomer.setCpfCnpj(customer.getCpfCnpj());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setAddress(customer.getAddress());
        return customerRepository.save(existingCustomer);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado!"));
    }

    @Override
    public Customer findCustomerByCpfCnpj(String cpfCnpj) {
        Optional<Customer> customer = customerRepository.findCustomerByCpfCnpj(cpfCnpj);
        return customer.orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado!"));
    }

    @Override
    public List<Customer> findByNameContainingIgnoreCaseAndAccents(String customerName) {
        return customerRepository.findByNameContainingIgnoreCase(customerName);
    }
}