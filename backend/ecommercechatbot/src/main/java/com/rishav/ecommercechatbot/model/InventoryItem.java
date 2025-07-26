package com.rishav.ecommercechatbot.model;

public class InventoryItem {
    private Long id;
    private Long productId;
    private Long distributionCenterId;
    private Integer stock;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getDistributionCenterId() {
        return distributionCenterId;
    }

    public void setDistributionCenterId(Long distributionCenterId) {
        this.distributionCenterId = distributionCenterId;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
