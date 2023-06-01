package com.car.Modelos;


public class cadastroPessoas {
    private String nomeUsuario;
    private String email;
    private String senha;
    
    public cadastroPessoas(){}
    
    public cadastroPessoas(String nomeUsuario, String email, String senha){
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.email = email;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
