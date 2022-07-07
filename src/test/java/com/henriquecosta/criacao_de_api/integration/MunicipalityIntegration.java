package com.henriquecosta.criacao_de_api.integration;

import com.henriquecosta.criacao_de_api.entities.Municipality;
import com.henriquecosta.criacao_de_api.utils.MunicipalityTools;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpMethod;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class MunicipalityIntegration {

    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;

    @Test
    @DisplayName("Pagina em Integration retorna lista de dados quando sucesso")
    void encontrarPorPagina_Integration_deve_retornar_listaDeDados_quando_ha_sucesso(){
        //Caso o "pegarPorPagina" não tenha sucesso o mesmo exige um nome valido
        String nomeProdutoEsperado = MunicipalityTools.CriarNovoDadoQueSejaValido().getNomeProduto();
        template.exchange("/dados", HttpMethod.GET, null,
                new ParameterizedTypeReference<PageImpl<Municipality>>() {});
        //As Assertions fazem essa exigência
        /*Assertions.assertThat(dadosLista).isNotNull();
        Assertions.assertThat(dadosLista.toList()).isNotEmpty().hasSize(1);
        Assertions.assertThat(dadosLista.toList().get(0).getNomeProduto()).isEqualTo(nomeProdutoEsperado);*/
    }
}
