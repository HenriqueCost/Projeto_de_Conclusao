package com.henriquecosta.criacao_de_api.entities;

public class Produto {

    private Integer anoEmissao;
    private Integer mesEmissao;
    
    private Municipio municipio;

    public Produto(){
    }

    public Integer getAnoEmissao() {
        return anoEmissao;
    }

    public void setAnoEmissao(Integer anoEmissao) {
        this.anoEmissao = anoEmissao;
    }

    public Integer getMesEmissao() {
        return mesEmissao;
    }

    public void setMesEmissao(Integer mesEmissao) {
        this.mesEmissao = mesEmissao;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
