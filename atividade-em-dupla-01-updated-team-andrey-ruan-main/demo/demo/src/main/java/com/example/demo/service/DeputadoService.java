package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Deputado;
import com.example.demo.repository.DeputadoRepository;

@Service
public class DeputadoService {

    @Autowired
    private DeputadoRepository deputadoRepository;

    @Autowired
    private RestTemplate restTemplate;


    public String getDeputados() {
        return restTemplate.getForObject("https://www.camara.leg.br/SitCamaraWS/Deputados.asmx/ObterDeputados", String.class);
    }


    public Deputado saveDeputado(Deputado d) {
        return deputadoRepository.save(d);
    }

    public Deputado updateByDeputado(Long ideCadastro, Deputado d) throws ResourceNotFoundException {
    // Busca o deputado pelo ID
    Optional<Deputado> optionalDeputado = deputadoRepository.findById(ideCadastro);
    
    // Se o deputado existir, atualiza os campos e salva
    if (optionalDeputado.isPresent()) {
        Deputado deputado = optionalDeputado.get();
        // Atualiza os campos do deputado
        deputado.setNome(d.getNome());
        deputado.setUf(d.getUf());
        // deputado.setOrgao(d.getOrgao());

        // Salva as alterações no banco de dados
        return deputadoRepository.save(deputado);
    } else {
        // Lança a exceção se o deputado não for encontrado
        throw new ResourceNotFoundException("Deputado com ID " + ideCadastro + " não encontrado");
    }
}

    public List<Deputado> findAll() {
        return deputadoRepository.findAll();
    }

    public void deleteById(Long ideCadastro) {
        deputadoRepository.deleteById(ideCadastro);
        
    }

    public Deputado findByNome(String nome){
        return deputadoRepository.findByNome(nome);
    }

    public void deleteByNome(String nome){
        deputadoRepository.deleteByNome(nome);
    }
}
