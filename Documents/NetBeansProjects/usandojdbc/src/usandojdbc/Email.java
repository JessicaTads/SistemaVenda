/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usandojdbc;

import java.util.Objects;

/**
 *
 * @author Jessica
 */
public class Email {
    
    private int Codigo;
    private String Email;
    private Pessoa pessoa;

    public Email(int Codigo, String Email, Pessoa pessoa) {
        this.Codigo = Codigo;
        this.Email = Email;
        this.pessoa = pessoa;
    }
   
     public Email() {
        this.Codigo = 0;
        this.Email = "";
        this.pessoa = new Pessoa();
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.Codigo;
        hash = 17 * hash + Objects.hashCode(this.Email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Email other = (Email) obj;
        if (this.Codigo != other.Codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Email{" + "Codigo=" + Codigo + ", Email=" + Email + '}';
    }
     
      
    
}
