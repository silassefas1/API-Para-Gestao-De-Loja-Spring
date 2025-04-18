package com.silassefas.apigestaodeloja.services;

import com.silassefas.apigestaodeloja.model.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Long customerId);

    Order addProduct(Long orderId, Long productId, Integer quantity);

    Order removeProduct(Long orderId, Long productId, Integer quantity);

    Order updateProductQuantity(Long orderId, Long productId, Integer newQuantity);

    Order confirmOrder(Long orderId);

    Order cancelOrder(Long orderId);

    List<Order> findOrdersByCustomerName(String customerName);

    List<Order> findAllOrders();
}
