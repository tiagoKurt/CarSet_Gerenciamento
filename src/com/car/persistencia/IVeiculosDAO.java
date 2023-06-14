package com.car.persistencia;

import com.car.Modelos.Veiculos;
import java.util.ArrayList;


public interface IVeiculosDAO {
    void inserirModelos(Veiculos veiculos) throws Exception;
    void alterar(Veiculos veiculos) throws Exception;
    boolean excluir(int idVeiculos)throws Exception;
    ArrayList<Veiculos> listagemDeModelos()throws Exception;
    Veiculos buscar(int id) throws Exception;
}
