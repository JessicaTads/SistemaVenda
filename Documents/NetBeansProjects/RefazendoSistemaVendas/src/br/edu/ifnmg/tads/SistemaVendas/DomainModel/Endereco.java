/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SistemaVendas.DomainModel;

import java.util.Objects;

/**
 *
 * @author Jessica
 */
public class Endereco {
    private int codigo;
    private String rua;
    private int numero;
    private String bairro;
    private int CEP;
    private String cidade;
    private String estado;
    private String pais;
    private Pessoa pessoa;

    public Endereco(int codigo, String rua, int numero, int CEP, String cidade, String pais, Pessoa pessoa, String bairro) {
        this.codigo = codigo;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.CEP = CEP;
        this.cidade = cidade;
        this.pais = pais;
        this.pessoa = pessoa;
    }
    
    public Endereco() {
        this.codigo = 0;
        this.bairro = "";
        this.rua = "";
        this.numero = 0;
        this.CEP = 0;
        this.cidade = "";
        this.pais = "";
        this.pessoa = new Pessoa();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws ErroValidacaoException{
        if (codigo > 0){
            this.codigo = codigo;    
        } else {
            throw new ErroValidacaoException("Código Endereço Inválido. Insira um código maior que 0.");
        }
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) throws ErroValidacaoException{
        if ((rua.length() >= 3) && (rua.length() <= 250)){
            this.rua = rua;
        } else {
            throw new ErroValidacaoException("Rua Inválida. Insira uma rua com no minimo 3 caracteres e com no máximo 250 caracteres.");
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero)throws ErroValidacaoException {
        if (numero > 0) {
            this.numero = numero;
        } else {
            throw new ErroValidacaoException("Número Inválido. Insira um número maior que 0.");
        }
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) throws ErroValidacaoException{
        if ((bairro.length() >= 3) && (bairro.length() <= 250)){    
            this.bairro = bairro;
        } else {
            throw new ErroValidacaoException("Baiiro Inválido. Insira um bairro com no minimo 3 caracteres e com no máximo 250 caracteristicas.");
        } 
    }

    public int getCEP() {
        return CEP;
    }

    public void setCEP(int CEP) {
        this.CEP = CEP;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) throws ErroValidacaoException {
        if ((cidade.length() >= 3) && (cidade.length() <= 250)){
            this.cidade = cidade;    
        } else {
            throw new ErroValidacaoException("Cidade Inválida. Insira uma cidade com no minimo 3 caracteres e com no máximo 250 caracteristicas.");
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) throws ErroValidacaoException{
        if ((estado.length()>=3) && (estado.length() <= 250)){
            this.estado = estado;
        } else {
            throw new ErroValidacaoException("Estado Inválido. Insira um estado com no minimo 3 caracteres e com no máximo 250 caracteristicas.");
        }
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais)throws ErroValidacaoException{
        if ((pais.length()>=3) && (pais.length() <= 250)){
            this.pais = pais;
        } else {
            throw new ErroValidacaoException("País Inválido. Insira um país com no minimo 3 caracteres e com no máximo 250 caracteristicas.");
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
        int hash = 7;
        hash = 29 * hash + this.codigo;
        hash = 29 * hash + Objects.hashCode(this.rua);
        hash = 29 * hash + this.numero;
        hash = 29 * hash + Objects.hashCode(this.bairro);
        hash = 29 * hash + this.CEP;
        hash = 29 * hash + Objects.hashCode(this.cidade);
        hash = 29 * hash + Objects.hashCode(this.estado);
        hash = 29 * hash + Objects.hashCode(this.pais);
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
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (this.CEP != other.CEP) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.pais, other.pais)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Endereco{" + "rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", pais=" + pais + '}';
    }

    public void setCEP(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
