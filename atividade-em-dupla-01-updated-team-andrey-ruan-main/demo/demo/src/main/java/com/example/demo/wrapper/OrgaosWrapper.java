package com.example.demo.wrapper;

import java.util.List;

import com.example.demo.dto.OrgaoDTO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

// OrgaosWrapper.java
@XmlRootElement(name = "orgaos")
public class OrgaosWrapper {

    private List<OrgaoDTO> orgaos;

    @XmlElement(name = "orgao")
    public List<OrgaoDTO> getOrgaos() {
        return orgaos;
    }

    public void setOrgaos(List<OrgaoDTO> orgaos) {
        this.orgaos = orgaos;
    }
}
