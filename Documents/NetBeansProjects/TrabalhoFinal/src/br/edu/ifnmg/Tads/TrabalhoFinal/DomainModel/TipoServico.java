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
public class TipoServico {

    private int codigo;
    private String tipo;

    public TipoServico(int codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public TipoServico() {
        this.codigo = 0;
        this.tipo = "";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Codigo menor que um");
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) throws Exception {
        Pattern Tipo = Pattern.compile("[\\w\\s]{3,}");
        Matcher verifica = Tipo.matcher(tipo);

        if (verifica.matches()) {
            this.tipo = tipo;
        } else {
            throw new Exception("Valor passado para o campo 'tipo' é invalido.");
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.codigo;
        hash = 31 * hash + Objects.hashCode(this.tipo);
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
        final TipoServico other = (TipoServico) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoServico{" + "codigo=" + codigo + ", tipo=" + tipo + '}';
    }
}
