package com.silassefas.apigestaodeloja.controller;

import com.silassefas.apigestaodeloja.model.Customer;
import com.silassefas.apigestaodeloja.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findAllCustomers(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id){
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.findById(id));
    }

    @GetMapping("/cpfCnpj/{cpfCnpj}")
    public ResponseEntity<Customer> findCustomerByCpfCnpj(@PathVariable String cpfCnpj){
        return ResponseEntity.ok(customerService.findCustomerByCpfCnpj(cpfCnpj));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Customer>> findByNameContainingIgnoreCase(String customerName){
        return ResponseEntity.ok(customerService.findByNameContainingIgnoreCaseAndAccents(customerName));
    }
}