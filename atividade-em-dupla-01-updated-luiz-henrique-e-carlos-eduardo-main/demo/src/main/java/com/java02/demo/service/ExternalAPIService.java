package com.java02.demo.service;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java02.demo.Repository.PersonagemRepository;
import com.java02.demo.dto.PersonagemDto;

@Service
public class ExternalAPIService {

    private final String url = "https://www.dragonball-api.com/api";
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PersonagemRepository personagemRepository;

    public String getAllData() {
       return restTemplate.getForObject(this.url, String.class);
    }


    public List<PersonagemDto> getPersonagens() {
        String url = "https://dragonball-api.com/api/characters";


        ResponseEntity<PersonagemWrapper> response = restTemplate.getForEntity(url, PersonagemWrapper.class);
        return response.getBody().getPersonagem();
    }

    public List<PlanetaDto> getPlanetas() {
        String url = "https://dragonball-api.com/api/planets";


        ResponseEntity<PlanetaWrapper> response = restTemplate.getForEntity(url, PlanetaWrapper.class);
        return response.getBody().getPlaneta();
    }
}
