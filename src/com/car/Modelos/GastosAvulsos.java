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
public class GastosAvulsos {
    private int id;
    private ClassificacaoGastos identificadorGasto;
    private String  descgasto;
    private float valorGasto;
    private Date dataRealizacao;
    private Veiculos veiculo;

    public GastosAvulsos(int id, ClassificacaoGastos identificadorGasto, String descgasto, float valorGasto, Date dataRealizacao, Veiculos veiculo) {
        this.id = id;
        this.identificadorGasto = identificadorGasto;
        this.descgasto = descgasto;
        this.valorGasto = valorGasto;
        this.dataRealizacao = dataRealizacao;
        this.veiculo = veiculo;
    }

    public GastosAvulsos() {
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

    public String getDescgasto() {
        return descgasto;
    }

    public void setDescgasto(String descgasto) {
        this.descgasto = descgasto;
    }

    public float getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(float valorGasto) {
        this.valorGasto = valorGasto;
    }

    public Date getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(Date dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public Veiculos getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculos veiculo) {
        this.veiculo = veiculo;
    }
    
}
