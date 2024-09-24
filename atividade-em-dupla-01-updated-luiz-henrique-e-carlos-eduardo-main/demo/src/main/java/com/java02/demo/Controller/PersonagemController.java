package com.java02.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java02.demo.Exception.PersonagemNotFoundException;
import com.java02.demo.Model.Personagem;
import com.java02.demo.service.PersonagemService;


@RestController
@RequestMapping("/Personagem")
public class PersonagemController {
    
    @Autowired
    private PersonagemService personagemService;


    @PutMapping("/{id}")
public ResponseEntity<Personagem> updatePersonagem(@PathVariable Long id, @RequestBody Personagem persDeta) {
        personagemService.updatePersonagemById(id, persDeta);
        return new ResponseEntity<>(persDeta, HttpStatus.OK);
    }

    @GetMapping
    public String getAllData(){
        return personagemService.getAllData();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePersonagem(@PathVariable Long id) {
        personagemService.deleteById(id);
        return null;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Personagem> savePersonagem(@RequestBody Personagem personagem) {
       Personagem personagemSalvo = personagemService.savePersonagem(personagem);
        return new ResponseEntity<>(personagemSalvo, HttpStatus.CREATED);
    }

    
    @GetMapping("/all")
    public List<Personagem> getAllPersonagens() {
       return personagemService.getPersonagemList();
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Personagem> findByNome(@PathVariable String nome) throws PersonagemNotFoundException {
           Optional<Personagem> personagemOptional = Optional.ofNullable(personagemService.getPersonagemByNome(nome));
        return personagemOptional.map(personagem -> new ResponseEntity<>(personagem, HttpStatus.OK))
                             .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /* 
    @GetMapping("/{id}")
    public ResponseEntity<Personagem> findById(@PathVariable Long id) throws PersonagemNotFoundException {
           Optional<Personagem> personagemOptional = Optional.ofNullable(personagemService.getPersonagemById(id));
        return personagemOptional.map(personagem -> new ResponseEntity<>(personagem, HttpStatus.OK))
                             .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
*/
    @GetMapping("/{id}")
    public Personagem getPersonagemById(@PathVariable Long id) {
        Personagem p = personagemService.getPersonagemById(id);
        return p;
    }
 
}

