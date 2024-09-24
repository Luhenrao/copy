package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AgentDTO;
import com.example.demo.dto.WeaponDTO;
import com.example.demo.service.ExternalApiService;



@RestController
@RequestMapping("/api/external")
public class ExternalApiController {

    @Autowired
    private ExternalApiService externalApiService;

    @GetMapping("/agents")
    public List<AgentDTO> getAgentsExternos() {
        return externalApiService.getAgents();
    }

    @GetMapping("/weapon")
    public List<WeaponDTO> getWeaponsExternos() {
        return externalApiService.getWeapons();
    }


}
