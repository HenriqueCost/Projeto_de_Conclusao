package com.henriquecosta.criacao_de_api.servicies;

import com.henriquecosta.criacao_de_api.entities.Municipality;
import com.henriquecosta.criacao_de_api.repositories.MunicipalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipalityService{

    @Autowired
    private MunicipalityRepository repository;

    public Municipality pegarTodosDados(Municipality municipality) {
        return repository.save(municipality);
    }

}
