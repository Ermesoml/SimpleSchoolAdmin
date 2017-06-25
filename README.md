Projeto de CS 2016/1
========

NOME DO PROJETO: Sistema Administrador Escolar

#### Como rodar?

Instale o postgresSQL na sua máquina, crie uma database chamada ssa e utilize o usuário postres/postgres

Este projeto utiliza maven, para facilitar o deploy deixei previamente configurado o plugin CARGO2, que baixa o tomcat necessário e já
inicia o servidor, apenas execute o comando:

    mvn clean verify cargo:run

Ou você pode simplesmente rodar na sua IDE preferida utilizando o Plugin do Tomcat

O usuário padrão da aplicação é admin/admin

#### Tecnologias Configuradas

* [JSF 2.2]
* [Hibernate 5]
* [Spring MVC 4.2.0]
* [Spring Security 4.0.2]
* [AspectJ 1.8.6]
* [slf4j 1.17.12]
* [logback 1.1.3]
* [HikariCP 2.4.1]
* [Postgresql Connector]
