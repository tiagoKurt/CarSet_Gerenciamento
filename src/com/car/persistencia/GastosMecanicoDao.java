/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.car.persistencia;

import com.car.Ferramentas.ConexaoBD;
import com.car.Modelos.Gastos;
import com.car.Modelos.GastosMecanico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class GastosMecanicoDao implements IGastosMecanicoDao{
    private Connection conexao = null;
    PreparedStatement st;
    public GastosMecanicoDao() throws Exception{
        try{
        conexao = ConexaoBD.getConexao();
        }catch(SQLException e){
            throw new Exception(e);
        }
    }
    
    @Override
    public void InserirGastos(GastosMecanico gastos) throws Exception {
        try{
            st = conexao.prepareStatement("insert into gastos_mecanico(tipogasto,descgasto,qtditemman,valoritemman,valormaoobra,datamanutencao,id_veiculo)values(?,?,?,?,?,?,?)");
            st.setString(1, gastos.getIdentificadorGasto().toString());
            st.setString(2, gastos.getDecricaoGasto());
            st.setFloat(3, gastos.getQuantidadeDeItensManutencao());
            st.setFloat(4, gastos.getValorItemManutencao());
            st.setFloat(5, gastos.getValorMaoDeObra());
            st.setDate(6, gastos.getDataManutencao());
            st.setInt(7, gastos.getVeiculo().getId());
            st.executeUpdate();
            st.close();
            
            GastosDao objetoGastosGerais= new GastosDao();
            objetoGastosGerais.InserirGastos(inserirGastosGerais());
            
            
            
        }catch(SQLException e){
            throw new Exception(e);
        }
    }

    @Override
    public void AlterarGastos(GastosMecanico gastos) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean ExcluirGastos(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<GastosMecanico> listaDeGastos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GastosMecanico buscar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Gastos inserirGastosGerais() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public GastosMecanico buscarUltimoRegistroInserido() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
