package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Create a new product
    @PostMapping(value ="/add")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping
    public String getAllData(){
        return productService.getAllData();
    }

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.findAll();
    }

    // Get product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        Product p = productService.getProductById(id);
        return p;
    }
    

    // Get product by name (using "/name/{name}" to differentiate from ID)
    @GetMapping("/name/{name}")
    public Product getProductByName(@PathVariable String name) {
        Product p = productService.getProductByName(name);
        return p;
    }

    @GetMapping("/description/{description}")
    public Product getProductByDescription(@PathVariable String description) {
        Product p = productService.getProductByDescription(description);
        return p;
    }

    // Update product by ID
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateById(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Product product = productService.updateById(id, updatedProduct);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // Deletar um livro pelo ID
    @DeleteMapping("id/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    // Deletar um livro por gênero
    @DeleteMapping("name/{name}")
    public void deletaByName(@PathVariable String name) {
        productService.deleteByName(name);
    }
    
}
