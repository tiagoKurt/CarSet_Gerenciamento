package com.car.Modelos;

import java.io.File;
import java.io.FileInputStream;


public class Marcas {
    private int id = 0;
    private String descricao = "";
    private String url = "";
    private File imageFile = new File("");

    
    public Marcas(){}
    public Marcas(int id, String descricao, String url, File imageFile){
        this.id = id;
        this.descricao = descricao;
        this.url = url;
        this.imageFile = imageFile;
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

    public File getImageFile() {
        return imageFile;
    }

    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
    }
    
    @Override
    public String toString() {
        return id + ";" + descricao + ";" + url + ';';
    }
    
    
}
