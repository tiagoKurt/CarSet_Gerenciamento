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
}
