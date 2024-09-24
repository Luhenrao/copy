package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.DeputadoDTO;
import com.example.demo.dto.OrgaoDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Deputado;
import com.example.demo.repository.DeputadoRepository;
import com.example.demo.wrapper.DeputadosWrapper;
import com.example.demo.wrapper.OrgaosWrapper;

@Service
public class ExternalApiService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DeputadoRepository deputadoRepository;

    public ExternalApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Obtém os deputados da API externa e os mapeia para uma lista de DTOs
    public List<DeputadoDTO> getDeputados() {
        String url = "https://www.camara.leg.br/SitCamaraWS/Deputados.asmx/ObterDeputados";

        // Aqui assumimos que a resposta é XML e usamos o RestTemplate para converter em DeputadoDTO
        ResponseEntity<DeputadosWrapper> response = restTemplate.getForEntity(url, DeputadosWrapper.class);
        return response.getBody().getDeputados();
    }

    // Obtém os órgãos da API externa e os mapeia para uma lista de DTOs
    public List<OrgaoDTO> getOrgaos() {
        String url = "https://www.camara.leg.br/SitCamaraWS/Orgaos.asmx/ListarTiposOrgaos";

        // Aqui assumimos que a resposta é XML e usamos o RestTemplate para converter em OrgaoDTO
        ResponseEntity<OrgaosWrapper> response = restTemplate.getForEntity(url, OrgaosWrapper.class);
        return response.getBody().getOrgaos();
    }

    // Persistir um deputado localmente no banco de dados
    public Deputado saveDeputado(Deputado d) {
        return deputadoRepository.save(d);
    }

    // Atualizar um deputado com base no ideCadastro
    public Deputado updateByDeputado(Long ideCadastro, Deputado d) throws ResourceNotFoundException {
        Optional<Deputado> optionalDeputado = deputadoRepository.findById(ideCadastro);

        if (optionalDeputado.isPresent()) {
            Deputado deputado = optionalDeputado.get();
            deputado.setNome(d.getNome());
            deputado.setUf(d.getUf());

            return deputadoRepository.save(deputado);
        } else {
            throw new ResourceNotFoundException("Deputado com ID " + ideCadastro + " não encontrado");
        }
    }

    public List<Deputado> findAll() {
        return deputadoRepository.findAll();
    }

    public void deleteById(Long ideCadastro) {
        deputadoRepository.deleteById(ideCadastro);
    }

    public Deputado findByNome(String nome) {
        return deputadoRepository.findByNome(nome);
    }

    public void deleteByNome(String nome) {
        deputadoRepository.deleteByNome(nome);
    }
}

