package com.silassefas.apigestaodeloja.controller;

import com.silassefas.apigestaodeloja.model.Product;
import com.silassefas.apigestaodeloja.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
       return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> findByNameContainingIgnoreCaseAndAccents(@RequestParam String productName){
        return ResponseEntity.ok(productService.findByNameContainingIgnoreCaseAndAccents(productName));
    }

    @GetMapping("/category")
    public ResponseEntity<List<Product>> findByCategoryConteningIgnoringCaseAndAccents(@RequestParam String productCategory) {
        return ResponseEntity.ok(productService.findByCategoryConteningIgnoringCaseAndAccents(productCategory));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

}
