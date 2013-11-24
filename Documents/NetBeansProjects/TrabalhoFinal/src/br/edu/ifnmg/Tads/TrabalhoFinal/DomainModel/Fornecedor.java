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
public class Fornecedor extends Pessoa {

    private String cnpj;

    public Fornecedor(String cnpj) {
        this.cnpj = cnpj;
    }

    public Fornecedor() {
        this.cnpj = "";
    }

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(String cnpj) throws Exception{
        Pattern CNPJ = Pattern.compile("[\\w\\s]{3,}");
        Matcher verifica = CNPJ.matcher(cnpj);

        if (verifica.matches()) {
            this.cnpj = cnpj;
        } else {
            throw new Exception("Campo 'CNPJ' deve é invalido");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.cnpj);
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
        final Fornecedor other = (Fornecedor) obj;
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "cnpj=" + cnpj + '}';
    }
    
    
    
    
    
    
    
    
}
