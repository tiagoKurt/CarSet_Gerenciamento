/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.car.persistencia;

import com.car.Modelos.Gastos;
import com.car.Modelos.GastosMecanico;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public interface IGastosMecanicoDao {
    void InserirGastos(GastosMecanico gastos) throws Exception;
    void AlterarGastos(GastosMecanico gastos) throws Exception;
    boolean ExcluirGastos(int id) throws Exception;
    ArrayList<GastosMecanico> listaDeGastos() throws Exception;
    GastosMecanico buscar(int id) throws Exception; 
    Gastos inserirGastosGerais() throws Exception;
    GastosMecanico buscarUltimoRegistroInserido() throws Exception;
}
