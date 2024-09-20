package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String description;

    // Relacionamento de muitos produtos para uma categoria
    @ManyToOne
    private Categories category;
}
