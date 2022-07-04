package com.henriquecosta.criacao_de_api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
//Dados armazenados da API externa
public class MunicipalityDTO{
    public String nomeProduto;
    public String nomeRegiao;
    public String nomeUF;
    @JsonProperty("MesEmissao")
    public String mesEmissao;
    @JsonProperty("AnoEmissao")
    public String anoEmissao;
    public String cdPrograma;
    public String cdSubPrograma;
    public String cdFonteRecurso;
    public String cdTipoSeguro;
    @JsonProperty("QtdCusteio")
    public int qtdCusteio;
    @JsonProperty("VlCusteio")
    public int vlCusteio;
    @JsonProperty("Atividade")
    public String atividade;
    public String cdModalidade;
    @JsonProperty("AreaCusteio")
    public Double areaCusteio;
}