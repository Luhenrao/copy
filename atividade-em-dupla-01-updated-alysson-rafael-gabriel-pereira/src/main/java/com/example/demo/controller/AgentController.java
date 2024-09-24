package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Agent;
import com.example.demo.service.AgentService;

@RestController
@RequestMapping("api/v1/agent")
public class AgentController {
    
@Autowired
    private AgentService agentService;

    @PostMapping(value ="/add")
    public Agent createAgent(@RequestBody Agent agent) {
        return agentService.saveAgent(agent);
    }

    
    
    @GetMapping
    public List<Agent> findAll() {
        return agentService.findAll();
    }


    @GetMapping("/{id}")
    public Optional<Agent> findById(Long id) {
        return agentService.getById(id);
    }

    
    @GetMapping("/{agentName}")
    public Agent findByName(String agentName) {
        return agentService.getByDisplayName(agentName);
    }
    
    
    
    @DeleteMapping("id/{id}")
    public void deleteAgentById(@PathVariable Long id) {
        agentService.deleteById(id);
    }


    @DeleteMapping("name/{name}")
    public void deletaAgentByName(@PathVariable String name) {
        agentService.deleteByDisplayName(name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agent> updateAgent(@PathVariable Long id, @RequestBody Agent persDeta) {
        agentService.updateAgentById(id, persDeta);
        return new ResponseEntity<>(persDeta, HttpStatus.OK);
    }
}

