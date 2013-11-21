/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel;


/**
 *
 * @author Jessica
 */
public class Telefone {

    private int codigo;
    private int ddd;
    private int telefone;
    private Pessoa pessoa;

    public Telefone(int codigo, int ddd, int telefone, Pessoa pessoa) {
        this.codigo = codigo;
        this.ddd = ddd;
        this.telefone = telefone;
        this.pessoa = pessoa;
    }

    public Telefone() {
        this.codigo = 0;
        this.ddd = 0;
        this.telefone = 0;
        this.pessoa = new Pessoa();
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int Telefone) {
        this.telefone = telefone;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int Codigo) {
        this.codigo = codigo;
    }

    public int getDDD() {
        return ddd;
    }

    public void setDDD(int DDD) {
        this.ddd = ddd;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.telefone;
        hash = 47 * hash + this.codigo;
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
        if (this.telefone != other.telefone) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Telefone{" + "telefone=" + telefone + '}';
    }
}
