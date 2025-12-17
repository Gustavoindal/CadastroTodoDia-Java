🧾 Descrição

O Cadastro Todo Dia é um sistema de mercado desenvolvido em Java, com integração direta a um banco de dados MySQL, utilizando o padrão DAO (Data Access Object) para organização do acesso aos dados.

O projeto simula o funcionamento básico de um pequeno mercado, permitindo o cadastro e gerenciamento de clientes, produtos, fornecedores e vendas (caixa), além de controlar o estoque automaticamente após cada venda.

Este projeto representa uma evolução significativa em relação a versões anteriores mais simples, sendo focado em boas práticas, organização de código e integração real com banco de dados.


🎯 Objetivo do Projeto

Praticar Java orientado a objetos

Trabalhar com CRUD completo (Create, Read, Update, Delete)

Aplicar o padrão DAO

Integrar Java com MySQL via JDBC

Entender relacionamentos entre tabelas e chaves estrangeiras

Simular um fluxo real de venda com atualização automática de estoque


⚙️ Funcionalidades

👤 Clientes

Inserir clientes

Atualizar dados

Deletar clientes

Buscar por ID

Listar todos


📦 Produtos

Inserir produtos

Atualizar informações

Controlar estoque

Deletar produtos

Buscar por ID

Listar todos


🏭 Fornecedores

Inserir fornecedores

Atualizar dados

Deletar fornecedores

Buscar por ID

Listar todos


🤝 Relação Produto × Fornecedor

Relacionamento N:N

Controle via tabela intermediária


💰 Caixa (Vendas)

Registrar vendas

Relacionar cliente e produto

Calcular valor total

Atualizar estoque automaticamente

Persistir vendas no banco


🗄️ Banco de Dados

MySQL

Modelagem relacional completa

Uso de:

PRIMARY KEY

FOREIGN KEY

AUTO_INCREMENT

ON DELETE CASCADE


Trigger para atualização automática do estoque após venda


📌 Tabelas principais

cadastrar_clientes

cadastrar_produtos

cadastro_de_fornecedores

produto_fornecedor

caixa

usuarios



🛠️ Tecnologias Utilizadas

Java

JDBC

MySQL

NetBeans

Git & GitHub


📁 Organização do Projeto

src/
 ├── Conexao.java
 ├── ClienteDAO.java
 ├── ProdutosDAO.java
 ├── FornecedorDAO.java
 ├── CaixaDAO.java
 ├── ProdutoFornecedorDAO.java
 ├── CadastroTodoDia.java (Main)
 └── classes de modelo (CadastrarClientes, Produtos, Fornecedores, etc.)


▶️ Como Executar

1. Execute o script SQL fornecido para criar o banco e as tabelas


2. Configure corretamente o arquivo Conexao.java:

private static final String URL = "jdbc:mysql://localhost:3306/cadastro_todo_dia";
private static final String USER = "root";
private static final String PASSWORD = "root";


3. Abra o projeto no NetBeans


4. Execute a classe CadastroTodoDia


5. Utilize o menu pelo terminal


🧠 Aprendizados

Durante o desenvolvimento deste projeto, foram consolidados conceitos como:

Separação de responsabilidades (DAO vs lógica de negócio)

Tratamento de erros SQL

Relacionamentos entre entidades

Importância de manter o banco sincronizado com o código

Debugging de erros reais (sintaxe SQL, parâmetros, colunas inexistentes)

Autor: 
Gustavo Indalêncio da Silva
Estudante de Desenvolvimento de Sistemas – SENAC
Dezembro de 2025

