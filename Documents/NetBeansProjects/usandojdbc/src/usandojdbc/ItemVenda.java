/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usandojdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Jessica
 */
public class ItemVenda {
    
    private int Codigo;
    private int Quantidade;
    private List<Produto> produtos;
    


    public ItemVenda(int Codigo, int Quantidade, List<Produto> produtos ) {
        this.Codigo = Codigo;
        this.Quantidade = Quantidade;
        this.produtos = produtos;
        
    }
    
    public ItemVenda() {
        this.Codigo = 0;
        this.Quantidade = 0;
        this.produtos = new ArrayList<>();
        
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }
    
     
    public void addProduto(Produto produto){
        if(!produtos.contains(produto)){
            produtos.add(produto);
        }
    }
    
     public void removeProduto(Produto produto){
        if(produtos.contains(produto)){
            produtos.remove(produto);
        }
    } 
     public List<Produto> getProdutos(){
        return produtos;
    }
   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.Codigo;
        hash = 23 * hash + this.Quantidade;
        hash = 23 * hash + Objects.hashCode(this.produtos);
      
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
        if (this.Codigo != other.Codigo) {
            return false;
        }
        if (this.Quantidade != other.Quantidade) {
            return false;
        }
        if (!Objects.equals(this.produtos, other.produtos)) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "Codigo=" + Codigo + ", Quantidade=" + Quantidade + ", produtos=" + produtos + '}';
    } 
    
    
}
