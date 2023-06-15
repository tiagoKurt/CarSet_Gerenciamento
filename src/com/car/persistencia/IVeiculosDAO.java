package com.car.persistencia;

import com.car.Modelos.Veiculos;
import java.util.ArrayList;


public interface IVeiculosDAO {
    void inserirVeiculos(Veiculos veiculo) throws Exception;
    void alterar(Veiculos veiculo) throws Exception;
    boolean excluir(String placa)throws Exception;
    ArrayList<Veiculos> listagemDeModelos()throws Exception;
    Veiculos buscarPeloId(int id) throws Exception;
    Veiculos buscarVeiculos(String placa)throws Exception;
}
