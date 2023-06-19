package com.car.Controle;

import com.car.Modelos.Marcas;
import com.car.persistencia.MarcasDAO;
import java.util.ArrayList;

public class MarcasControle implements IMarcasControle {

    @Override
    public void InserirMarca(Marcas marca) throws Exception {
        MarcasDAO marc = new MarcasDAO();
        marc.InserirMarca(marca);
    }

    @Override
    public void alterarMarca(Marcas marca) throws Exception {
        MarcasDAO marc = new MarcasDAO();
        marc.alterarMarca(marca);
    }

    @Override
    public boolean excluirMarca(int idmarcas) throws Exception {
        MarcasDAO marc = new MarcasDAO();
        return marc.excluirMarca(idmarcas);
    }

    @Override
    public ArrayList<Marcas> listaDeMarcas() throws Exception {
        MarcasDAO marc = new MarcasDAO();
        return marc.listaDeMarcas();
    }

    @Override
    public Marcas buscar(int id) throws Exception {
        MarcasDAO marc = new MarcasDAO();
        return marc.buscar(id);
    }

}
