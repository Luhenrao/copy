package com.java02.demo.Exception;

public class PlanetaNotFoundException extends Exception {
    public PlanetaNotFoundException(String id) {
        super("Planeta não encontrado " + id);
    }
}