package com.silassefas.apigestaodeloja.repository;

import com.silassefas.apigestaodeloja.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByOrderUserNameContainingIgnoreCase(String name);
}
