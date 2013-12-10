/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess;

import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jessica
 */
public class ProdutoDAO extends DAO {

    public ProdutoDAO() {

        super();

    }

    public boolean SalvarProduto(Produto obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into produtos(nome,preco,descricao,CodFornecedor) values(?,?,?,?)");
                sql.setString(1, obj.getNome());
                sql.setDouble(2, obj.getPreco());
                sql.setString(3, obj.getDescricao());
                sql.setInt(4, obj.getFornecedor());

                sql.executeUpdate();


                PreparedStatement sql2 = getConexao().prepareStatement("select codProduto from Produtos where nome= ? and preco=? and descricao=? and CodFornecedor=?");
                sql2.setString(1, obj.getNome());
                sql2.setDouble(2, obj.getPreco());
                sql2.setString(3, obj.getDescricao());
                sql2.setInt(4, obj.getFornecedor());



                ResultSet resultado = sql2.executeQuery();

                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codProduto"));
                }

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;

    }//

    public boolean Remover(Produto obj) {
        if (obj.getCodigo() >= 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("delete from produto where codProduto=?");
                sql.setInt(1, obj.getCodigo());

                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return true;
    }

    public Produto Abrir(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from produtos where codProduto=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Produto obj = new Produto();

                obj.setCodigo(resultado.getInt("codProduto"));
                obj.setPreco((float) resultado.getDouble("preco"));
                obj.setNome(resultado.getString("nome"));
                obj.setDescricao(resultado.getString("Descricao"));
                obj.setFornecedor(resultado.getInt("CodFornecedor"));



                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public List<Produto> ListarTodos() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from produtos");

            ResultSet resultado = sql.executeQuery();

            List<Produto> lista = new ArrayList<Produto>();

            while (resultado.next()) {
                Produto obj = new Produto();

                obj.setCodigo(resultado.getInt("codProduto"));
                obj.setNome(resultado.getString("nome"));
                obj.setDescricao(resultado.getString("descricao"));
                obj.setFornecedor(resultado.getInt("CodFornecedor"));

                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public List<Produto> ListarProdutos() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Produtos");

            ResultSet resultado = sql.executeQuery();

            List<Produto> lista = new ArrayList<Produto>();

            while (resultado.next()) {
                Produto obj = new Produto();

                obj.setCodigo(resultado.getInt("CodProduto"));
                obj.setNome(resultado.getString("Nome"));
                obj.setPreco(resultado.getFloat("Preco"));
                obj.setDescricao(resultado.getString("descricao"));
                obj.setFornecedor(resultado.getInt("CodFornecedor"));


                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public List<Produto> buscar(Produto filtro) throws ErroValidacaoException, Exception {
        try {

            String sql = "select * from produtos ";
            String where = "";

            if (filtro.getNome().length() > 0) {
                where = "Descricao like '%" + filtro.getNome() + "%'";
            }

            if (filtro.getPreco() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " Preco = " + filtro.getPreco();
            }
            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " id = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + " where " + where;
            }

            Statement comando = getConexao().createStatement();

            ResultSet resultado = comando.executeQuery(sql);
            // Cria uma lista de produtos vazia
            List<Produto> produtos = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                Produto tmp = new Produto();
                // Pega os valores do retorno da consulta e coloca no objeto
                //tmp.setCodigo(resultado.getInt("Codigo"));
                tmp.setNome(resultado.getString("Nome"));
                tmp.setPreco(resultado.getFloat("Preco"));
                tmp.setDescricao(resultado.getString("descricao"));
                tmp.setFornecedor(resultado.getInt("CodFornecedor"));
                // Pega o objeto e coloca na lista
                produtos.add(tmp);
            }
            return produtos;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
