/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cadastrotododia;

/**
 *
 * @author indal
 */
public class CadastrarProdutos {
    private int ID;
    private String nome;
    private String tipo;
    private int estoque;
    private double precoCusto;
    private double valorUnitario;
    private double margemLucro;

    public CadastrarProdutos(int ID, String nome, String tipo, int estoque, double precoCusto, double valorUnitario, double margemLucro) {
        this.ID = ID;
        this.nome = nome;
        this.tipo = tipo;
        this.estoque = estoque;
        this.precoCusto = precoCusto;
        this.valorUnitario = valorUnitario;
        this.margemLucro = margemLucro;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(double margemLucro) {
        this.margemLucro = margemLucro;
    }

    public CadastrarProdutos(int ID) {
        this.ID = ID;
    }
    
    
}
