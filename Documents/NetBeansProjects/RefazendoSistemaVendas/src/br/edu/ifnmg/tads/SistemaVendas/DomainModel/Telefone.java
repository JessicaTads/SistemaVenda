/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SistemaVendas.DomainModel;

/**
 *
 * @author Jessica
 */
public class Telefone {
    private int codigo;
    private int DDD;
    private int numero;
    private Pessoa pessoa;

    public Telefone(int codigo, int DDD, int numero, Pessoa pessoa) {
        this.codigo = codigo;
        this.DDD = DDD;
        this.numero = numero;
        this.pessoa = pessoa;
    }
    
     public Telefone() {
        this.codigo = 0;
        this.DDD = 0;
        this.numero = 0;
        this.pessoa = new Pessoa();
    }
     
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws ErroValidacaoException{
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new ErroValidacaoException("Código Telefone Inválido. Insira um código maior que 0.");
        }
    }

    public int getDDD() {
        return DDD;
    }

    public void setDDD(int DDD) throws ErroValidacaoException{
        if (DDD > 0){ 
            this.DDD = DDD;
        } else {
            throw new ErroValidacaoException("Código Área Inválido. Insira um código maior que 0.");
        } 
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) throws ErroValidacaoException{
        if (numero > 0) {
            this.numero = numero;
        } else {
            throw new ErroValidacaoException("Número Inválido. Insira um número maior que 0.");
        }
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
        hash = 67 * hash + this.codigo;
        hash = 67 * hash + this.DDD;
        hash = 67 * hash + this.numero;
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
        if (this.DDD != other.DDD) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Telefone{" + "codigo=" + codigo + '}';
    }
    
    
     
    
    
    
    
}
