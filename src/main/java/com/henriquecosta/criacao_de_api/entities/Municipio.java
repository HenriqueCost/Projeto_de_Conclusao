package com.henriquecosta.criacao_de_api.entities;

public class Municipio {

    private Long id;
    private String name;

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
}
