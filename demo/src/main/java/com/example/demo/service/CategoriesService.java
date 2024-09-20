package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Categories;
import com.example.demo.repository.CategoriesRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

       private final String url="https://mcdonald-s-products-api.p.rapidapi.com/us/";

    @Autowired
    private RestTemplate restTemplate;


    public String getAllData(){
    return restTemplate.getForObject(this.url, String.class);
    }

    //Create

    public Categories saveCategories(Categories category) {
        return categoriesRepository.save(category);
    }

        // Read

    public List<Categories> findAll () {
     return categoriesRepository.findAll();
    }

    
    public Categories findById(Long id) {

        Optional<Categories> categoriesOpt = categoriesRepository.findById(id);

        if (categoriesOpt.isPresent()){
            return categoriesOpt.get();
        } else {
            return null;
        }

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

    public Categories updateByName(String name, Categories category)throws EntityNotFoundException {
        Categories existingCategory = categoriesRepository.findByName(name);
        if (existingCategory != null) {
            category.setId(existingCategory.getId());
            return categoriesRepository.save(category);
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