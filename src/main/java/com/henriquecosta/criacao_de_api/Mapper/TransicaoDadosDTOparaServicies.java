package com.henriquecosta.criacao_de_api.Mapper;

import com.henriquecosta.criacao_de_api.DTO.MunicipalityDTO;
import com.henriquecosta.criacao_de_api.entities.Municipality;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TransicaoDadosDTOparaServicies {

    @Autowired
    private ModelMapper modelMapper;

    //Convertendo os dados da API de JSON para Java e passando-os para a classe Municipality
    @Autowired
    private Municipality convertendoDados(MunicipalityDTO municipalityDTO){
        return modelMapper.map(municipalityDTO, Municipality.class);
    }




}
