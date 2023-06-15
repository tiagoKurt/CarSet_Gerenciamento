
package com.car.Modelos;

import com.car.Enumerations.ClassificacaoGastos;
import java.sql.Date;


public class GastosImposto {
     private int id;
     private ClassificacaoGastos identificadorGasto;
     private String descricaoGasto;
     private String tipoDocarro;
     private float valorGasto;
     private Date datapagamento;
     private Veiculos veiculo;

    public GastosImposto(int id, ClassificacaoGastos identificadorGasto, String descricaoGasto, String tipoDocarro, float valorGasto, Date datapagamento, Veiculos veiculo) {
        this.id = id;
        this.identificadorGasto = identificadorGasto;
        this.descricaoGasto = descricaoGasto;
        this.tipoDocarro = tipoDocarro;
        this.valorGasto = valorGasto;
        this.datapagamento = datapagamento;
        this.veiculo = veiculo;
    }

    public GastosImposto() {
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

    public String getDescricaoGasto() {
        return descricaoGasto;
    }

    public void setDescricaoGasto(String descricaoGasto) {
        this.descricaoGasto = descricaoGasto;
    }

    public String getTipoDocarro() {
        return tipoDocarro;
    }

    public void setTipoDocarro(String tipoDocarro) {
        this.tipoDocarro = tipoDocarro;
    }

    public float getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(float valorGasto) {
        this.valorGasto = valorGasto;
    }

    public Date getDatapagamento() {
        return datapagamento;
    }

    public void setDatapagamento(Date datapagamento) {
        this.datapagamento = datapagamento;
    }

    public Veiculos getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculos veiculo) {
        this.veiculo = veiculo;
    }
     
    
    
    
}
