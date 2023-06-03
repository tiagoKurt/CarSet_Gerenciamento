package com.car.persistencia;

import com.car.Modelos.Servico;
import java.util.ArrayList;

public interface IServicosDAO {
    void InserirServico(Servico servico) throws Exception;
    void AlterarServico(Servico servico) throws Exception;
    boolean excluirServico(int idServico) throws Exception;
    ArrayList<Servico> listagemServicos() throws Exception;
}
