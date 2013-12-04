/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess;

import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jessica
 */
public class UsuarioDAO extends DAO{
  
    
    public UsuarioDAO(){
        super();
    }
   
    public boolean Salvar(Usuario obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement
                        ("insert into usuarios(login,senha,CodFuncionario,Ativo) values(?,?,?,?)");
                sql.setString(1, obj.getLogin());
                sql.setString(2, obj.getSenha());
                sql.setInt(3, obj.getFuncionario().getCodigo());
                sql.setInt(4, obj.getAtivo());
                sql.executeUpdate();

                //Pega a chave primária que foi gerada no banco de dados
                PreparedStatement sqlConsulta = getConexao().prepareStatement
                        ("select IdUsuario from Usuarios where login = ? and senha = ? and CodPessoa = ? and Ativo = ?");
                sqlConsulta.setString(1, obj.getLogin());
                sqlConsulta.setString(2, obj.getSenha());
                sqlConsulta.setInt(4, obj.getAtivo());
                sqlConsulta.setInt(3, obj.getFuncionario().getCodigo());

                ResultSet resultado = sqlConsulta.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("IdUsuario"));
                }
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                
                Connection con = getConexao();
                PreparedStatement sqlUpdate = con.prepareStatement("update Usuarios set login=?, senha=? where CodUsuario=? and CodPessoa=?");
                sqlUpdate.setString(1, obj.getLogin());
                sqlUpdate.setString(2, obj.getSenha());
                sqlUpdate.setInt(3, obj.getCodigo());
                sqlUpdate.setInt(4, obj.getAtivo());
                sqlUpdate.setInt(4, obj.getFuncionario().getCodigo());

                sqlUpdate.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }
    
    
    
    
}
