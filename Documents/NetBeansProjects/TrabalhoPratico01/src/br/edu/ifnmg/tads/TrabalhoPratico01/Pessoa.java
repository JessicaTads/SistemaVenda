/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.TrabalhoPratico01;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jessica
 */
public class Pessoa {
    private int codigo;
    private String nome;
    private int cpf;
    private List<Endereco> enderecos;
    private List<Telefone> telefones;

    public Pessoa(int codigo, String nome, int cpf, List<Endereco> enderecos, List<Telefone> telefones){
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.enderecos = enderecos;
        this.telefones = telefones;
    }
    
    public Pessoa(){
        this.codigo = 0;
        this.nome = "";
        this.cpf = 0;
        this.enderecos = new ArrayList<>();
        this.telefones = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    
    public void addEnderecos(Endereco endereco){
        if(!enderecos.contains(endereco)){
          enderecos.add(endereco);
       }
    }
    public void removeEnderecos(Endereco endereco){
        if(enderecos.contains(endereco)){
            enderecos.remove(endereco);
        }
    }
    
    public void addTelefones(Telefone telefone){
        if(!telefones.contains(telefone)){
          telefones.add(telefone);
        }
    }
    public void removeTelefones(Telefone telefone){
        if(telefones.contains(telefone)){
            telefones.remove(telefone);
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.codigo;
        hash = 29 * hash + this.cpf;
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
        final Pessoa other = (Pessoa) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        
        if (this.cpf != other.cpf) {
            return false;
        }
        return true;
    }


   @Override
    public String toString() {
        return nome;
    }
    
  
    
    
}








