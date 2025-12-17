package com.mycompany.cadastrotododia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class ClienteDAO {

    public void inserir(CadastrarClientes cliente) {
        String sql = "INSERT INTO cadastrar_clientes (Nome_Cliente, Endereco_Cliente, Telefone_Cliente, Email_Cliente, CPF_Cliente) VALUES (?,?,?,?,?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getCPF());

            stmt.executeUpdate();

            System.out.println("Cliente inserido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
}
}
    public void deletar(int id) {
        String sql = "DELETE FROM cadastrar_clientes WHERE ID_Cliente = ?";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1,id);
            int linhas = stmt.executeUpdate();
            
            if (linhas > 0) {
                System.out.println("Cliente deletado com sucesso!");
            } else {
                System.out.println("Cliente não encontrado para deletar!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao encontrar cliente:" + e.getMessage());
        }
        
    }
    public void atualizar(CadastrarClientes cliente) {
        String sql = "UPDATE cadastrar_clientes SET Nome_Cliente= ?, Endereco_Cliente= ?, Telefone_Cliente = ?, Email_Cliente = ?, CPF_Cliente = ? WHERE ID_Cliente = ?";
        
        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getCPF());
            stmt.setInt(6, cliente.getID());

            int linha = stmt.executeUpdate();
            
            if (linha > 0) {
                System.out.println("Cliente atualizado com sucesso!");
            } else {
                System.out.println("Cliente não encontrado para atualizar.");
            }
            
            
           
        } catch (Exception e) {
            System.out.println("Cliente não encontrado." + e.getMessage());
        }
    }
    
    public CadastrarClientes buscarPorID (int id) {
        String sql = "SELECT * FROM cadastrar_clientes WHERE ID_Cliente = ?";
        
        CadastrarClientes cliente = null;
        
        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                cliente = new CadastrarClientes (
                rs.getInt("ID_Cliente"),
                rs.getString("Nome_Cliente"),
                rs.getString("Endereco_Cliente"),
                rs.getString("Telefone_Cliente"),
                rs.getString("Email_Cliente"),
                rs.getString("CPF_Cliente")
                );
            }
        } catch (Exception e) {
            System.out.println("Erro ao encontrar cliente." + e.getMessage());
        }
        
        return cliente;
    }
    
    public List<CadastrarClientes> buscarTodos() {
        String sql = "SELECT * FROM cadastrar_clientes";
        List<CadastrarClientes> lista = new ArrayList<>();
        
        try (Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            
           while(rs.next()) {
                CadastrarClientes cliente = new CadastrarClientes (
                rs.getInt("ID_Cliente"),
                rs.getString("Nome_Cliente"),
                rs.getString("Endereco_Cliente"),
                rs.getString("Telefone_Cliente"),
                rs.getString("Email_Cliente"),
                rs.getString("CPF_Cliente")
                );
                
                lista.add(cliente);
            }
            }
        catch (Exception e) {
            System.out.println("Erro ao buscar cliente." + e.getMessage());
        }
        return lista;
    }
}
    
    

