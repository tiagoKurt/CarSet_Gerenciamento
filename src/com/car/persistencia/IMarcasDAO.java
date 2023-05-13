package com.car.persistencia;

import com.car.Modelos.Marcas;
import java.sql.ResultSet;
import java.util.ArrayList;


public interface IMarcasDAO {
    void InserirMarca(Marcas marca) throws Exception;
    void alterarMarca(Marcas marca) throws Exception;
    boolean excluirMarca(int idmarcas) throws Exception;
    ArrayList<Marcas> listaDeMarcas() throws Exception;

}
