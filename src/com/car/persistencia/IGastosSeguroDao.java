/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.car.persistencia;

import com.car.Modelos.Gastos;
import com.car.Modelos.GastosSeguro;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public interface IGastosSeguroDao {
   void InserirGastos(GastosSeguro gastos) throws Exception;
    void AlterarGastos(GastosSeguro gastos) throws Exception;
    boolean ExcluirGastos(int id) throws Exception;
    ArrayList<GastosSeguro> listaDeGastos() throws Exception;
    GastosSeguro buscar(int id) throws Exception; 
    Gastos inserirGastosGerais() throws Exception;
    GastosSeguro buscarUltimoRegistroInserido() throws Exception; 
}
