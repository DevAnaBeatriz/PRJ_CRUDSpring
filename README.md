# Projeto CRUD com Spring Boot + JWT + H2

Este é um projeto de API RESTful desenvolvido em **Java com Spring Boot**. Ele permite **cadastro, autenticação com JWT e operações CRUD** (Create, Read, Update, Delete) de usuários, utilizando banco de dados em memória H2.

---

### Tecnologias utilizadas

- Java 21
- Spring Boot 3.5.3
- Spring Security com JWT
- Spring Data JPA
- H2 Database (memória)
- Maven

---

### Estrutura de pastas

```
src/
├── main/
│   ├── java/
│   │   └── com/example/prj_crud/
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── entity/
│   │       ├── repository/
│   │       ├── security/
│   │       ├── service/
│   │       └── PrjCrudApplication.java
│   └── resources/
│       ├── application.properties
│       └── static/
```

---

### Como executar o projeto

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/DevAnaBeatriz/PRJ_CRUDSpring.git
   cd PRJ_CRUDSpring
   ```

2. **Abra no Visual Studio Code ou IntelliJ.**

3. **Execute a aplicação:**

   ```bash
   ./mvnw spring-boot:run
   ```

   A aplicação será iniciada na porta:  
    `http://localhost:8080`

---

### Autenticação com JWT

Antes de acessar as rotas protegidas, você deve:

1. **Cadastrar um novo usuário:**

   ```json
   POST /auth/register
   {
     "name": "Ana",
     "email": "ana@email.com",
     "phone": "11999999999",
     "username": "anauser",
     "password": "123456"
   }
   ```

2. **Fazer login e obter o token JWT:**

   ```json
   POST /auth/login
   {
     "username": "anauser",
     "password": "123456"
   }
   ```

3. **Usar o token nas requisições protegidas:**

   ```http
   Authorization: Bearer SEU_TOKEN_JWT_GERADO_NO_LOGIN
   ```

---

### Endpoints disponíveis

#### Rotas públicas

- `POST /auth/register` – Cria novo usuário
- `POST /auth/login` – Retorna token JWT

#### Rotas protegidas (usar token JWT)

- `GET /users` – Lista todos os usuários
- `GET /users/{id}` – Busca usuário por ID
- `PUT /users/{id}` – Atualiza usuário
- `DELETE /users/{id}` – Deleta usuário

---

### H2 Console

Acesse o console do banco H2 para ver os dados:

 `http://localhost:8080/h2-console`

- **JDBC URL:** `jdbc:h2:mem:testdb`  
- **User:** `sa`  
- **Password:** *(deixe em branco)*

---

### Desenvolvido por

Ana Beatriz Martins Batista  
Estudante de ADS @ FATEC ZL  
Estagiária de Software na IBM 💙

---

###  Dica

Quer testar via Postman? Não esqueça de enviar o token JWT no header:

```
Authorization: Bearer seu_token
```
