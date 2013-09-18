/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usandojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jessica
 */
public class DAO {

    private Connection conexao;

    public DAO() {
        try {
            //Carrega Driver
            Class.forName("com.mysql.jdbc.Driver");
            //Cria Conexao
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    public Connection getConexao() {
        return conexao;
    }
}
