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
public class Pessoa {

    private int codigo;
    private String nome;
    private Date DataNascimento;
    private List<Email> emails;
    private List<Endereco> enderecos;
    private List<Telefone> telefones;

    public Pessoa(List<Email> emails, List<Endereco> enderecos, List<Telefone> telefones) {
        this.codigo = codigo;
        this.emails = emails;
        this.enderecos = enderecos;
        this.telefones = telefones;
    }

    public Pessoa() {
        this.codigo = 0;
        this.emails = new ArrayList<Email>();
        this.enderecos = new ArrayList<Endereco>();
        this.telefones = new ArrayList<Telefone>();
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

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
    
     public List<Endereco> getEnderecos(){
        return enderecos;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public void addEmail(Email email) {
        if (!emails.contains(emails)) {
            emails.add(email);
        }
    }

    public void removeEmail(Email email) {
        if (emails.contains(emails)) {
            emails.remove(email);

        }

    }
    public List<Email> getEmails(){
        return emails;
    }

    public void addTelefone(Telefone telefone) {
        if (!telefones.contains(telefones)) {
            telefones.add(telefone);
        }
    }

    public void removeTelefone(Telefone telefone) {
        if (telefones.contains(telefones)) {
            telefones.remove(telefone);

        }

    }
     public void addEndereco(Endereco endereco){
        if(!enderecos.contains(enderecos)){
            enderecos.add(endereco);    
        }
    }
    public void removeEndereco(Endereco endereco){
        if(enderecos.contains(enderecos)){
            enderecos.remove(endereco);
            
        }
    
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.codigo;
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.DataNascimento);
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
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.DataNascimento, other.DataNascimento)) {
            return false;
        }
        return true;
    }
    
    
    
}
