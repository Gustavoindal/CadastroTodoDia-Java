/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cadastrotododia;

import java.util.Scanner;

public class CadastroTodoDia {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        ClienteDAO daoCliente = new ClienteDAO();
        FornecedorDAO daoFornecedor = new FornecedorDAO();
        ProdutosDAO daoProduto = new ProdutosDAO();

        while (true) {

            System.out.println("\n=== MENU ===");
            System.out.println("1 - Clientes");
            System.out.println("2 - Fornecedores");
            System.out.println("3 - Produtos");
            System.out.println("4 - Caixa");
            System.out.println("5 - Sair");

            int opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao == 5) {
                System.out.println("Programa finalizado.");
                break;
            }

            /* ===================== CLIENTES ===================== */
            if (opcao == 1) {

                System.out.println("\n1) Inserir  2) Atualizar  3) Deletar  4) Buscar ID  5) Buscar Todos");
                int op = entrada.nextInt();
                entrada.nextLine();

                if (op == 1) {
                    System.out.print("ID: ");
                    int id = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();

                    System.out.print("Endereço: ");
                    String endereco = entrada.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = entrada.nextLine();

                    System.out.print("Email: ");
                    String email = entrada.nextLine();

                    System.out.print("CPF: ");
                    String cpf = entrada.nextLine();

                    CadastrarClientes c =
                            new CadastrarClientes(id, nome, endereco, telefone, email, cpf);

                    daoCliente.inserir(c);
                }

                if (op == 2) {
                    System.out.print("ID do cliente: ");
                    int id = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("Novo nome: ");
                    String nome = entrada.nextLine();

                    System.out.print("Novo endereço: ");
                    String endereco = entrada.nextLine();

                    System.out.print("Novo telefone: ");
                    String telefone = entrada.nextLine();

                    System.out.print("Novo email: ");
                    String email = entrada.nextLine();

                    System.out.print("Novo CPF: ");
                    String cpf = entrada.nextLine();

                    CadastrarClientes c =
                            new CadastrarClientes(id, nome, endereco, telefone, email, cpf);

                    daoCliente.atualizar(c);
                }

                if (op == 3) {
                    System.out.print("ID para deletar: ");
                    daoCliente.deletar(entrada.nextInt());
                }

                if (op == 4) {
                    System.out.print("ID para buscar: ");
                    CadastrarClientes c = daoCliente.buscarPorID(entrada.nextInt());

                    if (c != null)
                        System.out.println(c.getID() + " - " + c.getNome());
                    else
                        System.out.println("Cliente não encontrado.");
                }

                if (op == 5) {
                    for (CadastrarClientes c : daoCliente.buscarTodos()) {
                        System.out.println(c.getID() + " - " + c.getNome());
                    }
                }
            }

            /* ===================== FORNECEDORES ===================== */
            if (opcao == 2) {

                System.out.println("\n1) Inserir  2) Atualizar  3) Deletar  4) Buscar ID  5) Buscar Todos");
                int op = entrada.nextInt();
                entrada.nextLine();

                if (op == 1) {
                    System.out.print("ID: ");
                    int id = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();

                    System.out.print("Email: ");
                    String email = entrada.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = entrada.nextLine();

                    System.out.print("Endereço: ");
                    String endereco = entrada.nextLine();

                    System.out.print("Rua: ");
                    String rua = entrada.nextLine();

                    System.out.print("Bairro: ");
                    String bairro = entrada.nextLine();

                    System.out.print("Estado: ");
                    String estado = entrada.nextLine();

                    System.out.print("CEP: ");
                    String cep = entrada.nextLine();

                    System.out.print("CNPJ: ");
                    String cnpj = entrada.nextLine();

                    System.out.print("Histórico: ");
                    String historico = entrada.nextLine();

                    System.out.print("Ramo: ");
                    String ramo = entrada.nextLine();

                    CadastrarFornecedores f =
                            new CadastrarFornecedores(id, nome, email, telefone,
                                    endereco, rua, bairro, estado, cep, cnpj, historico, ramo);

                    daoFornecedor.inserir(f);
                }

                if (op == 2) {
                    System.out.print("ID: ");
                    int id = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("Novo nome: ");
                    String nome = entrada.nextLine();

                    System.out.print("Novo email: ");
                    String email = entrada.nextLine();

                    System.out.print("Novo telefone: ");
                    String telefone = entrada.nextLine();

                    System.out.print("Novo endereço: ");
                    String endereco = entrada.nextLine();

                    System.out.print("Rua: ");
                    String rua = entrada.nextLine();

                    System.out.print("Bairro: ");
                    String bairro = entrada.nextLine();

                    System.out.print("Estado: ");
                    String estado = entrada.nextLine();

                    System.out.print("CEP: ");
                    String cep = entrada.nextLine();

                    System.out.print("CNPJ: ");
                    String cnpj = entrada.nextLine();

                    System.out.print("Histórico: ");
                    String historico = entrada.nextLine();

                    System.out.print("Ramo: ");
                    String ramo = entrada.nextLine();

                    CadastrarFornecedores f =
                            new CadastrarFornecedores(id, nome, email, telefone,
                                    endereco, rua, bairro, estado, cep, cnpj, historico, ramo);

                    daoFornecedor.atualizar(f);
                }

                if (op == 3) {
                    System.out.print("ID para deletar: ");
                    daoFornecedor.deletar(entrada.nextInt());
                }

                if (op == 4) {
                    System.out.print("ID para buscar: ");
                    CadastrarFornecedores f = daoFornecedor.buscarPorID(entrada.nextInt());

                    if (f != null)
                        System.out.println(f.getID() + " - " + f.getNome());
                    else
                        System.out.println("Fornecedor não encontrado.");
                }

                if (op == 5) {
                    for (CadastrarFornecedores f : daoFornecedor.buscarTodos()) {
                        System.out.println(f.getID() + " - " + f.getNome());
                    }
                }
            }

