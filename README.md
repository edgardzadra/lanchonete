# lanchonete
desafio

Para executar a aplicação deixar a pasta Front junto com a pasta da API.
Pre-requisito:

ter o maven instalado
Java 8

Acessar a pasta da API e executar o comando mvn clean install e depois mvn spring-boot:run.
O banco de dados H2 pode ser acessado pela URL http://localhost:8080/h2-console

A API está em http://localhost:8080

driver: org.h2.Driver
jdbc url: jdbc:h2:mem:testdb
User name: sa

Para executar o front-end acessar a pasta Front, executar npm i e depois ng serve.

A Aplicação se encontra em http://localhost:4200.


Foi implementado o Docker tanto no front quanto na API, juntamente com o docker-compose.

Para executa-los basta executar o comando na pasta da API

docker build -t api .

e docker build -t front . na pasta do Front.

e para subir os container executar o comando docker-compose up

