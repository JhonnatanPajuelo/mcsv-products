package com.jpajuelo.products.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "productos")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;
    @Column(name = "create_at")
    private LocalDate createAt;
}
