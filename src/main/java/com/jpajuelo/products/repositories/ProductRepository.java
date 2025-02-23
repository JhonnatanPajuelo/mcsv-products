package com.jpajuelo.products.repositories;

import com.jpajuelo.products.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select u from Product u where u.price>:price")
    Optional<List<Product>> findProductosMayoresA(@Param("price") Double price);
    @Query(value = "SELECT * FROM products where price>:?1",nativeQuery = true)
    Optional<List<Product>> findProductosMenoresA(Double price);
}
