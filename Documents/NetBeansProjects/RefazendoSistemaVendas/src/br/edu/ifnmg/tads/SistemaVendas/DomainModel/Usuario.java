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
public class Usuario extends Pessoa{
    private int codigo;
    private String usuario;
    private String senha;
    private Pessoa pessoa;

    public Usuario(int Codigo, String usu, String sen, Pessoa apessoa){
        codigo = codigo;
        usuario = usuario;
        senha = senha;
        pessoa = apessoa;
    }
    
    public Usuario() {
        codigo = 0;
        usuario = "";
        senha = "";   
    }
        
    public int getCodigo() {
        return codigo;
    }
   
    public void setCodusuario(int codigo) throws ErroValidacaoException {
        if (codigo > 0){
            this.codigo = codigo;
        } else {
            throw new ErroValidacaoException("Código Usuário Inválido. Insira um código maior que 0.");
        }
    }
    public String getNomeUsuario() {
        return usuario;
    }

    public void setNomeUsuario(String usuario) throws ErroValidacaoException{
        if ((usuario.length() >=3) && (usuario.length() <=250)){
            this.usuario = usuario;
        } else {
            throw new ErroValidacaoException("Usuário Inválido. Insira um usuário com no minimo 3 caracteres e com no máximo 250 caracteristicas.");
        }
    }
    public String getSenhaUsuario() {
        return senha;
    }

    public void setSenhaUsuario(String senha) throws ErroValidacaoException{
        if ((senha.length() >=3) && (senha.length() <=250)){
            this.senha = senha;
        } else {
            throw new ErroValidacaoException("Senha Inválida. Insira uma senha com no minimo 3 caracteres e com no máximo 250 caracteristicas.");
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
        int hash = 3;
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
        final Usuario other = (Usuario) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNome();
    }
}


