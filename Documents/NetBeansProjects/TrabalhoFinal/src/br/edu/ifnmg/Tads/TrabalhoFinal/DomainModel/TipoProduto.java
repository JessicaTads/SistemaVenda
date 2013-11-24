/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jessica
 */
public class TipoProduto {

    private int codigo;
    private String tipo;

    public TipoProduto(int codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public TipoProduto() {
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
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
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
}
