
package com.mycompany.cadastrotododia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class ProdutosDAO {
    public void inserir(CadastrarProdutos produto) {
        String sql = "INSERT INTO cadastrar_produtos (Nome_Produto, Tipo_de_Produto, Estoque_Produto, Preco_Custo,Valor_Unitario,Margem_Lucro) VALUES (?,?,?,?,?,?)";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getTipo());
            stmt.setInt(3, produto.getEstoque());
            stmt.setDouble(4, produto.getPrecoCusto());
            stmt.setDouble(5, produto.getValorUnitario());
            stmt.setDouble(6, produto.getMargemLucro());

            stmt.executeUpdate();

            System.out.println("Produto inserido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
}
    }
    public void deletar (int id) {
        String sql = "DELETE from cadastrar_produtos WHERE ID_Produto = ?";
        
        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            int linha = stmt.executeUpdate();
            
            if (linha > 0) {
                System.out.println("Produto deletado com sucesso!");
            } else {
                System.out.println("Produto não encontrado para deletar.");
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao encontrar produto." + e.getMessage());
        }
            
    }
    public void atualizar(CadastrarProdutos produto) {
        String sql = "UPDATE cadastrar_produtos SET Nome_Produto = ?, Tipo_de_Produto = ?, Estoque_Produto = ?, Preco_Custo = ?, Valor_Unitario = ?, Margem_Lucro = ? WHERE ID_Produto = ?";
        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getTipo());
            stmt.setInt(3, produto.getEstoque());
            stmt.setDouble(4, produto.getPrecoCusto());
            stmt.setDouble(5, produto.getValorUnitario());
            stmt.setDouble(6, produto.getMargemLucro());
            stmt.setInt(7, produto.getID());
            
            int linha = stmt.executeUpdate();
            
            if (linha > 0) {
                System.out.println("Produto atualizado com sucesso!");
            } else {
                System.out.println("Produto não encontrado para atualizar.");
            }
        } catch (Exception e) {
            System.out.println("Produto não encontrado" + e.getMessage());
        }
    } public CadastrarProdutos buscarPorID(int id) {
        String sql = "SELECT * FROM cadastrar_produtos WHERE ID_Produto = ?";
        
        CadastrarProdutos produto = null;
        
        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,id);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                produto = new CadastrarProdutos (
                rs.getInt("ID_Produto"),
                rs.getString("Nome_Produto"),
                rs.getString("Tipo_De_Produto"),
                rs.getInt("Estoque_Produto"),
                rs.getDouble("Preco_Custo"),
                rs.getDouble("Valor_Unitario"),
                rs.getDouble("Margem_Lucro")
                );
                
            }
            } catch (Exception e) {
                System.out.println("Erro ao encontrar produto." + e.getMessage());
        }
        return produto;
        
    }
    public List<CadastrarProdutos>  buscarTodos() {
        String sql = "SELECT * FROM cadastrar_produtos";
        List<CadastrarProdutos> produtos = new ArrayList<>();
        
        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                CadastrarProdutos produto = new CadastrarProdutos (
                rs.getInt("ID_Produto"),
                rs.getString("Nome_Produto"),
                rs.getString("Tipo_de_Produto"),
                rs.getInt("Estoque_Produto"),
                rs.getDouble("Preco_Custo"),
                rs.getDouble("Valor_Unitario"),
                rs.getDouble("Margem_Lucro")
                );
                
                produtos.add(produto);
            }
            }
        catch (Exception e) {
            System.out.println("Erro ao buscar produto." + e.getMessage());
        }
        return produtos;
        }
              
    }

