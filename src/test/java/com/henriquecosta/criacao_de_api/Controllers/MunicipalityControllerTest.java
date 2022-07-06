package com.henriquecosta.criacao_de_api.Controllers;

import com.henriquecosta.criacao_de_api.entities.Municipality;
import com.henriquecosta.criacao_de_api.servicies.MunicipalityService;
import com.henriquecosta.criacao_de_api.utils.MunicipalityTools;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@SpringBootTest
class MunicipalityControllerTest {

    @InjectMocks
    private MunicipalityController controller;

    @Mock
    private MunicipalityService serviceMock;

    @BeforeEach
    void preparacaoParaTestes(){
        PageImpl<Municipality> dadosLista = new PageImpl<>(List.of(MunicipalityTools.CriarNovoDadoQueSejaValido()));
        BDDMockito.when(serviceMock.pegarTodosDados(ArgumentMatchers.any()))
                .thenReturn(dadosLista);
    }

    @Test
    @DisplayName("Pagina retorna lista de dados quando sucesso")
    void encontrarPorPagina_deve_retornar_listaDeDados_quando_ha_sucesso(){
        String nomeProdutoEsperado = MunicipalityTools.CriarNovoDadoQueSejaValido().getNomeProduto();
        Page<Municipality> dadosLista = controller.pegarPorPagina(null).getBody();
        Assertions.assertThat(dadosLista).isNotNull();
        Assertions.assertThat(dadosLista.toList()).isNotEmpty().hasSize(1);
        Assertions.assertThat(dadosLista.toList().get(0).getNomeProduto()).isEqualTo(nomeProdutoEsperado);

    }
}