package com.nhatnam.backend.controller;

import com.nhatnam.backend.data.Product;
import com.nhatnam.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/products")
    public List<Product> listProducts(final @RequestParam(value = "name", required = false) String productName) {
        if (productName == null) {
            return productService.listProducts();
        } else {
            return productService.searchProductsByName(productName);
        }
    }

    @GetMapping("/products/{productId}")
    public Product getProduct(final @PathVariable String productId) {
       return productService.getProduct(productId);
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
