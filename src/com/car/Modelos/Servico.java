package com.car.Modelos;

import java.io.File;


public class Servico {
    private int id= 0;
    private String descricao;
    private String url;
    private File imagemServico;
    
    public Servico(){}
    
    public Servico(int id, String descricao, String url, File imagemServico){
        this.id = id;
        this.descricao = descricao;
        this.imagemServico = imagemServico;  
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public File getImagemServico() {
        return imagemServico;
    }

    public void setImagemServico(File imagemServico) {
        this.imagemServico = imagemServico;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
