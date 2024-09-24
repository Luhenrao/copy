package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dto.DeputadoDTO;
import com.example.demo.dto.OrgaoDTO;
import com.example.demo.service.ExternalApiService;

@RestController
@RequestMapping("/api/external")
public class ExternalApiController {

    @Autowired
    private ExternalApiService externalApiService;

    @GetMapping("/deputados")
    public List<DeputadoDTO> getDeputadosExternos() {
        return externalApiService.getDeputados();
    }

    @GetMapping("/orgaos")
    public List<OrgaoDTO> getOrgaosExternos() {
        return externalApiService.getOrgaos();
    }
}
