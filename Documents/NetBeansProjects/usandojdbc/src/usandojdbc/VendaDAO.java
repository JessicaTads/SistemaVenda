/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usandojdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jessica
 */
public class VendaDAO extends DAO {

    public VendaDAO() {
        super();
    }

    public boolean Salvar(Venda obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into Venda(CodPessoa,CodItemVenda, Data,ValorTotal) values(?,?,?)");
                sql.setDate(1, new java.sql.Date(obj.getData().getTime()));
                sql.setFloat(2, obj.getValorTotal());
                sql.setInt(3, obj.getCodigo());
                sql.executeUpdate();

                PreparedStatement sql2 = getConexao().prepareStatement("select codVenda from Venda where Data = ?  and  ValorTotal= ? ");
                sql2.setDate(1, new java.sql.Date(obj.getData().getTime()));
                sql2.setFloat(2, obj.getValorTotal());
                ResultSet resultado = sql2.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("CodVenda"));
                }
                for (ItemVenda e : obj.getItemVenda()) {
                    SalvarItemVenda(obj, e);
                }
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Venda set Data=?, ValorTotal? where CodVenda=?");
                sql.setDate(1, new java.sql.Date(obj.getData().getTime()));
                sql.setFloat(2, obj.getValorTotal());
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        
    }
    
    private void SalvarItemVenda(Venda venda, ItemVenda obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into ItemVenda (CodVenda,CodProduto, Quantidade) values(?,?,?)");
                sql.setInt(1, venda.getCodigo());
                sql.setInt(3, obj.getQuantidade());
                sql.executeUpdate();


            } catch (Exception ex) {
                System.err.println(ex.getMessage());

            }

        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Venda = ?, Quantidade= ? where CodItemVenda=?");
                sql.setInt(1, obj.getCodigo());
                sql.setInt(2, obj.getQuantidade());
                sql.executeUpdate();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }

        }
    }
    
    
     public List<Venda> ListarTodas() {

        try {

            java.sql.PreparedStatement sql = getConexao().prepareStatement("select * from Venda");

            ResultSet resultado = sql.executeQuery();

            List<Venda> lista = new ArrayList<Venda>();

            while (resultado.next()) {

                Venda obj = new Venda();

                obj.setCodigo(resultado.getInt("CodVenda"));
                obj.setValorTotal(resultado.getFloat("ValorTotal"));
                lista.add(obj);

            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }


    }
    
    
    
    
    
    
}
