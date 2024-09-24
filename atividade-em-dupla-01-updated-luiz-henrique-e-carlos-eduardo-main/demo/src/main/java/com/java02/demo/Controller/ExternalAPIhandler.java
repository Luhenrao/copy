package com.java02.demo.Controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java02.demo.service.ExternalAPIService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping ("api/v1/")
public class ExternalAPIhandler {
    @Autowired
    private ExternalAPIService externalAPIService;

    @GetMapping
    public String getAllData(){
        return externalAPIService.getAllData();
    }

    @GetMapping("/Personagens")
    public List<PersonagemDTO> getPersonagemExternos() {
        return externalAPIService.getPersonagens();
    }
    

}
