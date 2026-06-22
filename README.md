# Sistema Objeto-Relacional (BDOR) com Spring Boot e PostgreSQL

Este projeto faz parte de um estudo prático sobre paradigmas de banco de dados e mapeamento objeto-relacional (ORM). O objetivo principal é demonstrar como o ecossistema corporativo Java resolve o **Descompasso de Impedância** (Impedance Mismatch) ao persistir objetos complexos em um banco de dados relacional clássico.

## O Desafio: Descompasso de Impedância
No paradigma de Orientação a Objetos, entidades frequentemente contêm coleções aninhadas. Neste sistema, temos uma classe `Pessoa` que encapsula uma lista (`List<String>`) de `telefones`.

Bancos de dados relacionais rigorosos, como o PostgreSQL, não suportam o armazenamento nativo de listas em uma única célula de tabela. Para contornar essa barreira de paradigmas, utilizamos o framework **Hibernate (via Spring Data JPA)** atuando como a camada de tradução (ORM).

### O Mecanismo em Ação
O Hibernate analisa o objeto Java e, nos bastidores, quebra a estrutura original para adequá-la ao modelo relacional. Ele gera automaticamente os scripts SQL (DDL e DML) para criar e popular **duas tabelas distintas**:
1. `pessoa`: Armazena os atributos simples (id, nome).
2. `pessoa_telefones`: Uma tabela auxiliar criada exclusivamente para armazenar a coleção, garantindo a integridade referencial através de uma **Chave Estrangeira (`FOREIGN KEY`)** apontando para o id da pessoa.

## Tecnologias Utilizadas
* **Linguagem:** Java 21
* **Framework Principal:** Spring Boot
* **Persistência:** Spring Data JPA / Hibernate
* **Banco de Dados:** PostgreSQL
* **Gerenciador de Dependências:** Maven

## Boas Práticas de Segurança Aplicadas
Este repositório segue padrões da indústria para a gestão de credenciais. Nenhuma senha de banco de dados está escrita (hardcoded) no arquivo `application.properties`. A conexão com o PostgreSQL é feita de forma dinâmica através da injeção de **Variáveis de Ambiente** configuradas no sistema operacional ou na IDE do desenvolvedor.

## 🚀 Como Executar o Projeto Localmente

### Pré-requisitos
* Ter o **PostgreSQL** instalado e rodando (porta padrão `5432`).
* Ter um banco de dados criado com o nome `apresentacao_bd`.
* Ter o Java Development Kit (JDK) instalado.

### Configurando as Variáveis de Ambiente
Antes de rodar a aplicação, você precisa fornecer as credenciais do seu banco local. Configure as seguintes variáveis de ambiente no seu sistema ou na sua IDE (ex: IntelliJ IDEA em *Run/Debug Configurations*):

* `DB_USER` = (ex: `postgres`)
* `DB_PASSWORD` = (sua senha do banco de dados)

### Executando
1. Clone este repositório.
2. Abra o projeto na sua IDE favorita.
3. Certifique-se de que as variáveis de ambiente estão injetadas na configuração de execução.
4. Execute a classe principal `ProjetoObjetoRelacionalApplication.java`.
5. Acompanhe os logs no terminal: você verá o Spring Boot inicializar e o Hibernate imprimir os scripts SQL de `CREATE TABLE` e `INSERT` em tempo real.
6. Abra o seu gerenciador de banco de dados (ex: pgAdmin) para verificar as tabelas criadas e os dados mapeados.
