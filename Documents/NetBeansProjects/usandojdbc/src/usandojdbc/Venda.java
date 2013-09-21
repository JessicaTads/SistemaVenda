/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usandojdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Jessica
 */
public class Venda {
    
    private int Codigo;
    private Date Data;
    private float ValorTotal;
    private Pessoa pessoa;
    private List<ItemVenda> itensvenda;
 

    public Venda(int Codigo, Date Data, float ValorTotal, Pessoa pessoa, List<ItemVenda> itensvenda) {
        this.Codigo = Codigo;
        this.Data = Data;
        this.ValorTotal = ValorTotal;
        this.pessoa = pessoa;
        this.itensvenda = this.itensvenda;
        
    }
    
    public Venda() {
        this.Codigo = 0;
        this.Data = new Date();
        this.ValorTotal = 0;
        this.pessoa = new Pessoa();
        this.itensvenda = new ArrayList<>();
        
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) throws Exception {
        if(Codigo >= 1)
            this.Codigo = Codigo;
        else{
         throw new Exception("Codigo Invalido!");
       }
    }
    

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public float getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(float ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void addItemVenda(ItemVenda itemvenda){
        if(!itensvenda.contains(itemvenda)){
            itensvenda.add(itemvenda);
            float valor = itemvenda.getQuantidade() + getValorTotal();
            setValorTotal(valor);
        }
    }
   
   public void removeItemVenda(ItemVenda itemvenda){
        if(itensvenda.contains(itemvenda)){
            itensvenda.remove(itemvenda);
            float valor = getValorTotal() - itemvenda.getQuantidade();
            setValorTotal(valor);
        }
    } 
   
    public List<ItemVenda> getitensVenda(){
        return itensvenda;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.Codigo;
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
        if (this.Codigo != other.Codigo) {
            return false;
        }
        if (!Objects.equals(this.Data, other.Data)) {
            return false;
        }
        if (Float.floatToIntBits(this.ValorTotal) != Float.floatToIntBits(other.ValorTotal)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        
        return true;
    }

    Iterable<ItemVenda> getItemVenda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
}
