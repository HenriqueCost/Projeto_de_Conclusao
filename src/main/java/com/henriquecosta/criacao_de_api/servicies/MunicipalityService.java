package com.henriquecosta.criacao_de_api.servicies;

import com.henriquecosta.criacao_de_api.DTO.MunicipalityListDTO;
import com.henriquecosta.criacao_de_api.entities.Municipality;
import com.henriquecosta.criacao_de_api.repositories.MunicipalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipalityService {

    @Autowired
    private MunicipalityRepository repository;

    public Municipality dados(Long id){
        MunicipalityListDTO dto = repository.findById(id).get();
         Municipality municipality = new Municipality(dto);
         return municipality;
    }

    /*@Autowired
    public MunicipalityFeign municipalityFeign;


    /*public Municipality pegarDados(MunicipalityDTO){
        MunicipalityDTO dados = repository.findById(MunicipalityDTO).get();
        Municipality municipality = new Municipality(dados);
        return dados;
    }

    /*public Optional<MunicipalityListDTO> acharPorId(Long id){

        return municipalityRepository.findById(id);
    }

    public MunicipalityListDTO salvar(MunicipalityListDTO municipality){

        return municipalityRepository.save(municipality);
    }

    public MunicipalityListDTO atualizarPorId(MunicipalityListDTO municipality){

        return  municipalityRepository.save(municipality);
    }

    public Optional<MunicipalityListDTO> removerPorId(Long id){

        return null;
    }*/

}
