package com.car.persistencia;

import com.car.Modelos.Modelos;
import java.util.ArrayList;


public interface IModelosDAO {
    void inserirModelos(Modelos modelos) throws Exception;
    void alterar(Modelos modelos) throws Exception;
    boolean excluir(int idModelos)throws Exception;
    ArrayList<Modelos> listagemDeModelos()throws Exception;
}
