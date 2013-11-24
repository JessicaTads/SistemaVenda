/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess;

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
                PreparedStatement sql = getConexao().prepareStatement("insert into pessoa(Nome,DataNasc,CPF,RG,ativo) values(?,?,?,?,?)");
                sql.setString(1, obj.getNome());
                sql.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
                sql.setString(3, obj.getCPF());
                sql.setString(4, obj.getRG());
                sql.setInt(5, 1);

                sql.executeUpdate();

                PreparedStatement sql2 = getConexao().prepareStatement("select CodPessoa from pessoa where Nome = ? and DataNasc = ? and CPF = ? and RG = ?");
                sql2.setString(1, obj.getNome());
                sql2.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
                sql2.setString(3, obj.getCPF());
                sql2.setString(4, obj.getRG());
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
                PreparedStatement sql = con.prepareStatement("update pessoa set Nome=?, DataNasc=?, RG=?, CPF=? where CodPessoa=?");
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
                PreparedStatement sql = getConexao().prepareStatement("insert into email(codPessoa,email,ativo) values(?,?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setString(2, obj.getEmail());
                sql.setInt(3, 1);
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
                PreparedStatement sql = getConexao().prepareStatement("insert into enderecos(codPessoa,numero,rua,bairro,cidade,ativo) values(?,?,?,?,?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getNumero());
                sql.setString(3, obj.getRua());
                sql.setString(4, obj.getBairro());
                sql.setString(5, obj.getCidade());
                sql.setInt(6, 1);
                sql.executeUpdate();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update enderecos set codPessoa=?, numero=?, rua=?, bairro=?,cidade=?  where codEndereco = ?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getNumero());
                sql.setString(3, obj.getRua());
                sql.setString(4, obj.getBairro());
                sql.setString(5, obj.getCidade());
                sql.setInt(6, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    private void SalvarTelefone(Pessoa pessoa, Telefone obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into telefones(codPessoa, DDD, telefone,ativo) values(?,?,?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getDDD());
                sql.setInt(3, obj.getTelefone());
                sql.setInt(4, 1);
                sql.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update telefones set codPessoa = ?, DDD= ?, Telefone = ? where codTelefone=?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getDDD());
                sql.setInt(3, obj.getTelefone());
                sql.setInt(4, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
