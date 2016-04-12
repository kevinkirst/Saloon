package dao;

import connection.Conexao;
import entity.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

    public void salvar(Produto produto) {

        try {
            PreparedStatement stmt = null;
            Connection conn = Conexao.getConnection();

            String QUERY_INSERT = "insert into produto (nome, fornecedor, quantidade, dtCompra, valorCompra, valorVenda) values (?, ?, ?, ?, ?, ?)";
            String QUERY_UPDATE = "update Produto set nome = ?, fornecedor = ?, quantidade =?, dtCompra=?, valorCompra=?, valorVenda=? where idproduto = ? ";

            if (produto.getId() == null) {

                stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, produto.getNome());
                stmt.setString(2, produto.getFornecedor());
                stmt.setInt(3, produto.getQtde());
                stmt.setDate(4, new java.sql.Date(produto.getDtCompra().getTime()));
//                stmt.setDate(4, null);
                stmt.setDouble(5, produto.getValorCompra());
                stmt.setDouble(6, produto.getValorVenda());

                stmt.executeUpdate();

            } else {

                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, produto.getNome());
                stmt.setString(2, produto.getFornecedor());
                stmt.setInt(3, produto.getQtde());
                stmt.setDate(4, new java.sql.Date(produto.getDtCompra().getTime()));
                stmt.setDouble(5, produto.getValorCompra());
                stmt.setDouble(6, produto.getValorVenda());
                stmt.setInt(7, produto.getId());

                stmt.executeUpdate();

            }

            // conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public Produto getById(Integer id) {
        Produto produto = new Produto();

        try {

            String QUERY_DETALHE = "select * from Produto where idproduto = ?";
            PreparedStatement stmt = null;
            Connection conn = Conexao.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                produto.setId(rs.getInt("idproduto"));
                produto.setNome(rs.getString("nome"));
                produto.setFornecedor(rs.getString("fornecedor"));
                produto.setQtde(rs.getInt("quantidade"));
                produto.setDtCompra(rs.getDate("dtCompra"));
                produto.setValorCompra(rs.getDouble("valorCompra"));
                produto.setValorVenda(rs.getDouble("valorVenda"));

            }
            // conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();
            produto = null;

        }

        return produto;
    }

    public List<Produto> getAll() {
        List<Produto> lista = new ArrayList<Produto>();
        try {
            String QUERY_DETALHE = "select * from produto";
            PreparedStatement stmt = null;
            Connection conn = Conexao.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("idproduto"));
                produto.setNome(rs.getString("nome"));
                produto.setFornecedor(rs.getString("fornecedor"));
                produto.setQtde(rs.getInt("quantidade"));
                produto.setDtCompra(rs.getDate("dtCompra"));
                produto.setValorCompra(rs.getDouble("valorCompra"));
                produto.setValorVenda(rs.getDouble("valorVenda"));
                lista.add(produto);
            }
            //  conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

            return lista;

        }
    }

    public void excluir(Produto produto) {

        try {
            PreparedStatement stmt = null;
            Connection conn = Conexao.getConnection();

            String QUERY_DELETE = "delete from produto where idproduto = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, produto.getId());

            stmt.executeUpdate();
            //   conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        }
    }
}
