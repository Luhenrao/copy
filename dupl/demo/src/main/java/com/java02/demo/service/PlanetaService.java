package com.java02.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.java02.demo.Model.Planeta;
import org.springframework.web.client.RestTemplate;
import com.java02.demo.Repository.PlanetaRepository;

@Service
public class PlanetaService {

    @Autowired
    private PlanetaRepository planetaRepository;

    private final String url = "https://dragonball-api.com/api/planets";
    
    @Autowired
    private RestTemplate restTemplate;

    public String getAllData() {
       return restTemplate.getForObject(this.url, String.class);
    }

    public void deleteById(Long id) {
        if (planetaRepository.existsById(id)) {
            planetaRepository.deleteById(id);
        }
    }

    public Planeta updatePlanetaById(Long id, Planeta planetaAtualizado) {
        Optional<Planeta> planetaExistente = planetaRepository.findById(id);

        if (planetaExistente.isPresent()) {
            Planeta planeta = planetaExistente.get();

            planeta.setNome(planetaAtualizado.getNome());
            planeta.setDestruido(planetaAtualizado.getDestruido());
            planetaRepository.save(planeta);

            return planeta;
        } else {
            return null;
        }

    }

    public Planeta savePlaneta(Planeta planeta) {
        return planetaRepository.save(planeta);
    }

    public List<Planeta> getPlanetaList() {
        return planetaRepository.findAll();
    }

    public List<Planeta> getPlanetasByDestruido(Boolean destruido) {
        return planetaRepository.findByDestruido(destruido);
    }

    public Planeta getPlanetaById(Long id){
        Optional<Planeta> planetaOpt = planetaRepository.findById(id);

        if(planetaOpt.isPresent()){
            return planetaOpt.get();
        } else{
            return null;
        }
    }

}
