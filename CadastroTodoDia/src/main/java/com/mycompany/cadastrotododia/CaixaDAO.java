package com.mycompany.cadastrotododia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CaixaDAO {

    public void inserir(Caixa caixa) {
        String sql = "INSERT INTO caixa (Cliente, Produto, Forma_de_Pagamento, Quantidade_Vendida, Valor_Final) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, caixa.getCliente().getID());
            stmt.setInt(2, caixa.getProduto().getID());
            stmt.setString(3, caixa.getFormaPagamento());
            stmt.setInt(4, caixa.getQuantidadeVendida());
            stmt.setDouble(5, caixa.getValorTotal());

            stmt.executeUpdate();
            System.out.println("Venda registrada no caixa com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao registrar venda: " + e.getMessage());
        }
    }

    public void deletar(int idVenda) {
        String sql = "DELETE FROM caixa WHERE ID_Caixa = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idVenda);
            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Venda removida do caixa.");
            } else {
                System.out.println("Venda não encontrada.");
            }

        } catch (Exception e) {
            System.out.println("Erro ao deletar venda: " + e.getMessage());
        }
    }

    public List<Caixa> buscarTodos() {
        String sql = "SELECT * FROM caixa";
        List<Caixa> lista = new ArrayList<>();

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                CadastrarClientes cliente =
                        new CadastrarClientes(rs.getInt("Cliente"));

                CadastrarProdutos produto =
                        new CadastrarProdutos(rs.getInt("Produto"));

                Caixa caixa = new Caixa(
                        rs.getInt("ID_Caixa"),
                        cliente,
                        produto,
                        rs.getString("Forma_de_Pagamento"),
                        rs.getInt("Quantidade_Vendida"),
                        rs.getDouble("Valor_Final")
                );

                lista.add(caixa);
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar caixa: " + e.getMessage());
        }

        return lista;
    }
}