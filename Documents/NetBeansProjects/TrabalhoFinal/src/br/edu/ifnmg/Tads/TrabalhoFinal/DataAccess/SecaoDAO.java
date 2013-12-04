/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess;

import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.Secao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Jessica
 */
public class SecaoDAO extends DAO {

    //Construtor
    public SecaoDAO() {
        super();
    }

    //Salvar Sessão
    public boolean Salvar(Secao obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sqlInsert = getConexao().prepareStatement("insert into secao(DataInicial,DataFinal,saldoInicial,SaldoFinal,codCaixa,codUsuario) values(?,?,?,?,?,?)");

                sqlInsert.setDate(1, new java.sql.Date(obj.getIniciosecao().getTime()));
                sqlInsert.setDate(2, new java.sql.Date(obj.getFinalsecao().getTime()));
                sqlInsert.setDouble(3, obj.getSaldoinicial());
                sqlInsert.setDouble(4, obj.getSaldofinal());
                sqlInsert.setInt(5, obj.getCaixa().getCodigo());
                sqlInsert.setInt(6, obj.getUsuario().getCodigo());
                sqlInsert.executeUpdate();

                PreparedStatement sqlConsulta = getConexao().prepareStatement("select codSessao from Secao where DataInicial=? and DataFinal=? and saldoInicial=?  and SaldoFinal and codUsuario=? and codCaixa=?");
                sqlConsulta.setDate(1, new java.sql.Date(obj.getIniciosecao().getTime()));
                sqlConsulta.setDate(2, new java.sql.Date(obj.getFinalsecao().getTime()));
                sqlConsulta.setDouble(2, obj.getSaldoinicial());
                sqlConsulta.setDouble(4, obj.getSaldofinal());
                sqlConsulta.setInt(3, obj.getUsuario().getCodigo());
                sqlConsulta.setInt(4, obj.getCaixa().getCodigo());

                ResultSet resultado = sqlConsulta.executeQuery();

                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codSecao"));
                }

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Secao set DataInicial=?,DataFinal=?, SaldoFinal, saldoFinal=? where codSecao=?");
                sql.setDate(1, new java.sql.Date(obj.getFinalsecao().getTime()));
                sql.setDouble(2, obj.getSaldofinal());
                sql.setInt(3, obj.getCodigo());
                sql.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }

    public boolean Remover(Secao obj) {
        if (obj.getCodigo() >= 0) {
            try {
                PreparedStatement sqlDelete = getConexao().prepareStatement("delete from Secao where codSecao=?");
                sqlDelete.setInt(1, obj.getCodigo());
                sqlDelete.executeUpdate();
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }
}
