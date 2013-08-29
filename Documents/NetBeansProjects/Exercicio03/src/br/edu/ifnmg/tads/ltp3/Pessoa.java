/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.ltp3;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jessica
 */
public class Pessoa {

    private int CodPessoa;
    private List<Email> email;
    private String Nome;
    private List<Endereco> endereco;

    public Pessoa(int CodPessoa, List<Email> email, String Nome, List<Endereco> endereco) {
        this.CodPessoa = CodPessoa;
        this.email = email;
        this.Nome = Nome;
        this.endereco = endereco;
    }
    
     public Pessoa() {
        this.CodPessoa = 0;
        this.email = new LinkedList<>();
        this.Nome = "";
        this.endereco = new LinkedList<>();
    }
    
    

    public int getCodPessoa() {
        return CodPessoa;
    }

    public void setCodPessoa(int CodPessoa) {
        this.CodPessoa = CodPessoa;
    }

    public List<Email> getEmail() {
        return email;
    }

    public void setEmail(List<Email> email) {
        this.email = email;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
    
    
}

