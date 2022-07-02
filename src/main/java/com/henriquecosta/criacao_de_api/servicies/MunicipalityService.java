package com.henriquecosta.criacao_de_api.servicies;

import com.henriquecosta.criacao_de_api.DTO.MunicipalityListDTO;
import com.henriquecosta.criacao_de_api.Mapper.TransicaoDadosDTOparaServicies;
import com.henriquecosta.criacao_de_api.repositories.MunicipalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipalityService {

    @Autowired
    private MunicipalityRepository municipalityRepository;

    public List<MunicipalityListDTO> pegarTodosOsDados(TransicaoDadosDTOparaServicies transicaoDeDadosDTO){

        return municipalityRepository.findAll();
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
