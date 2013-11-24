/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jessica
 */
public class Servico extends Agendamento{

    private int codigo;
    private double valor;
    private String descricao;
    private List<Produto> produto;
    private String formapagamento;
    private Date data;
    private Agendamento agendamento;
    private TipoServico tipo;

    public Servico(int codigo, double valor, String descricao, List<Produto> produto, String formapagamento, Date data, Agendamento agendamento, TipoServico tipo) {
        this.codigo = codigo;
        this.valor = valor;
        this.descricao = descricao;
        this.produto = produto;
        this.formapagamento = formapagamento;
        this.data = data;
        this.agendamento = agendamento;
        this.tipo = tipo;

    }

    public Servico() {
        this.codigo = 0;
        this.valor = 0;
        this.descricao = "";
        this.produto = new ArrayList<Produto>();
        this.formapagamento = "";
        this.data = data;
        this.agendamento = agendamento;
        this.tipo = new TipoServico();
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) throws Exception {
        if (valor > 0) {
            this.valor = valor;
        } else {
            throw new Exception("Valor passado para o campo 'Preço' não pode ser negativo!");
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

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

    public String getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public TipoServico getTipo() {
        return tipo;
    }

    public void setTipo(TipoServico tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.codigo;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.descricao);
        hash = 79 * hash + Objects.hashCode(this.produto);
        hash = 79 * hash + Objects.hashCode(this.formapagamento);
        hash = 79 * hash + Objects.hashCode(this.data);
        hash = 79 * hash + Objects.hashCode(this.agendamento);
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
        final Servico other = (Servico) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.formapagamento, other.formapagamento)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.agendamento, other.agendamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servico{" + "codigo=" + codigo + '}';
    }
}
