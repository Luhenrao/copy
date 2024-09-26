package com.java02.demo.Wrapper;


import java.util.List;

import com.java02.demo.dto.PersonagemDto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Personagem")
public class PersonagemWrapper {
    





    private List<PersonagemDto> Personagens;

    @XmlElement(name = "Personagens")
    public List<PersonagemDto> getPersonagem() {
        return Personagens;
    }

    public void setPersonagem(List<PersonagemDto> Personagens) {
        this.Personagens = Personagens;
    }
}


