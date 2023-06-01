package com.car.Modelos;


public class cadastroPessoas {
    private String nomeUsuario;
    private String senha;
    
    public cadastroPessoas(){}
    
    public cadastroPessoas(String nomeUsuario, String senha){
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        
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
    
}
