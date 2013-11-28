/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess;

import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.Cliente;
import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Jessica
 */
public class FornecedorDAO extends DAO {

    private DAO bd;

    public FornecedorDAO() {

        super();

    }

    public boolean Salvar(Fornecedor obj) {
        if (obj.getCodigo() == 0) {
            super.Salvar(obj);

            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into Forncedores(ativo,codpessoa,CNPJ) values(?,?,?)");
                sql.setInt(1, obj.getCodigo());
                sql.setString(2, obj.getCNPJ());
                sql.setInt(3, obj.getAtivo());


                sql.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                super.Salvar(obj);
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Clientes set  Ativo=? where CodPessoa=?");
                sql.setInt(1, obj.getAtivo());
                sql.setInt(2, obj.getCodigo());

                sql.executeUpdate();

                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }
}
