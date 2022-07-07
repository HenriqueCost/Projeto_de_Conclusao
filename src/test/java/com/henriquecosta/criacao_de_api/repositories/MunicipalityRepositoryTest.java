package com.henriquecosta.criacao_de_api.repositories;

import com.henriquecosta.criacao_de_api.entities.Municipality;
import com.henriquecosta.criacao_de_api.utils.MunicipalityTools;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class MunicipalityRepositoryTest {

    @Autowired
    private MunicipalityRepository repository;

    @Test
    @DisplayName("Novos dados sao adicionados quando ha sucesso")
    void salvar_dado_Municipality_quando_sucesso(){
        //Criando um novoDdado
        Municipality dadoASerSalvo = MunicipalityTools.criarNovoDadoParaSalvar();

        Municipality dadoSalvo = this.repository.save(dadoASerSalvo);

        //Verificando se o dado enviado ao banco de dados não é nulo
        Assertions.assertThat(dadoSalvo).isNotNull();

        //Verificando se o Id do dado enviado não é nula
        Assertions.assertThat(dadoSalvo.getId()).isNotNull();

        //Verificando se o dado salvo é o mesmo que foi pedido para ser salvo
        Assertions.assertThat(dadoSalvo.getNomeProduto()).isEqualTo(dadoASerSalvo.getNomeProduto());
    }

    @Test
    @DisplayName("Atualizar dado quando ha sucesso")
    void salvar_dado_atualizado_quando_sucesso(){
        //Criando mesmo dado do teste de adicionar dados
        Municipality dadoASerSalvo = MunicipalityTools.criarNovoDadoParaSalvar();

        Municipality dadoSalvo = this.repository.save(dadoASerSalvo);

        //Adicionando novo dado
        dadoSalvo.setNomeProduto("SAIS MINERAIS");

        //E salvando o dado em "dadoSalvo"
        Municipality dadoAtualizado = this.repository.save(dadoSalvo);

        //Verificando se o dadoAtualizado não é nulo
        Assertions.assertThat(dadoAtualizado).isNotNull();

        //Verificando se o Id do dadoAtualizado não é nula
        Assertions.assertThat(dadoAtualizado.getId()).isNotNull();

        //Verificando se o dadoAtualizado é agora igual ao dadoSalvo
        Assertions.assertThat(dadoAtualizado.getNomeProduto()).isEqualTo(dadoSalvo.getNomeProduto());
    }

    @Test
    @DisplayName("Deletar dado quando ha sucesso")
    void deletar_dado_atualizado_quando_sucesso(){
        //Criando mesmo dado do teste de adicionar dados
        Municipality dadoASerSalvo = MunicipalityTools.criarNovoDadoParaSalvar();

        Municipality dadoSalvo = this.repository.save(dadoASerSalvo);

        //Deletando o dadoSalvo do banco de dados
        this.repository.delete(dadoSalvo);

        //Deletando dado po Id e armazenando em "dadoDeletado"
        Optional<Municipality> dadoDeletado = this.repository.findById(dadoSalvo.getId());

        //Verificando se o dado foi deletado
        Assertions.assertThat(dadoDeletado).isEmpty();
    }

    @Test
    @DisplayName("Pegar dado por id e retornar lista de dados quando ha sucesso")
    void Pegar_dado_por_id_quando_sucesso(){
        //Criando mesmo dado do teste de adicionar dados
        Municipality dadoASerSalvo = MunicipalityTools.criarNovoDadoParaSalvar();

        Municipality dadoSalvo = this.repository.save(dadoASerSalvo);

        //Pegando um dado por Id
        Long id = dadoSalvo.getId();

        //Retornando uma lista de dados
        Optional<Municipality> dadoPorId = this.repository.findById(id);

        //Verificando se a lista não esta vazia
        Assertions.assertThat(dadoPorId).isNotEmpty();

        //Verificando se a lista contém o dadoSalvo
        Assertions.assertThat(dadoPorId).contains(dadoSalvo);
    }

    //Verificando caso onde Id não existe
    @Test
    @DisplayName("Pegar dado por id e retornar lista vazia quando nao encontrar dado")
    void Retornar_dado_vazio_quando_dado_nao_encontrado(){
        //Pegando um Id não existente
        Optional<Municipality> dadoPorId= this.repository.findById(1L);

        //Verificando se o Id esta vazio
        Assertions.assertThat(dadoPorId).isEmpty();
    }

}