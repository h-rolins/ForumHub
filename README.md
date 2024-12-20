# ForumHub
Este é um projeto de API RESTful desenvolvido com **Spring Boot** para gerenciar tópicos. Ele permite que os usuários criem, leiam, atualizem e excluam tópicos. Cada tópico contém informações como título, mensagem, autor, curso, status e data de criação.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para desenvolvimento rápido de aplicações Java.
- **Spring Data JPA**: Para persistência dos dados em um banco de dados relacional.
- **PostgreSQL**: Banco de dados utilizado para armazenar os tópicos.
- **Java 17**: Linguagem de programação utilizada para o desenvolvimento do backend.
- **Maven**: Gerenciador de dependências e construção do projeto.

## Configuração do Ambiente

### Pré-requisitos

1. **Java 17**: Certifique-se de ter o JDK 17 instalado no seu sistema.
2. **PostgreSQL**: Você precisa de uma instância do PostgreSQL em funcionamento. 
3. **IDE**: Utilize uma IDE como IntelliJ IDEA, Eclipse ou VSCode para abrir e executar o projeto.

## Endpoints da API

A API possui os seguintes endpoints:

### 1. **Criar Tópico**

- **Método**: `POST`
- **URL**: `/topicos`
- **Corpo da Requisição**:

   ```json
   {
     "titulo": "Título do Tópico",
     "mensagem": "Mensagem do Tópico",
     "status": "Status do Tópico",
     "autor": "Nome do Autor",
     "curso": "Nome do Curso"
   }
   ```

- **Resposta** (201 Created):

   ```json
   {
     "id": 1,
     "titulo": "Título do Tópico",
     "mensagem": "Mensagem do Tópico",
     "status": "Ativo",
     "autor": "Maria Silva",
     "curso": "Ciência da Computação",
     "dataCriacao": "2024-12-20T10:00:00"
   }
   ```

### 2. **Listar Todos os Tópicos**

- **Método**: `GET`
- **URL**: `/topicos`
- **Resposta** (200 OK):

   ```json
   [
     {
       "id": 1,
       "titulo": "Título do Tópico",
       "mensagem": "Mensagem do Tópico",
       "status": "Ativo",
       "autor": "Maria Silva",
       "curso": "Ciência da Computação",
       "dataCriacao": "2024-12-20T10:00:00"
     },
     {
       "id": 2,
       "titulo": "Outro Tópico",
       "mensagem": "Mensagem do Outro Tópico",
       "status": "Inativo",
       "autor": "João Souza",
       "curso": "Matemática",
       "dataCriacao": "2024-12-19T11:30:00"
     }
   ]
   ```

### 3. **Detalhamento de Tópico**

- **Método**: `GET`
- **URL**: `/topicos/{id}`
- **Resposta** (200 OK):

   ```json
   {
     "id": 1,
     "titulo": "Título do Tópico",
     "mensagem": "Mensagem do Tópico",
     "status": "Ativo",
     "autor": "Maria Silva",
     "curso": "Ciência da Computação",
     "dataCriacao": "2024-12-20T10:00:00"
   }
   ```

### 4. **Atualizar Tópico**

- **Método**: `PUT`
- **URL**: `/topicos/{id}`
- **Corpo da Requisição**:

   ```json
   {
     "titulo": "Título Atualizado",
     "mensagem": "Mensagem Atualizada",
     "status": "Ativo",
     "autor": "Carlos Souza",
     "curso": "Engenharia de Software",
     "dataCriacao": "2024-12-20T10:00:00"
   }
   ```

- **Resposta** (200 OK):

   ```json
   {
     "id": 1,
     "titulo": "Título Atualizado",
     "mensagem": "Mensagem Atualizada",
     "status": "Ativo",
     "autor": "Carlos Souza",
     "curso": "Engenharia de Software",
     "dataCriacao": "2024-12-20T10:00:00"
   }
   ```

### 5. **Excluir Tópico**

- **Método**: `DELETE`
- **URL**: `/topicos/{id}`
- **Resposta** (200 OK):
   - Caso o tópico seja excluído com sucesso, o servidor retornará um status 200 OK sem corpo.

## Testando a API com Postman

1. **Criar Tópico**: Envie uma requisição `POST` para `http://localhost:8080/topicos` com o corpo da requisição em formato JSON.
2. **Listar Tópicos**: Envie uma requisição `GET` para `http://localhost:8080/topicos`.
3. **Detalhamento de Tópico**: Envie uma requisição `GET` para `http://localhost:8080/topicos/{id}`.
4. **Atualizar Tópico**: Envie uma requisição `PUT` para `http://localhost:8080/topicos/{id}` com o corpo atualizado.
5. **Excluir Tópico**: Envie uma requisição `DELETE` para `http://localhost:8080/topicos/{id}`.

