package com.car.Modelos;

import com.car.Enumerations.TipoCombustivel;
import com.car.Enumerations.TipoDoVeiculo;


public class Veiculos {
    private int id;
    private String placa;
    private TipoDoVeiculo tipoDoVeiculo;
    private Modelos modelo;
    private TipoCombustivel tipoCombustivel;
    private int quilometragemAtual;
    
    public Veiculos(){}
    
    public Veiculos(int id, String placa, TipoDoVeiculo tipoDoVeiculo, Modelos modelo, TipoCombustivel tipoCombustivel, int quilometragemAtual){
        this.id = id;
        this.placa = placa;
        this.tipoDoVeiculo = tipoDoVeiculo;
        this.modelo = modelo;
        this.tipoCombustivel = tipoCombustivel;
        this.quilometragemAtual = quilometragemAtual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TipoDoVeiculo getTipoDoVeiculo() {
        return tipoDoVeiculo;
    }

    public void setTipoDoVeiculo(TipoDoVeiculo tipoDoVeiculo) {
        this.tipoDoVeiculo = tipoDoVeiculo;
    }

    public Modelos getModelo() {
        return modelo;
    }

    public void setModelo(Modelos modelo) {
        this.modelo = modelo;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public int getQuilometragemAtual() {
        return quilometragemAtual;
    }

    public void setQuilometragemAtual(int quilometragemAtual) {
        this.quilometragemAtual = quilometragemAtual;
    }
    
    
}
