package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Orgao;
import com.example.demo.repository.OrgaoRepository;

@Service
public class OrgaoService {

    @Autowired
    private OrgaoRepository orgaoRepository;

    @Autowired
    private RestTemplate restTemplate;

    // Método para salvar um novo orgão
    public Orgao saveOrgao(Orgao o) {
        return orgaoRepository.save(o);
    }

    public String getOrgao() {
        return restTemplate.getForObject("https://www.camara.leg.br/SitCamaraWS/Orgaos.asmx/ListarTiposOrgaos", String.class);
    }

    // Método para atualizar um órgão com base no ID
    public Orgao updateByOrgao(Long id, Orgao o) throws ResourceNotFoundException {
        // Busca o órgão pelo ID
        Optional<Orgao> optionalOrgao = orgaoRepository.findById(id);
    
        // Se o órgão existir, atualiza os campos e salva
        if (optionalOrgao.isPresent()) {
            Orgao orgao = optionalOrgao.get();
            // Atualiza os campos do órgão
            orgao.setNome(o.getNome());
    
            // Salva as alterações no banco de dados
            return orgaoRepository.save(orgao);
        } else {
            // Lança a exceção se o órgão não for encontrado
            throw new ResourceNotFoundException("Órgão com ID " + id + " não encontrado");
        }
    }

    // Método para buscar todos os órgãos
    public List<Orgao> findAll() {
        return orgaoRepository.findAll();
    }

    // Método para deletar um órgão pelo ID
    public void deleteById(Long id){
        orgaoRepository.deleteById(id);
    }

    public Orgao findByNome(String nome){
        return orgaoRepository.findByNome(nome);
    }

    public void deleteByNome(String nome){
        orgaoRepository.deleteByNome(nome);
    }


    }


