/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.ltp3;

/**
 *
 * @author Jessica
 */
public class ItemVenda{
    
    private int codigo;
    private int quantidade;
    private Produto produto;

    public ItemVenda(int codigo, int quantidade, Produto produto) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.produto = produto;
    }
    
    public ItemVenda() {
        this.codigo = 0;
        this.quantidade = 0;
        this.produto = produto;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
    
    
}
