/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.car.persistencia;

import com.car.Enumerations.ClassificacaoGastos;
import com.car.Ferramentas.ConexaoBD;
import com.car.Modelos.Gastos;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tiago
 */
public class GastosDao implements IGastosDao{

    private Connection conexao = null;
    PreparedStatement st;
   
    public GastosDao() throws Exception{
        conexao = ConexaoBD.getConexao();
    }
    
    @Override
    public void InserirGastos(Gastos gastos) throws Exception {
        try{
            st = conexao.prepareStatement("insert into gastosgeral (id_gasto,tipogasto,descgasto,valortotal,datagasto,id_veiculo)values(?,?,?,?,?,?)");
            st.setInt(1, gastos.getIdGasto());
            st.setString(2, gastos.getIdentificadorGasto().toString());
            st.setString(3, gastos.getDescricao());
            st.setFloat(4, gastos.getGastoTotal());
            st.setDate(5, gastos.getDataGasto());
            st.setInt(6, gastos.getId_veiculo());
            st.executeUpdate();
            st.close();
        }catch(SQLException e){
            throw new Exception(e);
        }
    }

    @Override
    public void AlterarGastos(Gastos gastos) throws Exception {
       try{
            st = conexao.prepareStatement("UPDATE gastosgeral SET id_gasto = ?, tipogasto = ?, descgasto = ?, valortotal = ?,datagasto = ?, id_veiculo = ? WHERE id = ?");
            st.setInt(1, gastos.getIdGasto());
            st.setString(2, gastos.getIdentificadorGasto().toString());
            st.setString(3, gastos.getDescricao());            
            st.setFloat(4, gastos.getGastoTotal());
            st.setDate(5, gastos.getDataGasto());
            st.setInt(6, gastos.getId_veiculo());
            st.setInt(7, gastos.getId());
            st.executeUpdate();
            st.close();
            
        }catch(SQLException e){
            throw new Exception(e);
        }
    }

    @Override
    public boolean ExcluirGastos(int id) throws Exception {
         try {
            st = conexao.prepareStatement("DELETE FROM gastosgeral WHERE id = ?");
            st.setInt(1, id);           
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    
    }

    @Override
    public ArrayList<Gastos> listaDeGastos() throws Exception {
          ArrayList<Gastos> listaDeGastos = new ArrayList<>();
          try{
             String sql = "select * from gastosgeral order by datagasto";
             PreparedStatement st = conexao.prepareStatement(sql);
             
             ResultSet rs = st.executeQuery();
             while(rs.next()){
                 Gastos gastos = new Gastos();
                 gastos.setId(rs.getInt("id"));
                 gastos.setIdGasto(rs.getInt("id_gasto"));
                 gastos.setIdentificadorGasto(ClassificacaoGastos.valueOf(rs.getString("tipogasto")));
                 gastos.setDescricao(rs.getString("descgasto"));
                 gastos.setGastoTotal(rs.getFloat("valortotal"));
                 gastos.setDataGasto(rs.getDate("datagasto"));
                 gastos.setId_veiculo(rs.getInt("id_veiculo"));
                 listaDeGastos.add(gastos);
             }}catch(SQLException e){
                     throw new Exception(e);
                     }
                return listaDeGastos;
          }
    

    @Override
    public Gastos buscar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
