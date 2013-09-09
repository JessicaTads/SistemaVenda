/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.TrabalhoPratico01;

/**
 *
 * @author Jessica
 */
public class Telefone {
    private int codigo;
    private int ddd;
    private int numero;
    private Pessoa pessoa;

    public Telefone(int codigo, int ddd, int numero, Pessoa pessoa) {
        this.codigo = codigo;
        this.ddd = ddd;
        this.numero = numero;
        this.pessoa = pessoa;
    }
    
    public Telefone() {
        this.codigo = 0;
        this.ddd = 0;
        this.numero = 0;
        this.pessoa = new Pessoa();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
        hash = 23 * hash + this.ddd;
        hash = 23 * hash + this.numero;
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
        final Telefone other = (Telefone) obj;
        if (this.ddd != other.ddd) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+numero;
    }
    
    
    
    
    
    


    
}
