/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel;

import java.util.Objects;

/**
 *
 * @author Jessica
 */
public class Estoque {
    private int codigo;
    private TipoProduto tipoproduto;
    private int quantidade;

    public Estoque(int codigo, TipoProduto produto, int quantidade) {
        this.codigo = codigo;
        
        this.tipoproduto = produto;
        this.quantidade = quantidade;
    }
    public Estoque() {
        this.codigo = 0;
        this.tipoproduto = new TipoProduto();
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

   

    public TipoProduto getTipoProduto() {
        return tipoproduto;
    }

    public void setTipoProduto(TipoProduto tipoproduto) {
        this.tipoproduto = tipoproduto;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.codigo;
        hash = 59 * hash + Objects.hashCode(this.tipoproduto);
        hash = 59 * hash + this.quantidade;
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
        final Estoque other = (Estoque) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.tipoproduto, other.tipoproduto)) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estoque{" + "codigo=" + codigo + ", tipoproduto=" + tipoproduto + ", quantidade=" + quantidade + '}';
    }
    
    
    
    
    
    
    
    
}
