package com.rishav.ecommercechatbot.controller;

import com.rishav.ecommercechatbot.model.Product;
import com.rishav.ecommercechatbot.service.ChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chatbot")
public class ChatbotController {

    @Autowired
    private ChatbotService chatbotService;

    @GetMapping("/top-products")
    public List<Product> getTopSoldProducts(@RequestParam(defaultValue = "5") int count) {
        return chatbotService.getTopSoldProducts(count);
    }

    @GetMapping("/order-status/{orderId}")
    public String getOrderStatus(@PathVariable String orderId) {
        return chatbotService.getOrderStatus(orderId);
    }

    @GetMapping("/check-stock")
    public String checkStock(@RequestParam String name) {
        return chatbotService.checkStock(name);
    }
}
