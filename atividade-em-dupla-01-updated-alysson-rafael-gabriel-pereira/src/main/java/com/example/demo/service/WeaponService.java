package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Weapon;
import com.example.demo.repository.WeaponRepository;

@Service
public class WeaponService {
    @Autowired
    private WeaponRepository weaponRepository;


    public List<Weapon> findAll(){
        return weaponRepository.findAll();
    }
    
    public Weapon getByWeaponName(String weaponName){
        return weaponRepository.findByWeaponName(weaponName);
    }

    public List<Weapon> getByCategory(String category){
        return weaponRepository.findByCategory(category);
    }

    public Optional<Weapon> getById(Long Id){
        return weaponRepository.findById(Id);
    }
    
    public void deleteById(Long Id){
        weaponRepository.deleteById(Id);
    }

    public void deleteByWeaponName(String weaponName){
        weaponRepository.deleteByWeaponName(weaponName);
    }

    public Weapon saveWeapon(Weapon weapon) {
        return weaponRepository.save(weapon);
    }
    
    public Weapon updateWeaponById(Long id, Weapon weaponAtualizado) {
        Optional<Weapon> weaponExistente = weaponRepository.findById(id);

        if (weaponExistente.isPresent()) {
            Weapon weapon = weaponExistente.get();

            weapon.setWeaponName(weaponAtualizado.getWeaponName());
            weapon.setCategory(weaponAtualizado.getCategory());
            weaponRepository.save(weapon);

            return weapon;
        } else {
            return null;
        }


}
}