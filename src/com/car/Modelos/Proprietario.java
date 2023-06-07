package com.car.Modelos;

import com.car.Enumerations.CategoriaCNH;


public class Proprietario {
    private String CPF;
    private String CNPJ;
    private String nome;
    private String telefone;
    private String email;
    private String CNH;
    private CategoriaCNH categoriaCNH;
    
    public Proprietario(){}
    
    public Proprietario(String CPF, String CNPJ, String nome, String telefone, String email, String CNH, CategoriaCNH categoriaCNH){
        this.CPF = CPF;
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.CNH = CNH;
        this.categoriaCNH = categoriaCNH;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCNH() {
        return CNH;
    }

    public void setCNH(String CNH) {
        this.CNH = CNH;
    }

    public CategoriaCNH getCategoriaCNH() {
        return categoriaCNH;
    }

    public void setCategoriaCNH(CategoriaCNH categoriaCNH) {
        this.categoriaCNH = categoriaCNH;
    }
    
    
}
