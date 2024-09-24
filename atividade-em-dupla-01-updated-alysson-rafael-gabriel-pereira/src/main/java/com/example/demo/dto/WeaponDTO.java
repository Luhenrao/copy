package com.example.demo.dto;

import lombok.Data;

@Data
public class WeaponDTO {
    private Long id;
    private String weaponName;
    private String category;
    private float bodyDamage;
    private float headDamage;

}
