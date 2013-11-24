/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel;

/**
 *
 * @author Jessica
 */
public class Caixa {

    private int codigo;
    private double saldo;

    public Caixa(int codigo, double saldo) {
        this.codigo = codigo;
        this.saldo = saldo;
    }

    public Caixa() {
        this.codigo = 0;
        this.saldo = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Codigo errado");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
