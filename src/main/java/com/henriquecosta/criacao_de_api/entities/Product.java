package com.henriquecosta.criacao_de_api.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_product")
@SpringBootApplication
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Autowired
    private Long Id;
    //@Autowired
    private Integer anoEmissao;
    //@Autowired
    private Integer mesEmissao;

    @ManyToOne
    @JoinColumn(name = "municipality_id")
    private Municipality municipality;

    public Product(){
    }

    public Product(Long id, Integer anoEmissao, Integer mesEmissao){
        this.Id = id;
        this.anoEmissao = anoEmissao;
        this.mesEmissao = mesEmissao;
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
