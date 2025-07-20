package com.products.exception;

public class ExistingProductException extends RuntimeException {
    public ExistingProductException(String message) {
        super(message);
    }
}
