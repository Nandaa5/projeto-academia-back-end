package com.cefet.projeto_academia.dto;


import com.cefet.projeto_academia.entities.Pessoa;
import com.cefet.projeto_academia.entities.Usuario;

public class UsuarioDTO {

    private Long id;
    private String login;
    private String senha;
    private String tipo;
    private Pessoa pessoa;

    public UsuarioDTO() {
    
    }

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.tipo = usuario.getTipo();
        this.pessoa = usuario.getPessoa();
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha(){
        return senha;
    }

    public String getTipo() {
        return tipo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
 
}
