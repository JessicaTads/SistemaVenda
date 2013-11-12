/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SistemaVendas.DataAccess;

import br.edu.ifnmg.tads.SistemaVendas.DomainModel.Email;
import br.edu.ifnmg.tads.SistemaVendas.DomainModel.Endereco;
import br.edu.ifnmg.tads.SistemaVendas.DomainModel.Pessoa;
import br.edu.ifnmg.tads.SistemaVendas.DomainModel.Telefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

                PreparedStatement sql2 = getConexao().prepareStatement("select CodPessoa from pessoa where Nome = ? and DataNascimento = ?");
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
                PreparedStatement sql = con.prepareStatement("update pessoa set Nome=?, DataNascimento=? where CodPessoa=?");
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
                sql.setInt(6, obj.getCEP());
                sql.setString(7,obj.getEstado());
                sql.setString(8, obj.getPais());
                sql.executeUpdate();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update endereco set codPessoa=?, numero=?, rua=?, bairro=?,cidade=?, cep =?, estado =?, pais = ? where codEndereco = ?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getNumero());
                sql.setString(3, obj.getRua());
                sql.setString(4, obj.getBairro());
                sql.setString(5, obj.getCidade());
                sql.setInt(6, obj.getCEP());
                sql.setString(7,obj.getEstado());
                sql.setString(8, obj.getPais());
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
                PreparedStatement sql = getConexao().prepareStatement("insert into telefone(codPessoa,DDD, Numero) values(?,?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getDDD());
                sql.setInt(3, obj.getNumero()); 
                sql.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update telefone set codPessoa = ?, DDD= ?, Numero = ? where codTelefone=?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getDDD());
                sql.setInt(3, obj.getNumero());
                sql.setInt(3, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
  
   public boolean Remover(Pessoa obj) {
        if (obj.getCodigo() >= 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("delete from pessoa where codPessoa=?");
                sql.setInt(1, obj.getCodigo());
                sql.setDate(2, new java.sql.Date( obj.getDataNascimento().getTime() ));
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
            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa where codPessoa=?");
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

                obj.setCodigo(resultado.getInt("codPessoa"));
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
   
    public List<Pessoa> buscar(Pessoa filtro) throws Exception {
        try {

            String sql = "select * from pessoa ";
            String where = "";

            if (filtro.getNome().length() > 0) {
                where = "nome like '%" + filtro.getNome() + "%'";
            }

            /* if (filtro.getValor() > 0) {
             if(where.length() > 0) 
             where = where + " and ";
             where = where + " valor = " + filtro.getValor();
             }*/
            if (filtro.getDataNascimento() != null) {
                if (where.length() > 0) {
                    where += "and";
                    where = where + " dataNascimento= " + filtro.getDataNascimento();

                }
            }
                if (filtro.getCodigo() > 0) {
                    if (where.length() > 0) {
                        where = where + " and ";
                        where = where + " CodPessoa = " + filtro.getCodigo();
                    }
                }

                if (where.length() > 0) {
                    sql = sql + " where " + where;
                }

                Statement comando = getConexao().createStatement();

                ResultSet resultado = comando.executeQuery(sql);
                // Cria uma lista de produtos vazia
                List<Pessoa> pessoas = new LinkedList<>();
                while (resultado.next()) {
                    // Inicializa um objeto de produto vazio
                    Pessoa tmp = new Pessoa();
                    // Pega os valores do retorno da consulta e coloca no objeto
                    tmp.setCodigo(resultado.getInt("codPessoa"));
                    tmp.setNome(resultado.getString("nome"));
                    tmp.setDataNascimento(resultado.getDate("dataNascimento"));
                    //tmp.setValor(resultado.getDouble("valor"));
                    // Pega o objeto e coloca na lista
                    pessoas.add(tmp);
                }
                return pessoas;
            }  catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }


    }
   
   
   
}