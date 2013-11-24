/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jessica
 */
public class Pessoa {

    private int codigo;
    private String CPF;
    private String nome;
    private String RG;
    private Date datanascimento;
    private List<Endereco> enderecos;
    private List<Email> emails;
    private List<Telefone> telefones;

    public Pessoa(int codigo, String CPF, String nome, String RG, Date datanascimento, List<Endereco> enderecos, List<Email> emails, List<Telefone> telefones) {
        this.codigo = codigo;
        this.CPF = CPF;
        this.nome = nome;
        this.RG = RG;
        this.datanascimento = datanascimento;
        this.enderecos = enderecos;
        this.emails = emails;
        this.telefones = telefones;
    }

    public Pessoa() {
        this.codigo = 0;
        this.CPF = "";
        this.nome = "";
        this.RG = "";
        this.datanascimento = new Date();
        this.enderecos = new ArrayList<Endereco>();
        this.emails = new ArrayList<Email>();
        this.telefones = new ArrayList<Telefone>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        Pattern Nome = Pattern.compile("[\\w\\s]{3,}");
        Matcher verifica = Nome.matcher(nome);

        if (verifica.matches()) {
            this.nome = nome;
        } else {
            throw new Exception("Formato de nome Inválido!");

        }
    }

    public Date getDataNascimento() {
        return datanascimento;
    }

    public void setDataNascimento(Date datanascimento) throws Exception {
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.set(1900, 1, 1);

        if (calendario.getTime().before(datanascimento)) {
            this.datanascimento = datanascimento;
        } else {
            throw new Exception("Valor passado para o campo 'Data' é invalido!");
        }
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) throws Exception {
        Pattern Pcpf = Pattern.compile("");
        Matcher verificacao = Pcpf.matcher(CPF);

        if (verificacao.matches()) {
            this.CPF = CPF;
        } else {
            throw new Exception("Entrada para o campo CPF INVALIDA!");
        }

    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) throws Exception {
        Pattern PRG = Pattern.compile("");
        Matcher verificacao = PRG.matcher(RG);

        if (verificacao.matches()) {
            this.RG = RG;
        } else {
            throw new Exception("Entrada para o campo RG INVALIDA!");
        }
    }

    public void addEmail(Email email) {
        if (!emails.contains(email)) {
            emails.add(email);
        }
    }

    public void removeEmail(Email email) {
        if (emails.contains(email)) {
            emails.remove(email);
        }
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void addEndereco(Endereco endereco) {
        if (!enderecos.contains(endereco)) {
            enderecos.add(endereco);
        }
    }

    public void removeEndereco(Endereco endereco) {
        if (enderecos.contains(endereco)) {
            enderecos.remove(endereco);
        }
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    //adicionar telefone
    public void addTelefone(Telefone telefone) {
        if (!telefones.contains(telefone)) {
            telefones.add(telefone);
        }
    }
    //Remover um Telefone

    public void removeTelefone(Telefone telefone) {
        if (telefones.contains(telefone)) {
            telefones.remove(telefone);
        }
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }
    // hashCode

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + this.codigo;
        hash = 43 * hash + Objects.hashCode(this.datanascimento);
        return hash;
    }
    // Equals 

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.datanascimento, other.datanascimento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    void setDataNascimento(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
