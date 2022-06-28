package com.henriquecosta.criacao_de_api.entities;

import org.springframework.boot.SpringApplication;

import javax.persistence.*;

@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Integer anoEmissao;
    private Integer mesEmissao;

    @ManyToOne
    @JoinColumn(name = "municipality_id")
    private Municipality municipality;

    public Product(){
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public Municipality getMunicipio() {
        return municipality;
    }

    public void setMunicipio(Municipality municipality) {
        this.municipality = municipality;
    }

    public static void main(String[] args) {

        SpringApplication.run(Product.class, args);
    }
}
