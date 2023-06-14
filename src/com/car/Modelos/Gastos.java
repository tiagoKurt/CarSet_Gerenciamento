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
public class Gastos {
    private int id;
    private int idGasto;
    private ClassificacaoGastos identificadorGasto;
    private String descricao;
    private float gastoTotal;
    private Date dataGasto;
    
    public Gastos(){
    }
    
    public Gastos(int id, int idGasto, ClassificacaoGastos identificadorGasto, String descricao, float gastoTotal,Date dataGasto) {
        this.id = id;
        this.idGasto = idGasto;
        this.identificadorGasto = identificadorGasto;
        this.descricao = descricao;
        this.gastoTotal = gastoTotal;
        this.dataGasto = dataGasto;
    }

    public Date getDataGasto() {
        return dataGasto;
    }

    public void setDataGasto(Date dataGasto) {
        this.dataGasto = dataGasto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    public ClassificacaoGastos getIdentificadorGasto() {
        return identificadorGasto;
    }

    public void setIdentificadorGasto(ClassificacaoGastos identificadorGasto) {
        this.identificadorGasto = identificadorGasto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(float gastoTotal) {
        this.gastoTotal = gastoTotal;
    }
    
    
    
    
    
    
}
