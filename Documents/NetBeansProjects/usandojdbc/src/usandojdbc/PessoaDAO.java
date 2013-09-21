/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usandojdbc;

import java.sql.Connection;
import java.sql.Date;
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

                PreparedStatement sql2 = getConexao().prepareStatement("select codPessoa from pessoa where nome = ? and DataNascimento = ?");
                sql2.setString(1, obj.getNome());
                sql2.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
                ResultSet resultado = sql2.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("CodPessoa"));
                }


                for (Email e : obj.getEmails()) {
                    SalvarEmail(obj, e);
                }

                for(Endereco e : obj.getEnderecos())
                 {
                 SalvarEndereco(obj, e);
                 }

                for (Telefone e : obj.getTelefones()) {
                    SalvarTelefone(obj, e);
                }
                for (Venda e : obj.getVendas()){
                    SalvarVenda(obj, e);
                }
                return true;


            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Pessoa set Nome=?, DataNascimento=? where CodPessoa=?");
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

    }

    private void SalvarEmail(Pessoa pessoa, Email obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into Emails (Codpessoa, email) values(?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setString(2, obj.getEmail());
                sql.executeUpdate();


            } catch (Exception ex) {
                System.err.println(ex.getMessage());

            }

        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Pessoa = ?, Email= ? where CodPessoa=?");
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
                PreparedStatement sql = getConexao().prepareStatement("delete from pessoa where CodPessoa=?");
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
            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa where CodPessoa=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Pessoa obj = new Pessoa();

                obj.setCodigo(resultado.getInt("CodPessoa"));
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

                obj.setCodigo(resultado.getInt("CodPessoa"));
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

    private void SalvarTelefone(Pessoa pessoa, Telefone obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into telefones(CodPessoa,telefone) values(?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getTelefone());
                sql.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update telefone set CodPessoa = ?, telefone = ? where CodTelefone = ?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getTelefone());

                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    
    private void SalvarEndereco(Pessoa pessoa, Endereco obj) {
        if (obj.getCodigo() == 0) {
            try
            {
                PreparedStatement sql = getConexao().prepareStatement("insert into enderecos(CodPessoa,numero,rua,bairro) values(?,?,?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getNumero());
                sql.setString(3, obj.getRua());
                sql.setString(4, obj.getBairro());
                sql.executeUpdate();
            }
            catch (Exception ex)
            {
                System.err.println(ex.getMessage());
            }
        }
        else {
            try{
                PreparedStatement sql = getConexao().prepareStatement("update enderecos set Codpessoa=?, numero=?, rua=?, bairro=? where CodEndereco = ?");
                sql.setInt(1, obj.getNumero());
                sql.setString(2, obj.getRua());
                sql.setString(3, obj.getBairro());
                sql.setInt(4, pessoa.getCodigo());
                sql.executeQuery();
            }
            catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    
    private void SalvarVenda(Pessoa pessoa, Venda obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into vendas(CodPessoa, Data, ValorTotal) values(?,?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setDate(2, (Date) obj.getData());
                sql.setFloat(3, obj.getValorTotal());
                sql.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update venda set CodPessoa = ?, Data = ?, ValorTotal = ?  where CodVenda = ?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setDate(2, new java.sql.Date(obj.getData().getTime()));

                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    
    
    
}
