package com.car.persistencia;

import com.car.Ferramentas.ConexaoBD;
import com.car.Modelos.Veiculos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeiculosDAO implements IVeiculosDAO{
    private Connection conexao = null;
    PreparedStatement st;
    
    public VeiculosDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
    }

    @Override
    public void inserirVeiculos(Veiculos veiculo) throws Exception {
        try {

            st = conexao.prepareStatement("insert into veiculos(id_modelo, placa, tipo_veiculo, tipo_combustivel,quilometragem) values (?, ?, ?, ?, ?)");
            st.setInt(1, veiculo.getModelo().getIdModelos());
            st.setString(2, veiculo.getPlaca());
            st.setString(3, veiculo.getTipoDoVeiculo().toString());
            st.setString(4, veiculo.getTipoCombustivel().toString());
            st.setInt(5, veiculo.getQuilometragemAtual());
            st.executeUpdate();
            st.close();
            
        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        }
    }

    @Override
    public void alterar(Veiculos veiculos) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluir(int idVeiculos) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Veiculos> listagemDeModelos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Veiculos buscar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
