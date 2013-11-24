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
public class Pessoa {

    private int codigo;
    private List<Email> emails;
    private String nome;
    private List<Endereco> enderecos;
    private List<Telefones> telefones;

    public Pessoa(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
       
    }
    
    public Pessoa() {
        this.codigo = 0;
        this.emails = new ArrayList<>();
        this.nome = "";
        this.enderecos = new ArrayList<>();
        this.telefones= new ArrayList<>();
    }
    
  
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Email> getEmails() {
        return emails;
    }
    
    public void addemail(List<Email> emails){
        
        if(emails.contains(emails)){
          emails.add(emails);
        }
       
        
    }
    
    public void removemail(List<Email> emails){
        
        if(emails.contains(emails)){
         emails.remove(emails);
        }
        
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Telefones> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefones> telefones) {
        this.telefones = telefones;
    }
    
    

    
    
}

