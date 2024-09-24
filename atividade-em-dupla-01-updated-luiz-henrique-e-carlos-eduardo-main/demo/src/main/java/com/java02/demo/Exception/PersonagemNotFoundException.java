package com.java02.demo.Exception;

public class PersonagemNotFoundException extends Exception {
    public PersonagemNotFoundException(String id) {
        super("Personagem não encontrado " + id);
    }
}