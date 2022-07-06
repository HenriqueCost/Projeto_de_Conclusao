package com.henriquecosta.criacao_de_api.repositories;

import com.henriquecosta.criacao_de_api.entities.Municipality;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class MunicipalityRepositoryTest {

    @Autowired
    private MunicipalityRepository repository;

    @Test
    @DisplayName("Novos dados sao adicionados quando ha sucesso")
    void salvar_dado_Municipality_quando_sucesso(){
        Municipality dadoASerSalvo = novoDadoTest();
        Municipality dadoSalvo = this.repository.save(dadoASerSalvo);
        //Verificando se o dado enviado ao banco de dados não é nulo
        Assertions.assertThat(dadoSalvo).isNotNull();
        //Verificando se o id do dado enviado não é nulo
        Assertions.assertThat(dadoSalvo.getId()).isNotNull();
        //Verificando se o dado salvo é o mesmo que foi pedido para ser salvo
        Assertions.assertThat(dadoSalvo.getNomeProduto()).isEqualTo(dadoASerSalvo.getNomeProduto());
    }

    //Retornando novo dado "SOJA" para o Municipality
    private Municipality novoDadoTest(){
        return Municipality.builder().nomeProduto("SOJA").build();
    }
}