package com.henriquecosta.criacao_de_api.integration;

import com.henriquecosta.criacao_de_api.entities.Municipality;
import com.henriquecosta.criacao_de_api.repositories.MunicipalityRepository;
import com.henriquecosta.criacao_de_api.utils.MunicipalityTools;
import com.henriquecosta.criacao_de_api.wrapper.PageableResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class MunicipalityControllerIntegrationTest {

    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;

    @Autowired
    private MunicipalityRepository repository;

    @Test
    @DisplayName("Pagina em Integration retorna lista de dados quando sucesso")
    void encontrarPorPagina_Integration_deve_retornar_listaDeDados_quando_ha_sucesso(){

        Municipality dadoSalvo = repository.save(MunicipalityTools.CriarNovoDadoAtualizado());

        //Caso o "pegarPorPagina" não tenha sucesso o mesmo exige um nome valido
        String nomeProdutoEsperado = dadoSalvo.getNomeProduto();

        PageableResponse<Municipality> dadosLista = template.exchange("/dados/pagina", HttpMethod.GET, null,
                        new ParameterizedTypeReference<PageableResponse<Municipality>>() {})
                .getBody();

        //As Assertions fazem essa exigência
        Assertions.assertThat(dadosLista).isNotNull();
        Assertions.assertThat(dadosLista.toList()).isNotEmpty().hasSize(4);
        Assertions.assertThat(dadosLista.toList().get(0).getNomeProduto()).isEqualTo(nomeProdutoEsperado);
    }

    @Test
    @DisplayName("Id em Integration retorna dados quando sucesso")
    void pegarPorId_Integration_deve_retornar_dados_quando_ha_sucesso(){

        Municipality dadoSalvo = repository.save(MunicipalityTools.criarNovoDadoParaSalvar());

        //Caso o "pegarDadosPorId" não tenha sucesso o mesmo exige um nome valido
        Long idEsperado = dadoSalvo.getId();

        //Exige que o municipality seja retornado
        Municipality municipality = template.getForObject("/dados/{id}", Municipality.class, idEsperado);

        //As Assertions fazem essa exigência
        Assertions.assertThat(municipality).isNotNull();
        Assertions.assertThat(municipality.getId()).isNotNull().isEqualTo(idEsperado);
    }

    @Test
    @DisplayName("criarDados em Integration retorna dados quando sucesso")
    void criarDados_Integration_deve_retornar_dados_quando_ha_sucesso(){
        Municipality dadosCriadosEsperados = repository.save(MunicipalityTools.CriarNovoDadoQueSejaValido());

        //Exige que o dadosCriados seja retornado
        ResponseEntity<Municipality> municipality = template.postForEntity("/dados", dadosCriadosEsperados, Municipality.class);

        //As Assertions fazem essa exigência
        Assertions.assertThat(municipality).isNotNull();
        Assertions.assertThat(municipality.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Assertions.assertThat(municipality.getBody()).isNotNull();
        Assertions.assertThat(municipality.getBody().getId()).isNotNull();
    }

    @Test
    @DisplayName("atualizarDados em Integration atualiza dados quando sucesso")
    void atualizar_Integration_deve_atualiza_dados_quando_ha_sucesso(){
        Municipality dadosAtualizadosEsperados = repository.save(MunicipalityTools.CriarNovoDadoAtualizado());

        //Exige que o dadosCriados seja retornado
        ResponseEntity<Municipality> municipality = template.exchange("/dados",
                HttpMethod.PUT, new HttpEntity<>(dadosAtualizadosEsperados), Municipality.class);

        //As Assertions fazem essa exigência
        Assertions.assertThat(municipality).isNotNull();
        Assertions.assertThat(municipality.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("deletarDados em Controller remove dados quando sucesso")
    void deletar_Controller_deve_deletar_dados_quando_ha_sucesso(){
        Municipality dadosDeletadosEsperados = repository.save(MunicipalityTools.CriarNovoDadoAtualizado());

        //Exige que o dadosCriados seja retornado
        ResponseEntity<Municipality> municipality = template.exchange("/dados/{id}",
                HttpMethod.DELETE, null, Municipality.class, dadosDeletadosEsperados.getId());

        //As Assertions fazem essa exigência
        Assertions.assertThat(municipality).isNotNull();
        Assertions.assertThat(municipality.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}
