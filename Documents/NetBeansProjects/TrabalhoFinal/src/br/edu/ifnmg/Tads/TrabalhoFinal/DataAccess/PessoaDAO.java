/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess;

import br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess.DAO;
import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.Email;
import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.Endereco;
import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.Pessoa;
import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.Telefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Jessica
 */
public class PessoaDAO extends DAO {

    private DAO bd;

    public PessoaDAO() {
        super();
        bd = new DAO();
    }

    public boolean Salvar(Pessoa obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into pessoa(Nome,DataNasc) values(?,?)");
                sql.setString(1, obj.getNome());
                sql.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));

                sql.executeUpdate();

                PreparedStatement sql2 = getConexao().prepareStatement("select CodPessoa from pessoa where Nome = ? and DataNasc = ?");
                sql2.setString(1, obj.getNome());
                sql2.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
                ResultSet resultado = sql2.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("CodPessoa"));
                }
                /*------- Salva o email ---------------------------------------*/
                for (Email e : obj.getEmails()) {
                    SalvarEmail(obj, e);
                }
                for (Endereco e : obj.getEnderecos()) {
                    SalvarEndereco(obj, e);
                }
                // Salva o Telefone
                for (Telefone e : obj.getTelefones()) {
                    SalvarTelefone(obj, e);
                }

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update pessoa set Nome=?, DataNasc=? where CodPessoa=?");
                sql.setString(1, obj.getNome());
                sql.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
                sql.setInt(3, obj.getCodigo());
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }

    private void SalvarEmail(Pessoa pessoa, Email obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into email(codPessoa,email) values(?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setString(2, obj.getEmail());
                sql.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update email set codPessoa = ?, email = ? where codEmail= ?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setString(2, obj.getEmail());
                sql.setInt(3, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    private void SalvarEndereco(Pessoa pessoa, Endereco obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into endereco(codPessoa,numero,rua,bairro,cidade,cep,estado,pais) values(?,?,?,?,?,?,?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getNumero());
                sql.setString(3, obj.getRua());
                sql.setString(4, obj.getBairro());
                sql.setString(5, obj.getCidade());
                sql.executeUpdate();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update endereco set codPessoa=?, numero=?, rua=?, bairro=?,cidade=?  where codEndereco = ?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getNumero());
                sql.setString(3, obj.getRua());
                sql.setString(4, obj.getBairro());
                sql.setString(5, obj.getCidade());
                sql.setInt(9, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    private void SalvarTelefone(Pessoa pessoa, Telefone obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into telefone(codPessoa, DDD, telefone) values(?,?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getDDD());
                sql.setInt(3, obj.getTelefone());
                sql.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update telefone set codPessoa = ?, DDD= ?, Telefone = ? where codTelefone=?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getDDD());
                sql.setInt(3, obj.getTelefone());
                sql.setInt(3, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
