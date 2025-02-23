package com.jpajuelo.products.controllers;

import com.jpajuelo.products.entities.Product;
import com.jpajuelo.products.repositories.ProductRepository;
import com.jpajuelo.products.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/Products")
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }
    @GetMapping("/ProductosMayoresA/{price}")
    public ResponseEntity<Optional<List<Product>>> getProductsMayoresA(@PathVariable("price") Double price) {
        return ResponseEntity.ok(productService.findProductosMayoresA(price));
    }
    @GetMapping("/ProductosMenores/{price}")
    public ResponseEntity<Optional<List<Product>>> getProductsMenoresA(@PathVariable("price") Double price) {
        return ResponseEntity.ok(productService.findProductosMayoresA(price));
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        System.out.println("📌 Recibiendo producto: " + product.toString()); // Debug
        Product savedProduct = productService.saveProduct(product);
        return ResponseEntity.ok(savedProduct);
    }


}
