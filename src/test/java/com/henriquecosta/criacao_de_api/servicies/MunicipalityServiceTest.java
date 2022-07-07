package com.henriquecosta.criacao_de_api.servicies;

import com.henriquecosta.criacao_de_api.entities.Municipality;
import com.henriquecosta.criacao_de_api.repositories.MunicipalityRepository;
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
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class MunicipalityServiceTest {
    @InjectMocks
    private MunicipalityService service;

    @Mock
    private MunicipalityRepository repositoryMock;

    @BeforeEach
    void preparacaoParaTestes(){
        //Retornar uma lista valida de dados que fica armazenada na variável "dadosLista"
        PageImpl<Municipality> dadosLista = new PageImpl<>(List.of(MunicipalityTools.CriarNovoDadoQueSejaValido()));
        //Não importa o argumento utilizado, ao chamar a classe repository, a mesma retorna "dadosLista"
        BDDMockito.when(repositoryMock.findAll(ArgumentMatchers.any(PageRequest.class)))
                .thenReturn(dadosLista);

        //Teste referente ao pegarPorId da classe MunicipalityService
        BDDMockito.when(repositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(MunicipalityTools.CriarNovoDadoQueSejaValido()));

        //Teste referente ao PostMapping da classe MunicipalityService
        BDDMockito.when(repositoryMock.save(ArgumentMatchers.any()))
                .thenReturn(MunicipalityTools.CriarNovoDadoQueSejaValido());

        //Teste referente ao PutMapping da classe MunicipalityService
        //BDDMockito.when(repositoryMock.save(ArgumentMatchers.any()))
          //      .thenReturn(MunicipalityTools.CriarNovoDadoAtualizado());

        //Teste referente ao DeleteMapping da classe MunicipalityService
        BDDMockito.doNothing().when(repositoryMock).deleteById(ArgumentMatchers.anyLong());
    }

    @Test
    @DisplayName("Pagina em Service retorna lista de dados quando sucesso")
    void encontrarPorPagina_Service_deve_retornar_listaDeDados_quando_ha_sucesso(){
        //Caso o "pegarPorPagina" não tenha sucesso o mesmo exige um nome valido
        String nomeProdutoEsperado = MunicipalityTools.CriarNovoDadoQueSejaValido().getNomeProduto();
        //Exige que o dadosLista seja retornado
        Page<Municipality> dadosLista = service.encontrarPorPagina(PageRequest.of(1,1));
        //As Assertions fazem essa exigência
        Assertions.assertThat(dadosLista).isNotNull();
        Assertions.assertThat(dadosLista.toList()).isNotEmpty().hasSize(1);
        Assertions.assertThat(dadosLista.toList().get(0).getNomeProduto()).isEqualTo(nomeProdutoEsperado);
    }

    @Test
    @DisplayName("Id em Service retorna dados quando sucesso")
    void pegarPorId_Service_deve_retornar_dados_quando_ha_sucesso(){
        //Caso o "pegarDadosPorId" não tenha sucesso o mesmo exige um nome valido
        Long idEsperado = MunicipalityTools.CriarNovoDadoQueSejaValido().getId();
        //Exige que o municipality seja retornado
        Municipality municipality = service.pegarDadosPorId(idEsperado);
        //As Assertions fazem essa exigência
        Assertions.assertThat(municipality).isNotNull();
        Assertions.assertThat(municipality.getId()).isNotNull().isEqualTo(idEsperado);
    }

    @Test
    @DisplayName("criarDados em Service retorna dados quando sucesso")
    void criarDados_Service_deve_retornar_dados_quando_ha_sucesso(){
        //Exige que o dadosCriados seja retornado
        Municipality dadosCriados = service.criarDados(MunicipalityTools.CriarNovoDadoQueSejaValido());
        //As Assertions fazem essa exigência
        Assertions.assertThat(dadosCriados).isNotNull().isEqualTo(MunicipalityTools.CriarNovoDadoQueSejaValido());
    }

    @Test
    @DisplayName("atualizarDados em Service atualiza dados quando sucesso")
    void atualizar_Service_deve_atualiza_dados_quando_ha_sucesso(){
        //Exige que o dadosAtualizados seja retornado
        Municipality dadosAtualizados = service.atualizarDados(MunicipalityTools.CriarNovoDadoQueSejaValido());

        //As Assertions fazem essa exigência
        Assertions.assertThat(dadosAtualizados).isNotNull().isEqualTo(MunicipalityTools.CriarNovoDadoQueSejaValido());
    }

    @Test
    @DisplayName("deletarDados em Service remove dados quando sucesso")
    void deletar_Service_deve_deletar_dados_quando_ha_sucesso(){
        //Como deletarDados é void, só foi possível realizar uma Assertions
        Assertions.assertThatCode(() -> service.deletarDados(1L))
                .doesNotThrowAnyException();
    }
}