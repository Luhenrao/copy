package com.java02.demo.Wrapper;

import org.hibernate.mapping.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import  
@XmlRootElement(name = "Planeta")
public class PlanetaWrapper {
    





    private List<PlanetaDto> planeta;

    @XmlElement(name = "planetas")
    public List<PlanetaDto> getPlaneta() {
        return planeta;
    }

    public void setPlaneta(List<PlanetaDto> planeta) {
        this.planeta = planeta;
    }
}


