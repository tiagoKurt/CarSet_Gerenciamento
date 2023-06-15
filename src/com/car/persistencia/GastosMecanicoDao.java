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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean ExcluirGastos(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
