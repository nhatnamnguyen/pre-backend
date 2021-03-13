package com.nhatnam.backend.controller;

import com.nhatnam.backend.data.Product;
import com.nhatnam.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/products")
    public List<Product> listProducts(final @RequestParam Map<String, String> parameters) {
        String productName = parameters.get("name");
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
    public Product addProduct(final @RequestParam Map<String, String> parameters) {
        String productName = parameters.get("name");
        return productService.addProduct(productName);
    }

    @PostMapping("/products/{productId}")
    public Product updateProduct(final @PathVariable String productId, final @RequestParam Map<String, String> parameters) {
        String productName = parameters.get("name");
        return productService.updateProduct(productId, productName);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(final @PathVariable String productId) {
        productService.deleteProduct(productId);
    }
}
