package com.car.Controle;

import com.car.Modelos.Modelos;
import com.car.persistencia.ModelosDAO;
import java.util.ArrayList;


public class ModelosControle implements IModelosControle{

    @Override
    public void inserirModelos(Modelos modelos) throws Exception {
        ModelosDAO model = new ModelosDAO();
        model.inserirModelos(modelos);
    }

    @Override
    public void alterar(Modelos modelos) throws Exception {
        ModelosDAO model = new ModelosDAO();
        model.alterar(modelos);
    }

    @Override
    public boolean excluir(int idModelos) throws Exception {
        ModelosDAO model = new ModelosDAO();
        return model.excluir(idModelos);
    }

    @Override
    public ArrayList<Modelos> listagemDeModelos() throws Exception {
        ModelosDAO model = new ModelosDAO();
        return model.listagemDeModelos();
    }

    @Override
    public Modelos buscar(int id) throws Exception {
        ModelosDAO model = new ModelosDAO();
        return model.buscar(id);
    }
    
}
