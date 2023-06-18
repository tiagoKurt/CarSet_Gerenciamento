package com.car.persistencia;

import com.car.Enumerations.ClassificacaoGastos;
import com.car.Enumerations.TipoCombustivel;
import com.car.Enumerations.TiposCombustiveisGastos;
import com.car.Ferramentas.ConexaoBD;
import com.car.Modelos.Gastos;

import com.car.Modelos.GastosCombustivel;
import com.car.Modelos.Veiculos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GastosCombustivelDao implements IGastosCombustivelDao {

    private Connection conexao = null;
    PreparedStatement st;

    public GastosCombustivelDao() throws Exception {
        conexao = ConexaoBD.getConexao();
    }

    @Override
    public void InserirGastos(GastosCombustivel gastos) throws Exception {
        try {
            st = conexao.prepareStatement("insert into gastos_combustivel(tipogasto,descgasto,qtdlcomb,valorlitrocomb,kmplcarro,dataabast,id_veiculo)values(?,?,?,?,?,?,?)");
            st.setString(1, gastos.getIdentificadorGasto().toString());
            st.setString(2, gastos.getDescricao().toString());
            st.setFloat(3, gastos.getQuantidadeLitrosCombustivel());
            st.setFloat(4, gastos.getValorLitroCombustivel());
            st.setFloat(5, gastos.getQntdKmPorLitroCarro());
            st.setDate(6, gastos.getDataAbastecimento());
            st.setInt(7, gastos.getVeiculos().getId());
            st.executeUpdate();
            st.close();

            GastosDao objetoGastosGerais = new GastosDao();
            objetoGastosGerais.InserirGastos(inserirGastosGerais());

        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    @Override
    public void AlterarGastos(GastosCombustivel gastos) throws Exception {
        try {

            st = conexao.prepareStatement("UPDATE gastos_combustivel SET tipogasto = ?, descgasto = ?, qtdlcomb = ?, valorlitrocomb = ?,"
                    + "kmplcarro = ?, dataabast = ?, id_veiculo = ? WHERE id = ?");
            st.setString(1, gastos.getIdentificadorGasto().toString());
            st.setString(2, gastos.getDescricao().toString());
            st.setFloat(3, gastos.getQuantidadeLitrosCombustivel());
            st.setFloat(4, gastos.getValorLitroCombustivel());
            st.setFloat(5, gastos.getQntdKmPorLitroCarro());
            st.setDate(6, gastos.getDataAbastecimento());
            st.setInt(7, gastos.getVeiculos().getId());
            st.setInt(8, gastos.getId());
            st.executeUpdate();
            st.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ALTERAR" + e);
        }
    }

    @Override
    public boolean ExcluirGastos(int id) throws Exception {
        try {
            st = conexao.prepareStatement("DELETE FROM gastos_combustivel WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public ArrayList<GastosCombustivel> listaDeGastos() throws Exception {
        ArrayList<GastosCombustivel> listaDeGastosCombustivel = new ArrayList<>();
        try {
            String sql = "select * from gastos_combustivel";
            PreparedStatement st = conexao.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                GastosCombustivel gastos = new GastosCombustivel();
                IVeiculosDAO objetoDaoVeiculos = new VeiculosDAO();
                gastos.setId(rs.getInt("id"));
                gastos.setIdentificadorGasto(ClassificacaoGastos.valueOf(rs.getString("tipogasto")));
                gastos.setDescricao(TiposCombustiveisGastos.valueOf(rs.getString("descgasto")));
                gastos.setQuantidadeLitrosCombustivel(rs.getFloat("qtdlcomb"));
                gastos.setValorLitroCombustivel(rs.getFloat("valorlitrocomb"));
                gastos.setQntdKmPorLitroCarro(rs.getFloat("kmplcarro"));
                gastos.setDataAbastecimento(rs.getDate("dataabast"));
                gastos.setVeiculos(objetoDaoVeiculos.buscarPeloId(rs.getInt("id_veiculo")));
                listaDeGastosCombustivel.add(gastos);
            }
        } catch (SQLException e) {
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
        float gastoTotal = buscarUltimoRegistroInserido().getQuantidadeLitrosCombustivel() * buscarUltimoRegistroInserido().getValorLitroCombustivel();

        return new Gastos(0, buscarUltimoRegistroInserido().getId(), buscarUltimoRegistroInserido().getIdentificadorGasto(), buscarUltimoRegistroInserido().getDescricao().toString(), gastoTotal, buscarUltimoRegistroInserido().getDataAbastecimento(), buscarUltimoRegistroInserido().getVeiculos().getId());
    }

    public Gastos alterarGastosGerais() throws Exception {
        float gastoTotal = buscarUltimoRegistroInserido().getQuantidadeLitrosCombustivel() * buscarUltimoRegistroInserido().getValorLitroCombustivel();

        return new Gastos(0, buscarUltimoRegistroInserido().getId(), buscarUltimoRegistroInserido().getIdentificadorGasto(), buscarUltimoRegistroInserido().getDescricao().toString(), gastoTotal, buscarUltimoRegistroInserido().getDataAbastecimento(), buscarUltimoRegistroInserido().getVeiculos().getId());
    }

    public ResultSet puxarIDVeiculo(int id) throws Exception {
        
        String query = "select gastos_combustivel.id_veiculo from gastosgeral inner join gastos_combustivel on \n"
                + "gastosgeral.id_gasto = gastos_combustivel.id\n"
                + "where gastos_combustivel.id = ?";
        st = conexao.prepareStatement(query);
        st.setInt(1, id);
        return st.executeQuery();

    }
    public ResultSet puxarIDGasto(int id) throws Exception {
        
        String query = "select gastosgeral.id from gastosgeral inner join gastos_combustivel on \n"
                + "gastosgeral.id_gasto = gastos_combustivel.id\n"
                + "where gastos_combustivel.id = ?";
        try {
        st = conexao.prepareStatement(query);
        st.setInt(1, id);
        return st.executeQuery();
        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        }
    }

    @Override
    public GastosCombustivel buscarUltimoRegistroInserido() throws Exception {
        String sql = "select id\n"
                + "			  ,tipogasto\n"
                + "			  ,descgasto\n"
                + "			  ,qtdlcomb\n"
                + "			  ,valorlitrocomb\n"
                + "			  ,kmplcarro\n"
                + "			  ,dataabast \n"
                + "			  ,id_veiculo \n"
                + "FROM gastos_combustivel\n"
                + "group by id,tipogasto,descgasto,qtdlcomb,valorlitrocomb,kmplcarro,dataabast\n "
                + "order by id desc";

        PreparedStatement st = conexao.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            GastosCombustivel gastosCombustivel = new GastosCombustivel();
            IVeiculosDAO objetoVeiculosDao = new VeiculosDAO();
            gastosCombustivel.setId(rs.getInt("id"));
            gastosCombustivel.setIdentificadorGasto(ClassificacaoGastos.valueOf(rs.getString("tipogasto")));
            gastosCombustivel.setDescricao(TiposCombustiveisGastos.valueOf(rs.getString("descgasto")));
            gastosCombustivel.setQuantidadeLitrosCombustivel(rs.getFloat("qtdlcomb"));
            gastosCombustivel.setValorLitroCombustivel(rs.getFloat("valorlitrocomb"));
            gastosCombustivel.setQntdKmPorLitroCarro(rs.getFloat("kmplcarro"));
            gastosCombustivel.setDataAbastecimento(rs.getDate("dataabast"));
            gastosCombustivel.setVeiculos(objetoVeiculosDao.buscarPeloId(rs.getInt("id_veiculo")));
            return new GastosCombustivel(gastosCombustivel.getId(), gastosCombustivel.getIdentificadorGasto(), gastosCombustivel.getDescricao(), gastosCombustivel.getQuantidadeLitrosCombustivel(), gastosCombustivel.getValorLitroCombustivel(), gastosCombustivel.getQntdKmPorLitroCarro(), gastosCombustivel.getDataAbastecimento(), gastosCombustivel.getVeiculos());
        }
        return null;
    }

}
