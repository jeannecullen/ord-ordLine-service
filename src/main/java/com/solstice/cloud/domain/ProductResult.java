package com.solstice.cloud.domain;

public class ProductResult {

    private Long productId;
    private String productName;
    private String description;
    private String productImage;
    private double productPrice;


    public ProductResult() {}

    public ProductResult(Long productId, String productName, String description, String productImage, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.productImage = productImage;
        this.productPrice = productPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
