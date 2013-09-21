/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usandojdbc;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jessica
 */
public class Produto {
    
    private int Codigo;
    private String Descricao;
    private float Preco;

    public Produto(int Codigo, String Descricao, float Preco) {
        this.Codigo = Codigo;
        this.Descricao = Descricao;
        this.Preco = Preco;
    }
    
    public Produto() {
        this.Codigo = 0;
        this.Descricao = "";
        this.Preco = 0;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) throws Exception{
       try{
        if(Codigo >= 0){
        this.Codigo = Codigo;
        }
    }catch(Exception ex){
            throw new Exception("Codigo invalido");
            
        }
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        Pattern Desc = Pattern.compile("[0-9\\w\\s]{3,}");
        Matcher verificar = Desc.matcher(Descricao);
        
        if(verificar.matches())
            this.Descricao = Descricao;
        
    }

    public float getPreco() {
        return Preco;
    }

    public void setPreco(float Preco) {
        this.Preco = Preco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.Codigo;
        hash = 53 * hash + Objects.hashCode(this.Descricao);
        hash = 53 * hash + Float.floatToIntBits(this.Preco);
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
        final Produto other = (Produto) obj;
        if (this.Codigo != other.Codigo) {
            return false;
        }
        if (!Objects.equals(this.Descricao, other.Descricao)) {
            return false;
        }
        if (Float.floatToIntBits(this.Preco) != Float.floatToIntBits(other.Preco)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "Codigo=" + Codigo + ", Descricao=" + Descricao + ", Preco=" + Preco + '}';
    }
    
    
    
    
    
}
