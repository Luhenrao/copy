package com.java02.demo.Wrapper;


import java.util.List;

import com.java02.demo.dto.PlanetaDto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Planeta")
public class PlanetaWrapper {
    





    private List<PlanetaDto> planetas;

    @XmlElement(name = "planetas")
    public List<PlanetaDto> getPlaneta() {
        return planetas;
    }

    public void setPlaneta(List<PlanetaDto> planetas) {
        this.planetas = planetas;
    }
}


