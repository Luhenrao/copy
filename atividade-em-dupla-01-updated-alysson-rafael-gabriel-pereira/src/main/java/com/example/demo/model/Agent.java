package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Agent {

    @Id
    @GeneratedValue
    
    private Long id;
    

    private String Displayname;

    private String Agentdescription;

    private String hability1;
    private String hability2;
    private String hability3;
    private String ultimate;

    private String descriptionH1;
    private String descriptionH2;
    private String descriptionH3;
    private String Ultdescription;

    private String role;
  
}
