/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel;

import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.Pessoa;
import java.util.Objects;

/**
 *
 * @author Jessica
 */
public class Endereco {

    private int codigo;
    private String rua;
    private String bairro;
    private String cidade;
    private int numero;
    private Pessoa pessoa;

    public Endereco(int codigo, String rua, String bairro, String cidade, int numero, Pessoa pessoa) {
        this.codigo = codigo;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
        this.pessoa = pessoa;
    }

    public Endereco() {
        this.codigo = 0;
        this.rua = "";
        this.bairro = "";
        this.cidade = "";
        this.numero = 0;
        this.pessoa = new Pessoa();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        if (codigo >= 0) {
            this.codigo = codigo;
        } else {
            //captura excessão
            throw new Exception("Codigo Inválido!");
        }
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {

        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {

        this.cidade = cidade;
    }

    public int getNumero() {

        return numero;
    }

    public void setNumero(int numero) throws Exception {

        if (numero > 0) {
            this.numero = numero;
        } else {
            throw new Exception(" Numero inválido! (Somente são aceitos inteiros positivos)");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.rua);
        hash = 17 * hash + this.numero;
        hash = 17 * hash + Objects.hashCode(this.bairro);
        hash = 17 * hash + Objects.hashCode(this.cidade);


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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }

        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return rua;
    }
}
