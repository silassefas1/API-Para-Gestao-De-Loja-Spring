package com.silassefas.apigestaodeloja.services.implementation;

import com.silassefas.apigestaodeloja.enums.OrderStatus;
import com.silassefas.apigestaodeloja.model.User;
import com.silassefas.apigestaodeloja.model.Order;
import com.silassefas.apigestaodeloja.model.Product;
import com.silassefas.apigestaodeloja.repository.UserRepository;
import com.silassefas.apigestaodeloja.repository.OrderRepository;
import com.silassefas.apigestaodeloja.repository.ProductRepository;
import com.silassefas.apigestaodeloja.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImplementation implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Order createOrder(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Order order = new Order();
        order.setUser(user);
        order.setStatus(OrderStatus.PENDING);
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order addProduct(Long orderId, Long productId, Integer quantity) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (order.getProducts().containsKey(product)) {
            order.getProducts().put(product, order.getProducts().get(product) + quantity);
        } else {
            order.getProducts().put(product, quantity);
        }

        order.setTotalValue(calculateTotalValue(order));
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order removeProduct(Long orderId, Long productId, Integer quantity) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (order.getProducts().containsKey(product)) {
            Integer currentQuantity = order.getProducts().get(product);
            if (currentQuantity > quantity) {
                order.getProducts().put(product, currentQuantity - quantity);
            } else {
                order.getProducts().remove(product);
            }
        }

        order.setTotalValue(calculateTotalValue(order));
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order updateProductQuantity(Long orderId, Long productId, Integer newQuantity) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (newQuantity <= 0) {
            order.getProducts().remove(product);
        } else {
            order.getProducts().put(product, newQuantity);
        }

        order.setTotalValue(calculateTotalValue(order));
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order confirmOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (order.getStatus() == OrderStatus.CONFIRMED) {
            throw new RuntimeException("Order is already confirmed");
        }

        order.setStatus(OrderStatus.CONFIRMED);
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (order.getStatus() == OrderStatus.CONFIRMED) {
            throw new RuntimeException("Confirmed order cannot be canceled");
        }

        order.setStatus(OrderStatus.CANCELED);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findOrdersByUserName(String userName) {
        return orderRepository.findByUserNameContainingIgnoreCase(userName);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }


    public BigDecimal calculateTotalValue(Order order) {
        return order.getProducts().entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
