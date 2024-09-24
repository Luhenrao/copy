package com.java02.demo.dto;

import com.java02.demo.Model.Personagem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PlanetaDto {
    private Long id;


    private String nome;

 
    private Boolean destruido;


    private Personagem personagens;



    
}
