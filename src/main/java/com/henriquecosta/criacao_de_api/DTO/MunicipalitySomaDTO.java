package com.henriquecosta.criacao_de_api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.henriquecosta.criacao_de_api.entities.Municipality;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MunicipalitySomaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    public String nomeProduto;
    public String nomeUF;
    @JsonProperty("MesEmissao")
    public String mesEmissao;
    @JsonProperty("AnoEmissao")
    public String anoEmissao;
    public Double vlCusteio;

    public MunicipalitySomaDTO(Municipality municipality){
        id = municipality.getId();
        nomeProduto = municipality.getNomeProduto();
        nomeUF = municipality.getNomeUF();
        mesEmissao = municipality.getMesEmissao();
        anoEmissao = municipality.getAnoEmissao();
        vlCusteio = municipality.getVlCusteio();
    }

}
