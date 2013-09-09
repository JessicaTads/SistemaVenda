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
public class Lancamento {
    
    private int codigo;
    private double multa;
    private double valorIntegral;
    private double desconto;
    private String historico;
    private Date dataBaixa;
    private Date dataLiquidacao;
    private Date data;  
    private Pessoa pessoa;

    public Lancamento(int codigo, double multa, double valorIntegral, double desconto, String historico, Date dataBaixa, Date dataLiquidacao, Date data, Pessoa pessoa) {
        this.codigo = codigo;
        this.multa = multa;
        this.valorIntegral = valorIntegral;
        this.desconto = desconto;
        this.historico = historico;
        this.dataBaixa = dataBaixa;
        this.dataLiquidacao = dataLiquidacao;
        this.data = data;
        this.pessoa = pessoa;
    }
    public Lancamento() {
        this.codigo = 0;
        this.multa = 0;
        this.valorIntegral = 0;
        this.desconto = 0;
        this.historico = "";
        this.dataBaixa = new Date();
        this.dataLiquidacao = new Date();
        this.data = new Date();
        this.pessoa = new Pessoa();
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

    public double getValorIntegral() {
        return valorIntegral;
    }

    public void setValorIntegral(double valorIntegral) {
        this.valorIntegral = valorIntegral;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Date getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(Date dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public Date getDataLiquidacao() {
        return dataLiquidacao;
    }

    public void setDataLiquidacao(Date dataLiquidacao) {
        this.dataLiquidacao = dataLiquidacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
        hash = 17 * hash + this.codigo;
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
        final Lancamento other = (Lancamento) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Lancamento{" + "codigo=" + codigo + '}';
    }
    
    
    
    
    
    
    
}
