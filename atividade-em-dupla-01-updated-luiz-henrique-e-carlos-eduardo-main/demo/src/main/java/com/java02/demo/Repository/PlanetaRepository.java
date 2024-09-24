package com.java02.demo.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java02.demo.Model.Planeta;


@Repository
public interface PlanetaRepository extends JpaRepository<Planeta, Long>{

public List<Planeta> findByDestruido(Boolean destruido); 
    
}
