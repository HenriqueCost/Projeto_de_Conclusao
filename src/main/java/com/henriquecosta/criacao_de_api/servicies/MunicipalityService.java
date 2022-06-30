package com.henriquecosta.criacao_de_api.servicies;

import com.henriquecosta.criacao_de_api.entities.Municipality;
import com.henriquecosta.criacao_de_api.repositories.MunicipalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MunicipalityService {

    @Value("${Projeto_de_Conclusao.host}")
    private String projetoConclusaoHost;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<Object> getDados(){
        String url = "https://was-p.bcnet.bcb.gov.br/olinda/servico/SICOR/versao/v2/odata$metadata#CusteioMunicipioProduto(Municipio,nomeProduto,MesEmissao,AnoEmissao,cdPrograma,cdSubPrograma,cdFonteRecurso,cdTipoSeguro,cdEstado,VlCusteio,cdProduto,codCadMu,Atividade,cdModalidade,codIbge,AreaCusteio)";
        RestTemplate restTemplate1 = new RestTemplate();
        Object[] dados = restTemplate1.getForObject(url, Object[].class);
        return Arrays.asList(dados);
    }

    @Autowired
    private MunicipalityRepository municipalityRepository;

    public List<Municipality> acharTudo(){

        return municipalityRepository.findAll();
    }

    public Optional<Municipality> acharPorId(Long id){

        return municipalityRepository.findById(id);
    }

    public Municipality salvar(Municipality municipality){

        return municipalityRepository.save(municipality);
    }

    public Municipality atualizarPorId(Municipality municipality){

        return  municipalityRepository.save(municipality);
    }

    public Optional<Municipality> removerPorId(Long id){

        return null;
    }

}
