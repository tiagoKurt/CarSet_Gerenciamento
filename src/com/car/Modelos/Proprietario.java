package com.car.Modelos;

import com.car.Enumerations.CategoriaCNH;


public class Proprietario {
    private String CPF;
    private String nome;
    private String telefone;
    private String CNH;
    private CategoriaCNH categoriaCNH;
    
    public Proprietario(){}
    
    public Proprietario(String CPF, String nome, String telefone, String CNH, CategoriaCNH categoriaCNH){
        this.CPF = CPF;
        this.nome = nome;
        this.telefone = telefone;
        this.CNH = CNH;
        this.categoriaCNH = categoriaCNH;
    }
}
