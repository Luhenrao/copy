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
import com.example.demo.model.Deputado;
import com.example.demo.service.DeputadoService;
import com.example.demo.service.ExternalApiService;

@RestController
@RequestMapping("/api/deputados")
public class DeputadoController {

    @Autowired
    private DeputadoService deputadoService;

    @Autowired
    private ExternalApiService externalApiService;

    // Endpoint para criar um novo deputado
    @PostMapping(value = "add")
    public Deputado createDeputado(@RequestBody Deputado d) {
        return deputadoService.saveDeputado(d);
    }

    // Endpoint para atualizar um deputado
    @PutMapping("/{id}")
public ResponseEntity<Deputado> updateOrgao(@PathVariable Long ideCadastro, @RequestBody Deputado Deputado) {
    try {
        // Chama o serviço para atualizar o órgão
        Deputado updatedDeputado = deputadoService.updateByDeputado(ideCadastro, Deputado);

        // Retorna uma resposta com o órgão atualizado
        return ResponseEntity.ok(updatedDeputado);

    } catch (ResourceNotFoundException e) {
        // Retorna 404 caso o órgão não seja encontrado
        return ResponseEntity.notFound().build();
    }
}

    // Endpoint para buscar todos os deputados
    @GetMapping(value = "all")
    public List<Deputado> findAllDeputados() {
        return deputadoService.findAll();
    }

    // Endpoint para deletar um deputado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeputado(@PathVariable Long ideCadastro) {
        deputadoService.deleteById(ideCadastro);
        return ResponseEntity.noContent().build();
    }

    

    @GetMapping("/nome")
    public Deputado findByNome(@PathVariable String nome) {
        return externalApiService.findByNome(nome);
    }

    @DeleteMapping("/nome")
    public ResponseEntity<Void> deleteByNome(@PathVariable String nome) {
        deputadoService.deleteByNome(nome);
        return ResponseEntity.noContent().build();
    }

    
}