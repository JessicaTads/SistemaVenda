/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel;

import br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess.PessoaDAO;
import br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess.UsuarioDAO;
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
        Usuario usuario = new Usuario();


        pessoa.setNome("Jefferson");
        pessoa.setDataNascimento(new Date());
        pessoa.setCPF("");
        pessoa.setRG("");
        email.setEmail("Jefferson@yahoo.com");
        endereco.setBairro("Real");
        endereco.setCidade("Guanambi ");
        endereco.setRua("Rua 17");
        endereco.setNumero(678);
        telefone.setDDD(77);
        telefone.setTelefone(9123232);


        pessoa.addEmail(email);
        pessoa.addEndereco(endereco);
        pessoa.addTelefone(telefone);
        
        usuario.setLogin("Jessica");
        usuario.setSenha("123");
        //usuario.setFuncionario(1);
        

        PessoaDAO dao = new PessoaDAO();
        UsuarioDAO daoo = new UsuarioDAO();

        //dao.Salvar(pessoa);
        daoo.Usuario(usuario);
        






    }
}
