package com.rishav.ecommercechatbot.service;

import com.rishav.ecommercechatbot.model.Order;
import com.rishav.ecommercechatbot.model.Product;
import com.rishav.ecommercechatbot.repository.OrderRepository;
import com.rishav.ecommercechatbot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ChatbotService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<Product> getTopSoldProducts(int n) {
        return productRepository.findAll().stream()
                .sorted(Comparator.comparingInt(Product::getSold).reversed())
                .limit(n)
                .toList();
    }

    public String getOrderStatus(String orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return order.map(o -> "Status of Order ID " + orderId + " is: " + o.getStatus())
                .orElse("Order ID not found");
    }

    public String checkStock(String productName) {
        Optional<Product> product = productRepository.findByNameIgnoreCase(productName);
        return product.map(p -> p.getQuantity() + " units left of " + productName)
                .orElse("Product not found");
    }
}
