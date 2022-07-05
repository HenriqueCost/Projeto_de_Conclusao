package com.henriquecosta.criacao_de_api.servicies;

import com.henriquecosta.criacao_de_api.entities.Municipality;
import com.henriquecosta.criacao_de_api.repositories.MunicipalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MunicipalityService{

    @Autowired
    private MunicipalityRepository repository;

    public Municipality pegarTodosDados(Municipality municipality) {
        return repository.save(municipality);
    }

    public Municipality pegarDadosPorId(Long id){
        return repository.findById(id).get();
    }

    public Municipality criarDados(Municipality novoDado){
        return repository.save(novoDado);
    }

    public Municipality atualizarDados(Municipality dadosAtualizados){
        return repository.save(dadosAtualizados);
    }

    public Municipality deletarDados(Long id){
        return null;
    }

}
