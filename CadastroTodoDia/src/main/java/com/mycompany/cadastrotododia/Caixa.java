package com.mycompany.cadastrotododia;

public class Caixa {

    private int ID;
    private CadastrarClientes cliente;
    private CadastrarProdutos produto;
    private String formaPagamento;
    private int quantidadeVendida;
    private double valorTotal;

    public Caixa(int ID, CadastrarClientes cliente, CadastrarProdutos produto,
                 String formaPagamento, int quantidadeVendida, double valorTotal) {

        this.ID = ID;
        this.cliente = cliente;
        this.produto = produto;
        this.formaPagamento = formaPagamento;
        this.quantidadeVendida = quantidadeVendida;
        this.valorTotal = produto.getValorUnitario() * quantidadeVendida;
    }

    public int getID() {
        return ID;
    }

    public CadastrarClientes getCliente() {
        return cliente;
    }

    public CadastrarProdutos getProduto() {
        return produto;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void exibirInfo() {
        if (produto.getEstoque() < quantidadeVendida) {
            System.out.println("Estoque insuficiente!");
            return;
        }

        System.out.println(
            "Cliente: " + cliente.getNome() +
            " | Produto: " + produto.getNome() +
            " | Quantidade: " + quantidadeVendida +
            " | Total: R$ " + valorTotal
        );
    }
}