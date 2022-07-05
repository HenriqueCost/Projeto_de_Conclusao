package com.henriquecosta.criacao_de_api.entities;


import com.henriquecosta.criacao_de_api.DTO.MunicipalityDTO;
import com.henriquecosta.criacao_de_api.DTO.MunicipalityListDTO;
import com.henriquecosta.criacao_de_api.repositories.MunicipalityRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class Conversor {

    @Autowired
    private static MunicipalityRepository repository;

    @Autowired
    private static MunicipalityListDTO listDTO;

    public static Municipality getList(MunicipalityDTO dto){

        return Municipality.builder()

                .nomeProduto(dto.getNomeProduto())
                .nomeRegiao(dto.getNomeRegiao())
                .nomeUF(dto.getNomeUF())
                .mesEmissao(dto.getMesEmissao())
                .anoEmissao(dto.getAnoEmissao())
                .cdPrograma(dto.getCdPrograma())
                .cdSubPrograma(dto.getCdSubPrograma())
                .cdFonteRecurso(dto.getCdFonteRecurso())
                .cdTipoSeguro(dto.getCdTipoSeguro())
                .qtdCusteio(dto.getQtdCusteio())
                .vlCusteio(dto.getVlCusteio())
                .atividade(dto.getAtividade())
                .cdModalidade(dto.getCdModalidade())
                .areaCusteio(dto.getAreaCusteio())

        .build();
    }
}
