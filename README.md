<<<<<<< HEAD
# 🐾 API de Adoção de Animais

API REST desenvolvida em **Java** com **Spring Boot** para gerenciamento de animais disponíveis para adoção.

O projeto foi desenvolvido como atividade acadêmica da disciplina de Backend da **UNIPAR**, com o objetivo de praticar a criação de APIs REST, métodos HTTP, rotas, JSON, `@PathVariable`, `@RequestParam`, `@RequestBody` e `ResponseEntity`.

## 🚀 Tecnologias utilizadas

* Java
* Spring Boot
* Spring Web
* Maven
* IntelliJ IDEA
* Postman

## 📋 Funcionalidades

A API permite:

* Cadastrar animais
* Consultar todos os animais
* Consultar um animal pelo ID
* Atualizar um animal
* Excluir um animal
* Filtrar animais por espécie
* Filtrar animais por porte
* Filtrar animais por situação de adoção
* Combinar os filtros

Os dados são armazenados **em memória**, utilizando uma lista, sem conexão com banco de dados.

## 🗂️ Estrutura do projeto

```text
src
└── main
    └── java
        └── br.unipar.backend.apiadocaoanimais
            ├── ApiAdocaoAnimaisApplication.java
            │
            ├── controller
            │   └── AnimalController.java
            │
            └── model
                └── Animal.java
```

## 🐶 Modelo Animal

Cada animal possui os seguintes dados:

| Campo     | Tipo    | Descrição                         |
| --------- | ------- | --------------------------------- |
| `id`      | Long    | Identificador do animal           |
| `nome`    | String  | Nome do animal                    |
| `especie` | String  | Espécie do animal                 |
| `idade`   | Integer | Idade do animal                   |
| `porte`   | String  | Porte do animal                   |
| `adotado` | Boolean | Indica se o animal já foi adotado |

## 🔗 Endpoints

A API utiliza a rota base:

```text
http://localhost:8080/animais
```

### GET — Listar todos os animais

```http
GET /animais
```

Retorna todos os animais cadastrados.

### GET — Buscar animal por ID

```http
GET /animais/{id}
```

Exemplo:

```http
GET /animais/1
```

### POST — Cadastrar animal

```http
POST /animais
```
=======
# API Adoção de Animais - Spring Data JPA + PostgreSQL

API REST desenvolvida em Java e Spring Boot para cadastro de animais para adoção.

## Tecnologias

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven

## Banco de dados

Crie o banco:

```sql
CREATE DATABASE adocao_animais;
```

Depois configure a senha do PostgreSQL em `src/main/resources/application.properties`.

## Rotas

### Listar

`GET /animais`

### Buscar por ID

`GET /animais/{id}`

### Cadastrar

`POST /animais`
>>>>>>> main

Exemplo de JSON:

```json
{
<<<<<<< HEAD
    "nome": "Bento",
    "especie": "Cachorro",
    "idade": 2,
    "porte": "Pequeno",
    "adotado": false
}
```

O ID é gerado automaticamente pela aplicação.

### PUT — Atualizar animal

```http
PUT /animais/{id}
```

Exemplo:

```http
PUT /animais/1
```

JSON:

```json
{
    "nome": "Bento",
    "especie": "Cachorro",
    "idade": 3,
    "porte": "Pequeno",
    "adotado": true
}
```

### DELETE — Excluir animal

```http
DELETE /animais/{id}
```

Exemplo:

```http
DELETE /animais/1
```

## 🔎 Filtros

A API possui três filtros utilizando `@RequestParam`.

### Filtrar por espécie

```http
GET /animais/filtro?especie=Cachorro
```

### Filtrar por porte

```http
GET /animais/filtro?porte=Pequeno
```

### Filtrar por situação de adoção

```http
GET /animais/filtro?adotado=false
```

### Combinar filtros

Os filtros podem ser utilizados juntos:

```http
GET /animais/filtro?especie=Cachorro&porte=Pequeno&adotado=false
```

Nesse caso, serão retornados apenas os animais que atendem a todos os filtros informados.

## ▶️ Como executar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/camilamendes-dev/api-adocao-animais.git
```

### 2. Abrir o projeto

Abra o projeto na IDE de sua preferência, como o **IntelliJ IDEA**.

### 3. Executar a aplicação

Execute a classe:

```text
ApiAdocaoAnimaisApplication.java
```

A aplicação será iniciada em:

```text
http://localhost:8080
```

### 4. Testar a API

Os endpoints podem ser testados utilizando o **Postman**.

## 📚 Objetivos acadêmicos

Este projeto foi desenvolvido para praticar os principais conceitos de desenvolvimento de uma API REST com Spring Boot:

* Criação de rotas
* Métodos HTTP
* Requisições e respostas HTTP
* JSON
* `@GetMapping`
* `@PostMapping`
* `@PutMapping`
* `@DeleteMapping`
* `@PathVariable`
* `@RequestParam`
* `@RequestBody`
* `ResponseEntity`
* Organização em camadas `model` e `controller`

---

Desenvolvido por **Camila Mendes** & **Gabriel Santos Inácio**
UNIPAR — Engenharia de Software
=======
  "nome": "Bento",
  "especie": "Cachorro",
  "idade": 2,
  "porte": "Medio",
  "adotado": false
}
```

O `id` não deve ser informado. Ele é gerado pelo banco.

### Atualizar

`PUT /animais/{id}`

### Excluir

`DELETE /animais/{id}`

### Filtros

`GET /animais/filtro?especie=Cachorro`

`GET /animais/filtro?porte=Medio`

`GET /animais/filtro?adotado=false`

Os filtros podem ser combinados:

`GET /animais/filtro?especie=Cachorro&porte=Medio&adotado=false`

## Consulta SQL para demonstrar persistência

```sql
SELECT * FROM animais;
```

Depois de cadastrar um animal pelo Postman, reinicie a aplicação e execute novamente a consulta ou `GET /animais`. O registro continuará no PostgreSQL.
>>>>>>> main
