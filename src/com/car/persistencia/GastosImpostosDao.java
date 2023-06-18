/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.car.persistencia;

import com.car.Enumerations.ClassificacaoGastos;
import com.car.Ferramentas.ConexaoBD;
import com.car.Modelos.Gastos;
import com.car.Modelos.GastosImposto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class GastosImpostosDao implements IGastosImpostosDao{
    private Connection conexao = null;
    PreparedStatement st;
    public GastosImpostosDao()throws Exception{
        try{
        conexao = ConexaoBD.getConexao();
        }catch(SQLException e){
            throw new Exception(e);
        }
    }
    
    @Override
    public void InserirGastos(GastosImposto gastos) throws Exception {
      st = conexao.prepareStatement("insert into gastos_impostos(tipogasto,descgasto,tipocarro,valorpago,datapagamento,id_veiculo)values(?,?,?,?,?,?)");
            st.setString(1, gastos.getIdentificadorGasto().toString());
            st.setString(2, gastos.getDescricaoGasto());
            st.setString(3, gastos.getTipoDocarro());
            st.setFloat(4, gastos.getValorGasto());
            st.setDate(5, gastos.getDatapagamento());
            st.setFloat(6, gastos.getVeiculo().getId());
            
            st.executeUpdate();
            st.close();
            
            GastosDao objetoGastosGerais= new GastosDao();
            objetoGastosGerais.InserirGastos(inserirGastosGerais());
    }

    @Override
    public void AlterarGastos(GastosImposto gastos) throws Exception {
       st = conexao.prepareStatement(" UPDATE gastos_impostos SET tipogasto = ? ,descgasto = ? ,tipocarro = ? ,valorpago = ?,datapagamento = ?,id_veiculo = ? where id = ?");
            st.setString(1, gastos.getIdentificadorGasto().toString());
            st.setString(2, gastos.getDescricaoGasto());
            st.setString(3, gastos.getTipoDocarro());
            st.setFloat(4, gastos.getValorGasto());
            st.setDate(5, gastos.getDatapagamento());
            st.setFloat(6, gastos.getVeiculo().getId());
            st.setInt(7, gastos.getId());
            st.executeUpdate();
            st.close(); 
            
            GastosDao objetoGastosGerais = new GastosDao();
            objetoGastosGerais.AlterarGastos(alterarGastosGerais(gastos.getId()));
    }

    @Override
    public boolean ExcluirGastos(int id) throws Exception {
        GastosDao objetoDao = new GastosDao();
            objetoDao.ExcluirGastos(buscarParaAlterarGastoGeral(id, ClassificacaoGastos.IMPOSTO.toString()));
        try {
            st = conexao.prepareStatement("DELETE FROM gastos_impostos WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public ArrayList<GastosImposto> listaDeGastos() throws Exception {
        ArrayList<GastosImposto> listaGastosImpostos = new ArrayList<>();
          try{
             String sql = "select * from gastos_impostos";
             PreparedStatement st = conexao.prepareStatement(sql);
             ResultSet rs = st.executeQuery();
             while(rs.next()){
                 GastosImposto gastos = new GastosImposto();
                 IVeiculosDAO objetoDaoVeiculos = new VeiculosDAO();
                 gastos.setId(rs.getInt("id"));
                 gastos.setIdentificadorGasto(ClassificacaoGastos.valueOf(rs.getString("tipogasto")));
                 gastos.setDescricaoGasto(rs.getString("descgasto"));
                 gastos.setTipoDocarro(rs.getString("tipocarro"));
                 gastos.setValorGasto(rs.getFloat("valorpago"));
                 gastos.setDatapagamento(rs.getDate("datapagamento"));
                 gastos.setVeiculo(objetoDaoVeiculos.buscarPeloId(rs.getInt("id_veiculo")));
                 listaGastosImpostos.add(gastos);
             }
          }catch(Exception e){
              throw new Exception(e);
          }
          return listaGastosImpostos;
    }

    @Override
    public GastosImposto buscar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Gastos inserirGastosGerais() throws Exception {
        return new Gastos(0, buscarUltimoRegistroInserido().getId(),buscarUltimoRegistroInserido().getIdentificadorGasto(), buscarUltimoRegistroInserido().getDescricaoGasto(), buscarUltimoRegistroInserido().getValorGasto(), buscarUltimoRegistroInserido().getDatapagamento(),buscarUltimoRegistroInserido().getVeiculo().getId());

    }
     public Gastos alterarGastosGerais(int id) throws Exception {
        
        return new Gastos(buscarParaAlterarGastoGeral(id,ClassificacaoGastos.IMPOSTO.toString()),  buscarParaAlterar(id).getId(),  buscarParaAlterar(id).getIdentificadorGasto(),  buscarParaAlterar(id).getDescricaoGasto(), buscarParaAlterar(id).getValorGasto(),  buscarParaAlterar(id).getDatapagamento(),  buscarParaAlterar(id).getVeiculo().getId());
    }

    @Override
    public GastosImposto buscarUltimoRegistroInserido() throws Exception {
        String sql = "select * from gastos_impostos order by id desc";
             PreparedStatement st = conexao.prepareStatement(sql);
             ResultSet rs = st.executeQuery();
             while(rs.next()){
                 GastosImposto gastos = new GastosImposto();
                 IVeiculosDAO objetoDaoVeiculos = new VeiculosDAO();
                 gastos.setId(rs.getInt("id"));
                 gastos.setIdentificadorGasto(ClassificacaoGastos.valueOf(rs.getString("tipogasto")));
                 gastos.setDescricaoGasto(rs.getString("descgasto"));
                 gastos.setTipoDocarro(rs.getString("tipocarro"));
                 gastos.setValorGasto(rs.getFloat("valorpago"));
                 gastos.setDatapagamento(rs.getDate("datapagamento"));
                 gastos.setVeiculo(objetoDaoVeiculos.buscarPeloId(rs.getInt("id_veiculo")));
                 return new GastosImposto(gastos.getId(), gastos.getIdentificadorGasto(), gastos.getDescricaoGasto(), gastos.getTipoDocarro(), gastos.getValorGasto(), gastos.getDatapagamento(), gastos.getVeiculo());
             }
             return null;
    }
    
    public int buscarParaAlterarGastoGeral(int idgasto,String tipogasto){
       
        try {
            String sql ="select id from gastosgeral where id_gasto = ? and tipogasto = ? ";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setInt(1, idgasto);
            st.setString(2, tipogasto); 
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return rs.getInt("id");
            }
            
            
        } catch (SQLException ex) {
            
        }
        return 0;
    }
    
    public GastosImposto buscarParaAlterar(int idgasto) throws Exception {
        String sql ="select * from gastos_impostos where id = ?";
        PreparedStatement st = conexao.prepareStatement(sql);
        st.setInt(1, idgasto);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            GastosImposto gastos = new GastosImposto();
                 IVeiculosDAO objetoDaoVeiculos = new VeiculosDAO();
                 gastos.setId(rs.getInt("id"));
                 gastos.setIdentificadorGasto(ClassificacaoGastos.valueOf(rs.getString("tipogasto")));
                 gastos.setDescricaoGasto(rs.getString("descgasto"));
                 gastos.setTipoDocarro(rs.getString("tipocarro"));
                 gastos.setValorGasto(rs.getFloat("valorpago"));
                 gastos.setDatapagamento(rs.getDate("datapagamento"));
                 gastos.setVeiculo(objetoDaoVeiculos.buscarPeloId(rs.getInt("id_veiculo")));
                 return new GastosImposto(gastos.getId(), gastos.getIdentificadorGasto(), gastos.getDescricaoGasto(), gastos.getTipoDocarro(), gastos.getValorGasto(), gastos.getDatapagamento(), gastos.getVeiculo());
           }
        return null;
    }
}
