package com.cefet.projeto_academia.dto;


import com.cefet.projeto_academia.entities.Usuario;

public class UsuarioDTO {

    private Long id;
    private String login;
    private String tipo;
    private Long idPessoa;

       public UsuarioDTO() {
    
    }

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.login = usuario.getLogin();
        this.tipo = usuario.getTipo();
        this.idPessoa = usuario.getPessoa().getId();
    }

     public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getTipo() {
        return tipo;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }


  
}
