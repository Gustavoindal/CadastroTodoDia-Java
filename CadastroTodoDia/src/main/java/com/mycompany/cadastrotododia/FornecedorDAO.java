package com.mycompany.cadastrotododia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class FornecedorDAO {

    public void inserir(CadastrarFornecedores fornecedor) {
        String sql = "INSERT INTO cadastro_de_fornecedores (Nome_Fornecedor, Email_Fornecedor, Telefone_Fornecedor, Endereco_Fornecedor, Rua_Fornecedor, Bairro_Fornecedor, Estado_Fornecedor, CEP_Fornecedor, CNPJ_Fornecedor, Historico_de_fornecimento, Ramo_de_atuacao) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getEmail());
            stmt.setString(3, fornecedor.getTelefone()); 
            stmt.setString(4, fornecedor.getEndereco());
            stmt.setString(5, fornecedor.getRua());
            stmt.setString(6, fornecedor.getBairro());
            stmt.setString(7, fornecedor.getEstado());
            stmt.setString(8, fornecedor.getCEP());
            stmt.setString(9, fornecedor.getCNPJ());
            stmt.setString(10, fornecedor.getHistoricoFornecimento());
            stmt.setString(11, fornecedor.getRamoAtuacao());

            stmt.executeUpdate();

            System.out.println("Fornecedor inserido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao inserir fornecedor: " + e.getMessage());
        }
    }
    
    public void deletar(int id) {
        String sql = "DELETE FROM cadastro_de_fornecedores WHERE ID_Fornecedor = ?";
        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,id);
            
            int linha = stmt.executeUpdate();
            
            if (linha > 0) {
                System.out.println("Fornecedor deletado com sucesso!");
                
            } else {
                System.out.println("Fornecedor não encontrado para deletar.");
            } 
            
        } catch (Exception e) {
            System.out.println("Erro ao deletar fornecedor." + e.getMessage());
        }
    }
    public void atualizar(CadastrarFornecedores fornecedor) {
        String sql = "UPDATE cadastro_de_fornecedores SET Nome_Fornecedor = ?, Email_Fornecedor = ?, Telefone_Fornecedor = ?, Endereco_Fornecedor = ?, Rua_Fornecedor = ?, Bairro_Fornecedor = ?, Estado_Fornecedor = ?, CEP_Fornecedor = ?, CNPJ_Fornecedor = ?, Historico_de_fornecimento = ?, Ramo_de_atuacao = ? WHERE ID_Fornecedor = ?";
        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getEmail());
            stmt.setString(3, fornecedor.getTelefone());
            stmt.setString(4, fornecedor.getEndereco());
            stmt.setString(5, fornecedor.getRua());
            stmt.setString(6, fornecedor.getBairro());
            stmt.setString(7, fornecedor.getEstado());
            stmt.setString (8, fornecedor.getCEP());
            stmt.setString (9, fornecedor.getCNPJ());
            stmt.setString (10, fornecedor.getHistoricoFornecimento());
            stmt.setString (11, fornecedor.getRamoAtuacao());
            stmt.setInt(12, fornecedor.getID());
            
            int linha = stmt.executeUpdate();
            
            if (linha > 0) {
                System.out.println("Fornecedor atualizado com sucesso!");
            } else {
                System.out.println("Fornecedor não encontrado para atualizar.");
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao atualizar fornecedor." + e.getMessage());
        }
    }
    public CadastrarFornecedores buscarPorID(int id) {
         String sql = "SELECT * FROM cadastro_de_fornecedores WHERE ID_Fornecedor = ?";
        
        CadastrarFornecedores fornecedor = null;
        
        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                fornecedor = new CadastrarFornecedores (
                rs.getInt("ID_Fornecedor"),
                rs.getString("Nome_Fornecedor"),
                rs.getString("Email_Fornecedor"),
                rs.getString("Telefone_Fornecedor"),
                rs.getString("Endereco_Fornecedor"),
                rs.getString("Rua_Fornecedor"),
                rs.getString("Bairro_Fornecedor"),
                rs.getString("Estado_Fornecedor"),
                rs.getString("CEP_Fornecedor"),
                rs.getString("CNPJ_Fornecedor"),
                rs.getString("Historico_de_fornecimento"),
                rs.getString("Ramo_de_atuacao")
                );
            }
        } catch (Exception e) {
            System.out.println("Erro ao encontrar fornecedor." + e.getMessage());
        }
        
        return fornecedor;
    }
    
    public List<CadastrarFornecedores> buscarTodos() {
        String sql = "SELECT * FROM cadastro_de_fornecedores";
        List<CadastrarFornecedores> lista = new ArrayList<>();
        
        try (Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            
           while(rs.next()) {
                CadastrarFornecedores fornecedor = new CadastrarFornecedores (
                rs.getInt("ID_Fornecedor"),
                rs.getString("Nome_Fornecedor"),
                rs.getString("Email_Fornecedor"),
                rs.getString("Telefone_Fornecedor"),
                rs.getString("Endereco_Fornecedor"),
                rs.getString("Rua_Fornecedor"),
                rs.getString("Bairro_Fornecedor"),
                rs.getString("Estado_Fornecedor"),
                rs.getString("CEP_Fornecedor"),
                rs.getString("CNPJ_Fornecedor"),
                rs.getString("Historico_de_fornecimento"),
                rs.getString("Ramo_de_atuacao")
                );
                
                lista.add(fornecedor);
            }
            }
        catch (Exception e) {
            System.out.println("Erro ao buscar fornecedor." + e.getMessage());
        }
        return lista;
    }
    
    }

