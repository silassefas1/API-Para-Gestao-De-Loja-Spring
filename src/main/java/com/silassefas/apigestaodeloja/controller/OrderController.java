package com.silassefas.apigestaodeloja.controller;

import com.silassefas.apigestaodeloja.model.Order;
import com.silassefas.apigestaodeloja.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/create/{userId}")
    public Order createOrder(@PathVariable Long userId) {
        return orderService.createOrder(userId);
    }

    @PostMapping("/{orderId}/add-product/{productId}/{quantity}")
    public Order addProduct(@PathVariable Long orderId, @PathVariable Long productId, @PathVariable Integer quantity) {
        return orderService.addProduct(orderId, productId, quantity);
    }

    @DeleteMapping("/{orderId}/remove-product/{productId}/{quantity}")
    public Order removeProduct(@PathVariable Long orderId, @PathVariable Long productId, @PathVariable Integer quantity) {
        return orderService.removeProduct(orderId, productId, quantity);
    }

    @PutMapping("/{orderId}/update-product/{productId}/{newQuantity}")
    public Order updateProductQuantity(@PathVariable Long orderId, @PathVariable Long productId, @PathVariable Integer newQuantity) {
        return orderService.updateProductQuantity(orderId, productId, newQuantity);
    }

    @PostMapping("/{orderId}/confirm")
    public Order confirmOrder(@PathVariable Long orderId) {
        return orderService.confirmOrder(orderId);
    }

    @PostMapping("/{orderId}/cancel")
    public Order cancelOrder(@PathVariable Long orderId) {
        return orderService.cancelOrder(orderId);
    }

    @GetMapping("/user/{userName}")
    public List<Order> getOrdersByUser(@PathVariable String userName) {
        return orderService.findOrdersByUserName(userName);
    }

    @GetMapping("/findAll")
    public List<Order> findAllOrders(){
        return orderService.findAllOrders();
    }
}
