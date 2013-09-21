/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usandojdbc;

import java.util.Date;

/**
 *
 * @author Jessica
 */
public class Usandojdbc {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
      
        Pessoa pessoa = new Pessoa();
          
        Email email = new Email();
        Telefone tele= new Telefone();
        Endereco end = new Endereco();
        Produto prod = new Produto();
        
        
        //pessoa.setCodigo(-3);
        email.setEmail("jessicatads210@gmail.com");
        
        
        tele.setTelefone(91615207);
        pessoa.setNome("Jessica Oliveira");
        
        pessoa.setDataNascimento(new Date());
        
        pessoa.addEmail(email);
        pessoa.addTelefone(tele);
        
        end.setNumero(651);
        end.setRua("Rua Jose Augusto");
        end.setBairro("Viana");
        
        prod.setDescricao("Violao");
        prod.setPreco(500);
        
        
        
        
        
      
        PessoaDAO dao = new PessoaDAO();
        
        dao.Salvar(pessoa);
        //dao.ListarTodos();
        
    }
   
}

