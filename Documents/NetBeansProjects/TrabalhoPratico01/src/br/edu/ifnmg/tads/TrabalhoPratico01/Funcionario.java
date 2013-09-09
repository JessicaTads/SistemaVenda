/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.TrabalhoPratico01;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Jessica
 */
public class Funcionario {
    
    private int codigo;
    private String cargo;
    private Pessoa pessoa;
    private List<Lancamento> lancamentos;

    public Funcionario(int codigo, String cargo, Pessoa pessoa, List<Lancamento> lancamentos) {
        this.codigo = codigo;
        this.cargo = cargo;
        this.pessoa = pessoa;
        this.lancamentos = lancamentos;
    }
   
    public Funcionario() {
        this.codigo = 0;
        this.cargo = "";
        this.pessoa = new Pessoa();
        this.lancamentos = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }
  
   
    
    
    @Override
    public int hashCode() {
        int hash = 3;
       
        hash = 31 * hash + Objects.hashCode(this.cargo);
        hash = 31 * hash + Objects.hashCode(this.pessoa);
         hash = 31 * hash + Objects.hashCode(this.lancamentos);
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
        final Funcionario other = (Funcionario) obj;
      
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.lancamentos, other.lancamentos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pessoa.toString();
    } 
    
    
    
    
    
    
    
}
