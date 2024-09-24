package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Wrapper.AgentWrapper;
import com.example.demo.Wrapper.WeaponWrapper;
import com.example.demo.dto.AgentDTO;
import com.example.demo.dto.WeaponDTO;
import com.example.demo.repository.AgentRepository;

public class ExternalApiService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AgentRepository agentRepository;


    public List<AgentDTO> getAgents() {
        String url = "https://valorant-api.com/v1/agents";


        ResponseEntity<AgentWrapper> response = restTemplate.getForEntity(url, AgentWrapper.class);
        return response.getBody().getAgent();
    }

    public List<WeaponDTO> getWeapons() {
        String url = "https://valorant-api.com/v1/weapons";


        ResponseEntity<WeaponWrapper> response = restTemplate.getForEntity(url, WeaponWrapper.class);
        return response.getBody().getWeapon();
    }


}
