package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Weapon;
@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Long> {
        
        public Weapon findByWeaponName(String weaponName);

        public List<Weapon> findByCategory(String category);

        public void deleteByWeaponName(String weaponName);


}
