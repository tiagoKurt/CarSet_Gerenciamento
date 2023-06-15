/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.car.persistencia;

import com.car.Enumerations.ClassificacaoGastos;
import com.car.Ferramentas.ConexaoBD;
import com.car.Modelos.Gastos;
import com.car.Modelos.GastosAvulsos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class GastosAvulsosDao implements IGastosAvulsosDao{
private Connection conexao = null;
    PreparedStatement st;
    public GastosAvulsosDao()throws Exception{
        try{
        conexao = ConexaoBD.getConexao();
        }catch(SQLException e){
            throw new Exception(e);
        }
    }
    @Override
    public void InserirGastos(GastosAvulsos gastos) throws Exception {
         st = conexao.prepareStatement("insert into gastos_avulsos(tipogasto,descgasto,valorgasto,datarealizacao,id_veiculo)values(?,?,?,?,?)");
            st.setString(1, gastos.getIdentificadorGasto().toString());
            st.setString(2, gastos.getDescgasto());
            st.setFloat(3, gastos.getValorGasto());
            st.setDate(4, gastos.getDataRealizacao());
            st.setInt(5, gastos.getVeiculo().getId());
            
            
            st.executeUpdate();
            st.close();
            
            GastosDao objetoGastosGerais= new GastosDao();
            objetoGastosGerais.InserirGastos(inserirGastosGerais());  
    }

    @Override
    public void AlterarGastos(GastosAvulsos gastos) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean ExcluirGastos(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<GastosAvulsos> listaDeGastos() throws Exception {
        ArrayList<GastosAvulsos> listaGastosImpostos = new ArrayList<>();
          try{
              
             String sql = "select * from gastos_impostos";
             PreparedStatement st = conexao.prepareStatement(sql);
             ResultSet rs = st.executeQuery();
             while(rs.next()){
                 GastosAvulsos gastos = new GastosAvulsos();
                 IVeiculosDAO objetoDaoVeiculos = new VeiculosDAO();
                 gastos.setId(rs.getInt("id"));
                 gastos.setIdentificadorGasto(ClassificacaoGastos.valueOf(rs.getString("tipogasto")));
                 gastos.setDescgasto(rs.getString("descgasto"));
                 gastos.setValorGasto(rs.getFloat("valorgasto"));
                 gastos.setDataRealizacao(rs.getDate("datarealizacao"));
                 gastos.setVeiculo(objetoDaoVeiculos.buscarPeloId(rs.getInt("id_veiculo")));
                 listaGastosImpostos.add(gastos);
             }
          }catch(Exception e){
              throw new Exception(e);
          }
          return listaGastosImpostos;
    
    }

    @Override
    public GastosAvulsos buscar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Gastos inserirGastosGerais() throws Exception {
        
        return new Gastos(0, buscarUltimoRegistroInserido().getId(),buscarUltimoRegistroInserido().getIdentificadorGasto(), buscarUltimoRegistroInserido().getDescgasto(), buscarUltimoRegistroInserido().getValorGasto(), buscarUltimoRegistroInserido().getDataRealizacao(),buscarUltimoRegistroInserido().getVeiculo().getId());

    }

    @Override
    public GastosAvulsos buscarUltimoRegistroInserido() throws Exception {
        String sql = "select * from gastos_impostos order by id desc";
             PreparedStatement st = conexao.prepareStatement(sql);
             ResultSet rs = st.executeQuery();
             while(rs.next()){
                 GastosAvulsos gastos = new GastosAvulsos();
                 IVeiculosDAO objetoDaoVeiculos = new VeiculosDAO();
                 gastos.setId(rs.getInt("id"));
                 gastos.setIdentificadorGasto(ClassificacaoGastos.valueOf(rs.getString("tipogasto")));
                 gastos.setDescgasto(rs.getString("descgasto"));
                 gastos.setValorGasto(rs.getFloat("valorgasto"));
                 gastos.setDataRealizacao(rs.getDate("datarealizacao"));
                 gastos.setVeiculo(objetoDaoVeiculos.buscarPeloId(rs.getInt("id_veiculo")));
                 return new GastosAvulsos(gastos.getId(),gastos.getIdentificadorGasto(),gastos.getDescgasto(),gastos.getValorGasto(),gastos.getDataRealizacao(), gastos.getVeiculo());
    }
             return null;
}
}
