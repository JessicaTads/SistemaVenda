/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Jessica
 */
public class Secao {

    private int codigo;
    private Date iniciosecao;
    private Date finalsecao;
    private double saldoinicial;
    private double saldofinal;
    private Usuario usuario;
    private Caixa caixa;

    public Secao(int codigo, Date iniciosecao, Date finalsecao, double saldoinicial, double saldofinal, Usuario usuario, Caixa caixa) {
        this.codigo = codigo;
        this.iniciosecao = iniciosecao;
        this.finalsecao = finalsecao;
        this.saldoinicial = saldoinicial;
        this.saldofinal = saldofinal;
        this.usuario = usuario;
        this.caixa = caixa;
    }

    public Secao() {
        this.codigo = 0;
        this.iniciosecao = new Date();
        this.finalsecao = new Date();
        this.saldoinicial = 0;
        this.saldofinal = 0;
        this.usuario = new Usuario();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Codigo menor que um");
        }
    }

    public Date getIniciosecao() {
        return iniciosecao;
    }

    public void setIniciosecao(Date iniciosecao) {
        this.iniciosecao = iniciosecao;
    }

    public Date getFinalsecao() {
        return finalsecao;
    }

    public void setFinalsecao(Date finalsecao) {
        this.finalsecao = finalsecao;
    }

    public double getSaldoinicial() {
        return saldoinicial;
    }

    public void setSaldoinicial(double saldoinicial) {
        this.saldoinicial = saldoinicial;
    }

    public double getSaldofinal() {
        return saldofinal;
    }

    public void setSaldofinal(double saldofinal) throws Exception {
        if (saldofinal >= 0) {
            this.saldofinal = saldofinal;
        } else {
            throw new Exception("Valor negativo!");
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigo;
        hash = 97 * hash + Objects.hashCode(this.iniciosecao);
        hash = 97 * hash + Objects.hashCode(this.finalsecao);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.saldoinicial) ^ (Double.doubleToLongBits(this.saldoinicial) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.saldofinal) ^ (Double.doubleToLongBits(this.saldofinal) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.usuario);
        hash = 97 * hash + Objects.hashCode(this.caixa);
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
        final Secao other = (Secao) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.iniciosecao, other.iniciosecao)) {
            return false;
        }
        if (!Objects.equals(this.finalsecao, other.finalsecao)) {
            return false;
        }
        if (Double.doubleToLongBits(this.saldoinicial) != Double.doubleToLongBits(other.saldoinicial)) {
            return false;
        }
        if (Double.doubleToLongBits(this.saldofinal) != Double.doubleToLongBits(other.saldofinal)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.caixa, other.caixa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Secao{" + "codigo=" + codigo + '}';
    }
}
