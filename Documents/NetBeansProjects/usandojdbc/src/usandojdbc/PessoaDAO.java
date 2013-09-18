/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usandojdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jessica
 */
public class PessoaDAO extends DAO {

    public PessoaDAO() {
        super();
    }

    public boolean Salvar(Pessoa obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into pessoa(Nome,DataNascimento) values(?,?)");
                sql.setString(1, obj.getNome());
                sql.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
                sql.executeUpdate();
                return true;

                for (Email e : obj.getEmails()) {
                    SalvarEmail(obj, e);
                }
                for (Telefone e : obj.getTelefones()) {
                    SalvarTelefone(obj, e);
                }

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Pessoa set Nome=?, DataNascimento=? where codigo=?");
                sql.setInt(3, obj.getCodigo());
                sql.setString(1, obj.getNome());
                sql.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));

                sql.executeUpdate();
                return true;
                
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }

    private void SalvarEmail(Email obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into Emails (pessoa, email) values(?,?)");
                sql.setString(2, obj.getEmail());
                sql.executeUpdate();


            } catch (Exception ex) {
                System.err.println(ex.getMessage());

            }

        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Pessoa = ?, Email= ? where codigo=?");
                sql.setInt(3, obj.getCodigo());
                sql.setString(1, obj.getEmail());
                sql.executeUpdate();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }

        }
    }
        
    

    public boolean Remover(Pessoa obj) {
        if (obj.getCodigo() >= 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("delete from pessoa where codigo=?");
                sql.setInt(1, obj.getCodigo());
                sql.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return true;
    }

    public Pessoa Abrir(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa where codigo=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Pessoa obj = new Pessoa();

                obj.setCodigo(resultado.getInt("codPessoa"));
                obj.setNome(resultado.getString("Nome"));
                obj.setDataNascimento(resultado.getDate("DataNascimento"));

                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public List<Pessoa> ListarTodos() {

        try {

            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa");

            ResultSet resultado = sql.executeQuery();

            List<Pessoa> lista = new ArrayList<Pessoa>();

            while (resultado.next()) {

                Pessoa obj = new Pessoa();

                obj.setCodigo(resultado.getInt("codigo"));
                obj.setNome(resultado.getString("Nome"));
                obj.setDataNascimento(resultado.getDate("DataNascimento"));

                lista.add(obj);

            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }


    }

     private void SalvarTelefone(Pessoa obj1, Telefone obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into Telefones (pessoa, telefones) values(?,?)");
                sql.setInt(2, obj.getTelefone());
                sql.executeUpdate();


            } catch (Exception ex) {
                System.err.println(ex.getMessage());

            }

        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Pessoa = ?, Telefone= ? where codigo=?");
                sql.setInt(3, obj.getCodigo());
                sql.setInt(1, obj.getTelefone());
                sql.executeUpdate();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }

        }
    }

    
}
