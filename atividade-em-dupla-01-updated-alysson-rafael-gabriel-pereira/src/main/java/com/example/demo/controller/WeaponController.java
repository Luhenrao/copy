package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Weapon;
import com.example.demo.service.WeaponService;

@RestController
@RequestMapping("api/v1/weapon")
public class WeaponController {
    
 @Autowired
    private WeaponService weaponService;

    @PostMapping(value ="/add")
    public Weapon createWeapon(@RequestBody Weapon weapon) {
        return weaponService.saveWeapon(weapon);
    }

    
    
    @GetMapping 
    public List<Weapon> findAll() {
        return weaponService.findAll();
    }


    @GetMapping("/{id}")
    public Optional<Weapon> findById(Long id) {
        return weaponService.getById(id);
    }

    
    @GetMapping("/{weaponName}")
    public Weapon findByName(String weaponName) {
        return weaponService.getByWeaponName(weaponName);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Weapon> updateWeapon(@PathVariable Long id, @RequestBody Weapon persDeta) {
        weaponService.updateWeaponById(id, persDeta);
        return new ResponseEntity<>(persDeta, HttpStatus.OK);
    }

    
    
    
    @DeleteMapping("id/{id}")
    public void deleteWeaponById(@PathVariable Long id) {
        weaponService.deleteById(id);
    }


    @DeleteMapping("name/{name}")
    public void deletaWeaponByName(@PathVariable String name) {
        weaponService.deleteByWeaponName(name);
    }

}    

