package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long>{

   public Agent findByDisplayName(String DisplayName);

   public List<Agent> findByRole(String role);

   public void deleteByDisplayName(String weaponName);
   



}
