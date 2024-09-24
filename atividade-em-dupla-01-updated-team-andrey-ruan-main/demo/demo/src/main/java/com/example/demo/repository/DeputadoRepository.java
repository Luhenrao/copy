package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Deputado;



public interface DeputadoRepository extends JpaRepository<Deputado, Long> {

    public Deputado findByNome(String nome);
    public void deleteByNome(String nome);
}
