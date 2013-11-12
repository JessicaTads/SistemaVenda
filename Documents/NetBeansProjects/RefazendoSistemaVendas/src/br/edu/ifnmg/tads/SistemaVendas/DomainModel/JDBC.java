/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SistemaVendas.DomainModel;

import br.edu.ifnmg.tads.SistemaVendas.DataAccess.PessoaDAO;
import br.edu.ifnmg.tads.SistemaVendas.DataAccess.ProdutoDAO;
import br.edu.ifnmg.tads.SistemaVendas.DataAccess.VendaDAO;
import java.util.Date;

/**
 *
 * @author Jessica
 */
public class JDBC {
    
    public static void main(String[] args) throws Exception {
        
        Pessoa pessoa = new Pessoa();
        Produto produto = new Produto();
        Venda venda = new Venda();
        Email email= new Email();
        Endereco endereco = new Endereco();
        Telefone telefone = new Telefone();
        ItemVenda itemvenda = new ItemVenda();
        
        pessoa.setNome("blablabla");
        pessoa.setDataNascimento(new Date());
        email.setEmail("Cbrabra@yahoo.com");
        endereco.setBairro("VilaViana");
        endereco.setCEP(3948000);
        endereco.setCidade("Januaria");
        endereco.setEstado("Minas Gerais");
        endereco.setPais("Brasil");
        endereco.setRua("Rua Jose");
        endereco.setNumero(656);
        telefone.setDDD(38);
        telefone.setNumero(91615567);
        
        pessoa.addEmail(email);
        pessoa.addEndereco(endereco);
        pessoa.addTelefone(telefone);
        
        
        produto.setNome("Milho");
        produto.setPreco(5);
        produto.setTipo("Co");
        
       itemvenda.setProduto(produto);
       itemvenda.setQuantidade(10);
       
        venda.addItemVenda(itemvenda);
        venda.setPessoa(pessoa);
        venda.setValorTotal(itemvenda.getValor());
        venda.setData(new Date());
        
        PessoaDAO dao = new PessoaDAO();
        ProdutoDAO daao = new ProdutoDAO();
        VendaDAO daaoo = new VendaDAO();
        
        
        dao.Salvar(pessoa);
        daao.SalvarProduto(produto);
        daaoo.SalvarVenda(venda);
        
        
        
        
    }
    
}
