/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess;

import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.Caixa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Jessica
 */
public class CaixaDAO extends DAO{
    
   
    public CaixaDAO() {
        super();
    }
    
    public Caixa AbrirCaixa(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement
                    ("select * from caixa where codCaixa=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Caixa caixa = new Caixa();

                caixa.setCodigo(resultado.getInt("codCaixa"));
                caixa.setSaldo(resultado.getFloat("saldo"));
                
                return caixa;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    
    
    
    
}
