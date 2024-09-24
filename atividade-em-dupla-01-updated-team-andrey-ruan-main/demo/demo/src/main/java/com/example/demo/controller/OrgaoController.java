package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Orgao;
import com.example.demo.service.OrgaoService;

@RestController
@RequestMapping("/api/orgaos")
public class OrgaoController {

    @Autowired
    private OrgaoService orgaoService;

    

    // Endpoint para criar um novo órgão
    @PostMapping
    public ResponseEntity<Orgao> createOrgao(@RequestBody Orgao orgao) {
        Orgao savedOrgao = orgaoService.saveOrgao(orgao);
        return ResponseEntity.status(201).body(savedOrgao);
    }

    // Endpoint para atualizar um órgão
    @PutMapping("/{id}")
public ResponseEntity<Orgao> updateOrgao(@PathVariable Long id, @RequestBody Orgao orgao) {
    try {
        // Chama o serviço para atualizar o órgão
        Orgao updatedOrgao = orgaoService.updateByOrgao(id, orgao);

        // Retorna uma resposta com o órgão atualizado
        return ResponseEntity.ok(updatedOrgao);

    } catch (ResourceNotFoundException e) {
        // Retorna 404 caso o órgão não seja encontrado
        return ResponseEntity.notFound().build();
    }
}

    // Endpoint para buscar todos os órgãos
    @GetMapping
    public List<Orgao> findAllOrgaos() {
        return orgaoService.findAll();
    }

    // Endpoint para deletar um órgão
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrgao(@PathVariable Long id) {
        orgaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    

    @GetMapping("/nome")
    public Orgao findByNome(@PathVariable String nome) {
        return orgaoService.findByNome(nome);
    }


    @DeleteMapping("/nome")
    public ResponseEntity<Void> deleteByNome(@PathVariable String nome) {
        orgaoService.deleteByNome(nome);
        return ResponseEntity.noContent().build();
    }
}
