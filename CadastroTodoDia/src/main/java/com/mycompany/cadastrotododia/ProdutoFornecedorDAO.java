package com.mycompany.cadastrotododia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoFornecedorDAO {

    public void inserir(ProdutoFornecedor produtoFornecedor) {
        String sql = "INSERT INTO produto_fornecedor (ID_Fornecedor, ID_Produto) VALUES (?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, produtoFornecedor.getFornecedor().getID());
            stmt.setInt(2, produtoFornecedor.getProduto().getID());

            stmt.executeUpdate();

            System.out.println("ProdutoFornecedor inserido com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao inserir ProdutoFornecedor: " + e.getMessage());
}
}
    public void deletar(int idFornecedor, int idProduto) {
    String sql = "DELETE FROM produto_fornecedor WHERE ID_Fornecedor = ? AND ID_Produto = ?";

    try (Connection conn = Conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idFornecedor);
        stmt.setInt(2, idProduto);

        int linhas = stmt.executeUpdate();

        if (linhas > 0) {
            System.out.println("Relacionamento removido com sucesso!");
        } else {
            System.out.println("Relacionamento não encontrado.");
        }

    } catch (Exception e) {
        System.out.println("Erro ao deletar relacionamento: " + e.getMessage());
    }
} // Em relacionamentos, UPDATES são desnecessários.
    
  //Em relacionamentos, SELECT por ID específico é desnecessário.
    
    public List<ProdutoFornecedor> buscarTodos() {
    String sql = "SELECT * FROM produto_fornecedor";
    List<ProdutoFornecedor> lista = new ArrayList<>();

    try (Connection conn = Conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {

            CadastrarFornecedores fornecedor =
                    new CadastrarFornecedores(rs.getInt("ID_Fornecedor"));

            CadastrarProdutos produto =
                    new CadastrarProdutos(rs.getInt("ID_Produto"));

            ProdutoFornecedor pf =
                    new ProdutoFornecedor(fornecedor, produto);

            lista.add(pf);
        }

    } catch (Exception e) {
        System.out.println("Erro ao buscar relacionamentos: " + e.getMessage());
    }

    return lista;
}

    }
     


