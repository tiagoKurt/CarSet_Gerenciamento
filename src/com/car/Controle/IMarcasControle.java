package com.car.Controle;

import com.car.Modelos.Marcas;
import java.util.ArrayList;


public interface IMarcasControle {
    void InserirMarca(Marcas marca) throws Exception;
    void alterarMarca(Marcas marca) throws Exception;
    boolean excluirMarca(int idmarcas) throws Exception;
    ArrayList<Marcas> listaDeMarcas() throws Exception;
    Marcas buscar(int id) throws Exception;    
}
