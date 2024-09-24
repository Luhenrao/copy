package com.example.demo.wrapper;

import java.util.List;

import com.example.demo.dto.DeputadoDTO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "deputados")
public class DeputadosWrapper {

    private List<DeputadoDTO> deputados;

    @XmlElement(name = "deputado")
    public List<DeputadoDTO> getDeputados() {
        return deputados;
    }

    public void setDeputados(List<DeputadoDTO> deputados) {
        this.deputados = deputados;
    }
}