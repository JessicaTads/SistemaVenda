/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SistemaVenda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jessica
 */
public class Email {
   private int codigo;
   private String email;
  
    

    public Email(int codigo, String email, Pessoa pessoa) {
        this.codigo = codigo;
        this.email = email;
      
    }
    
    public Email() {
        this.codigo = 0;
        this.email = "";
        
    }
   

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        
        this.codigo = codigo;
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Pattern testeemail = Pattern.compile("[a-z A-Z 0-9-.\\d]{3,250}@[\\d\\w]+[\\w]+");
         Matcher busca = testeemail.matcher(email);
        
        if (busca.matches()){
          this.email = email;
        } else{
          System.out.println("Nao Achou!");
        }
    }

    
    
    
}

