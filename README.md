package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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

     /*Cread*/

    //Criar uma categoria
    @PostMapping(value ="/add")
    public Categories createCategories(@RequestBody Categories category) {
        return categoriesService.saveCategories(category);
    }

    /*Read*/

    //Ler todas as Categorias
    @GetMapping 
    public List<Categories> findAll() {
        return categoriesService.findAll();
    }

    //Ler os id
    @GetMapping("/{id}")
    public Optional<Categories> findById(Long id) {
        return categoriesService.findById(id);
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

//////////

package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Create a new product
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    // Get all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

@GetMapping("/{id}")
public ResponseEntity<Product> getProductById(@PathVariable Long id) {
    Optional<Product> product = productService.getProductById(id);
    return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                  .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
}

    // Update product by ID
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Product product = productService.updateProduct(id, updatedProduct);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // Update product name by ID
    @PatchMapping("/{id}/name")
    public ResponseEntity<Product> updateProductName(@PathVariable Long id, @RequestParam String newName) {
        Product updatedProduct = productService.updateName(id, newName);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    // Update product description by ID
    @PatchMapping("/{id}/description")
    public ResponseEntity<Product> updateProductDescription(@PathVariable Long id, @RequestParam String newDescription) {
        Product updatedProduct = productService.updateDescription(id, newDescription);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    // Delete product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

///////////

package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Categories;
import com.example.demo.repository.CategoriesRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriesService {

    @Autowired(required = false)
    private CategoriesRepository categoriesRepository;

    //Create

    public Categories saveCategories(Categories category) {
        return categoriesRepository.save(category);
    }

        // Read

        public List<Categories> findAll () {
            return categoriesRepository.findAll();
        }
    
        public Optional<Categories> findById(Long id) {
            return categoriesRepository.findById(id);
        }
    
        public Categories findByName(String name) {
            return categoriesRepository.findByName(name);
        }
    

    // Update
    public Categories updateById(Long id, Categories category) throws EntityNotFoundException {
        if (categoriesRepository.existsById(id)) {
            category.setId(id);
            return categoriesRepository.save(category);
        } else {
            throw new EntityNotFoundException("Category with id " + id + " does not exist.");
        }
    }

    public Categories updateByName(String name, Categories newCategory)throws EntityNotFoundException {
        Categories existingCategory = categoriesRepository.findByName(name);
        if (existingCategory != null) {
            newCategory.setId(existingCategory.getId());
            return categoriesRepository.save(newCategory);
        } else {
            throw new EntityNotFoundException("Category with name " + name + " does not exist.");
        }
    }

    //Delete

    public void deleteById (Long id){
        categoriesRepository.deleteById(id);
    }

    public void deleteByName (String name) {
        categoriesRepository.deleteByName(name);
    }
}
