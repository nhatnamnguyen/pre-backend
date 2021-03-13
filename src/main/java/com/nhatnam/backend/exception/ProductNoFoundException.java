package com.nhatnam.backend.exception;

public class ProductNoFoundException extends RuntimeException {
    private String productId;

    public ProductNoFoundException(final String productId) {
        super("Product no found");
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
