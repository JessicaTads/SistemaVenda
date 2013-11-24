/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel;

import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jessica
 */
public class Produto {

    private int codigo;
    private String nome;
    private float preco;
    private String descricao;
    private Date datavencimento;
    private TipoProduto tipo;
    private int fornecedor;

    public Produto(int codigo, String nome, float preco, String descricao, Date datavencimento, TipoProduto tipo, int fornecedor) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.datavencimento = datavencimento;
        this.tipo = tipo;
        this.fornecedor = fornecedor;
    }

    public Produto() {
        this.codigo = 0;
        this.nome = "";
        this.preco = 0;
        this.descricao = "";
        this.datavencimento = new Date();
        this.tipo = new TipoProduto();
        this.fornecedor = 0;
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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) throws Exception {
        if (preco > 0) {
            this.preco = preco;
        } else {
            throw new Exception("Preco negativo");
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws Exception {
        Pattern Descricao = Pattern.compile("[\\w\\s]{3,}");
        Matcher verifica = Descricao.matcher(descricao);

        if (verifica.matches()) {
            this.descricao = descricao;
        } else {
            throw new Exception("Campo 'Descrição' deve ter no mínimo 3 caracteres");
        }
    }

    public Date getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(Date datavencimento) {
        this.datavencimento = datavencimento;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.codigo;
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + Float.floatToIntBits(this.preco);
        hash = 47 * hash + Objects.hashCode(this.descricao);
        hash = 47 * hash + Objects.hashCode(this.datavencimento);
        hash = 47 * hash + Objects.hashCode(this.tipo);
        hash = 47 * hash + this.fornecedor;
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
        if (Float.floatToIntBits(this.preco) != Float.floatToIntBits(other.preco)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.datavencimento, other.datavencimento)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (this.fornecedor != other.fornecedor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", nome=" + nome + ", preco=" + preco + ", descricao=" + descricao + '}';
    }
}
