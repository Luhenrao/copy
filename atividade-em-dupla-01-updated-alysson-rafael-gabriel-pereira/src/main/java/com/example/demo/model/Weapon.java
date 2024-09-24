package com.example.demo.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Weapon {
@Id
@GeneratedValue
private Long id;
private String weaponName;
private String category;
private float bodyDamage;
private float headDamage;


}
