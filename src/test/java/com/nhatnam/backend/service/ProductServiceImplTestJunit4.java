package com.nhatnam.backend.service;

import com.nhatnam.backend.data.Product;
import com.nhatnam.backend.repository.ProductRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

/**
 * JUnit4, do not start SpringBoot application
 */
@RunWith(SpringRunner.class)
public class ProductServiceImplTestJunit4 {
    @TestConfiguration
    static class ProductServiceImplTestContextConfiguration {
        @Bean
        public ProductService productService() {
            return new ProductServiceImpl();
        }
    }

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    public void testListProducts() {
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
