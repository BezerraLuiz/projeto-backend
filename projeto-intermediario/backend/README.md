# Router Airplane API

Este projeto é uma API para gerenciamento de viagens, permitindo que os usuários criem, visualizem e gerenciem suas informações de viagem, além de interagir com serviços de geolocalização.

## Sumário

- [Execução do Projeto](#execução-do-projeto)
- [Rotas da API](#rotas-da-api)
  - [Visualizar Local](#visualizar-local)
  - [Criar Viagem](#criar-viagem)
  - [Verificar Usuário](#verificar-usuário)
  - [Criar Usuário](#criar-usuário)
  - [Atualizar Usuário](#atualizar-usuário)
- [Exemplos de Requisições e Respostas](#exemplos-de-requisições-e-respostas)

## Execução do Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/BezerraLuiz/projeto-backend
   cd projeto-backend
2. Execute o projeto através do arquivo RouterairplaneApplication.java
3. A API estará disponível em `http://localhost:8080`

## Rotas da API

### Visualizar Local

-   **Endpoint**: `GET /api/places/view`
-   **Parâmetros**: `local` (query string)
-   **Descrição**: Obtém a localização geográfica de um lugar específico.
-   **Exemplo**: `GET /api/places/view?local=garopaba`

### Criar Viagem

-   **Endpoint**: `POST /api/travel/create`
-   **Body**: `{
  "idUser": 7,
  "localViagem": "Paris",
  "localHospedagem": "Hotel Plaza",
  "dataInicio": "2024-12-01",
  "dataFim": "2024-12-15",
  "valorPassagem": 1200.50,
  "valorHospedagem": 1800.75,
  "valorConsumo": 500.30,
  "valorTotal": 3501.55
}
`
-   **Descrição**: Cria uma nova viagem para o usuário.
-   **Exemplo**: `GET /api/places/view?local=garopaba`

### Verificar Usuário

-   **Endpoint**: `POST /api/user/verify`
-   **Body**: `{
	"email": "teste@mail.com",
	"senha": "123"
}`
-   **Descrição**: Login do usuário.

### Criar Usuário

-   **Endpoint**: `POST /api/user/create`
-   **Body**: `{
	"nome": "luiz",
	"email": "luiz@mail.com",
	"senha": "senha"
}`
-   **Descrição**: Criar usuário.

### Atualizar Usuário

-   **Endpoint**: `PUT /api/user/update`
-   **Body**: `{
	"nome": "Administrador",
	"email": "bytezest.bz@gmail.com",
	"senha": "admin@1234"
}`
-   **Descrição**: Atualizar informações do usuário.