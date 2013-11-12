/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SistemaVendas.DomainModel;

import java.util.Objects;

/**
 *
 * @author Jessica
 */
public class ItemVenda {
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
        this.produto = new Produto();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception
    {
       if(codigo >= 1)
         this.codigo = codigo;
       else{
         throw new Exception("Valor passado para o campo 'Codigo' é invalido!");
       }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws Exception 
    {
        if(quantidade >= 1)
              this.quantidade = quantidade;
        else{
         throw new Exception("Quantidade inferior á 1!");
        }
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto)throws Exception
    {
        if(produto != null)
            this.produto = produto;
        else{
         throw new Exception("Valor passado para o campo 'Produto' é Nulo!");
        }
    }
    
    public double getValor() {
        double valorTotal;
        valorTotal= getQuantidade()*produto.getPreco();
        return valorTotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.codigo;
        hash = 79 * hash + this.quantidade;
        hash = 79 * hash + Objects.hashCode(this.produto);
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
        final ItemVenda other = (ItemVenda) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
}
