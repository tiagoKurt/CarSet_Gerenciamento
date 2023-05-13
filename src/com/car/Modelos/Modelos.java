package com.car.Modelos;

import java.io.File;


public class Modelos {
    private int idModelos = 0;
    private Marcas marca;
    private String descricao = "";
    private String url = "";
    private File imagemModelo = new File("");
    
    public Modelos(){}
    
    public Modelos(int idModelos, Marcas marca, String descricao, String url, File imagemModelo){
        this.idModelos = idModelos;
        this.marca = marca;
        this.descricao = descricao;
        this.url = url;
        this.imagemModelo = imagemModelo;
    }

    public int getIdModelos() {
        return idModelos;
    }

    public void setIdModelos(int idModelos) {
        this.idModelos = idModelos;
    }

    public Marcas getMarca() {
        return marca;
    }

    public void setMarca(Marcas marca) {
        this.marca = marca;
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

    public File getImagemModelo() {
        return imagemModelo;
    }

    public void setImagemModelo(File imagemModelo) {
        this.imagemModelo = imagemModelo;
    }
    
}
