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
    private String name;
    //@Autowired
    private Long anoEmissao;
    //@Autowired
    private Long mesEmissao;

    //@ManyToOne
    //@JoinColumn(name = "municipality_id")
    //private Municipality municipality;

    public Product(){
    }

    public Product(Long id, String name, Long anoEmissao, Long mesEmissao){
        this.Id = id;
        this.name = name;
        this.anoEmissao = anoEmissao;
        this.mesEmissao = mesEmissao;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAnoEmissao() {
        return anoEmissao;
    }

    public void setAnoEmissao(Long anoEmissao) {
        this.anoEmissao = anoEmissao;
    }

    public Long getMesEmissao() {
        return mesEmissao;
    }

    public void setMesEmissao(Long mesEmissao) {
        this.mesEmissao = mesEmissao;
    }

    //public Municipality getMunicipio() {
      //  return municipality;
    //}

    //public void setMunicipio(Municipality municipality) {
      //  this.municipality = municipality;
    //}

    public static void main(String[] args) {

        SpringApplication.run(Product.class, args);
    }
}
