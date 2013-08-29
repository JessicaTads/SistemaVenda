/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.ltp3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jessica
 */
public class Email {
   private int codigo;
   private String email;
   private Pessoa pessoa;

    public Email(int codigo, String email, Pessoa pessoa) {
        this.codigo = codigo;
        this.email = email;
        this.pessoa = pessoa;
    }
    
    public Email() {
        this.codigo = 0;
        this.email = "";
        this.pessoa = pessoa;
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
        this.email = email;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    
}

