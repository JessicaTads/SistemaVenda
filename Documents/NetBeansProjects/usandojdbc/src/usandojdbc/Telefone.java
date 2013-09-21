/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usandojdbc;

/**
 *
 * @author Jessica
 */
public class Telefone {
    
    private int codigo;
    private int Telefone;
    private Pessoa pessoa;

    public Telefone(int codigo, int fone, Pessoa pessoa) {
        this.codigo = codigo;
        this.Telefone = fone;
        this.pessoa = pessoa;
    }
    
    public Telefone() {
        this.codigo = 0;
        this.Telefone = 0;
        this.pessoa = new Pessoa();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTelefone() {
        return Telefone;
    }

    public void setTelefone(int telefone) {
        this.Telefone = telefone;
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
        hash = 43 * hash + this.codigo;
        hash = 43 * hash + this.Telefone;
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
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.Telefone != other.Telefone) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Telefone{" + "codigo=" + codigo + ", Telefone=" + Telefone + '}';
    }
    
    
}
