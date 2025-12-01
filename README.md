🖼️ AWS Image App — Gerenciamento de Usuários e Tarefas + Upload de Imagens (em breve)

Este é um projeto desenvolvido em Java + Spring Boot, utilizando Docker e PostgreSQL, com o objetivo de gerenciar usuários, tarefas e futuramente realizar upload de imagens para a AWS (S3).

O sistema permite criar usuários, cadastrar tarefas associadas a cada usuário e filtrar por status.
A integração com AWS será implementada como melhoria futura.

🚀 Tecnologias Utilizadas

Java 21

Spring Boot 3

Spring Web

Spring Data JPA

Spring Security (se usado)

PostgreSQL 15

Docker & Docker Compose

Maven

Lombok

JPA / Hibernate

🐳 Rodando o projeto com Docker

Certifique-se de que já construiu o .jar:

mvn clean package -DskipTests


Suba os containers:

docker compose up --build


A aplicação estará disponível em:

http://localhost:8080


E o banco PostgreSQL em:

localhost:5432

▶️ Rodando localmente sem Docker

Suba seu PostgreSQL manualmente

Configure o application.properties (mas não commite — ele está no .gitignore 👍)

Rode:

mvn spring-boot:run

📌 Endpoints Principais
👤 Usuários
Método	Endpoint	Descrição
POST	/users	Criar usuário
GET	/users/{id}	Buscar usuário por ID
GET	/users	Listar todos usuários
DELETE	/users/{id}	Remover usuário
📋 Tarefas
Método	Endpoint	Descrição
POST	/tarefas	Criar tarefa
GET	/tarefas/user/{id}	Listar tarefas de um usuário
GET	/tarefas/status/{status}	Listar tarefas por status
PUT	/tarefas/{id}	Atualizar tarefa
DELETE	/tarefas/{id}	Remover tarefa
📂 Estrutura do Projeto
src/
 ├── main/
 │   ├── java/com/ArielMelo/AWS_image/
 │   │   ├── controllers/
 │   │   ├── entities/
 │   │   ├── repositories/
 │   │   ├── services/
 │   │   └── AWS_imageApplication.java
 │   └── resources/
 │       ├── application.properties (IGNORADO no Git)
 │       └── static/
 └── test/

📌 Roadmap
✔️ Concluído

CRUD de Usuários

CRUD de Tarefas

Relacionamento User → Tarefas

Filtro por status e por usuário

Docker Compose com PostgreSQL

Geração automática do .jar para o container

🔜 Próximas Features

📤 Upload de imagens para AWS S3

🔑 Login + autenticação com JWT

🧹 Validações com Bean Validation

🧪 Testes (Unitários e Integração)

📊 Paginação e ordenação de tarefas

🌎 Sobre o projeto

Esse projeto foi criado para estudos e prática de:

Arquitetura REST

JPA + Hibernate

Docker

Deploy e integração com serviços externos (AWS S3)

Boas práticas com Lombok e camadas organizadas

⭐ Como contribuir

Fique à vontade para abrir issues, sugerir melhorias ou enviar PRs.
