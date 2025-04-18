package com.silassefas.apigestaodeloja.services.implementation;

import com.silassefas.apigestaodeloja.model.Product;
import com.silassefas.apigestaodeloja.repository.ProductRepository;
import com.silassefas.apigestaodeloja.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        product.setCreatedAt(java.time.ZonedDateTime.now());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product productToUpdate) {
        Optional<Product> existentProduct = productRepository.findById(productId);
        if (existentProduct.isPresent()) {
            Product product = existentProduct.get();
            if(productToUpdate.getName() != null && !productToUpdate.getName().trim().isEmpty()) {
                product.setName(productToUpdate.getName());
            }
            if(productToUpdate.getPrice() != null && productToUpdate.getPrice().compareTo(java.math.BigDecimal.ZERO) > 0) {
                product.setPrice(productToUpdate.getPrice());
            }
            if(productToUpdate.getDescription() != null && !productToUpdate.getDescription().trim().isEmpty()) {
                product.setDescription(productToUpdate.getDescription());
            }
            if(productToUpdate.getCategory() != null && !productToUpdate.getCategory().trim().isEmpty()) {
                product.setCategory(productToUpdate.getCategory());
            }
            product.setUpdatedAt(java.time.LocalDateTime.now());
            return productRepository.save(product);

        }else{
            throw new NoSuchElementException("Product with ID " + productId + " not found.");
        }


    }

    @Override
    public void deleteProduct(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()){
            productRepository.delete(product.get());
        }else{
            throw new NoSuchElementException("Product with ID " + productId + " not found.");
        }

    }

    @Override
    public List<Product> findByNameContainingIgnoreCaseAndAccents(String productName) {
        String normalizedName = org.apache.commons.lang3.StringUtils.stripAccents(productName);
        return productRepository.findByNameContainingIgnoreCase(normalizedName);
    }

    @Override
    public List<Product> findByCategoryConteningIgnoringCaseAndAccents(String productCategory) {
        String normalizedCategory = org.apache.commons.lang3.StringUtils.stripAccents(productCategory);
        return productRepository.findByCategoryContainingIgnoreCase(normalizedCategory);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product with ID " + id + " not found."));
    }



}
