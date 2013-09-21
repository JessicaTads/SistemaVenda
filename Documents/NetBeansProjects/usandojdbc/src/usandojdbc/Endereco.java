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
public class Endereco {
    private int Codigo;
    private String Rua;
    private String Bairro;
    private int Numero;
    private Pessoa pessoa;

    public Endereco(int Codigo, String Rua, String Bairro, int Numero, Pessoa pessoa) {
        this.Codigo = Codigo;
        this.Rua = Rua;
        this.Bairro = Bairro;
        this.Numero = Numero;
        this.pessoa = pessoa;
    }
    
     public Endereco() {
        this.Codigo = 0;
        this.Rua = "";
        this.Bairro = "";
        this.Numero = 0;
        this.pessoa = new Pessoa();
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.Codigo;
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
        final Endereco other = (Endereco) obj;
        if (this.Codigo != other.Codigo) {
            return false;
        }
        if (!Objects.equals(this.Rua, other.Rua)) {
            return false;
        }
        if (!Objects.equals(this.Bairro, other.Bairro)) {
            return false;
        }
        if (this.Numero != other.Numero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Endereco{" + "Codigo=" + Codigo + '}';
    }
    
    
    
    
    
    
}
