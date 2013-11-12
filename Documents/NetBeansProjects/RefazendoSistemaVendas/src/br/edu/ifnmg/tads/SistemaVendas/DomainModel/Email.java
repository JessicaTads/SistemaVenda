/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SistemaVendas.DomainModel;

import java.util.Objects;

/**
 *
 * @author Jessica
 */
public class Email {
    private int codigo;
    private String email;
    private Pessoa pessoa;

    public Email(int codigo, Pessoa pessoa) {
        this.codigo = codigo;
        this.pessoa = pessoa;
    }
    
    public Email() {
        this.codigo = 0;
        this.pessoa = new Pessoa();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws ErroValidacaoException{
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new ErroValidacaoException("Código Email Inválido. Insira um código maior que 0.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email)throws ErroValidacaoException{
        if ((email.length() >=3) && (email.length() <=250)){
            this.email = email;
        } else {
            throw new ErroValidacaoException("Email Inválido. Insira um email com no minimo 3 caracteres e com no máximo 250 caracteristicas.");
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.codigo;
        hash = 19 * hash + Objects.hashCode(this.email);
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
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
