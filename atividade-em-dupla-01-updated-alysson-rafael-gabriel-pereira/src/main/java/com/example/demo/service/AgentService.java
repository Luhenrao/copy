package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Agent;
import com.example.demo.repository.AgentRepository;

@Service
public class AgentService {
    @Autowired
    private AgentRepository agentRepository;


    public List<Agent> findAll(){
        return agentRepository.findAll();
    }
    
    public Agent getByDisplayName(String DisplayName){
        return agentRepository.findByDisplayName(DisplayName);
    }

    public List<Agent> getByCategory(String category){
        return agentRepository.findByRole(category);
    }

    public Optional<Agent> getById(Long Id){
        return agentRepository.findById(Id);
    }
    
    public void deleteById(Long Id){
        agentRepository.deleteById(Id);
    }

    public void deleteByDisplayName(String DisplayName){
        agentRepository.deleteByDisplayName(DisplayName);
    }

    public Agent saveAgent(Agent agent) {
        return agentRepository.save(agent);
    }
    
    public Agent updateAgentById(Long id, Agent agentAtualizado) {
        Optional<Agent> agentExistente = agentRepository.findById(id);

        if (agentExistente.isPresent()) {
            Agent agent = agentExistente.get();

            agent.setDisplayname(agentAtualizado.getDisplayname());
            agent.setRole(agentAtualizado.getRole());
            agentRepository.save(agent);

            return agent;
        } else {
            return null;
        }


}
}