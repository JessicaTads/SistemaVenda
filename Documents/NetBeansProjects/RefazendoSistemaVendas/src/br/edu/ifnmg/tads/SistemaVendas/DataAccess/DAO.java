/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SistemaVendas.DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jessica
 */
public class DAO {
    private Connection conexao;

    public DAO()
    {
        try
        {
         
            Class.forName("com.mysql.jdbc.Driver");
            
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/sistemavenda", "root", "");
        }
        catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }

    }

    public Connection getConexao()
    {
        return conexao;
    }
    
}
