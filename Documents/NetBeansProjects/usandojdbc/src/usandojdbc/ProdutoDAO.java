/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usandojdbc;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jessica
 */
public class ProdutoDAO extends DAO {

    public ProdutoDAO() {
        super();
    }

    public boolean Salvar(Produto obj) {
        if (obj.getCodigo() == 0) {
            try {
                java.sql.PreparedStatement sql = getConexao().prepareStatement("insert into produto(Descricao,Preco) values(?,?)");
                sql.setString(1, obj.getDescricao());
                sql.setFloat(2, obj.getPreco());
                sql.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }

        } else {
            try {
                Connection con = getConexao();
                java.sql.PreparedStatement sql = con.prepareStatement("update Produto set Descricao=?, Preco=? where CodProduto=?");
                sql.setInt(1, obj.getCodigo());
                sql.setString(2, obj.getDescricao());
                sql.setFloat(3, obj.getPreco());
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }

    public boolean Remover(Produto obj) {
        if (obj.getCodigo() >= 0) {
            try {
                java.sql.PreparedStatement sql = getConexao().prepareStatement("delete from produto where CodProduto=?");
                sql.setInt(1, obj.getCodigo());
                sql.setString(2, obj.getDescricao());
                sql.setFloat(3, obj.getPreco());
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return true;
    }
    
    
    public Produto Abrir(int Codigo) {
        try {
            java.sql.PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa where CodProduto=?");
            sql.setInt(1, Codigo);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Produto obj = new Produto();

                obj.setCodigo(resultado.getInt("CodProduto"));
                obj.setDescricao(resultado.getString("Descricao"));
                obj.setPreco(resultado.getFloat("Preco"));

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

            java.sql.PreparedStatement sql = getConexao().prepareStatement("select * from Produto");

            ResultSet resultado = sql.executeQuery();

            List<Produto> lista = new ArrayList<Produto>();

            while (resultado.next()) {

                Produto obj = new Produto();

                obj.setCodigo(resultado.getInt("CodProduto"));
                obj.setDescricao(resultado.getString("Descricao"));
                obj.setPreco(resultado.getFloat("Preco"));

                lista.add(obj);

            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }


    }
    
    
}
