package com.henriquecosta.criacao_de_api.entities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_municipality")
@SpringBootApplication
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Long getMesEmissao() {
        return mesEmissao;
    }

    public void setMesEmissao(Long mesEmissao) {
        this.mesEmissao = mesEmissao;
    }

    public Long getAnoEmissao() {
        return anoEmissao;
    }

    public void setAnoEmissao(Long anoEmissao) {
        this.anoEmissao = anoEmissao;
    }

    public Long getCdPrograma() {
        return cdPrograma;
    }

    public void setCdPrograma(Long cdPrograma) {
        this.cdPrograma = cdPrograma;
    }

    public Long getCdSubPrograma() {
        return cdSubPrograma;
    }

    public void setCdSubPrograma(Long cdSubPrograma) {
        this.cdSubPrograma = cdSubPrograma;
    }

    public Long getCdFonteRecurso() {
        return cdFonteRecurso;
    }

    public void setCdFonteRecurso(Long cdFonteRecurso) {
        this.cdFonteRecurso = cdFonteRecurso;
    }

    public Long getCdTipoSeguro() {
        return cdTipoSeguro;
    }

    public void setCdTipoSeguro(Long cdTipoSeguro) {
        this.cdTipoSeguro = cdTipoSeguro;
    }

    public Long getCdEstado() {
        return cdEstado;
    }

    public void setCdEstado(Long cdEstado) {
        this.cdEstado = cdEstado;
    }

    public Double getVlCusteio() {
        return vlCusteio;
    }

    public void setVlCusteio(Double vlCusteio) {
        this.vlCusteio = vlCusteio;
    }

    public Long getCdProduto() {
        return cdProduto;
    }

    public void setCdProduto(Long cdProduto) {
        this.cdProduto = cdProduto;
    }

    public Long getCodCadMu() {
        return codCadMu;
    }

    public void setCodCadMu(Long codCadMu) {
        this.codCadMu = codCadMu;
    }

    public Long getAtividade() {
        return atividade;
    }

    public void setAtividade(Long atividade) {
        this.atividade = atividade;
    }

    public Long getCdModalidade() {
        return cdModalidade;
    }

    public void setCdModalidade(Long cdModalidade) {
        this.cdModalidade = cdModalidade;
    }

    public Long getCodIbge() {
        return codIbge;
    }

    public void setCodIbge(Long codIbge) {
        this.codIbge = codIbge;
    }

    public Long getAreaCusteio() {
        return areaCusteio;
    }

    public void setAreaCusteio(Long areaCusteio) {
        this.areaCusteio = areaCusteio;
    }

    public static void main(String[] args) {

        SpringApplication.run(Municipality.class, args);
    }
}
