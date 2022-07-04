package com.henriquecosta.criacao_de_api.entities;


import com.henriquecosta.criacao_de_api.DTO.MunicipalityListDTO;
import com.henriquecosta.criacao_de_api.repositories.MunicipalityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class Conversor {

    @Autowired
    private MunicipalityRepository repository;

    @Autowired
    private MunicipalityListDTO listDTO;

    public Municipality get(){
        List<MunicipalityListDTO> list = (List<MunicipalityListDTO>) get();

        listDTO.getValue().forEach(dto -> {
            Municipality municipality = new Municipality();
            municipality.setNomeProduto(dto.getNomeProduto());
            municipality.setNomeRegiao(dto.getNomeRegiao());
            municipality.setNomeUF(dto.getNomeUF());
            municipality.setMesEmissao(dto.getMesEmissao());
            municipality.setAnoEmissao(dto.getAnoEmissao());
            municipality.setCdPrograma(dto.getCdPrograma());
            municipality.setCdSubPrograma(dto.getCdSubPrograma());
            municipality.setCdFonteRecurso(dto.getCdFonteRecurso());
            municipality.setCdTipoSeguro(dto.getCdTipoSeguro());
            municipality.setQtdCusteio(dto.getQtdCusteio());
            municipality.setVlCusteio(dto.getVlCusteio());
            municipality.setAtividade(dto.getAtividade());
            municipality.setCdModalidade(dto.getCdModalidade());
            municipality.setAreaCusteio(dto.getAreaCusteio());
            repository.save(new MunicipalityListDTO());
        });
        return new Municipality();
    }
}
