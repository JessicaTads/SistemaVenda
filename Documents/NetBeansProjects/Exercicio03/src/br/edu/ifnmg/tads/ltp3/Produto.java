/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.ltp3;

/**
 *
 * @author Jessica
 */
public class Produto {
    
    private int codigo;
    private String Nome;
    private double Preco;

    public Produto(int Codigo, String Nome, double Preco) {
        this.codigo = Codigo;
        this.Nome = Nome;
        this.Preco = Preco;
    }
    
    public Produto() {
        this.codigo = 0;
        this.Nome = "";
        this.Preco = 0.0;
    }
    

 
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int Codigo) {
        this.codigo = Codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double Preco) {
        this.Preco = Preco;
    }

    
    
}
