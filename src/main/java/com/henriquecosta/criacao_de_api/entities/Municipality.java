package com.henriquecosta.criacao_de_api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_municipality")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Municipality implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
