/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.car.persistencia;

import com.car.Enumerations.ClassificacaoGastos;
import com.car.Ferramentas.ConexaoBD;
import com.car.Modelos.Gastos;
import com.car.Modelos.GastosMecanico;
import com.car.persistencia.IGastosMecanicoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            st = conexao.prepareStatement("insert into gastos_mecanico(tipogasto,descgasto,descitemman,qtditemman,valoritemman,valormaoobra,datamanutencao,id_veiculo)values(?,?,?,?,?,?,?,?)");
            st.setString(1, gastos.getIdentificadorGasto().toString());
            st.setString(2, gastos.getDecricaoGasto());
            st.setString(3, gastos.getDescricaoItemManutencao());
            st.setFloat(4, gastos.getQuantidadeDeItensManutencao());
            st.setFloat(5, gastos.getValorItemManutencao());
            st.setFloat(6, gastos.getValorMaoDeObra());
            st.setDate(7, gastos.getDataManutencao());
            st.setInt(8, gastos.getVeiculo().getId());
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
        st = conexao.prepareStatement(" UPDATE gastos_mecanico SET tipogasto = ?,descgasto = ?,descitemman = ?,qtditemman = ?,valoritemman = ?,valormaoobra = ?,datamanutencao = ?,id_veiculo = ? where id = ?");
        System.out.println(gastos.getIdentificadorGasto().toString());
        st.setString(1, gastos.getIdentificadorGasto().toString());
            st.setString(2, gastos.getDecricaoGasto());
            st.setString(3, gastos.getDescricaoItemManutencao());
            st.setFloat(4, gastos.getQuantidadeDeItensManutencao());
            st.setFloat(5, gastos.getValorItemManutencao());
            st.setFloat(6, gastos.getValorMaoDeObra());
            st.setDate(7, gastos.getDataManutencao());
            st.setInt(8, gastos.getVeiculo().getId());
            st.setInt(9, gastos.getId());
            st.executeUpdate();
            st.close();
            
            GastosDao objetoGastosGerais = new GastosDao();
            objetoGastosGerais.AlterarGastos(alterarGastosGerais(gastos.getId()));
            
    }

    @Override
    public boolean ExcluirGastos(int id) throws Exception {
        GastosDao objetoDao = new GastosDao();
            objetoDao.ExcluirGastos(buscarParaAlterarGastoGeral(id, ClassificacaoGastos.MECANICO.toString()));
        try {
            st = conexao.prepareStatement("DELETE FROM gastos_mecanico WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    
    }

    @Override
    public ArrayList<GastosMecanico> listaDeGastos() throws Exception {
            ArrayList<GastosMecanico> listaDeGastosCombustivel = new ArrayList<>();
          try{
             String sql = "select * from gastos_mecanico";
             PreparedStatement st = conexao.prepareStatement(sql);
             ResultSet rs = st.executeQuery();
             while(rs.next()){
                 GastosMecanico gastos = new GastosMecanico();
                 IVeiculosDAO objetoDaoVeiculos = new VeiculosDAO();
                 gastos.setId(rs.getInt("id"));
                 gastos.setIdentificadorGasto(ClassificacaoGastos.valueOf(rs.getString("tipogasto")));
                 gastos.setDecricaoGasto(rs.getString("descgasto"));
                 gastos.setDescricaoItemManutencao(rs.getString("descitemman"));
                 gastos.setQuantidadeDeItensManutencao(rs.getInt("qtditemman"));
                 gastos.setValorItemManutencao(rs.getFloat("valoritemman"));
                 gastos.setValorMaoDeObra(rs.getFloat("valormaoobra"));
                 gastos.setDataManutencao(rs.getDate("datamanutencao"));
                 gastos.setVeiculo(objetoDaoVeiculos.buscarPeloId(rs.getInt("id_veiculo")));
                 listaDeGastosCombustivel.add(gastos);
             }}catch(SQLException e){
                     throw new Exception(e);
                     }
                return listaDeGastosCombustivel;
    }

    @Override
    public GastosMecanico buscar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Gastos inserirGastosGerais() throws Exception {
        float gastoTotal = 0;
        
        if(buscarUltimoRegistroInserido().getQuantidadeDeItensManutencao() == 0){
            gastoTotal = buscarUltimoRegistroInserido().getValorMaoDeObra();
        }else{
            gastoTotal = (buscarUltimoRegistroInserido().getQuantidadeDeItensManutencao() * buscarUltimoRegistroInserido().getValorItemManutencao()) + buscarUltimoRegistroInserido().getValorMaoDeObra();
        }
        
        return new Gastos(0, buscarUltimoRegistroInserido().getId(),buscarUltimoRegistroInserido().getIdentificadorGasto(), buscarUltimoRegistroInserido().getDecricaoGasto(), gastoTotal, buscarUltimoRegistroInserido().getDataManutencao(),buscarUltimoRegistroInserido().getVeiculo().getId());
    }
    
    public Gastos alterarGastosGerais(int id) throws Exception {
        float gastoTotal = 0;
        System.out.println(buscarParaAlterar(id).getQuantidadeDeItensManutencao());
        if(buscarParaAlterar(id).getQuantidadeDeItensManutencao() == 0){
            gastoTotal = buscarParaAlterar(id).getValorMaoDeObra();
        }else{
            gastoTotal = (buscarParaAlterar(id).getQuantidadeDeItensManutencao() * buscarParaAlterar(id).getValorItemManutencao()) + buscarParaAlterar(id).getValorMaoDeObra();
           }
    return new Gastos(buscarParaAlterarGastoGeral(id, ClassificacaoGastos.MECANICO.toString()), buscarParaAlterar(id).getId(),buscarParaAlterar(id).getIdentificadorGasto(), buscarParaAlterar(id).getDecricaoGasto(), gastoTotal, buscarParaAlterar(id).getDataManutencao(),buscarParaAlterar(id).getVeiculo().getId());    
    
    }
     public GastosMecanico buscarParaAlterar(int idgasto) throws Exception {
        String sql ="select * from gastos_mecanico where id = ?";
         PreparedStatement st = conexao.prepareStatement(sql);
         st.setInt(1, idgasto);
         ResultSet rs = st.executeQuery();
         
         while(rs.next()){
         GastosMecanico gastos = new GastosMecanico();
                 IVeiculosDAO objetoDaoVeiculos = new VeiculosDAO();
                 gastos.setId(rs.getInt("id"));
                 gastos.setIdentificadorGasto(ClassificacaoGastos.valueOf(rs.getString("tipogasto")));
                 gastos.setDecricaoGasto(rs.getString("descgasto"));
                 gastos.setDescricaoItemManutencao(rs.getString("descitemman"));
                 gastos.setQuantidadeDeItensManutencao(rs.getInt("qtditemman"));
                 gastos.setValorItemManutencao(rs.getFloat("valoritemman"));
                 gastos.setValorMaoDeObra(rs.getFloat("valormaoobra"));
                 gastos.setDataManutencao(rs.getDate("datamanutencao"));
                 gastos.setVeiculo(objetoDaoVeiculos.buscarPeloId(rs.getInt("id_veiculo")));
         return new GastosMecanico(gastos.getId(), gastos.getIdentificadorGasto(), gastos.getDecricaoGasto(), gastos.getDescricaoItemManutencao(),gastos.getQuantidadeDeItensManutencao(), gastos.getValorItemManutencao(), gastos.getValorMaoDeObra(), gastos.getDataManutencao(), gastos.getVeiculo());
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
            Logger.getLogger(GastosCombustivelDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public GastosMecanico buscarUltimoRegistroInserido() throws Exception {
        String sql = "select * from gastos_mecanico order by id desc";
        PreparedStatement st = conexao.prepareStatement(sql);
         ResultSet rs = st.executeQuery();
         
         while(rs.next()){
         GastosMecanico gastos = new GastosMecanico();
                 IVeiculosDAO objetoDaoVeiculos = new VeiculosDAO();
                 gastos.setId(rs.getInt("id"));
                 gastos.setIdentificadorGasto(ClassificacaoGastos.valueOf(rs.getString("tipogasto")));
                 gastos.setDecricaoGasto(rs.getString("descgasto"));
                 gastos.setDescricaoItemManutencao(rs.getString("descitemman"));
                 gastos.setQuantidadeDeItensManutencao(rs.getInt("qtditemman"));
                 gastos.setValorItemManutencao(rs.getFloat("valoritemman"));
                 gastos.setValorMaoDeObra(rs.getFloat("valormaoobra"));
                 gastos.setDataManutencao(rs.getDate("datamanutencao"));
                 gastos.setVeiculo(objetoDaoVeiculos.buscarPeloId(rs.getInt("id_veiculo")));
         return new GastosMecanico(gastos.getId(), gastos.getIdentificadorGasto(), gastos.getDecricaoGasto(), gastos.getDescricaoItemManutencao(),gastos.getQuantidadeDeItensManutencao(), gastos.getValorItemManutencao(), gastos.getValorMaoDeObra(), gastos.getDataManutencao(), gastos.getVeiculo());
         }
         return null;
    }
    
}
