package com.example.demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    /*Em todos os repositorios de interface JPA: create, delete, deleteById, findAll, findById*/
    
    //
    public Optional<Product> findByName(String name);
    public Optional<Product> findByDescription(String description);
    
    //
    public void deleteByName (String name);
    public void deleteByDescription (String name);

}
