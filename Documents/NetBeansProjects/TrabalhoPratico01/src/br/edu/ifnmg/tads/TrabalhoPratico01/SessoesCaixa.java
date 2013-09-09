/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.TrabalhoPratico01;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jessica
 */
public class SessoesCaixa {
    
    private int codigo;
    private double multa;
    private Date dataAbertura;  
    private Date dataFechamento; 
    private List<Contas> contas;

    public SessoesCaixa(int codigo, double multa, Date dataAbertura, Date dataFechamento, List<Contas> contas) {
        this.codigo = codigo;
        this.multa = multa;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.contas = contas;
    }
    
    public SessoesCaixa() {
        this.codigo = 0;
        this.multa = 0;
        this.dataAbertura = new Date();
        this.dataFechamento = new Date();
        this.contas = new ArrayList<>();
       
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public List<Contas> getContas() {
        return contas;
    }

    public void setContas(List<Contas> contas) {
        this.contas = contas;
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
        final SessoesCaixa other = (SessoesCaixa) obj;
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
