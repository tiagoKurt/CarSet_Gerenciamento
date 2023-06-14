/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.car.persistencia;

import com.car.Modelos.Gastos;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public interface IGastosDao {
    void InserirGastos(Gastos gastos) throws Exception;
    void AlterarGastos(Gastos gastos) throws Exception;
    boolean ExcluirGastos(int id) throws Exception;
    ArrayList<Gastos> listaDeGastos() throws Exception;
    Gastos buscar(int id) throws Exception;
}
