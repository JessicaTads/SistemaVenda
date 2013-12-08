/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess;

import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.Agendamento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author Jessica
 */
public class AgendamentoDAO extends DAO {

    private DAO bd;

    public AgendamentoDAO() {
        super();
        bd = new DAO();
    }
    
    /* public boolean Salvar(Agendamento obj){
        if (obj.getCodigo() == 0) {
            super.Salvar(obj);

            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into Agendamento(horario,data,CodCliente,CodFuncionario) values(?,?,?,?)");
                sql.setTime(1, obj.getHorario());
                sql.setDate(1, new java.sql.Date(obj.getData().getTime());
                sql.setInt(3, obj.getCodigo());

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
                PreparedStatement sql = con.prepareStatement("update Fornecedores set CNPJ=?, ATIVO=? where CodPessoa=?");

                sql.setString(1, obj.getCNPJ());
                sql.setInt(2, obj.getAtivo());
                sql.setInt(3, obj.getCodigo());

                sql.executeUpdate();

                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }*/
    }
    
    
    

