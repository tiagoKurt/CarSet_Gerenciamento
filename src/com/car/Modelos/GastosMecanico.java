package com.car.Modelos;

import com.car.Enumerations.ClassificacaoGastos;
import java.sql.Date;

public class GastosMecanico {
    private int id;
    private ClassificacaoGastos identificadorGasto;
    private String decricaoGasto;
    private int quantidadeDeItensManutencao;
    private float valorItemManutencao;
    private float valorMaoDeObra;
    private Date dataManutencao;
    private Veiculos veiculo;

    public GastosMecanico(int id, ClassificacaoGastos identificadorGasto, String decricaoGasto, int quantidadeDeItensManutencao, float valorItemManutencao, float valorMaoDeObra, Date dataManutencao, Veiculos veiculo) {
        this.id = id;
        this.identificadorGasto = identificadorGasto;
        this.decricaoGasto = decricaoGasto;
        this.quantidadeDeItensManutencao = quantidadeDeItensManutencao;
        this.valorItemManutencao = valorItemManutencao;
        this.valorMaoDeObra = valorMaoDeObra;
        this.dataManutencao = dataManutencao;
        this.veiculo = veiculo;
    }
    public GastosMecanico(){
        
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

    public String getDecricaoGasto() {
        return decricaoGasto;
    }

    public void setDecricaoGasto(String decricaoGasto) {
        this.decricaoGasto = decricaoGasto;
    }

    public int getQuantidadeDeItensManutencao() {
        return quantidadeDeItensManutencao;
    }

    public void setQuantidadeDeItensManutencao(int quantidadeDeItensManutencao) {
        this.quantidadeDeItensManutencao = quantidadeDeItensManutencao;
    }

    public float getValorItemManutencao() {
        return valorItemManutencao;
    }

    public void setValorItemManutencao(float valorItemManutencao) {
        this.valorItemManutencao = valorItemManutencao;
    }

    public float getValorMaoDeObra() {
        return valorMaoDeObra;
    }

    public void setValorMaoDeObra(float valorMaoDeObra) {
        this.valorMaoDeObra = valorMaoDeObra;
    }

    public Date getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(Date dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public Veiculos getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculos veiculo) {
        this.veiculo = veiculo;
    }
    
    
    
}
