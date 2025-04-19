package com.silassefas.apigestaodeloja.services;

import com.silassefas.apigestaodeloja.model.Product;

import java.util.List;

public interface ProductService   {

    Product createProduct(Product product);

    Product updateProduct(Long productId, Product productToUpdate);

    void deleteProduct(Long productId);

    Product findById(Long id);

    List<Product> findByNameContainingIgnoreCaseAndAccents(String productName);

    List<Product> findByCategoryConteningIgnoringCaseAndAccents(String productCategory);

    List<Product> findAll();




}