            /* ===================== PRODUTOS ===================== */
            if (opcao == 3) {

                System.out.println("\n1) Inserir  2) Atualizar  3) Deletar  4) Buscar ID  5) Buscar Todos");
                int op = entrada.nextInt();
                entrada.nextLine();

                if (op == 1) {
                    System.out.print("ID: ");
                    int id = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();

                    System.out.print("Tipo: ");
                    String tipo = entrada.nextLine();

                    System.out.print("Estoque: ");
                    int estoque = entrada.nextInt();

                    System.out.print("Custo: ");
                    double custo = entrada.nextDouble();

                    System.out.print("Valor unitário: ");
                    double valor = entrada.nextDouble();

                    System.out.print("Margem: ");
                    double margem = entrada.nextDouble();

                    CadastrarProdutos p =
                            new CadastrarProdutos(id, nome, tipo, estoque, custo, valor, margem);

                    daoProduto.inserir(p);
                }

                if (op == 2) {
                    System.out.print("ID: ");
                    int id = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();

                    System.out.print("Tipo: ");
                    String tipo = entrada.nextLine();

                    System.out.print("Estoque: ");
                    int estoque = entrada.nextInt();

                    System.out.print("Custo: ");
                    double custo = entrada.nextDouble();

                    System.out.print("Valor: ");
                    double valor = entrada.nextDouble();

                    System.out.print("Margem: ");
                    double margem = entrada.nextDouble();

                    CadastrarProdutos p =
                            new CadastrarProdutos(id, nome, tipo, estoque, custo, valor, margem);

                    daoProduto.atualizar(p);
                }

                if (op == 3) {
                    System.out.print("ID para deletar: ");
                    daoProduto.deletar(entrada.nextInt());
                }

                if (op == 4) {
                    System.out.print("ID para buscar: ");
                    CadastrarProdutos p = daoProduto.buscarPorID(entrada.nextInt());

                    if (p != null)
                        System.out.println(p.getID() + " - " + p.getNome());
                    else
                        System.out.println("Produto não encontrado.");
                }

                if (op == 5) {
                    for (CadastrarProdutos p : daoProduto.buscarTodos()) {
                        System.out.println(p.getID() + " - " + p.getNome());
                    }
                }
            }

            /* ===================== CAIXA ===================== */
            if (opcao == 4) {

                ClienteDAO clienteDAO = new ClienteDAO();
                ProdutosDAO produtoDAO = new ProdutosDAO();
                CaixaDAO caixaDAO = new CaixaDAO();

                System.out.println("ID do cliente:");
                int idCliente = entrada.nextInt();

                CadastrarClientes cliente = clienteDAO.buscarPorID(idCliente);

                if (cliente == null) {
                    System.out.println("Cliente não encontrado!");
                    continue;
                }

                System.out.println("ID do produto:");
                int idProduto = entrada.nextInt();

                CadastrarProdutos produto = produtoDAO.buscarPorID(idProduto);

                if (produto == null) {
                    System.out.println("Produto não encontrado!");
                    continue;
                }

                System.out.println("Quantidade vendida:");
                int quantidade = entrada.nextInt();

                if (quantidade > produto.getEstoque()) {
                    System.out.println("Estoque insuficiente!");
                    continue;
                    }

                entrada.nextLine(); 
                System.out.println("Forma de pagamento:");
                String formaPagamento = entrada.nextLine();
                
                double valor_total = produto.getValorUnitario() * quantidade;

                int idVenda = 0; 

                Caixa caixa = new Caixa(idVenda,cliente,produto,formaPagamento,quantidade, valor_total);
                caixaDAO.inserir(caixa);

            produto.setEstoque(produto.getEstoque() - quantidade);
            produtoDAO.atualizar(produto);

            caixa.exibirInfo();

        }
    }
}
}

    

