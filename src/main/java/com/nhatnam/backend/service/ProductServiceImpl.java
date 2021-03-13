package com.nhatnam.backend.service;

import com.nhatnam.backend.data.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> listProducts() {
        Product coffeeProduct = new Product();
        coffeeProduct.setId("1");
        coffeeProduct.setName("Coffee");

        Product teaProduct = new Product();
        teaProduct.setId("2");
        teaProduct.setName("Tea");

        return newArrayList(coffeeProduct, teaProduct);
    }

    @Override
    public Optional<Product> getProduct(String productId) {
        List<Product> products = listProducts();
        Optional<Product> found = products.stream().filter(product -> product.getId().equals(productId)).findFirst();
        return found;
    }

    @Override
    public Product addProduct(String productName) {
        Product product = new Product();
        product.setId(String.valueOf(new Random().nextInt(10)));
        product.setName(productName);
        return product;
    }

    @Override
    public Product updateProduct(String productId, String productName) {
        Product product = new Product();
        product.setId(productId);
        product.setName(productName);

        return product;
    }

    @Override
    public void deleteProduct(String productId) {
        System.out.println("Delete product :" + productId);
    }
}
