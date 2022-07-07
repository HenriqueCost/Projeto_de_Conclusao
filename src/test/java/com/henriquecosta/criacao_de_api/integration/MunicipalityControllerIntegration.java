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
import org.springframework.http.HttpMethod;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class MunicipalityControllerIntegration {

    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;

    @Autowired
    private MunicipalityRepository repository;

    @Test
    @DisplayName("Pagina em Integration retorna lista de dados quando sucesso")
    void encontrarPorPagina_Integration_deve_retornar_listaDeDados_quando_ha_sucesso(){

        Municipality dadoSalvo = repository.save(MunicipalityTools.criarNovoDadoParaSalvar());
        //Caso o "pegarPorPagina" não tenha sucesso o mesmo exige um nome valido
        String nomeProdutoEsperado = dadoSalvo.getNomeProduto();
        PageableResponse<Municipality> dadosLista = template.exchange("/pagina", HttpMethod.GET, null,
                new ParameterizedTypeReference<PageableResponse<Municipality>>() {}).getBody();
        //As Assertions fazem essa exigência
        Assertions.assertThat(dadosLista).isNotNull();
        Assertions.assertThat(dadosLista.toList()).isNotEmpty().hasSize(1);
        Assertions.assertThat(dadosLista.toList().get(0).getNomeProduto()).isEqualTo(nomeProdutoEsperado);
    }
}
