package com.jpajuelo.products.services;

import com.jpajuelo.products.entities.Product;
import com.jpajuelo.products.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.of(productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found")));
    }
    @Override
    public Optional<List<Product>> findProductosMayoresA(Double price) {
        return Optional.ofNullable(productRepository.findProductosMayoresA(price).orElseThrow(() -> new RuntimeException("Error al procesar la consulta")));
    }
    @Override
    public Optional<List<Product>> findProductosMenoresA(Double price) {
        return Optional.ofNullable(productRepository.findProductosMenoresA(price).orElseThrow(() -> new RuntimeException("Error al procesar la consulta")));
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }


}
