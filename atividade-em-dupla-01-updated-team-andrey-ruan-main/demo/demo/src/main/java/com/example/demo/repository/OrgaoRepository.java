package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.Orgao;

public interface OrgaoRepository extends JpaRepository<Orgao, Long> {

    public Orgao findByNome(String nome);
    public void deleteByNome(String nome);
}
