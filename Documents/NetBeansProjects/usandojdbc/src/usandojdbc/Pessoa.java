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
public class Pessoa {
    
    
    private String nome;
    private int codigo;
    private Date DataNascimento;
    private List<Email> emails;
    private List<Telefone> telefones;

    /*---------- Construtor --------------------------------------------------*/
    public Pessoa(String nome, int codigo, Date DataNascimento, List<Email> emails, List<Telefone> telefones) {
        this.nome = nome;
        this.codigo = codigo;
        this.DataNascimento = DataNascimento;
        this.emails = emails;
        this.telefones = telefones;
    }
    
    
  
    public Pessoa() {
        this.nome = "";
        this.codigo = 0;
        this.DataNascimento = new Date();
        this.emails = new ArrayList<>();
        this.telefones = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) {
        this.DataNascimento = DataNascimento;
    }
    
    

   public void addEmail(Email email){
        if(!emails.contains(email)){
            emails.add(email);
        }
    }
   
   public void removeEmail(Email email){
        if(emails.contains(email)){
            emails.remove(email);
        }
    } 
   
    public List<Email> getEmails(){
        return emails;
    }
    
    public void addTelefone(Telefone telefone){
        if(!telefones.contains(telefone)){
            telefones.add(telefone);
        }
    }
    
     public void removeTelefone(Telefone telefone){
        if(telefones.contains(telefone)){
            telefones.remove(telefone);
        }
    } 
     public List<Telefone> getTelefones(){
        return telefones;
    }
   
  

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + this.codigo;
        hash = 97 * hash + Objects.hashCode(this.DataNascimento);
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
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.DataNascimento, other.DataNascimento)) {
            return false;
        }
        return true;
    }

    
    
    
}
