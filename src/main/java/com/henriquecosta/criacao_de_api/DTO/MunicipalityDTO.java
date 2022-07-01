package com.henriquecosta.criacao_de_api.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MunicipalityDTO {

    private String nomeProduto;
    private String nomeRegiao;
    private String nomeUF;
    private Long mesEmissao;
    private Long anoEmissao;
    private Long cdPrograma;
    private Long cdSubPrograma;
    private Long cdFonteRecurso;
    private Long cdTipoSeguro;
    private Long cdEstado;
    private Double QtdCusteio;
    private Double vlCusteio;
    private Long Atividade;
    private Long cdModalidade;
    private Double AreaCusteio;
}
