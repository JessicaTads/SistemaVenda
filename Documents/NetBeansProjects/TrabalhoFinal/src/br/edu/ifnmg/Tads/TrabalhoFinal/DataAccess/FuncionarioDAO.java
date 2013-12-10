/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess;

import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jessica
 */
public class FuncionarioDAO extends PessoaDAO{

    private DAO bd;

    public FuncionarioDAO() {
        super();
        bd = new DAO();
    }
     
     public boolean Salvar(Funcionario obj) {
        if (obj.getCodigo() == 0) {
            super.Salvar(obj);

            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into Funcionarios(especialidade,Codpessoa,Ativo) values(?,?,?)");
                sql.setString(1, obj.getEspecialidade());
                sql.setInt(2, obj.getCodigo());
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
                PreparedStatement sql = con.prepareStatement("update Funcionarios set especialidade=? where CodPessoa=? Ativo=?");

                sql.setString(1, obj.getEspecialidade());
                sql.setInt(2, obj.getCodigo());
                sql.setInt(3, obj.getAtivo());

                sql.executeUpdate();

                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }
     
    /*  public Funcionario AbrirFuncionario(int id) {
        try {
            Funcionario funcionario = new Funcionario();

            super.AbrirPessoa(funcionario, id);

            //Seleciona o funcionario e armazena em 'resultado'
            PreparedStatement sql = getConexao().prepareStatement("select * from Funcionario where IdPessoa=?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();



            if (resultado.next()) {

                //funcionario.setCargo(CargoDAO.AbrirCargo(resultado.getInt("IdCargo")));
                
                return funcionario;
            } else {
                return null;
            }


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
      */

    public List<Funcionario> buscar(Funcionario filtro) {
        try {

            String sql = "select * from pessoa p join funcionarios f on p.CodPessoa = f.CodPessoa where ativo = 1 ";
            String where = "";

            if (filtro.getNome().length() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = "and nome like '%" + filtro.getNome() + "%'";
            }

            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " Codpessoa = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + where;
            }

            Statement comando = bd.getConexao().createStatement();

            ResultSet resultado = comando.executeQuery(sql);

            // Cria uma lista de produtos vazia
            List<Funcionario> funcionarios = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                Funcionario tmp = new Funcionario();
                // Pega os valores do retorno da consulta e coloca no objeto

                try {

                    tmp.setCodigo(resultado.getInt("CodPessoa"));
                    

                } catch (Exception ex) {
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Pega o objeto e coloca na lista
                funcionarios.add(tmp);
            }
            return funcionarios;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
     
    
    
    
    
}
