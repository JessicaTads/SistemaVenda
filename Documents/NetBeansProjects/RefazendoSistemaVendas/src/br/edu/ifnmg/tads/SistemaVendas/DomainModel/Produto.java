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
public class Produto {
    private int codigo;
    private String nome;
    private String tipo;
    private double preco;

    public Produto(int codigo, String nome, String tipo, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
    }
    public Produto() {
        this.codigo = 0;
        this.nome = "";
        this.tipo = "";
        this.preco = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws ErroValidacaoException{
        if (codigo > 0){
            this.codigo = codigo;
        } else {
            throw new ErroValidacaoException("Código Produto Inválido. Insira um código maior que 0.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ErroValidacaoException{
        if ((nome.length() >= 3) && (nome.length() <= 250)){
            this.nome = nome;
        } else {
            throw new ErroValidacaoException("Nome Inválido. Insira um nome com no minimo 3 caracteres e com no máximo 250 caracteres.");
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) throws ErroValidacaoException{
        if (preco > 0){
            this.preco = preco;
        } else {
        throw new ErroValidacaoException("Valor  Inválido. Insira um valor maior que 0.");
        }    
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.codigo;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.tipo);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
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
        final Produto other = (Produto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + '}';
    }
    
    
    
    
    
    
}
