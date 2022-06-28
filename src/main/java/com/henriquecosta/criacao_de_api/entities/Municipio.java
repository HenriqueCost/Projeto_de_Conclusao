package com.henriquecosta.criacao_de_api.entities;

public class Municipio {

    private Long id;
    private String name;
    private String produto;

    public Municipio(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}
