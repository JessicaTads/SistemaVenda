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
        // TODO code application logic here
        Pessoa pessoa = new Pessoa();
        
        pessoa.setCodigo(0);
        pessoa.setNome("Jessika Tenorio ");
        pessoa.setDataNascimento(new Date());
       // pessoa.setEmails("jeugbi_6@hotmail.com");
       // pessoa.setTelefones(0);
        
    
        
        PessoaDAO dao = new PessoaDAO();
        
        dao.Salvar(pessoa);
        //dao.ListarTodos();
        
    }
}
