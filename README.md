[![Build Status](https://app.travis-ci.com/rafaelsulimann/projeto-spring-postgresql-docker.svg?branch=main)](https://app.travis-ci.com/rafaelsulimann/projeto-spring-postgresql-docker)
# API RESTFULL COM BANCO POSTGRESQL, IMPLEMENTAÇÃO DE DOCKER, DOCKER COMPOSE E CI/CD USANDO TRAVIS CI

## INTRODUÇÃO

Este projeto é uma API de venda onde realizo o **BACKEND** para todo o funcionamento da mesma realizando o **CRUD** completo com implementação do **HATEOAS**.

Foi feito o **DEPLOY** da API na nuvem do **HEROKU** para que possa ser acessado online.

Foi implementado o **DOCKER** com **Dockerfile** e **Docker Compose**, para criação da imagem da aplicação e armazenamento no Docker Hub, Docker Compose para subir os dois containers (API + Banco) e que eles possam interagir entre si.

Para finalizar, foi realizado o **CI/CD** utilizando o **TRAVIS CI** para a automação do versionamento da **IMAGEM**.

## COMO ACESSAR A API?

A API pode ser acessada através dos **ENDPOINTS** disponíveis através da URL do **HEROKU**.

A URL da API é:

- [https://spring-postgresql-restfull.herokuapp.com/](https://spring-postgresql-restfull.herokuapp.com/)

Porém só será possível acessar a API através dos ENDPOINTS, e para isso será necessário a utilização do aplicativo **POSTMAN** onde você pode fazer as **REQUISIÇÕES** da API:

- GET (acessar as entidades)
- POST (inserir entidades)
- PUT (atualizar entidades)
- DELETE (deletar entidades)

# ENDPOINTS DISPONÍVEIS

## 1) CATEGORY

### GET

- **FIND ALL** (filtrar todos)
    - [https://spring-postgresql-restfull.herokuapp.com/](https://spring-postgresql-restfull.herokuapp.com/)categories
- **FIND BY ID** (filtrar por ID)
    - [https://spring-postgresql-restfull.herokuapp.com/](https://spring-postgresql-restfull.herokuapp.com/)categories/1

### POST

- Aqui será um pouco diferente, pois neste caso não estamos apenas buscando e sim incluindo uma entidade, então precisaremos inserir as informações que desejamos que ela tenha, e neste caso a **CATEGORY** tem apenas o **NOME**, então abaixo segue um exemplo de como deveríamos fazer para incluir uma entidade no Postman.

![Untitled](https://user-images.githubusercontent.com/97992737/157959034-8b308f7b-a5b5-4115-bccc-70f10505ca27.png)

### PUT

- Aqui da mesma forma que fizemos no **POST** nós iremos realizar no **PUT**, a diferença é que neste caso não estamos inserindo nenhum nova entidade e sim alterando um entidade ja existente, por isso é necessário que a entidade ja exista para que funcione o **PUT**. Então também neste caso devemos filtrar por **ID** e alterar as informações necessárias. Abaixo segue exemplo:

![Untitled2](https://user-images.githubusercontent.com/97992737/157959961-b25a8d9a-8cb5-4fae-90fa-5d74589c6ab1.png)

### DELETE

- Aqui também se faz necessário que a entidade exista pois caso contrário não será possível deletar. Basta inserirmos a entidade com o **ID** com a requisição **DELETE** para deletar.

![Untitled3](https://user-images.githubusercontent.com/97992737/157960117-cd6d5463-c970-4d96-a499-8ce8d3e1e183.png)

## 2) USER

### GET

- **FIND ALL** (filtrar todos)
    - [https://spring-postgresql-restfull.herokuapp.com/](https://spring-postgresql-restfull.herokuapp.com/)users
- **FIND BY ID** (filtrar por ID)
    - [https://spring-postgresql-restfull.herokuapp.com/](https://spring-postgresql-restfull.herokuapp.com/)users/1

### POST, PUT, DELETE

- Fazer da mesma forma que o **CATEGORY**.

## 3) PRODUCT

### GET

- **FIND ALL** (filtrar todos)
    - [https://spring-postgresql-restfull.herokuapp.com/](https://spring-postgresql-restfull.herokuapp.com/)products
- **FIND BY ID** (filtrar por ID)
    - [https://spring-postgresql-restfull.herokuapp.com/](https://spring-postgresql-restfull.herokuapp.com/)products/1

### POST, PUT, DELETE

- Fazer da mesma forma que o **CATEGORY**.

## 4) ORDER

- **FIND ALL** (filtrar todos)
    - [https://spring-postgresql-restfull.herokuapp.com/](https://spring-postgresql-restfull.herokuapp.com/)orders
- **FIND BY ID** (filtrar por ID)
    - [https://spring-postgresql-restfull.herokuapp.com/](https://spring-postgresql-restfull.herokuapp.com/)orders/1

### POST, PUT, DELETE

- Fazer da mesma forma que o **CATEGORY**.

# DOCKERFILE, DOCKER COMPOSE E TRAVIS CI

## 1) DOCKERFILE

- Utilizamos o **DOCKERFILE** para gerar a **IMAGEM** da nossa aplicação, e para fazer isso, podemos utilizar o **TERMINAL DE COMANDOS** ou se for o caso e voce estiver utilizando o **VSCODE**, podemos utilizar por ali também. Eu particularmente gosto de utilizar o **WSL** no terminal do VSCode para fazer o **BUILD** da imagem.
- Para fazer isso basta então abrirmos o projeto com o VSCODE e entrar na pasta **APP** pois é onde se encontra o **DOKCERFILE**. Para fazer isto basta inserir o comando abaixo:

```java
cd app
```

- Agora ja na pasta onde se encontra o **DOCKERFILE** vamos então fazer o **BUILD** da imagem da nossa API inserindo comando abaixo:

```java
docker build -t <nome da imagem>:1.0
```

## 2) DOCKER COMPOSE

- Vamos agora voltar para a pasta onde se encontra o arquivo **docker-compose.yml**, inserindo o seguinte comando:

```java
cd ..
```

- Após digitar no terminal o seguinte comando para subir os **2 containers**(API + banco) e se comunicarem entre si:

```java
docker-compose up
```

## 3) CI/CD COM TRAVIS CI

- Para configurar o **TRAVIS CI** nós criamos o arquivo **.travis.yml** onde sempre que nós realizar um **COMMIT** no nosso **GITHUB** será feito um novo **BUILD** da imagem com uma **NOVA VERSÃO** e será realizar o **PUSH** desta nova versão da imagem la para o nosso **DOCKER HUB**.
