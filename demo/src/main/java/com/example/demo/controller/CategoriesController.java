package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Categories;
import com.example.demo.service.CategoriesService;

@RestController
@RequestMapping("api/v1/Categories")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

     /*Create*/

    //Criar uma categoria
    @PostMapping(value ="/add")
    public Categories createCategories(@RequestBody Categories category) {
        return categoriesService.saveCategories(category);
    }

    /*Read*/
    @GetMapping
    public String getAllData(){
        return categoriesService.getAllData();
    }

    //Ler todas as Categorias
    @GetMapping("/all")
    public List<Categories> findAll() {
        return categoriesService.findAll();
    }

    //Ler os id
    @GetMapping("/{id}")
    public Categories findById(@PathVariable Long id) {
        Categories c= categoriesService.findById(id);
        return c;
    }

    //Ler os nomes
    @GetMapping("/{name}")
    public Categories findByName(String name) {
        return categoriesService.findByName(name);
    }

    /*Update*/

    // Atualizar categorias pelo Id
    @PutMapping("id/{id}")
    public Categories updateById(@PathVariable Long id, @RequestBody Categories updatedCategories) {
        return categoriesService.updateById(id, updatedCategories);
    }

    // Atualizar categoria pelo Nome
    @PutMapping("name/{name}")
    public Categories updateByName(@PathVariable String name, @RequestBody Categories updatedCategories) {
        return categoriesService.updateByName(name, updatedCategories);
    }

    /*Delete*/
    
    // Deletar um livro pelo ID
    @DeleteMapping("id/{id}")
    public void deleteCategoriesById(@PathVariable Long id) {
        categoriesService.deleteById(id);
    }

    // Deletar um livro por gênero
    @DeleteMapping("name/{name}")
    public void deletaCategoriesByName(@PathVariable String name) {
        categoriesService.deleteByName(name);
    }

}