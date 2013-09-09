/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.TrabalhoPratico01;

import java.util.Date;

/**
 *
 * @author Jessica
 */
public class Contas {
    
    private int codigo;
    private String tipo;
    private double valor;  
    private Date vencimento;

    public Contas(int codigo, String tipo, double valor, Date vencimento) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.valor = valor;
        this.vencimento = vencimento;
    }
    
    public Contas() {
        this.codigo = 0;
        this.tipo = "";
        this.valor = 0;
        this.vencimento = new Date();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.codigo;
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
        final Contas other = (Contas) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+codigo;
    }  
    
    
    
    
    
}
