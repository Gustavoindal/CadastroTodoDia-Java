package com.mycompany.cadastrotododia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO {

    public void inserir(Usuario usuario) {
        String sql = "INSERT INTO usuarios (Login, Senha, Perfil) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getPerfil());

            stmt.executeUpdate();

            System.out.println("Usuário inserido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
}
}
    public void deletar(int id) {
        String sql = "DELETE FROM usuarios WHERE Usuario_ID = ?";
        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,id);
            
            int linha = stmt.executeUpdate();
            
            if (linha > 0) {
                System.out.println("Usuario deletado com sucesso!");
                
            } else {
                System.out.println("Usuario não encontrado para deletar.");
            } 
            
        } catch (Exception e) {
            System.out.println("Erro ao deletar usuario." + e.getMessage());
        }
    }
    public void atualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET Login = ?, Senha = ?, Perfil = ? WHERE Usuario_ID = ?";
        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getPerfil()
            );
            
            
            int linha = stmt.executeUpdate();
            
            if (linha > 0) {
                System.out.println("Usuario atualizado com sucesso!");
            } else {
                System.out.println("Usuario não encontrado para atualizar.");
            }
            
        } catch (Exception e) {
            System.out.println("Usuario não encontrado." + e.getMessage());
        }
    }
    
    public Usuario buscarPorID(int id) {
         String sql = "SELECT * FROM usuario WHERE Usuario_ID = ?";
        
        Usuario usuario = null;
        
        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                usuario = new Usuario (
                rs.getInt("Usuario_ID"),
                rs.getString("Login"),
                rs.getString("Senha"),
                rs.getString("Perfil")  
                );
            }
        } catch (Exception e) {
            System.out.println("Erro ao encontrar Usuario." + e.getMessage());
        }
        
        return usuario;
    }
    
        public List<Usuario> buscarTodos() {
        String sql = "SELECT * FROM cadastrar_de_fornecedores";
        List<Usuario> usuarios = new ArrayList<>();
        
        try (Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            
           while(rs.next()) {
                Usuario usuario = new Usuario (
                rs.getInt("Usuario_ID"),
                rs.getString("Login"),
                rs.getString("Senha"),
                rs.getString("Perfil")     
                );
                
                usuarios.add(usuario);
            }
            }
        catch (Exception e) {
            System.out.println("Erro ao buscar usuario." + e.getMessage());
        }
        return usuarios;
    }
}
