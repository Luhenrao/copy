package com.java02.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java02.demo.dto.PersonagemDto;
import com.java02.demo.dto.PlanetaDto;
import com.java02.demo.service.ExternalAPIService;



@RestController
@RequestMapping ("api/v1/")
public class ExternalAPIhandler {
    @Autowired
    private ExternalAPIService externalAPIService;

    @GetMapping("/personagens")
    public List<PersonagemDto> getPersonagensExternos() {
        return externalAPIService.getPersonagens();
    }

    @GetMapping("/planetas")
    public List<PlanetaDto> getPlanetasExternos() {
        return externalAPIService.getPlanetas();
    }
    

}
