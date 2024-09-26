package com.java02.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java02.demo.Model.Personagem;
import com.java02.demo.Model.Planeta;
import com.java02.demo.Repository.PersonagemRepository;
import com.java02.demo.Repository.PlanetaRepository;
import com.java02.demo.Wrapper.PersonagemWrapper;
import com.java02.demo.Wrapper.PlanetaWrapper;
import com.java02.demo.dto.PersonagemDto;
import com.java02.demo.dto.PlanetaDto;

@Service
public class ExternalAPIService {

    private final String url1 = "https://www.dragonball-api.com/api/characters";
    private final String url2 = "https://dragonball-api.com/api/planets";
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    private PlanetaRepository planetaRepository;
    


    public List<PersonagemDto> getPersonagens() {
        String url1 = this.url1;


        ResponseEntity<PersonagemWrapper> response = restTemplate.getForEntity(url1, PersonagemWrapper.class);
        return response.getBody().getPersonagem();
    }

    public List<PlanetaDto> getPlanetas() {
        String url2 = this.url2;


        ResponseEntity<PlanetaWrapper> response = restTemplate.getForEntity(url2, PlanetaWrapper.class);
        return response.getBody().getPlaneta();
    }

    public ExternalAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    



   public List<Personagem> getPersonagensByRaca(String raca) {
        return personagemRepository.findByRaca(raca);
    }

    public void deleteById(Long id) {
        if (personagemRepository.existsById(id)) {
            personagemRepository.deleteById(id);
        }
    }

    public Personagem updatePersonagemById(Long id, Personagem personagemAtualizado) {
        Optional<Personagem> personagemExistente = personagemRepository.findById(id);

        if (personagemExistente.isPresent()) {
            Personagem personagem = personagemExistente.get();

            personagem.setNome(personagemAtualizado.getNome());
            personagem.setRaca(personagemAtualizado.getRaca());
            personagemRepository.save(personagem);

            return personagem;
        } else {
            return null;
        }

    }

    public Personagem savePersonagem(Personagem personagem) {
        return personagemRepository.save(personagem);
    }

    public List<Personagem> getPersonagemList() {
        return personagemRepository.findAll();
    }

    public Personagem getPersonagemByNome(String nome){
        Optional<Personagem> personagemOpt = Optional.ofNullable(personagemRepository.findByNome(nome));

        if(personagemOpt.isPresent()){
            return personagemOpt.get();
        }   else{
            return null;
        }
        
    } 

    public Personagem getPersonagemById(Long id){
        Optional<Personagem> personagemOpt = personagemRepository.findById(id);

        if(personagemOpt.isPresent()){
            return personagemOpt.get();
        }   else{
            return null;
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

    public Planeta findByNome(String nome){
        return planetaRepository.findByNome(nome);
    }
}
