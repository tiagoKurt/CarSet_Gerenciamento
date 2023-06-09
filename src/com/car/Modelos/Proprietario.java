package com.car.Modelos;

import com.car.Enumerations.CategoriaCNH;
import com.car.Enumerations.tipoProprietario;


public class Proprietario {
    private tipoProprietario tipoDoProprietario;
    private String CPF_CNPJ;
    private String nome;
    private String telefone;
    private String email;
    private String CNH;
    private CategoriaCNH categoriaCNH;
    
    public Proprietario(){}
    
    public Proprietario(tipoProprietario tipoDoProprietario, String CPF_CNPJ, String nome, String telefone, String email, String CNH, 
           CategoriaCNH categoriaCNH){
        this.tipoDoProprietario = tipoDoProprietario;
        this.CPF_CNPJ = CPF_CNPJ;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.CNH = CNH;
        this.categoriaCNH = categoriaCNH;
    }

    public tipoProprietario getTipoDoProprietario() {
        return tipoDoProprietario;
    }

    public void setTipoDoProprietario(tipoProprietario tipoDoProprietario) {
        this.tipoDoProprietario = tipoDoProprietario;
    }

    public String getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public void setCPF_CNPJ(String CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
