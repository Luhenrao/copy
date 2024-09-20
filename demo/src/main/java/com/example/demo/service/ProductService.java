package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    private final String url="https://mcdonald-s-products-api.p.rapidapi.com/us/";

    @Autowired
    private RestTemplate restTemplate;


    public String getAllData(){
    return restTemplate.getForObject(this.url, String.class);
    }

    // Create a new product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Get all products
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Get a product by its ID
    public Product getProductById(Long id) {

        Optional<Product> productOpt = productRepository.findById(id);

        if (productOpt.isPresent()){
            return productOpt.get();
        } else {
            return null;
        }

    }

    // Get a product by its name (custom method)
    public Product getProductByName(String name) {
        Optional<Product> productOpt = productRepository.findByName(name);

        if (productOpt.isPresent()){
            return productOpt.get();
        } else {
            return null;
        }
    }

    // Get a product by its description (custom method)
    public Product getProductByDescription(String description) {
        Optional<Product> productOpt = productRepository.findByDescription(description);

        if (productOpt.isPresent()){
            return productOpt.get();
        } else {
            return null;
        }
    }
    public Product updateById(Long id, Product product) throws EntityNotFoundException {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        } else {
            throw new EntityNotFoundException("Category with id " + id + " does not exist.");
        }
    }

    // Delete a product by its ID
    public void deleteById(Long id) throws EntityNotFoundException {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Product not found");
        }
    }

    // Delete a product by its name (custom method)
    public void deleteByName(String name) {
        productRepository.deleteByName(name);
    }

    // Delete a product by its description (custom method)
    public void deleteByDescription(String description) {
        productRepository.deleteByDescription(description);
    }

}