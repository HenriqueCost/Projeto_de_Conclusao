package com.henriquecosta.criacao_de_api.utils;

import com.henriquecosta.criacao_de_api.entities.Municipality;

//Objetos que serão utilizados nos testes
public class MunicipalityTools {

    public static Municipality criarNovoDadoParaSalvar(){
        return Municipality.builder().nomeProduto("SOJA").build();
    }

    public static Municipality CriarNovoDadoQueSejaValido(){
        return Municipality.builder().nomeProduto("SOJA").id(1L).build();
    }

    public static Municipality CriarNovoDadoAtualizado(){
        return Municipality.builder().nomeProduto("SOJA 2").id(1L).build();
    }

}
