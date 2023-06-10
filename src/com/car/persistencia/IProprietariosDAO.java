package com.car.persistencia;

import com.car.Modelos.Proprietario;
import java.util.ArrayList;

public interface IProprietariosDAO {
    
    void incluirProprietario(Proprietario proprietario) throws Exception;
    boolean excluirProprietario(int idProprietario) throws Exception;
    ArrayList<Proprietario> listagemProprietarios() throws Exception;
    void alterarProprietario(Proprietario proprietario) throws Exception;
    Proprietario buscarProprietario(int id) throws Exception;    
}
