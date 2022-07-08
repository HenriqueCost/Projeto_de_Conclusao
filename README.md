# Projeto de Conclusão

  Projeto de uma API sobre uma Matriz de Dados do Crédito Rural.
  
## Tabela de Conteúdos

<!--ts-->
  * [Informações do Projeto](#Informações-do-projeto)
  * [Técnologias Utilizadas](#Técnologias-utilizadas)
  * [Modo de Funcionamento](#Modo-de-funcionamento)
  * [Preview do Código](#Preview-do-codigo)
  * [Configurações do Projeto](#Configurações-do-projeto)
  * [Documentação](#Documentacao)
  * [Autor](#Autor)
<!--te-->

## Informações do Projeto

  O Projeto de conclusão se trata de um projeto back-end, sobre a criação de uma API, que realiza um processo de onboarding de dados, consumindo
uma API externa e obtendo seus dados, que ficam guardados em um banco de dados.

  Essa API externa possui uma lista de dados armazenados sobre sobre contratos de comercialização por Produto, Região e UF e foram retirados da
seguinte link: 

[Dados Extraídos da API Externa](https://olinda.bcb.gov.br/olinda/servico/SICOR/versao/v2/odata/CusteioRegiaoUFProduto?%24format=json&%24top=1000 "Dados Extraídos")

  O banco de dados utilizado para o onboarding dos dados foi o H2: 

![Banco H2](https://user-images.githubusercontent.com/105726010/177912388-1292080b-1bb8-4c84-a8f0-80f20c3e43ed.png "Banco de Dados H2")

  Esse banco pode ser acessado na seguinte porta: "localhost8080/h2-console"

  Obs.: vale destacar que a porta "localhost8080" só vai funcionar se a aplicação estiver rodando.

## Técnologias Utilizadas

- Java JDK 11 ++
- Spring Boot
- Banco de Dados H2
- Git
- Lombok
- Swagger
- Jpa
- Postman - 9.19.0.0
- Intellij IDE - 2022.1.3 Windows

## Modo de Funcionamento

  Após a finalização da parte de codificação, para que esse mesmo código pudesse funcionar, foi necessário a utilização da plataforma Postman para fazer
uma requisição GET, utilizando a seguinte url: "localhost:8080/dados":

![Postman](https://user-images.githubusercontent.com/105726010/177987319-40055b42-ab96-459c-b4b3-8f0d56885fb8.png "Requisição GET no Postman")

  Após isso, o banco de dados H2 começara a ser povoado com os dados contidos url fornecida no código e que estão sendo extraídos da API externa:

![Banco H2 com dados](https://user-images.githubusercontent.com/105726010/177989073-854c9fe9-f280-42fb-b026-22fbd43aa552.png "Banco H2 povoado com dados")

  Obs.: Também é possível buscar dados por Id usando a url: "localhost:8080/dados/id escolhida" e a requisição GET, salvar novos dados com uma requisição
POST usando a url: "localhost:8080/dados", modificar dados através de uma requisição PUT com a mesma url do POST e por fim, também é possível deletar
dados através de Id da requisição DELETE, com a mesma url utilizada para buscar dados por Id.

## Preview do Código

  O código em questão utiliza a linguagem de programação Java, na IDE IntelliJ, e possui 14 pacotes (sendo 9 pertencendo ao pacote principal e 5 ao pacote
de testes) com algumas classes dentro, cada uma executando uma função diferente:

![Pacotes](https://user-images.githubusercontent.com/105726010/177992865-bf455466-7fb5-4b21-bdb9-b61b1ee413f1.png "Pacotes do Projeto")


#### Preview da classe principal do projeto: "Municipality":

```Java
package com.henriquecosta.criacao_de_api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_municipality")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Municipality implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String nomeProduto;
    public String nomeRegiao;
    public String nomeUF;
    @JsonProperty("MesEmissao")
    public String mesEmissao;
    @JsonProperty("AnoEmissao")
    public String anoEmissao;
    public String cdPrograma;
    public String cdSubPrograma;
    public String cdFonteRecurso;
    public String cdTipoSeguro;
    @JsonProperty("QtdCusteio")
    public Double qtdCusteio;
    @JsonProperty("VlCusteio")
    public Double vlCusteio;
    @JsonProperty("Atividade")
    public String atividade;
    public String cdModalidade;
    @JsonProperty("AreaCusteio")
    public Double areaCusteio;

}
```

## Documentação

A documentação foi feita utilizando da ferramenta Swagger e cobre as funcionalidades da API, como funcionam os métodos, os parâmetos utilizandos por eles e o que 
eles retornam em suas reuisições (GET, POST, PUT e DELETE):

![Documentação](https://user-images.githubusercontent.com/105726010/178049434-105b4b28-57fd-4160-bc23-c490ecbaa1e2.png "Documentação da API")

## Configurações do Projeto

Pré requisito: Java 17

```java
# Link do GitHub: 
"https://github.com/HenriqueCost/Projeto_de_Conclusao"

# Porta de acesso: 
"http://localhost:8080"

## Documentação em Swagger
"http://localhost:8080/swagger-ui/index.html"

# Sistema de funcionamento
"Windows"
```

## Autor

Henrique Manuel dos Santos Costa

https://www.linkedin.com/in/henrique-costa-99b7b7217
