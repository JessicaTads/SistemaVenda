/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.ltp3;

/**
 *
 * @author Jessica
 */
public class Endereco {
    
    private int codigo;
    private String rua;
    private String cidade;
    private String bairro;
    private int cep;

    public Endereco(int codigo, String rua, String cidade, String bairro, int cep) {
        this.codigo = codigo;
        this.rua = rua;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
    }
    
    public Endereco() {
        this.codigo = 0;
        this.rua = "";
        this.cidade = "";
        this.bairro = "";
        this.cep = 0;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

   
}
