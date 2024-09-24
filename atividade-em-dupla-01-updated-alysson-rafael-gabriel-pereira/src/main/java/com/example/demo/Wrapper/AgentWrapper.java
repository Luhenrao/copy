package com.example.demo.Wrapper;

import java.util.List;

import com.example.demo.dto.AgentDTO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Agent")
public class AgentWrapper {

    private List<AgentDTO> agents;

    @XmlElement(name = "agents")
    public List<AgentDTO> getAgent() {
        return agents;
    }

    public void setAgents(List<AgentDTO> agents) {
        this.agents = agents;
    }
}

