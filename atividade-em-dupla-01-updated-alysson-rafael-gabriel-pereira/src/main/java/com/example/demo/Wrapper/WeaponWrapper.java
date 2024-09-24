package com.example.demo.Wrapper;

import java.util.List;

import com.example.demo.dto.WeaponDTO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Weapon")
public class WeaponWrapper {

    private List<WeaponDTO> weapons;

    @XmlElement(name = "weapons")
    public List<WeaponDTO> getWeapon() {
        return weapons;
    }

    public void setWeapons(List<WeaponDTO> weapons) {
        this.weapons = weapons;
    }
}
