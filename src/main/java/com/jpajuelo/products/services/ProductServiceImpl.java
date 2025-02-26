package com.jpajuelo.products.services;

import com.jpajuelo.products.entities.Product;
import com.jpajuelo.products.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final Environment environment;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, Environment env) {
        this.productRepository = productRepository;
        this.environment = env;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll().stream().map(product -> {
            product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
            return product;
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found with id: " + id));
        product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return Optional.of(product);
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
