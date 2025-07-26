package com.rishav.ecommercechatbot.model;

public class Order {
    private Long id;
    private Long userId;
    private String orderDate;
    private String status;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
