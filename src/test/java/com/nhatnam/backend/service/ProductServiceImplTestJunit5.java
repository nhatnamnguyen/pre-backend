package com.nhatnam.backend.service;

import com.nhatnam.backend.data.Product;
import com.nhatnam.backend.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

/**
 * JUnit5, start SpringBoot application
 */
@SpringBootTest
public class ProductServiceImplTestJunit5 {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService = new ProductServiceImpl();

    @Test
    void listProducts() {
        Product coffeeProduct = buildProduct("1", "Coffee");
        Product teaProduct = buildProduct("2", "Tea");
        Mockito.when(productRepository.findAll()).thenReturn(newArrayList(coffeeProduct, teaProduct));

        List<Product> products = productService.listProducts();
        Assertions.assertEquals(2, products.size());
        Assertions.assertTrue(products.containsAll(newArrayList(coffeeProduct, teaProduct)));
    }

    private Product buildProduct(final String id, final String name) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        return product;
    }
}