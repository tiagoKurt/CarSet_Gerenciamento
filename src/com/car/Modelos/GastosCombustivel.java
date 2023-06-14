/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.car.Modelos;

import com.car.Enumerations.ClassificacaoGastos;
import com.car.Enumerations.TipoCombustivel;
import com.car.Enumerations.TiposCombustiveisGastos;
import java.sql.Date;

/**
 *
 * @author tiago
 */
public class GastosCombustivel {
    private int id;
    private ClassificacaoGastos identificadorGasto;
    private TiposCombustiveisGastos descricao;
    private float quantidadeLitrosCombustivel;
    private float kmPercorridoVeiculo;
    private float valorLitroCombustivel;
    private float qntdKmPorLitroCarro;
    private Date dataAbastecimento;
    private Veiculos veiculos;

    public GastosCombustivel(int id, ClassificacaoGastos identificadorGasto, TiposCombustiveisGastos descricao, float quantidadeLitrosCombustivel, float kmPercorridoVeiculo, float valorLitroCombustivel, float qntdKmPorLitroCarro, Date dataAbastecimento,Veiculos veiculos) {
        this.id = id;
        this.identificadorGasto = identificadorGasto;
        this.descricao = descricao;
        this.quantidadeLitrosCombustivel = quantidadeLitrosCombustivel;
        this.kmPercorridoVeiculo = kmPercorridoVeiculo;
        this.valorLitroCombustivel = valorLitroCombustivel;
        this.qntdKmPorLitroCarro = qntdKmPorLitroCarro;
        this.dataAbastecimento = dataAbastecimento;
        this.veiculos = veiculos;
    }

    public GastosCombustivel() {

    }

    public Veiculos getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Veiculos veiculos) {
        this.veiculos = veiculos;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataAbastecimento() {
        return dataAbastecimento;
    }

    public void setDataAbastecimento(Date dataAbastecimento) {
        this.dataAbastecimento = dataAbastecimento;
    }

    public ClassificacaoGastos getIdentificadorGasto() {
        return identificadorGasto;
    }

    public void setIdentificadorGasto(ClassificacaoGastos identificadorGasto) {
        this.identificadorGasto = identificadorGasto;
    }

    public TiposCombustiveisGastos getDescricao() {
        return descricao;
    }

    public void setDescricao(TiposCombustiveisGastos descricao) {
        this.descricao = descricao;
    }

    public float getQuantidadeLitrosCombustivel() {
        return quantidadeLitrosCombustivel;
    }

    public void setQuantidadeLitrosCombustivel(float quantidadeLitrosCombustivel) {
        this.quantidadeLitrosCombustivel = quantidadeLitrosCombustivel;
    }

    public float getKmPercorridoVeiculo() {
        return kmPercorridoVeiculo;
    }

    public void setKmPercorridoVeiculo(float kmPercorridoVeiculo) {
        this.kmPercorridoVeiculo = kmPercorridoVeiculo;
    }

    public float getValorLitroCombustivel() {
        return valorLitroCombustivel;
    }

    public void setValorLitroCombustivel(float valorLitroCombustivel) {
        this.valorLitroCombustivel = valorLitroCombustivel;
    }

    public float getQntdKmPorLitroCarro() {
        return qntdKmPorLitroCarro;
    }

    public void setQntdKmPorLitroCarro(float qntdKmPorLitroCarro) {
        this.qntdKmPorLitroCarro = qntdKmPorLitroCarro;
    }
    
    
}
