# AlugaKi API

API REST desenvolvida em Spring Boot para gerenciamento de aluguel de produtos. Projeto desenvolvido em arquitetura limpa para a faculdade de ADS Fase 4.

## 📋 Índice

- [Tecnologias](#tecnologias)
- [Pré-requisitos](#pré-requisitos)
- [Configuração](#configuração)
- [Executando o Projeto](#executando-o-projeto)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [API Endpoints](#api-endpoints)
  - [Usuario](#usuario)
  - [Produto](#produto)
  - [Periodo](#periodo)
- [Exemplos de Requisições](#exemplos-de-requisições)

## 🛠 Tecnologias

- **Java 17**
- **Spring Boot 3.5.6**
- **Spring Data JPA**
- **MySQL**
- **Maven**

## 📦 Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- MySQL 8.0+
- IDE (IntelliJ IDEA, Eclipse, VS Code)

## ⚙️ Configuração

### 1. Banco de Dados

Crie um banco de dados MySQL chamado `alugaki`:

```sql
CREATE DATABASE alugaki;
```

### 2. Configuração da Aplicação

Edite o arquivo `src/main/resources/application.properties` com suas configurações:

```properties
# Configurações do banco de dados MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/alugaki?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

### 3. DDL Auto

A aplicação está configurada com `spring.jpa.hibernate.ddl-auto=update`, que cria/atualiza automaticamente as tabelas no banco de dados.

## 🚀 Executando o Projeto

### Via Maven

```bash
mvn spring-boot:run
```

### Via IDE

Execute a classe `AlugaKiApiApplication.java`

### Compilar

```bash
mvn clean compile
```

### Gerar JAR

```bash
mvn clean package
```

A aplicação estará disponível em: `http://localhost:8080`

## 📁 Estrutura do Projeto

```
src/main/java/com/AlugaKi/
├── controller/          # Camada de apresentação (REST Controllers)
├── domain/             # Camada de domínio (Entidades de negócio)
│   └── entity/
├── application/        # Camada de aplicação (Use Cases e Gateways)
│   ├── gateway/
│   └── usecases/
└── infrastructure/     # Camada de infraestrutura (Persistência)
    ├── gateway/
    └── persistence/
```

## 🔌 API Endpoints

Base URL: `http://localhost:8080`

---

## 👤 Usuario

### POST /usuario
Cria um novo usuário.

**Headers:**
```
Content-Type: application/json
```

**Request Body:**
```json
{
  "idUsuario": 0,
  "nome": "João Silva",
  "email": "joao@email.com",
  "cpfCnpj": "12345678900",
  "contato": "47999999999",
  "senha": "senha123",
  "cep": "89000000",
  "endereco": "Rua Exemplo, 123",
  "numeroResidenc": "123",
  "foto": "https://exemplo.com/foto.jpg"
}
```

**Campos Obrigatórios:**
- `nome` (String, máx. 100 caracteres)
- `email` (String, máx. 100 caracteres)
- `cpfCnpj` (String, máx. 15 caracteres, único)
- `contato` (String, máx. 11 caracteres)
- `senha` (String, máx. 45 caracteres)
- `cep` (String, máx. 10 caracteres)
- `endereco` (String, máx. 100 caracteres)
- `numeroResidenc` (String, máx. 6 caracteres)
- `foto` (String, LONGTEXT)

**Campos Opcionais:**
- `idUsuario` (int) - Use `0` para criar novo usuário (gerado automaticamente)

**Response 200 OK:**
```json
{
  "idUsuario": 1,
  "nome": "João Silva",
  "email": "joao@email.com",
  "cpfCnpj": "12345678900",
  "contato": "47999999999",
  "cep": "89000000",
  "endereco": "Rua Exemplo, 123",
  "numeroResidenc": "123",
  "foto": "https://exemplo.com/foto.jpg"
}
```

**Exemplo cURL:**
```bash
curl -X POST http://localhost:8080/usuario \
  -H "Content-Type: application/json" \
  -d '{
    "idUsuario": 0,
    "nome": "João Silva",
    "email": "joao@email.com",
    "cpfCnpj": "12345678900",
    "contato": "47999999999",
    "senha": "senha123",
    "cep": "89000000",
    "endereco": "Rua Exemplo, 123",
    "numeroResidenc": "123",
    "foto": "https://exemplo.com/foto.jpg"
  }'
```

---

### GET /usuario/{id}
Busca um usuário pelo ID.

**Path Parameters:**
- `id` (int) - ID do usuário

**Response 200 OK:**
```json
{
  "idUsuario": 1,
  "nome": "João Silva",
  "email": "joao@email.com",
  "cpfCnpj": "12345678900",
  "contato": "47999999999",
  "cep": "89000000",
  "endereco": "Rua Exemplo, 123",
  "numeroResidenc": "123",
  "foto": "https://exemplo.com/foto.jpg"
}
```

**Exemplo cURL:**
```bash
curl -X GET http://localhost:8080/usuario/1
```

---

### GET /usuario
Lista todos os usuários.

**Response 200 OK:**
```json
[
  {
    "idUsuario": 1,
    "nome": "João Silva",
    "email": "joao@email.com",
    "cpfCnpj": "12345678900",
    "contato": "47999999999",
    "cep": "89000000",
    "endereco": "Rua Exemplo, 123",
    "numeroResidenc": "123",
    "foto": "https://exemplo.com/foto.jpg"
  },
  {
    "idUsuario": 2,
    "nome": "Maria Santos",
    "email": "maria@email.com",
    "cpfCnpj": "98765432100",
    "contato": "47988888888",
    "cep": "89010000",
    "endereco": "Avenida Principal, 456",
    "numeroResidenc": "456",
    "foto": "https://exemplo.com/foto2.jpg"
  }
]
```

**Exemplo cURL:**
```bash
curl -X GET http://localhost:8080/usuario
```

---

## 📦 Produto

### POST /produto
Cria um novo produto.

**Headers:**
```
Content-Type: application/json
```

**Request Body:**
```json
{
  "idProduto": 0,
  "nome": "Bicicleta Mountain Bike",
  "descricao": "Bicicleta mountain bike usada, em bom estado, ideal para trilhas e passeios",
  "foto": "https://exemplo.com/bicicleta.jpg",
  "preco": 150.00,
  "categoriaIdCategoria": 1,
  "condicaoIdCondicao": 1,
  "periodoIdPeriodo": 1,
  "usuarioIdUsuario": 1
}
```

**Campos Obrigatórios:**
- `nome` (String, máx. 100 caracteres)
- `foto` (String, LONGTEXT) - URL da imagem ou base64
- `preco` (BigDecimal) - Formato: `150.00` ou `2500.50`
- `categoriaIdCategoria` (int) - ID da categoria
- `condicaoIdCondicao` (int) - ID da condição
- `periodoIdPeriodo` (int) - ID do período
- `usuarioIdUsuario` (int) - ID do usuário dono do produto

**Campos Opcionais:**
- `idProduto` (int) - Use `0` para criar novo produto (gerado automaticamente)
- `descricao` (String, TEXT) - Pode ser `null`

**Response 200 OK:**
```json
{
  "idProduto": 1,
  "nome": "Bicicleta Mountain Bike",
  "descricao": "Bicicleta mountain bike usada, em bom estado, ideal para trilhas e passeios",
  "foto": "https://exemplo.com/bicicleta.jpg",
  "preco": 150.00,
  "categoriaIdCategoria": 1,
  "condicaoIdCondicao": 1,
  "periodoIdPeriodo": 1,
  "usuarioIdUsuario": 1
}
```

**Exemplo cURL:**
```bash
curl -X POST http://localhost:8080/produto \
  -H "Content-Type: application/json" \
  -d '{
    "idProduto": 0,
    "nome": "Bicicleta Mountain Bike",
    "descricao": "Bicicleta mountain bike usada, em bom estado",
    "foto": "https://exemplo.com/bicicleta.jpg",
    "preco": 150.00,
    "categoriaIdCategoria": 1,
    "condicaoIdCondicao": 1,
    "periodoIdPeriodo": 1,
    "usuarioIdUsuario": 1
  }'
```

**Observação:** O campo `usuarioIdUsuario` é obrigatório e vincula o produto ao usuário. Um usuário pode ter vários produtos.

---

### GET /produto/{id}
Busca um produto pelo ID.

**Path Parameters:**
- `id` (int) - ID do produto

**Response 200 OK:**
```json
{
  "idProduto": 1,
  "nome": "Bicicleta Mountain Bike",
  "descricao": "Bicicleta mountain bike usada, em bom estado, ideal para trilhas e passeios",
  "foto": "https://exemplo.com/bicicleta.jpg",
  "preco": 150.00,
  "categoriaIdCategoria": 1,
  "condicaoIdCondicao": 1,
  "periodoIdPeriodo": 1,
  "usuarioIdUsuario": 1
}
```

**Exemplo cURL:**
```bash
curl -X GET http://localhost:8080/produto/1
```

---

### GET /produto
Lista todos os produtos.

**Response 200 OK:**
```json
[
  {
    "idProduto": 1,
    "nome": "Bicicleta Mountain Bike",
    "descricao": "Bicicleta mountain bike usada",
    "foto": "https://exemplo.com/bicicleta.jpg",
    "preco": 150.00,
    "categoriaIdCategoria": 1,
    "condicaoIdCondicao": 1,
    "periodoIdPeriodo": 1,
    "usuarioIdUsuario": 1
  },
  {
    "idProduto": 2,
    "nome": "Notebook Dell",
    "descricao": "Notebook usado, funcionando perfeitamente",
    "foto": "https://exemplo.com/notebook.jpg",
    "preco": 2500.50,
    "categoriaIdCategoria": 2,
    "condicaoIdCondicao": 2,
    "periodoIdPeriodo": 2,
    "usuarioIdUsuario": 1
  }
]
```

**Exemplo cURL:**
```bash
curl -X GET http://localhost:8080/produto
```

---

## 📅 Periodo

### GET /periodo/{id}
Busca um período pelo ID.

**Path Parameters:**
- `id` (int) - ID do período

**Response 200 OK:**
```json
{
  "idPeriodo": 1,
  "descricao": "Diária"
}
```

**Exemplo cURL:**
```bash
curl -X GET http://localhost:8080/periodo/1
```

---

### GET /periodo
Lista todos os períodos.

**Response 200 OK:**
```json
[
  {
    "idPeriodo": 1,
    "descricao": "Diária"
  },
  {
    "idPeriodo": 2,
    "descricao": "Semanal"
  },
  {
    "idPeriodo": 3,
    "descricao": "Mensal"
  }
]
```

**Exemplo cURL:**
```bash
curl -X GET http://localhost:8080/periodo
```

---

## 📊 Resumo dos Endpoints

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/usuario` | Criar usuário |
| GET | `/usuario/{id}` | Buscar usuário por ID |
| GET | `/usuario` | Listar todos os usuários |
| POST | `/produto` | Criar produto |
| GET | `/produto/{id}` | Buscar produto por ID |
| GET | `/produto` | Listar todos os produtos |
| GET | `/periodo/{id}` | Buscar período por ID |
| GET | `/periodo` | Listar todos os períodos |

**Total: 8 endpoints**

---

## 🗄️ Estrutura do Banco de Dados

### Tabelas Principais

- **usuario**: Armazena informações dos usuários
- **produto**: Armazena informações dos produtos (vinculado ao usuário)
- **categoria**: Categorias de produtos
- **condicao**: Condições dos produtos (Novo, Usado, etc.)
- **periodo**: Períodos de aluguel (Diária, Semanal, Mensal)

### Relacionamentos

- **Usuario (1) ──< (N) Produto**: Um usuário pode ter vários produtos
- **Produto (N) ──> (1) Categoria**: Um produto pertence a uma categoria
- **Produto (N) ──> (1) Condicao**: Um produto tem uma condição
- **Produto (N) ──> (1) Periodo**: Um produto tem um período de aluguel

---

## 📝 Exemplos de Requisições

### Exemplo 1: Criar Usuário

```bash
curl -X POST http://localhost:8080/usuario \
  -H "Content-Type: application/json" \
  -d '{
    "idUsuario": 0,
    "nome": "João Silva",
    "email": "joao@email.com",
    "cpfCnpj": "12345678900",
    "contato": "47999999999",
    "senha": "senha123",
    "cep": "89000000",
    "endereco": "Rua Exemplo, 123",
    "numeroResidenc": "123",
    "foto": "https://exemplo.com/foto.jpg"
  }'
```

### Exemplo 2: Criar Produto

```bash
curl -X POST http://localhost:8080/produto \
  -H "Content-Type: application/json" \
  -d '{
    "idProduto": 0,
    "nome": "Notebook Dell Inspiron",
    "descricao": "Notebook usado, funcionando perfeitamente",
    "foto": "https://exemplo.com/notebook.jpg",
    "preco": 2500.50,
    "categoriaIdCategoria": 1,
    "condicaoIdCondicao": 1,
    "periodoIdPeriodo": 1,
    "usuarioIdUsuario": 1
  }'
```

### Exemplo 3: Listar Produtos de um Usuário

Primeiro, liste todos os produtos:
```bash
curl -X GET http://localhost:8080/produto
```

Depois, filtre pelo `usuarioIdUsuario` desejado.

---

## 🔒 Observações Importantes

1. **Senha**: A senha é armazenada em texto plano. Para produção, implemente hash (BCrypt, etc.).

2. **Foto**: O campo `foto` aceita URL ou string base64. Para produção, considere upload de arquivos.

3. **Validação**: Adicione validações de campos (Bean Validation) para produção.

4. **Tratamento de Erros**: Implemente tratamento de erros adequado com mensagens claras.

5. **Segurança**: Implemente autenticação e autorização (JWT, OAuth2, etc.) para produção.

---

## 📚 Arquitetura

O projeto segue os princípios da **Arquitetura Limpa (Clean Architecture)**:

- **Domain**: Entidades de negócio puras (sem dependências)
- **Application**: Casos de uso e interfaces (Gateways)
- **Infrastructure**: Implementações concretas (JPA, Repositories)
- **Controller**: Camada de apresentação (REST APIs)

---

## 👨‍💻 Desenvolvimento

Projeto desenvolvido para a faculdade de ADS Fase 4.

---

## 📄 Licença

Este projeto é desenvolvido para fins educacionais.

---

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

---

## 📧 Contato

Para dúvidas ou sugestões, abra uma issue no repositório.

