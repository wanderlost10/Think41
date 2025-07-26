package com.rishav.ecommercechatbot.repository;

import com.rishav.ecommercechatbot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findByNameIgnoreCase(String name);
}