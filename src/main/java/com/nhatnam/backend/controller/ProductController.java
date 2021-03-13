package com.nhatnam.backend.controller;

import com.nhatnam.backend.data.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static com.google.common.collect.Lists.newArrayList;

@RestController
public class ProductController {

    @GetMapping(path = "/products")
    public List<Product> listProducts() {
        Product coffeeProduct = new Product();
        coffeeProduct.setId("1");
        coffeeProduct.setName("Coffee");

        Product teaProduct = new Product();
        teaProduct.setId("2");
        teaProduct.setName("Tea");

        return newArrayList(coffeeProduct, teaProduct);
    }

    @GetMapping("/products/{productId}")
    public Product getProduct(final @PathVariable String productId) {
        List<Product> products = listProducts();
        Optional<Product> found = products.stream().filter(product -> product.getId().equals(productId)).findFirst();
        if (found.isPresent()) {
            return found.get();
        }
        throw new IllegalArgumentException("Not found product");
    }

    @PutMapping("/products")
    public Product addProduct(final @RequestParam("name") String productName) {
        Product product = new Product();
        product.setId(String.valueOf(new Random().nextInt(10)));
        product.setName(productName);
        return product;
    }

    @PostMapping("/products/{productId}")
    public Product updateProduct(final @PathVariable String productId, final @RequestParam("name") String productName) {
        Product product = new Product();
        product.setId(productId);
        product.setName(productName);

        return product;
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(final @PathVariable String productId) {
        System.out.println("Delete product :" + productId);
    }
}
