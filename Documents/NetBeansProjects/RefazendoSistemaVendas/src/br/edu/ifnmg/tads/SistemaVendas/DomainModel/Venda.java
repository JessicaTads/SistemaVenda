/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SistemaVendas.DomainModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Jessica
 */
public class Venda {
    private int codigo;
    private Date data;
    private double valorTotal;
    private Pessoa pessoa;
    private List<ItemVenda> itemVenda;

    public Venda(int codigo, Date data, double valorTotal, Pessoa pessoa, List<ItemVenda> itemVenda) {
        this.codigo = codigo;
        this.data = data;
        this.valorTotal = valorTotal;
        this.pessoa = pessoa;
        this.itemVenda = itemVenda;
    }
    
    public Venda() {
        this.codigo = 0;
        this.data = new Date();
        this.valorTotal = 0;
        this.pessoa = new Pessoa();
        this.itemVenda = new ArrayList<ItemVenda>();
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public List<ItemVenda> getItemVendas() {
        return itemVenda;
    }
    
    public void addItemVenda(ItemVenda iV) throws Exception{
        if(!itemVenda.contains(iV)){
            itemVenda.add(iV);
            
             valorTotal += (iV.getProduto().getPreco() * iV.getQuantidade());
        }
        else{
         throw new Exception("Esse item já esta contido na lista de Vendas");
        }
        
    }
    
    public void RemoveItemVenda(ItemVenda iV) throws Exception{
        if(!itemVenda.contains(iV)){
            itemVenda.add(iV);
            
             valorTotal -= (iV.getProduto().getPreco() * iV.getQuantidade());
        }
        else{
         throw new Exception("Esse item já esta contido na lista de Vendas");
        }
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.codigo;
        hash = 29 * hash + Objects.hashCode(this.data);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.valorTotal) ^ (Double.doubleToLongBits(this.valorTotal) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.pessoa);
        hash = 29 * hash + Objects.hashCode(this.itemVenda);
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
        final Venda other = (Venda) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorTotal) != Double.doubleToLongBits(other.valorTotal)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.itemVenda, other.itemVenda)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "codigo=" + codigo + '}';
    }
    
  
    
}
