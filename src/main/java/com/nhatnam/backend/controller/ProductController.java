package com.nhatnam.backend.controller;

import com.nhatnam.backend.data.Product;
import com.nhatnam.backend.exception.ProductNoFoundException;
import com.nhatnam.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static com.google.common.collect.Lists.newArrayList;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/products")
    public List<Product> listProducts() {
        return productService.listProducts();
    }

    @GetMapping("/products/{productId}")
    public Product getProduct(final @PathVariable String productId) {
        Optional<Product> product = productService.getProduct(productId);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ProductNoFoundException(productId);
        }

    }

    @PutMapping("/products")
    public Product addProduct(final @RequestParam("name") String productName) {
        return productService.addProduct(productName);
    }

    @PostMapping("/products/{productId}")
    public Product updateProduct(final @PathVariable String productId, final @RequestParam("name") String productName) {
        return productService.updateProduct(productId, productName);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(final @PathVariable String productId) {
        productService.deleteProduct(productId);
    }
}
