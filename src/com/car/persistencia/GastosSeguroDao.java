/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.car.persistencia;

import com.car.Enumerations.ClassificacaoGastos;
import com.car.Ferramentas.ConexaoBD;
import com.car.Modelos.Gastos;
import com.car.Modelos.GastosSeguro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class GastosSeguroDao implements IGastosSeguroDao{
    private Connection conexao = null;
    PreparedStatement st;
    public GastosSeguroDao()throws Exception{
        try{
        conexao = ConexaoBD.getConexao();
        }catch(SQLException e){
            throw new Exception(e);
        }
    }
    @Override
    public void InserirGastos(GastosSeguro gastos) throws Exception {
        st = conexao.prepareStatement("insert into gastos_seguro(tipogasto,descgasto,valorfranquia,datapagamento,id_veiculo)values(?,?,?,?,?)");
            st.setString(1, gastos.getIdentificadorGasto().toString());
            st.setString(2, gastos.getDescricaoGastos());
            st.setFloat(3, gastos.getValorFranquia());
            st.setDate(4, gastos.getDataPagamento());
            st.setInt(5, gastos.getVeiculo().getId());  
            
            st.executeUpdate();
            st.close();
            
            GastosDao objetoGastosGerais= new GastosDao();
            objetoGastosGerais.InserirGastos(inserirGastosGerais());
    
    }

    @Override
    public void AlterarGastos(GastosSeguro gastos) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean ExcluirGastos(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<GastosSeguro> listaDeGastos() throws Exception {
        ArrayList<GastosSeguro> listaDeGastosSeguro = new ArrayList<>();
          try{
             String sql = "select * from gastos_seguro";
             PreparedStatement st = conexao.prepareStatement(sql);
             ResultSet rs = st.executeQuery();
             while(rs.next()){
                 GastosSeguro gastos = new GastosSeguro();
                 IVeiculosDAO objetoDaoVeiculos = new VeiculosDAO();
                 gastos.setId(rs.getInt("id"));
                 gastos.setIdentificadorGasto(ClassificacaoGastos.valueOf(rs.getString("tipogasto")));
                 gastos.setDescricaoGastos(rs.getString("descgasto"));
                 gastos.setValorFranquia(rs.getFloat("valorfranquia"));
                 gastos.setDataPagamento(rs.getDate("datapagamento"));
                 gastos.setVeiculo(objetoDaoVeiculos.buscarPeloId(rs.getInt("id_veiculo")));
                 listaDeGastosSeguro.add(gastos);
             }
          }catch(Exception e){
              throw new Exception(e);
          }
          return listaDeGastosSeguro;
    }

    @Override
    public GastosSeguro buscar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Gastos inserirGastosGerais() throws Exception {
        return new Gastos(0, buscarUltimoRegistroInserido().getId(),buscarUltimoRegistroInserido().getIdentificadorGasto(), buscarUltimoRegistroInserido().getDescricaoGastos(), buscarUltimoRegistroInserido().getValorFranquia(), buscarUltimoRegistroInserido().getDataPagamento(),buscarUltimoRegistroInserido().getVeiculo().getId());
    }

    @Override
    public GastosSeguro buscarUltimoRegistroInserido() throws Exception {
        String sql = "select * from gastos_seguro order by id desc";
             PreparedStatement st = conexao.prepareStatement(sql);
             ResultSet rs = st.executeQuery();
             while(rs.next()){
                 GastosSeguro gastos = new GastosSeguro();
                 IVeiculosDAO objetoDaoVeiculos = new VeiculosDAO();
                 gastos.setId(rs.getInt("id"));
                 gastos.setIdentificadorGasto(ClassificacaoGastos.valueOf(rs.getString("tipogasto")));
                 gastos.setDescricaoGastos(rs.getString("descgasto"));
                 gastos.setValorFranquia(rs.getFloat("valorfranquia"));
                 gastos.setDataPagamento(rs.getDate("datapagamento"));
                 gastos.setVeiculo(objetoDaoVeiculos.buscarPeloId(rs.getInt("id_veiculo")));
                 return new GastosSeguro(gastos.getId(), gastos.getIdentificadorGasto(), gastos.getDescricaoGastos(), gastos.getValorFranquia(), gastos.getDataPagamento(), gastos.getVeiculo());
         }
        return null;
    }
}
