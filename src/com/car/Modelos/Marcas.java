package com.car.Modelos;


public class Marcas {
    private int id = 0;
    private String descricao = "";
    private String url = "";
    
    public Marcas(){}
    public Marcas(int id, String descricao, String url){
        this.id = id;
        this.descricao = descricao;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return id + ";" + descricao + ";" + url + ';';
    }
    
    
}
