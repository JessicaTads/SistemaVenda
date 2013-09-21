/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package usandojdbc;

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
public class Pessoa {
    
    
    private String nome;
    private int codigo;
    private Date DataNascimento;
    private List<Email> emails;
    private List<Telefone> telefones;
    private List<Endereco> enderecos;
    private List<Venda> vendas;

    /*---------- Construtor --------------------------------------------------*/
    public Pessoa(String nome, int codigo, Date DataNascimento, List<Email> emails, List<Telefone> telefones, List<Endereco> enderecos, List<Venda> vendas) {
        this.nome = nome;
        this.codigo = codigo;
        this.DataNascimento = DataNascimento;
        this.emails = emails;
        this.telefones = telefones;
        this.enderecos = enderecos;
        this.vendas = vendas;
    }
    
  
    public Pessoa() {
        this.nome = "";
        this.codigo = 0;
        this.DataNascimento = new Date();
        this.emails = new ArrayList<>();
        this.telefones = new ArrayList<>();
        this.enderecos = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
       Pattern Nome = Pattern.compile("[0-9\\w\\s]{3,}");
        Matcher verifica = Nome.matcher(nome);
        
        if(verifica.matches())
             this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo)  throws Exception{
       try{
        if(codigo >= 0){
        this.codigo = codigo;
        }
    }catch(Exception ex){
            throw new Exception("Codigo invalido");
            
        }
            
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public String setDataNascimento(String DataNascimento) {
       return DataNascimento;
    }
    
   public void addEmail(Email email){
        if(!emails.contains(email)){
            emails.add(email);
        }
    }
   
   public void removeEmail(Email email){
        if(emails.contains(email)){
            emails.remove(email);
        }
    } 
   
    public List<Email> getEmails(){
        return emails;
    }
    
    public void addTelefone(Telefone telefone){
        if(!telefones.contains(telefone)){
            telefones.add(telefone);
        }
    }
    
     public void removeTelefone(Telefone telefone){
        if(telefones.contains(telefone)){
            telefones.remove(telefone);
        }
    } 
     public List<Telefone> getTelefones(){
        return telefones;
    }
    
     public void addEndereco(Endereco endereco){
        if(!enderecos.contains(endereco)){
            enderecos.add(endereco);
        }
    }
    
     public void removeEndereco(Endereco endereco){
        if(enderecos.contains(endereco)){
            enderecos.remove(endereco);
        }
    } 
     public List<Endereco> getEnderecos(){
        return enderecos;
    }
    public void addVenda(Venda venda){
        if(!vendas.contains(venda)){
            vendas.add(venda);
        }
    }
    
     public void removeVenda(Venda venda){
        if(vendas.contains(venda)){
            vendas.remove(venda);
        }
    } 
     public List<Venda> getVendas(){
        return vendas;
    }
   
  

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + this.codigo;
        hash = 97 * hash + Objects.hashCode(this.DataNascimento);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.DataNascimento, other.DataNascimento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", codigo=" + codigo + '}';
    }

    void addEmail(String emailteste) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setDataNascimento(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
    
    
}
