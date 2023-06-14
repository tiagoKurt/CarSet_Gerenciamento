
package com.car.persistencia;

import com.car.Enumerations.ClassificacaoGastos;
import com.car.Enumerations.TipoCombustivel;
import com.car.Ferramentas.ConexaoBD;
import com.car.Modelos.Gastos;

import com.car.Modelos.GastosCombustivel;
import com.car.Modelos.Veiculos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class GastosCombustivelDao implements IGastosCombustivelDao{

    private Connection conexao = null;
    PreparedStatement st;
   
    public GastosCombustivelDao() throws Exception{
        conexao = ConexaoBD.getConexao();
    }

    
    @Override
    public void InserirGastos(GastosCombustivel gastos) throws Exception {
        try{
            st = conexao.prepareStatement("insert into gastos_combustivel(tipogasto,descgasto,qtdlcomb,kmpercorrido,valorlitrocomb,kmplcarro,dataabast,id_veiculo)values(?,?,?,?,?,?,?,?)");
            st.setString(1, gastos.getIdentificadorGasto().toString());
            st.setString(2, gastos.getDescricao().toString());
            st.setFloat(3, gastos.getQuantidadeLitrosCombustivel());
            st.setFloat(4, gastos.getKmPercorridoVeiculo());
            st.setFloat(5, gastos.getValorLitroCombustivel());
            st.setFloat(6, gastos.getQntdKmPorLitroCarro());
            st.setDate(7, gastos.getDataAbastecimento());
            st.setInt(8, gastos.getVeiculos().getId());
            st.executeUpdate();
            st.close();
            
            GastosDao objetoGastosGerais= new GastosDao();
            objetoGastosGerais.InserirGastos(inserirGastosGerais());
            
            
            
        }catch(SQLException e){
            throw new Exception(e);
        }
    }

    @Override
    public void AlterarGastos(GastosCombustivel gastos) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean ExcluirGastos(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<GastosCombustivel> listaDeGastos() throws Exception {
        ArrayList<GastosCombustivel> listaDeGastosCombustivel = new ArrayList<>();
          try{
             String sql = "select * from gastos_combustivel";
             PreparedStatement st = conexao.prepareStatement(sql);
             
             ResultSet rs = st.executeQuery();
             while(rs.next()){
                 GastosCombustivel gastos = new GastosCombustivel();
                 gastos.setId(rs.getInt("id"));
                 gastos.setIdentificadorGasto(ClassificacaoGastos.valueOf(rs.getString("tipogasto")));
                 gastos.setDescricao(TipoCombustivel.valueOf(rs.getString("descgasto")));
                 gastos.setQuantidadeLitrosCombustivel(rs.getFloat("qtdlcomb"));
                 gastos.setKmPercorridoVeiculo(rs.getFloat("kmpercorrido"));
                 gastos.setValorLitroCombustivel(rs.getFloat("valorlitrocomb"));
                 gastos.setQntdKmPorLitroCarro(rs.getFloat("kmplcarro"));
                 gastos.setDataAbastecimento(rs.getDate("dataabast"));
                 
                 listaDeGastosCombustivel.add(gastos);
             }}catch(SQLException e){
                     throw new Exception(e);
                     }
                return listaDeGastosCombustivel;
          }
    

    @Override
    public GastosCombustivel buscar(int id) throws Exception {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public Gastos inserirGastosGerais() throws Exception {
        float gastoTotal  = buscarUltimoRegistroInserido().getQuantidadeLitrosCombustivel() * buscarUltimoRegistroInserido().getValorLitroCombustivel();
        
        return new Gastos(0, buscarUltimoRegistroInserido().getId(),buscarUltimoRegistroInserido().getIdentificadorGasto(), buscarUltimoRegistroInserido().getDescricao().toString(), gastoTotal, buscarUltimoRegistroInserido().getDataAbastecimento(),buscarUltimoRegistroInserido().getVeiculos().getId());
    }

    @Override
    public GastosCombustivel buscarUltimoRegistroInserido() throws Exception {
         String sql = "select id\n" +
"			  ,tipogasto\n" +
"			  ,descgasto\n" +
"			  ,qtdlcomb\n" +
"			  ,kmpercorrido\n" +
"			  ,valorlitrocomb\n" +
"			  ,kmplcarro\n" +
"			  ,dataabast \n" +
"			  ,id_veiculo \n" +
"FROM gastos_combustivel\n" +
"group by id,tipogasto,descgasto,qtdlcomb,kmpercorrido,valorlitrocomb,kmplcarro,dataabast\n "+
"order by id desc";
        
         PreparedStatement st = conexao.prepareStatement(sql);
         ResultSet rs = st.executeQuery();
         
         while(rs.next()){
             GastosCombustivel gastosCombustivel = new GastosCombustivel();
                IVeiculosDAO objetoVeiculosDao = new VeiculosDAO();
                 gastosCombustivel.setId(rs.getInt("id"));
                 gastosCombustivel.setIdentificadorGasto(ClassificacaoGastos.valueOf(rs.getString("tipogasto")));
                 gastosCombustivel.setDescricao(TipoCombustivel.valueOf(rs.getString("descgasto")));
                 gastosCombustivel.setQuantidadeLitrosCombustivel(rs.getFloat("qtdlcomb"));
                 gastosCombustivel.setKmPercorridoVeiculo(rs.getFloat("kmpercorrido"));
                 gastosCombustivel.setValorLitroCombustivel(rs.getFloat("valorlitrocomb"));
                 gastosCombustivel.setQntdKmPorLitroCarro(rs.getFloat("kmplcarro"));
                 gastosCombustivel.setDataAbastecimento(rs.getDate("dataabast"));
                 gastosCombustivel.setVeiculos(objetoVeiculosDao.buscar(rs.getInt("id_veiculo")));
        return new GastosCombustivel(gastosCombustivel.getId(),gastosCombustivel.getIdentificadorGasto(), gastosCombustivel.getDescricao(), gastosCombustivel.getQuantidadeLitrosCombustivel(), gastosCombustivel.getKmPercorridoVeiculo(), gastosCombustivel.getValorLitroCombustivel(), gastosCombustivel.getQntdKmPorLitroCarro(), gastosCombustivel.getDataAbastecimento(),gastosCombustivel.getVeiculos());
         }
         return null;
    }
        
}
