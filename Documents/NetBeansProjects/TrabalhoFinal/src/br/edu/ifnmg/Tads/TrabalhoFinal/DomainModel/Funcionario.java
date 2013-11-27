/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jessica
 */
public class Funcionario extends Pessoa {

    private int codigo;
    private String especialidade;
    private int Ativo;
    private Pessoa pessoa;

    public Funcionario(int codigo, String especialidade, Pessoa pessoa, int Ativo) {
        this.codigo = codigo;
        this.especialidade = especialidade;
        this.pessoa = pessoa;
        this.Ativo = Ativo;
    }

    public Funcionario() {
        this.Ativo = 1;
        this.especialidade = "";
    }

    //************************************
    public int getAtivo() {
        return Ativo;
    }

    public void setAtivo(int Ativo) {
        this.Ativo = Ativo;
    }
    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        if (codigo >= 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Codigo Inválido!");
        }
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) throws Exception {
        Pattern Especialidade = Pattern.compile("[\\w\\s]{3,}");
        Matcher verifica = Especialidade.matcher(especialidade);

        if (verifica.matches()) {
            this.especialidade = especialidade;
        } else {
            throw new Exception("Formato de nome Inválido!");

        }
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.codigo;
        hash = 97 * hash + Objects.hashCode(this.especialidade);
        hash = 97 * hash + Objects.hashCode(this.pessoa);
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
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.especialidade, other.especialidade)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pessoa.toString();
    }
}
