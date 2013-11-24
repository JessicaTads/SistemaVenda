/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SistemaVenda;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jessica
 */
public class Venda {
  
    private int codigo;
    private List<ItemVenda> ItemVendas;

    public Venda(int Codigo, List<ItemVenda> ItemVendas) {
        this.codigo = Codigo;
        this.ItemVendas = ItemVendas;
    }
    
    public Venda() {
        this.codigo = 0;
        this.ItemVendas = ItemVendas;
    }
   
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int Codigo) {
        this.codigo = Codigo;
    }

    public List<ItemVenda> getItemVenda() {
        return ItemVendas;
    }

    public void setItemVendas(List<ItemVenda> ItemVendas) {
        this.ItemVendas = ItemVendas;
    }

   
}
