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

  /*    @Override
    public MunicipalityListDTO pegarId(long id) {
        Optional<MunicipalityListDTO> result = repository.findById(id);
        if(result.isPresent()){
            return result.get();
        }else {
            throw new ResourceNotFoundException("Municipality", "Id", id);
        }
    }

    @Override
    public Municipality criarDado(Long id, Municipality municipality) {
        return repository.save(municipality);
    }

    @Override
    public Municipality atualizarDados(Long id) {
        Municipality municipality = repository.findById(id)
            .orElseThrow(() -> new ConfigDataResourceNotFoundException("Municipality", "id", id));
        municipality.setNomeProduto(municipality.getNomeProduto());
        municipality.setNomeRegiao(municipality.getNomeRegiao());
        municipality.setNomeUF(municipality.getNomeUF());
        municipality.setMesEmissao(municipality.getMesEmissao());
        municipality.setAnoEmissao(municipality.getAnoEmissao());
        municipality.setCdPrograma(municipality.getCdPrograma());
        municipality.setCdSubPrograma(municipality.getCdSubPrograma());
        municipality.setCdFonteRecurso(municipality.getCdFonteRecurso());
        municipality.setCdTipoSeguro(municipality.getCdTipoSeguro());
        municipality.setQtdCusteio(municipality.getQtdCusteio());
        municipality.setVlCusteio(municipality.getVlCusteio());
        municipality.setAtividade(municipality.getAtividade());
        municipality.setCdModalidade(municipality.getCdModalidade());
        municipality.setAreaCusteio(municipality.getAreaCusteio());
        return repository.save(municipality);
    }*/

    /*@Override
    public void deletarDados(Long id) {
        Municipality municipality = repository.findById(id)
                .orElseThrow(() -> new ConfigDataResourceNotFoundException(Municipality, "id", id));
        repository.delete(municipality);
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
