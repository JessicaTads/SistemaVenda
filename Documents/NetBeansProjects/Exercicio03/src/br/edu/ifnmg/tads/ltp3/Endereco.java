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
    
    private int CodEndereco;
    private String Rua;
    private String Cidade;
    private String Bairro;
    private int Cep;

    public int getCodEndereco() {
        return CodEndereco;
    }

    public void setCodEndereco(int CodEndereco) {
        this.CodEndereco = CodEndereco;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public int getCep() {
        return Cep;
    }

    public void setCep(int Cep) {
        this.Cep = Cep;
    }
    
    
}
