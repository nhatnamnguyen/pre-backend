package com.nhatnam.backend.repository;

import com.nhatnam.backend.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findProductsByName(String productName);
}
