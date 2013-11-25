/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess;

import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.Produto;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    }//salvar
}
