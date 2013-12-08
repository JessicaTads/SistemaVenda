/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jessica
 */
public class Usuario {

    private int codigo;
    private String login;
    private String senha;
    
    private Funcionario funcionario;

    /*----------- Construtor ----------*/
    public Usuario(int codigo, String login, String senha, Funcionario funcionario) {
        this.codigo = codigo;
        this.login = login;
        this.senha = senha;
     
        this.funcionario = funcionario;
    }

    public Usuario() {
     
    }

    /*----------- Getters -------------*/
    public int getCodigo() {
        return codigo;
    }

    

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    /*----------- Setters ----------------------------------------------------*/
    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Codigo menor que um");
        }
    }

    public void setLogin(String login) throws Exception {
        Pattern Nome = Pattern.compile("[\\w\\s]{3,}");
        Matcher verifica = Nome.matcher(login);

        if (verifica.matches()) {
            this.login = login;
        } else {
            throw new Exception("Campo 'login' deve ter no mínimo 3 caracteres");
        }
    }

    public void setSenha(String senha) throws Exception {
        Pattern Nome = Pattern.compile("[\\w]{6,}");
        Matcher verifica = Nome.matcher(login);

        if (verifica.matches()) {
            this.senha = senha;
        } else {
            throw new Exception("Campo 'senha' deve ter no mínimo 6 caracteres");
        }
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.login);
        hash = 29 * hash + Objects.hashCode(this.senha);
        hash = 29 * hash + Objects.hashCode(this.funcionario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return funcionario.toString();
    }
}
