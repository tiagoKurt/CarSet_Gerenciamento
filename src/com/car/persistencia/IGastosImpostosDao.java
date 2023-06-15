/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.car.persistencia;
import com.car.Modelos.Gastos;
import com.car.Modelos.GastosImposto;
import java.util.ArrayList;
/**
 *
 * @author tiago
 */
public interface IGastosImpostosDao {
   void InserirGastos(GastosImposto gastos) throws Exception;
    void AlterarGastos(GastosImposto gastos) throws Exception;
    boolean ExcluirGastos(int id) throws Exception;
    ArrayList<GastosImposto> listaDeGastos() throws Exception;
    GastosImposto buscar(int id) throws Exception; 
    Gastos inserirGastosGerais() throws Exception;
    GastosImposto buscarUltimoRegistroInserido() throws Exception; 
}
