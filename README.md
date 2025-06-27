# ATVD-JWT - API de Autenticação e Autorização JWT Interna

[![Build Status](https://img.shields.io/github/actions/workflow/status/seu-usuario/ATVD-JWT/ci.yml)](https://github.com/seu-usuario/ATVD-JWT/actions)
[![License](https://img.shields.io/badge/license-Apache%202.0-blue)](http://www.apache.org/licenses/LICENSE-2.0.html)
[![Coverage](https://img.shields.io/codecov/c/github/seu-usuario/ATVD-JWT)](https://codecov.io/gh/seu-usuario/ATVD-JWT)

Este projeto implementa uma API RESTful com Spring Boot para **autenticação e autorização** usando **JSON Web Tokens (JWT)**. Inclui geração e validação de tokens, proteção de endpoints, documentação automática com Swagger/OpenAPI e testes de integração.

## 🚀 Tecnologias Utilizadas

* Java 17
* Spring Boot 3.x

  * spring-boot-starter-web
  * spring-boot-starter-security
  * spring-boot-starter-oauth2-resource-server
  * spring-boot-starter-data-jpa
  * springdoc-openapi-starter-webmvc-ui
  * spring-boot-devtools
  * spring-boot-starter-test
  * lombok
* H2 Database (in-memory)
* Maven (pom.xml)
* JUnit 5 + MockMvc
* JMeter (plano de teste de carga)

## 📥 Como Rodar o Projeto

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/seu-usuario/ATVD-JWT.git
   cd ATVD-JWT
   ```

2. **Compile e execute**:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. A API estará disponível em `http://localhost:8080`.

## 🛠️ Configuração

> **Variáveis de Ambiente**:
>
> * `JWT_SECRET`: sua chave secreta para JWT (substitui `jwt.secret` no application.yml)
> * `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, `SPRING_DATASOURCE_PASSWORD`: para configurar outro banco em produção.

O arquivo `src/main/resources/application.yml` já vem configurado para:

O arquivo `src/main/resources/application.yml` já vem configurado para:

* Banco H2 em memória (`jdbc:h2:mem:testdb`)
* Console H2 em `/h2-console`
* JWT com chave secreta e expiração de 1 hora
* Swagger UI em `/swagger-ui.html`
* DevTools habilitado para hot reload

> **Importante:** Em produção, mova a chave secreta (`jwt.secret`) para variáveis de ambiente ou um serviço de gestão de segredos.

## 🔐 Endpoints Principais

*A tabela abaixo resume de forma rápida os principais endpoints, suas descrições e requisitos de autenticação, facilitando uma visão geral imediata para quem for avaliar o projeto.*

| Método | URL              | Descrição                                        | Autenticação |
| ------ | ---------------- | ------------------------------------------------ | ------------ |
| POST   | `/auth/login`    | Faz login e retorna o token JWT                  | Não          |
| POST   | `/auth/validate` | Valida um token JWT                              | Não          |
| GET    | `/api/hello`     | Endpoint protegido: qualquer usuário autenticado | Bearer JWT   |
| GET    | `/api/admin`     | Endpoint protegido: apenas role `ADMIN`          | Bearer JWT   |

### Cabeçalhos

Para acessar endpoints protegidos, adicione no header:

```
Authorization: Bearer <seu_token_jwt>
```

## 🧩 Console H2

* URL: `http://localhost:8080/h2-console`
* Driver: `org.h2.Driver`
* JDBC URL: `jdbc:h2:mem:testdb`
* Usuário: `sa`
* Senha: ` ` (vazio)

## 📄 Documentação Swagger / OpenAPI

* Acesse a UI interativa em: `http://localhost:8080/swagger-ui.html`
* Arquivo de definição em: `http://localhost:8080/v3/api-docs`

## ✅ Testes de Integração (JUnit + MockMvc)

Execute:

```bash
mvn test
```

Os testes cobrem cenários de:

* Login bem-sucedido e falha
* Acesso sem token (401)
* Acesso com token válido (200)
* Restrições de role ADMIN (200/403)

## 📈 Teste de Carga com JMeter

1. Abra o JMeter:

   ```bash
   jmeter.bat   # Windows
   ./jmeter.sh  # Linux/macOS
   ```
2. Carregue o plano de teste `login_stress_test.jmx` em `jmeter-tests/`.
3. Execute e visualize métricas em `Summary Report` e `View Results Tree`.
4. Ajuste número de threads e ramp-up conforme necessidade.

> Certifique-se de ter a aplicação rodando em `localhost:8080` antes de iniciar o teste.

## 🔗 Integração Contínua / CI-CD

Para maior robustez, configure um pipeline de CI (ex: GitHub Actions) que:

1. Execute `mvn clean verify` para rodar testes
2. Gere relatório de cobertura (ex: Jacoco)
3. Publique artefatos ou faça deploy automático em ambientes de teste

---

## 📂 Estrutura de Pastas

```
ATVD-JWT/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/com/example/authserver/
│   │   │   ├── config/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   └── service/
│   │   └── resources/
│   │       └── application.yml
│   └── test/
│       └── java/com/example/authserver/
│           └── AuthIntegrationTests.java
├── jmeter-tests/
│   └── login_stress_test.jmx
└── README.md
```

## 🗂️ Entrega no GitHub

Certifique-se de:

1. Ter o projeto em um repositório público no GitHub.
2. Incluir todos os arquivos-fonte necessários (`src/`, `pom.xml`, `application.yml`).
3. Versionar o arquivo de teste de carga JMeter (`jmeter-tests/login_stress_test.jmx`).
4. Adicionar um arquivo `.gitignore` para excluir pastas como `target/` e configurações do editor (`.vscode/`).
5. Ter o README.md apontando claramente como clonar e executar o projeto.

Essa seção demonstra ao professor que todo o projeto está organizado e disponível para avaliação.

## 📄 Licença

Este projeto está licenciado sob a [Apache License 2](http://www.apache.org/licenses/LICENSE-2.0.html)
