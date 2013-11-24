/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel;

import br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess.PessoaDAO;
import java.util.Date;

/**
 *
 * @author Jessica
 */
public class Principal {

    public static void main(String[] args) throws Exception {

        Pessoa pessoa = new Pessoa();
        Email email = new Email();
        Endereco endereco = new Endereco();
        Telefone telefone = new Telefone();


        pessoa.setNome("Paula");
        pessoa.setDataNascimento(new Date());
        pessoa.setCPF("");
        pessoa.setRG("");
        email.setEmail("Paula@yahoo.com");
        endereco.setBairro("Real");
        endereco.setCidade("Minas ");
        endereco.setRua("Rua c");
        endereco.setNumero(678);
        telefone.setDDD(38);
        telefone.setTelefone(91615777);


        pessoa.addEmail(email);
        pessoa.addEndereco(endereco);
        pessoa.addTelefone(telefone);

        PessoaDAO dao = new PessoaDAO();

        dao.Salvar(pessoa);






    }
}
