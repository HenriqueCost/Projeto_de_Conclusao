package com.henriquecosta.criacao_de_api.entities;

import org.springframework.boot.SpringApplication;

import javax.persistence.*;

@Entity
@Table(name = "tb_municipality")
public class Municipality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String produto;

    public Municipality(){
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

    public static void main(String[] args) {

        SpringApplication.run(Municipality.class, args);
    }
}
