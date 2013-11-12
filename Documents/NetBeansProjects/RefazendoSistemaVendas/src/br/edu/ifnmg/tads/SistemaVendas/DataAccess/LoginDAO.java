/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SistemaVendas.DataAccess;

import br.edu.ifnmg.tads.SistemaVendas.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.tads.SistemaVendas.DomainModel.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jessica
 */
public class LoginDAO extends DAO{
  
    
    public LoginDAO(){
        super();
    }
    
    public int Login(Usuario usuario){
        try {
            PreparedStatement comando;
            PreparedStatement sql = getConexao().prepareStatement("select * from usuario where usuario like ? and senha like password(?) and status = 1");
            sql.setString(1, usuario.getNomeUsuario());
            sql.setString(2, usuario.getSenhaUsuario());
            ResultSet resultado = sql.executeQuery();
            resultado.first();
            Usuario usuariologado = new Usuario();
            usuario.setNomeUsuario(resultado.getString("usuario"));
            usuario.setCodusuario(resultado.getInt("codusuario"));
            return 1;
        } catch (SQLException | ErroValidacaoException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
    }
            
            
            
}
