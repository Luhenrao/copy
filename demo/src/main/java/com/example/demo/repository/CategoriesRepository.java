package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Long> {

/*Em todos os repositorios de interface JPA: create, delete, deleteById, findAll, findById*/

//Read

    public Categories findByName (String name);

//Delete
    public void deleteByName (String name);

    public boolean existsByName(String name);

}