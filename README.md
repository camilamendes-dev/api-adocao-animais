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

Exemplo de JSON:

```json
{
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
