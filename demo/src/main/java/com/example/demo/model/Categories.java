package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Categories {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // Relacionamento de uma categoria para muitos produtos
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
