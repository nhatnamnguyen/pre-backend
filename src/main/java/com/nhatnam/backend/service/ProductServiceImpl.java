package com.nhatnam.backend.service;

import com.nhatnam.backend.data.Product;
import com.nhatnam.backend.exception.ProductNoFoundException;
import com.nhatnam.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> listProducts() {
        Sort sort = Sort.by(Sort.Direction.ASC,"id");
        return productRepository.findAll(sort);
    }

    @Override
    public List<Product> searchProductsByName(String productName) {
        return productRepository.findProductsByName(productName);
    }

    @Override
    public Product getProduct(String productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ProductNoFoundException(productId);
        }
    }

    @Override
    public Product addProduct(String productName) {
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setName(productName);
        product = productRepository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(String productId, String productName) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            Product newProduct = product.get();
            newProduct.setName(productName);
            productRepository.save(newProduct);
            return newProduct;
        } else {
            throw new ProductNoFoundException(productId);
        }
    }

    @Override
    public void deleteProduct(String productId) {
        try {
            productRepository.deleteById(productId);
        } catch (EmptyResultDataAccessException e) {
            throw new ProductNoFoundException(productId);
        }
    }
}
