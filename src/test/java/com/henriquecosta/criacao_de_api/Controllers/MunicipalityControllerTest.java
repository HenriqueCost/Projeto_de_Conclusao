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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
class MunicipalityControllerTest {

    @InjectMocks
    private MunicipalityController controller;

    @Mock
    private MunicipalityService serviceMock;

    @BeforeEach
    void preparacaoParaTestes(){
        //Retornar uma lista valida de dados que fica armazenada na variável "dadosLista"
        PageImpl<Municipality> dadosLista = new PageImpl<>(List.of(MunicipalityTools.CriarNovoDadoQueSejaValido()));

        //Não importa o argumento utilizado, ao chamar a classe service, a mesma retorna "dadosLista"
        BDDMockito.when(serviceMock.encontrarPorPagina(ArgumentMatchers.any()))
                .thenReturn(dadosLista);

        //Teste referente ao pegarPorId da classe MunicipalityController
        BDDMockito.when(serviceMock.pegarDadosPorId(ArgumentMatchers.anyLong()))
                .thenReturn(MunicipalityTools.CriarNovoDadoQueSejaValido());

        //Teste referente ao PostMapping da classe MunicipalityController
        BDDMockito.when(serviceMock.criarDados(ArgumentMatchers.any()))
                .thenReturn(MunicipalityTools.CriarNovoDadoQueSejaValido());

        //Teste referente ao PutMapping da classe MunicipalityController
        BDDMockito.when(serviceMock.atualizarDados(ArgumentMatchers.any()))
                .thenReturn(MunicipalityTools.CriarNovoDadoAtualizado());

        //Teste referente ao DeleteMapping da classe MunicipalityController
        BDDMockito.doNothing().when(serviceMock).deletarDados(ArgumentMatchers.anyLong());
    }

    @Test
    @DisplayName("Pagina em Controller retorna lista de dados quando sucesso")
    void encontrarPorPagina_Controller_deve_retornar_listaDeDados_quando_ha_sucesso(){
        //Caso o "pegarPorPagina" não tenha sucesso o mesmo exige um nome valido
        String nomeProdutoEsperado = MunicipalityTools.CriarNovoDadoQueSejaValido().getNomeProduto();

        //Exige que o dadosLista seja retornado
        Page<Municipality> dadosLista = controller.pegarPorPagina(null).getBody();

        //As Assertions fazem essa exigência
        Assertions.assertThat(dadosLista).isNotNull();
        Assertions.assertThat(dadosLista.toList()).isNotEmpty().hasSize(1);
        Assertions.assertThat(dadosLista.toList().get(0).getNomeProduto()).isEqualTo(nomeProdutoEsperado);
    }

    @Test
    @DisplayName("Id em Controller retorna dados quando sucesso")
    void pegarPorId_Controller_deve_retornar_dados_quando_ha_sucesso(){
        //Caso o "pegarDadosPorId" não tenha sucesso o mesmo exige um nome valido
        Long idEsperado = MunicipalityTools.CriarNovoDadoQueSejaValido().getId();

        //Exige que o municipality seja retornado
         Municipality municipality = controller.pegarDadosPorId(idEsperado);

        //As Assertions fazem essa exigência
        Assertions.assertThat(municipality).isNotNull();
        Assertions.assertThat(municipality.getId()).isNotNull().isEqualTo(idEsperado);
    }

    @Test
    @DisplayName("criarDados em Controller retorna dados quando sucesso")
    void criarDados_Controller_deve_retornar_dados_quando_ha_sucesso(){
        //Exige que o dadosCriados seja retornado
       Municipality dadosCriados = controller.criarDados();

        //As Assertions fazem essa exigência
        Assertions.assertThat(dadosCriados).isNotNull().isEqualTo(MunicipalityTools.CriarNovoDadoQueSejaValido());
    }

    @Test
    @DisplayName("atualizarDados em Controller atualiza dados quando sucesso")
    void atualizar_Controller_deve_atualiza_dados_quando_ha_sucesso(){
        //Exige que o dadosAtualizados seja retornado
        Municipality dadosAtualizados = controller.atualizarDados();

        //As Assertions fazem essa exigência
        Assertions.assertThat(dadosAtualizados).isNotNull().isEqualTo(MunicipalityTools.CriarNovoDadoAtualizado());
    }

    @Test
    @DisplayName("deletarDados em Controller remove dados quando sucesso")
    void deletar_Controller_deve_deletar_dados_quando_ha_sucesso(){

        Assertions.assertThatCode(() -> controller.deletarDados(1L))
                .doesNotThrowAnyException();

        //Exige que o deletarDados seja retornado
        ResponseEntity<Void> dadosDeletados = controller.deletarDados(1L);

        //As Assertions fazem essa exigência
        Assertions.assertThat(dadosDeletados).isNotNull();
        Assertions.assertThat(dadosDeletados.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}