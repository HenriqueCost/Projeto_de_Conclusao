package com.henriquecosta.criacao_de_api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_municipality")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Municipality implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
