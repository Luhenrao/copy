package com.java02.demo.dto;

import com.java02.demo.Model.Personagem;


import lombok.Data;


@Data
public class PlanetaDto {
    private Long id;


    private String nome;

 
    private Boolean destruido;


    private Personagem personagens;



    
}
