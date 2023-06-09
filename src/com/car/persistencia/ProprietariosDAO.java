package com.car.persistencia;

import com.car.Ferramentas.ConexaoBD;
import com.car.Modelos.Proprietario;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProprietariosDAO implements IProprietariosDAO{

    private Connection conexao = null;
    PreparedStatement st;
    
    public ProprietariosDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
    }

    @Override
    public void incluirProprietario(Proprietario proprietario) throws Exception {
        
    }

    @Override
    public boolean excluirProprietario(int idProprietario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Proprietario> listagemProprietarios() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void alterarProprietario(Proprietario proprietario) throws Exception {
        
    }
    
}
