/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel;


import br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess.CaixaDAO;
import br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess.ClienteDAO;
import br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess.FornecedorDAO;
import br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess.FuncionarioDAO;
import br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess.PessoaDAO;
import br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess.ProdutoDAO;
import br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess.SecaoDAO;
import br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess.UsuarioDAO;
import java.util.Date;

/**
 *
 * @author Jessica
 */
public class Principal {

    public static void main(String[] args) throws Exception {

        Pessoa pessoa = new Pessoa();
        Email email = new Email();
        Endereco endereco = new Endereco();
        Telefone telefone = new Telefone();
        Usuario usuario = new Usuario();
        Cliente cliente = new Cliente();
        Funcionario funcionario = new Funcionario();
        Fornecedor fornecedor = new Fornecedor();
        Caixa caixa = new Caixa();
        Secao secao = new Secao();
        Produto produto =new Produto();


        pessoa.setNome("Jefferson");
        pessoa.setDataNascimento(new Date());
        pessoa.setCPF("");
        pessoa.setRG("");
        email.setEmail("Jefferson@yahoo.com");
        endereco.setBairro("Real");
        endereco.setCidade("Guanambi ");
        endereco.setRua("Rua 17");
        endereco.setNumero(678);
        telefone.setDDD(77);
        telefone.setTelefone(9123232);


        pessoa.addEmail(email);
        pessoa.addEndereco(endereco);
        pessoa.addTelefone(telefone);
        
        usuario.setLogin("Jessica");
        usuario.setSenha("123");
        usuario.setFuncionario(funcionario);
      
        
        cliente.setAtivo(1);
        funcionario.setEspecialidade("Esteticista");
        fornecedor.setCNPJ("a123b");
        caixa.setSaldo(20);
        secao.setFinalsecao(null);
        secao.setIniciosecao(null);
        secao.setSaldoinicial(20);
        secao.setSaldofinal(80);
        produto.setDescricao("20 kg");
        produto.setFornecedor(1);
        produto.setNome("Arroz");
        produto.setPreco(5);
        
        
       
       
        

        PessoaDAO dao = new PessoaDAO();
        UsuarioDAO daoo = new UsuarioDAO();
        ClienteDAO daooo = new ClienteDAO();
        FuncionarioDAO da = new FuncionarioDAO();
        FornecedorDAO daoooo = new FornecedorDAO();
        CaixaDAO daooooo = new CaixaDAO();
        SecaoDAO daao = new SecaoDAO();
        ProdutoDAO daaao = new ProdutoDAO();

      // dao.Salvar(pessoa);
      // daoo.Salvar(usuario);
      //  daooo.Salvar(cliente);
      //  da.Salvar(funcionario);
        //daoooo.Salvar(fornecedor);
       // daooooo.AbrirCaixa(1);
      // daao.Salvar(secao);
       daaao.SalvarProduto(produto);
       
        






    }
}
