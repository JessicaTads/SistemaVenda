/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.ltp3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jessica
 */
public class Venda {
  
    private int codigo;
    private List<ItemVenda> ItemVenda;

    public Venda(int Codigo, List<ItemVenda> ItemVenda) {
        this.codigo = Codigo;
        this.ItemVenda = ItemVenda;
    }
    
    public Venda() {
        this.codigo = 0;
        this.ItemVenda = ItemVenda;
    }
   
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int Codigo) {
        this.codigo = Codigo;
    }

    public List<ItemVenda> getItemVenda() {
        return ItemVenda;
    }

    public void setItemVenda(List<ItemVenda> ItemVenda) {
        this.ItemVenda = ItemVenda;
    }

   
}
