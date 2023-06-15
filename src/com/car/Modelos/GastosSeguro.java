/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.car.Modelos;

import com.car.Enumerations.ClassificacaoGastos;
import java.sql.Date;

/**
 *
 * @author tiago
 */
public class GastosSeguro {
    private int id;
    private ClassificacaoGastos identificadorGasto;
    private String descricaoGastos;
    private float valorFranquia;
    private Date dataPagamento;
    private Veiculos veiculo;

    public GastosSeguro(int id, ClassificacaoGastos identificadorGasto, String descricaoGastos, float valorFranquia, Date dataPagamento, Veiculos veiculo) {
        this.id = id;
        this.identificadorGasto = identificadorGasto;
        this.descricaoGastos = descricaoGastos;
        this.valorFranquia = valorFranquia;
        this.dataPagamento = dataPagamento;
        this.veiculo = veiculo;
    }

    public GastosSeguro() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClassificacaoGastos getIdentificadorGasto() {
        return identificadorGasto;
    }

    public void setIdentificadorGasto(ClassificacaoGastos identificadorGasto) {
        this.identificadorGasto = identificadorGasto;
    }

    public String getDescricaoGastos() {
        return descricaoGastos;
    }

    public void setDescricaoGastos(String descricaoGastos) {
        this.descricaoGastos = descricaoGastos;
    }

    public float getValorFranquia() {
        return valorFranquia;
    }

    public void setValorFranquia(float valorFranquia) {
        this.valorFranquia = valorFranquia;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Veiculos getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculos veiculo) {
        this.veiculo = veiculo;
    }
    
    
}
