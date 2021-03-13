package com.nhatnam.backend.service;

import com.nhatnam.backend.data.Product;
import com.nhatnam.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> listProducts();

    List<Product> searchProductsByName(String productName);

    Product getProduct(String productId);

    Product addProduct(String productName);

    Product updateProduct(String productId, String productName);

    void deleteProduct(String productId);
}
