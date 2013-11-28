/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess;

import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.Produto;
import java.sql.Date;
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
                PreparedStatement sql = getConexao().prepareStatement("insert into produto(nome,preco,datavencimento,fornecedor) values(?,?,?,?,?)");
                sql.setString(1, obj.getNome());
                sql.setDouble(2, obj.getPreco());
                sql.setDate(3, (Date) obj.getDatavencimento());
                sql.setInt(4, obj.getFornecedor());

                sql.executeUpdate();


                PreparedStatement sql2 = getConexao().prepareStatement("select codProduto from Produto where nome= ? and preco=? and tipo=?");
                sql2.setString(1, obj.getNome());
                sql2.setDouble(2, obj.getPreco());
                sql2.setDate(3, (Date) obj.getDatavencimento());
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
                //sql.setDate(2, new java.sql.Date( obj.getDataNascimento().getTime() ));
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
            PreparedStatement sql = getConexao().prepareStatement("select * from produto where codProduto=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Produto obj = new Produto();

                obj.setCodigo(resultado.getInt("codProduto"));
                obj.setPreco((float) resultado.getDouble("preco"));
                obj.setNome(resultado.getString("nome"));
                obj.setDatavencimento(resultado.getDate("DataVencimento"));
                obj.setFornecedor(resultado.getInt("CodForncedor"));
               


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
            PreparedStatement sql = getConexao().prepareStatement("select * from produto");

            ResultSet resultado = sql.executeQuery();

            List<Produto> lista = new ArrayList<Produto>();

            while (resultado.next()) {
                Produto obj = new Produto();

                obj.setCodigo(resultado.getInt("codProduto"));
                obj.setNome(resultado.getString("nome"));
               obj.setDatavencimento(resultado.getDate("DataVencimento"));
                obj.setFornecedor(resultado.getInt("CodForncedor"));

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
            PreparedStatement sql = getConexao().prepareStatement("select * from Produto");

            ResultSet resultado = sql.executeQuery();

            List<Produto> lista = new ArrayList<Produto>();

            while (resultado.next()) {
                Produto obj = new Produto();

                obj.setCodigo(resultado.getInt("CodProduto"));
                obj.setNome(resultado.getString("Nome"));
                obj.setPreco(resultado.getFloat("Preco"));
                obj.setDatavencimento(resultado.getDate("DataVencimento"));
                obj.setFornecedor(resultado.getInt("CodForncedor"));


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
            
            if(filtro.getNome().length() > 0){
                where = "Descricao like '%"+filtro.getNome()+"%'";
            }
            
            if (filtro.getPreco() > 0) {
                if(where.length() > 0)
                    where = where + " and ";
                where = where + " Preco = " + filtro.getPreco();
            }
            if (filtro.getCodigo() > 0) {
                if(where.length() > 0)
                    where = where + " and ";
                where = where + " id = " + filtro.getCodigo();
            }
            
            if(where.length() > 0){
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
                tmp.setDatavencimento(resultado.getDate("DataVencimento"));
                tmp.setFornecedor(resultado.getInt("CodForncedor"));
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
