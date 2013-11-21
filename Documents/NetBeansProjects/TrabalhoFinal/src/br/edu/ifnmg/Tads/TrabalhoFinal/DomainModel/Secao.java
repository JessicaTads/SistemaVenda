/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel;

import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.Usuario;
import java.util.Objects;

/**
 *
 * @author Jessica
 */
public class Secao {

    private int codigo;
    private String iniciosecao;
    private String finalsecao;
    private Usuario usuario;

    public Secao(int codigo, String iniciosecao, String finalsecao, Usuario usuario) {
        this.codigo = codigo;
        this.iniciosecao = iniciosecao;
        this.finalsecao = finalsecao;
        this.usuario = usuario;
    }
    
    public Secao() {
        this.codigo = 0;
        this.iniciosecao = "";
        this.finalsecao = "";
        this.usuario = new Usuario();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getIniciosecao() {
        return iniciosecao;
    }

    public void setIniciosecao(String iniciosecao) {
        this.iniciosecao = iniciosecao;
    }

    public String getFinalsecao() {
        return finalsecao;
    }

    public void setFinalsecao(String finalsecao) {
        this.finalsecao = finalsecao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.codigo;
        hash = 53 * hash + Objects.hashCode(this.iniciosecao);
        hash = 53 * hash + Objects.hashCode(this.finalsecao);
        hash = 53 * hash + Objects.hashCode(this.usuario);
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
        final Secao other = (Secao) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.iniciosecao, other.iniciosecao)) {
            return false;
        }
        if (!Objects.equals(this.finalsecao, other.finalsecao)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Secao{" + "codigo=" + codigo + '}';
    }
    
    
    
    
    
    
    
    
    
}
