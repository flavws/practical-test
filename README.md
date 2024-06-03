# Spring Boot Customer Management API 🌐

Este projeto é uma API de gestão de clientes desenvolvida com Spring Boot. A API permite operações CRUD (Criar, Ler, Atualizar, Deletar) sobre entidades de clientes, além de oferecer suporte para manipulação de múltiplos endereços para cada cliente. Este projeto inclui tratamento de exceções, validações de entrada de dados e documentação de API com Swagger.

## Funcionalidades 🚀

- **Criação, leitura, atualização e exclusão de clientes.** 🆕
- **Adição e gerenciamento de múltiplos endereços para cada cliente.** 🏠
- **Validação de dados de entrada.** ✔️
- **Paginação na listagem de clientes.** 📄
- **Tratamento de exceções global.** 🛡️
- **Documentação automática da API com Swagger.** 📚
- **Persistência de dados com o banco de dados em memória H2.** 💾

## Tecnologias Utilizadas 🛠️

- **Spring Boot** - Framework para desenvolvimento de aplicações Spring.
- **Spring Data JPA** - Para persistência de dados e ORM.
- **H2 Database** - Banco de dados SQL em memória.
- **Springfox Swagger 2** - Para documentação da API.

## Configuração e Instalação 📦

### Pré-requisitos

- JDK 1.8 ou superior.
- Maven 3.3+ ou Gradle 4+.

### Passos para Execução

1. **Clone o repositório**

   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio

2. **Compile e execute a aplicação usando Maven**
   
   ```bash
   mvn clean install
   mvn spring-boot:run
Ou usando Gradle:

  ```bash
  ./gradlew build
  ./gradlew bootRun
```

3. **Acesse a aplicação 🌐**
A API estará disponível em `http://localhost:8080`.

4. **Acesse a documentação da Swagger UI 📄**
A documentação da API pode ser acessada em `http://localhost:8080/swagger-ui.html`.

## Endpoints da API 📡

A API de gestão de clientes oferece vários endpoints para operações CRUD em clientes e seus endereços. Abaixo estão os detalhes de cada endpoint disponível:

### Clientes

- **POST /api/customers**
  - **Descrição**: Cria um novo cliente.
  - **Corpo da Requisição**:
    ```json
    {
      "name": "Nome do Cliente",
      "email": "email@cliente.com"
    }
    ```
  - **Resposta de Sucesso**: Retorna o cliente criado com status 200 OK.

- **GET /api/customers/{id}**
  - **Descrição**: Obtém detalhes de um cliente específico.
  - **Parâmetros**:
    - `id`: ID do cliente.
  - **Resposta de Sucesso**: Retorna os detalhes do cliente com status 200 OK.

- **PUT /api/customers/{id}**
  - **Descrição**: Atualiza um cliente existente.
  - **Parâmetros**:
    - `id`: ID do cliente.
  - **Corpo da Requisição**:
    ```json
    {
      "name": "Nome Atualizado",
      "email": "email@atualizado.com"
    }
    ```
  - **Resposta de Sucesso**: Retorna o cliente atualizado com status 200 OK.

- **DELETE /api/customers/{id}**
  - **Descrição**: Exclui um cliente.
  - **Parâmetros**:
    - `id`: ID do cliente.
  - **Resposta de Sucesso**: Retorna status 204 No Content.

- **GET /api/customers**
  - **Descrição**: Lista todos os clientes com suporte à paginação.
  - **Parâmetros de Query**:
    - `page`: Número da página (opcional, padrão é 0).
    - `size`: Tamanho da página (opcional, padrão é 10).
  - **Resposta de Sucesso**: Retorna uma lista paginada de clientes com status 200 OK.

### Endereços

- **POST /api/customers/{customerId}/addresses**
  - **Descrição**: Adiciona um endereço a um cliente existente.
  - **Parâmetros**:
    - `customerId`: ID do cliente.
  - **Corpo da Requisição**:
    ```json
    {
      "street": "Rua dos Bobos",
      "city": "Cidade Exemplo"
    }
    ```
  - **Resposta de Sucesso**: Retorna o endereço criado com status 200 OK.

- **GET /api/customers/{customerId}/addresses**
  - **Descrição**: Lista todos os endereços de um cliente específico.
  - **Parâmetros**:
    - `customerId`: ID do cliente.
  - **Resposta de Sucesso**: Retorna uma lista de endereços com status 200 OK.

## Tratamento de Exceções 🚨

A API inclui tratamento global de exceções para capturar e responder adequadamente a erros comuns, como recursos não encontrados e violações de restrição. Erros são retornados com mensagens claras e códigos de status apropriados para facilitar a depuração e o uso da API.
