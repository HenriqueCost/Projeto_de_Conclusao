package com.henriquecosta.criacao_de_api.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_municipality")
@SpringBootApplication
@Getter
@Setter
public class Municipality implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String municipio;
    private String nomeProduto;
    private Long mesEmissao;
    private Long anoEmissao;
    private Long cdPrograma;
    private Long cdSubPrograma;
    private Long cdFonteRecurso;
    private Long cdTipoSeguro;
    private Long cdEstado;
    private Double vlCusteio;
    private Long cdProduto;
    private Long codCadMu;
    private Long atividade;
    private Long cdModalidade;
    private Long codIbge;
    private Long areaCusteio;

    public Municipality(){
    }

    public Municipality(Long id, String municipio, String nomeProduto, Long mesEmissao, Long anoEmissao,
                        Long cdPrograma, Long cdSubPrograma, Long cdFonteRecurso, Long cdTipoSeguro,
                        Long cdEstado, Double vlCusteio, Long cdProduto, Long codCadMu, Long atividade,
                        Long cdModalidade, Long codIbge, Long areaCusteio) {
        this.id = id;
        this.municipio = municipio;
        this.nomeProduto = nomeProduto;
        this.mesEmissao = mesEmissao;
        this.anoEmissao = anoEmissao;
        this.cdPrograma = cdPrograma;
        this.cdSubPrograma = cdSubPrograma;
        this.cdFonteRecurso = cdFonteRecurso;
        this.cdTipoSeguro = cdTipoSeguro;
        this.cdEstado = cdEstado;
        this.vlCusteio = vlCusteio;
        this.cdProduto = cdProduto;
        this.codCadMu = codCadMu;
        this.atividade = atividade;
        this.cdModalidade = cdModalidade;
        this.codIbge = codIbge;
        this.areaCusteio = areaCusteio;
    }


    public static void main(String[] args) {

        SpringApplication.run(Municipality.class, args);
    }
}
