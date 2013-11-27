/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess;

import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Jessica
 */
public class FuncionarioDAO extends PessoaDAO{
    
   
    
     public FuncionarioDAO() {
        super();
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
    }*/
     
    
    
    
    
}
