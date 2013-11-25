/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess;

import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.Usuario;
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
   
    public int Usuario(Usuario usuario) throws Exception{
        try {
            PreparedStatement comando;
            PreparedStatement sql = getConexao().prepareStatement("select * from usuarios where usuario like ? and senha like password(?) and status = 1");
            sql.setString(1, usuario.getUsuario());
            sql.setString(2, usuario.getSenha());
            ResultSet resultado = sql.executeQuery();
            resultado.first();
            Usuario usuariologado = new Usuario();
            usuario.setLogin(resultado.getString("usuario"));
            usuario.setCodigo(resultado.getInt("codUsuario"));
            return 1;
        } catch (SQLException | ErroValidacaoException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
    }
    
    
    
    
}
