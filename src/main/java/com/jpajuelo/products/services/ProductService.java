package com.jpajuelo.products.services;


import com.jpajuelo.products.entities.Product;
import com.jpajuelo.products.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> findById(Long id);
    Optional<List<Product>> findProductosMayoresA(Double price);
    Optional<List<Product>> findProductosMenoresA(Double price);
    Product saveProduct(Product product);
}
