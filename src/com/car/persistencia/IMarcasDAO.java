package com.car.persistencia;

import com.car.Modelos.Marcas;
import java.util.ArrayList;


public interface IMarcasDAO {
    void InserirMarca(Marcas marca) throws Exception;
    void alterarMarca(Marcas marca) throws Exception;
    boolean excluirMarca(Marcas marca) throws Exception;
    ArrayList<Marcas> listaDeMarcas() throws Exception;
}
