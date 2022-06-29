package com.henriquecosta.criacao_de_api.servicies;

import com.henriquecosta.criacao_de_api.entities.Municipality;
import com.henriquecosta.criacao_de_api.repositories.MunicipalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MunicipalityService {

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

  /*  public void removerPorId(Long Id){
        municipalityRepository.deleteById();
    }*/

}
