/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel;

/**
 *
 * @author Jessica
 */
public class Estoque {
    private int codigo;
    private int estoque;
    private Produto produto;
    private int quantidade;

    public Estoque(int codigo, int estoque, Produto produto, int quantidade) {
        this.codigo = codigo;
        this.estoque = estoque;
        this.produto = produto;
        this.quantidade = quantidade;
    }
    public Estoque() {
        this.codigo = 0;
        this.estoque = 0;
        this.produto = new Produto();
        this.quantidade = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) throws Exception {
        if (estoque >= 0) {
            this.estoque = estoque;
        } else {
            throw new Exception("Valor passado para o campo 'estoque' não pode ser negativo!");
        }
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws Exception {
        if (quantidade > 0) {
            this.quantidade = quantidade;
        } else {
            throw new Exception("Valor passado para o campo 'quantidade' não pode ser negativo!");
        }
    }
    
    
    
    
    
    
}
