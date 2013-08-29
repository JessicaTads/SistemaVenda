/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.ltp3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jessica
 */
public class Pessoa {

    private int codigo;
    private List<Email> email;
    private String nome;
    private List<Endereco> endereco;

    public Pessoa(int codigo, List<Email> email, String nome, List<Endereco> endereco) {
        this.codigo = codigo;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
    }
    
    public Pessoa() {
        this.codigo = 0;
        this.email = new ArrayList<>();
        this.nome = "";
        this.endereco = new ArrayList<>();
    }
    
  
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Email> getEmail() {
        return email;
    }

    public void setEmail(List<Email> email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    
    
}

