/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.ltp3;

/**
 *
 * @author Jessica
 */
public class Email {
   private int CodEmail;
   private String NomeEmail;
   private int CodPessoa;


    public Email(int CodEmail, String NomeEmail, int CodPessoa) {
        this.CodEmail = CodEmail;
        this.NomeEmail = NomeEmail;
        this.CodPessoa = CodPessoa;
    }

    public Email() {
        this.CodEmail = 0;
        this.NomeEmail = "";
        this.CodPessoa = 0;
    }
   
    public int getCodEmail() {
        return CodEmail;
    }

    public void setCodEmail(int CodEmail) {
        this.CodEmail = CodEmail;
    }

    public String getNomeEmail() {
        return NomeEmail;
    }

    public void setNomeEmail(String NomeEmail) {
        this.NomeEmail = NomeEmail;
    }

    public int getCodPessoa() {
        return CodPessoa;
    }

    public void setCodPessoa(int CodPessoa) {
        this.CodPessoa = CodPessoa;
    }
   
   
}

