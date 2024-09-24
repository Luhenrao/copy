package com.java02.demo.dto;

import com.java02.demo.Model.Planeta;


import lombok.Data;

@Data
public class PersonagemDto {
    private Long id;

 
    private String nome;

    private Long ki;
 
    private String raca;

    private String genero;

    private String afiliacao;


    private Planeta planetaOrigem;
}
