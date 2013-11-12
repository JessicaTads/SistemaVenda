/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SistemaVendas.DataAccess;

import br.edu.ifnmg.tads.SistemaVendas.DomainModel.ItemVenda;
import br.edu.ifnmg.tads.SistemaVendas.DomainModel.Pessoa;
import br.edu.ifnmg.tads.SistemaVendas.DomainModel.Produto;
import br.edu.ifnmg.tads.SistemaVendas.DomainModel.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jessica
 */
public class VendaDAO extends DAO {
    
    public VendaDAO(){
        super();
    }
   
        public boolean SalvarVenda(Venda obj){
        Pessoa pessoa = new Pessoa();
        pessoa = obj.getPessoa();
        if (obj.getCodigo() == 0) {
            try {
                //Salvar(obj.getPessoa());
                PreparedStatement sql = getConexao().prepareStatement("insert into venda(codPessoa,valortotal,data) values(?,?,?)");

                sql.setInt(1, pessoa.getCodigo());
                sql.setDouble(2, obj.getValorTotal());
                sql.setDate(3, new java.sql.Date(obj.getData().getTime()));
                sql.executeUpdate();


                PreparedStatement sql2 = getConexao().prepareStatement("select codVenda from venda where valortotal= ? and data= ?");
                sql2.setDouble(1, obj.getValorTotal());
                sql2.setDate(2, new java.sql.Date(obj.getData().getTime()));
                ResultSet resultado = sql2.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codVenda"));
                }
                for (ItemVenda e : obj.getItemVendas()) {
                    SalvarItemVenda(obj, e);
                }
               
                // Salvar(obj.getPessoa());
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                // Salvar(obj.getPessoa());
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update venda set codPessoa=?, data=? , valor=? where codVenda=?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setDouble(3, obj.getValorTotal());
                sql.setDate(2, new java.sql.Date(obj.getData().getTime()));
                sql.setDouble(4, obj.getCodigo());

                 
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }

    }//*****
    
    private void SalvarItemVenda(Venda venda, ItemVenda obj){
       
         Produto produto;
        produto = new Produto();
                
         produto=obj.getProduto();
        
         
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into itemvenda(codVenda,codProduto, quantidade) values(?,?,?)");
                sql.setInt(1, venda.getCodigo());
                sql.setInt(2, produto.getCodigo());
                sql.setInt(3, obj.getQuantidade());
                sql.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update ItemVenda set  codProduto = ? ,quantidade = ? where codItemVenda = ?");
                //sql.setInt(1, venda.getCodigo());
                sql.setInt(1, produto.getCodigo());
                sql.setInt(2, obj.getQuantidade());
                sql.setInt(3, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    
    public List<Venda> ListarVendas() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Venda");

            ResultSet resultado = sql.executeQuery();

            List<Venda> lista = new ArrayList<Venda>();

            while (resultado.next()) {
                Venda obj = new Venda();

                obj.setCodigo(resultado.getInt("codVenda"));
                obj.setValorTotal(resultado.getDouble("valor"));
                obj.setData(resultado.getDate("data"));



                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    
    
}
