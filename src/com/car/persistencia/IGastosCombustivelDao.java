/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.car.persistencia;

import com.car.Modelos.Gastos;
import com.car.Modelos.GastosCombustivel;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public interface IGastosCombustivelDao {
   void InserirGastos(GastosCombustivel gastos) throws Exception;
    void AlterarGastos(GastosCombustivel gastos) throws Exception;
    boolean ExcluirGastos(int id) throws Exception;
    ArrayList<GastosCombustivel> listaDeGastos() throws Exception;
    GastosCombustivel buscar(int id) throws Exception; 
    Gastos inserirGastosGerais() throws Exception;
    GastosCombustivel buscarUltimoRegistroInserido() throws Exception;
}
