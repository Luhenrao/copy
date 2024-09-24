package com.java02.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.java02.demo.Model.Personagem;
import com.java02.demo.Repository.PersonagemRepository;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    private final String url = "https://dragonball-api.com/api/characters";
    
    @Autowired
    private RestTemplate restTemplate;

    public String getAllData() {
       return restTemplate.getForObject(this.url, String.class);
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


}
