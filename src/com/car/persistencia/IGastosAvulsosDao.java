/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.car.persistencia;

import com.car.Modelos.Gastos;
import com.car.Modelos.GastosAvulsos;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public interface IGastosAvulsosDao {
   void InserirGastos(GastosAvulsos gastos) throws Exception;
    void AlterarGastos(GastosAvulsos gastos) throws Exception;
    boolean ExcluirGastos(int id) throws Exception;
    ArrayList<GastosAvulsos> listaDeGastos() throws Exception;
    GastosAvulsos buscar(int id) throws Exception; 
    Gastos inserirGastosGerais() throws Exception;
    GastosAvulsos buscarUltimoRegistroInserido() throws Exception; 
}
