# Projeto de Conclusão

Projeto de uma API sobre uma Matriz de Dados do Crédito Rural.

## Informações do Projeto

Link do GitHub: "https://github.com/HenriqueCost/Projeto_de_Conclusao"

O Projeto de conclusâo se trata de um projeto back-end, sobre a criação de uma API, que realiza um processo de onboarding de dados, consumindo
uma API externa e obtendo seus dados, que ficam guardados em um banco de dados.

Essa API externa possui uma lista de dados armazenados sobre sobre contratos de comercialização por Produto, Região e UF e foram retirados da
seguinte link: 

[Dados Extraídos da API Externa](https://olinda.bcb.gov.br/olinda/servico/SICOR/versao/v2/odata/CusteioRegiaoUFProduto?%24format=json&%24top=1000 "Dados Extraídos")

O banco de dados utilizado para o onboarding dos dados foi o H2: 

![Banco H2](https://user-images.githubusercontent.com/105726010/177912388-1292080b-1bb8-4c84-a8f0-80f20c3e43ed.png "Banco de Dados H2")

Esse banco pode ser acessado na seguinte porta: "localhost8080/h2-console"

Obs.: vale destacar que a porta "localhost8080" só vai funcionar se a aplicação estiver rodando.

## Técnologias utilizadas

- Java JDK 11 ++
- Spring Boot
- Banco de Dados H2
- Git
- Lombok
- Jpa
- Postman
