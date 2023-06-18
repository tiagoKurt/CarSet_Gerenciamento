package com.car.persistencia;

import com.car.Enumerations.CategoriaVeiculos;
import com.car.Enumerations.TipoCombustivel;
import com.car.Enumerations.TipoDoVeiculo;
import com.car.Ferramentas.ConexaoBD;
import com.car.Modelos.Veiculos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VeiculosDAO implements IVeiculosDAO {

    private Connection conexao = null;
    PreparedStatement st;

    public VeiculosDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
    }

    @Override
    public void inserirVeiculos(Veiculos veiculo) throws Exception {
        try {

            st = conexao.prepareStatement("insert into veiculos(id_modelo, placa, tipo_veiculo, categoria_veiculo, tipo_combustivel,quilometragem) values (?, ?, ?, ?, ?, ?)");
            st.setInt(1, veiculo.getModelo().getIdModelos());
            st.setString(2, veiculo.getPlaca());
            st.setString(3, veiculo.getTipoDoVeiculo().toString());
            st.setString(4, veiculo.getCategoriaVeiculos().toString());
            st.setString(5, veiculo.getTipoCombustivel().toString());
            st.setInt(6, veiculo.getQuilometragemAtual());
            st.executeUpdate();
            st.close();

        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        }
    }

    @Override
    public void alterar(Veiculos veiculo) throws Exception {
        try {
            st = conexao.prepareStatement("UPDATE marcas SET descricao = ?, url = ?, imagem = ? WHERE id = ?");

            st = conexao.prepareStatement("UPDATE veiculos set id_modelo = ?, placa = ?, tipo_veiculo = ?, categoria_veiculo = ?,"
                    + "tipo_combustivel = ?, quilometragem = ? WHERE id = ?");
            st.setInt(1, veiculo.getModelo().getIdModelos());
            st.setString(2, veiculo.getPlaca());
            st.setString(3, veiculo.getTipoDoVeiculo().toString());
            st.setString(4, veiculo.getCategoriaVeiculos().toString());
            st.setString(5, veiculo.getTipoCombustivel().toString());
            st.setInt(6, veiculo.getQuilometragemAtual());
            st.setInt(7, veiculo.getId());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ALTERAR" + e);
        }
    }

    @Override
    public boolean excluir(String placa) throws Exception {
        try {
            st = conexao.prepareStatement("DELETE FROM veiculos WHERE placa = ?");
            st.setString(1, placa);
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public ArrayList<Veiculos> listagemDeVeiculos() throws Exception {
        ArrayList<Veiculos> listagemDeVeiculos = new ArrayList<Veiculos>();
        try {

            String sql = "select * from veiculos order by id";
             PreparedStatement statement = conexao.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Veiculos veiculo = new Veiculos();
                IModelosDAO objetoModelo = new ModelosDAO();
                veiculo.setId(rs.getInt("id"));
                veiculo.setModelo(objetoModelo.buscar(rs.getInt("id_modelo")));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setTipoDoVeiculo(TipoDoVeiculo.valueOf(rs.getString("tipo_veiculo")));
                veiculo.setCategoriaVeiculos(CategoriaVeiculos.valueOf(rs.getString("categoria_veiculo")));
                veiculo.setTipoCombustivel(TipoCombustivel.valueOf(rs.getString("tipo_combustivel")));
                veiculo.setQuilometragemAtual(rs.getInt("quilometragem"));
                listagemDeVeiculos.add(veiculo);
            }
        } catch (Exception e) {
        }
        return listagemDeVeiculos;
    }

    @Override
    public Veiculos buscarPeloId(int id) throws Exception {
        String sql = "SELECT * FROM veiculos WHERE id = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Veiculos objetoVeiculos = new Veiculos();
            IModelosDAO objetoModelosDao = new ModelosDAO();
            objetoVeiculos.setId(rs.getInt("id"));
            objetoVeiculos.setModelo(objetoModelosDao.buscar(rs.getInt("id_modelo")));
            objetoVeiculos.setPlaca(rs.getString("placa"));
            objetoVeiculos.setTipoDoVeiculo(TipoDoVeiculo.valueOf(rs.getString("tipo_veiculo")));
            objetoVeiculos.setTipoCombustivel(TipoCombustivel.valueOf(rs.getString("tipo_combustivel")));
            objetoVeiculos.setCategoriaVeiculos(CategoriaVeiculos.valueOf(rs.getString("categoria_veiculo")));
            objetoVeiculos.setQuilometragemAtual(rs.getInt("quilometragem"));
            return new Veiculos(objetoVeiculos.getId(), objetoVeiculos.getPlaca(), objetoVeiculos.getTipoDoVeiculo(), objetoVeiculos.getCategoriaVeiculos(), objetoVeiculos.getModelo(), objetoVeiculos.getTipoCombustivel(), objetoVeiculos.getQuilometragemAtual());
        }
        return null;
    }
    
    @Override
    public Veiculos buscarVeiculos(String placa) throws Exception {
        String sql = "SELECT * FROM veiculos WHERE placa = ?";
        System.out.println(placa);
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, placa);
        System.out.println(sql);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Veiculos objetoVeiculos = new Veiculos();
            IModelosDAO objetoModelosDao = new ModelosDAO();
            objetoVeiculos.setId(rs.getInt("id"));
            objetoVeiculos.setModelo(objetoModelosDao.buscar(rs.getInt("id_modelo")));
            objetoVeiculos.setPlaca(rs.getString("placa"));
            objetoVeiculos.setTipoDoVeiculo(TipoDoVeiculo.valueOf(rs.getString("tipo_veiculo")));
            objetoVeiculos.setTipoCombustivel(TipoCombustivel.valueOf(rs.getString("tipo_combustivel")));
            objetoVeiculos.setCategoriaVeiculos(CategoriaVeiculos.valueOf(rs.getString("categoria_veiculo")));
            objetoVeiculos.setQuilometragemAtual(rs.getInt("quilometragem"));
            return new Veiculos(objetoVeiculos.getId(), objetoVeiculos.getPlaca(), objetoVeiculos.getTipoDoVeiculo(), objetoVeiculos.getCategoriaVeiculos(), objetoVeiculos.getModelo(), objetoVeiculos.getTipoCombustivel(), objetoVeiculos.getQuilometragemAtual());
        }
        return null;
    }
    
    public ResultSet listarVeiculos() throws Exception {
        String sql = "SELECT placa from veiculos ORDER BY id";

        try {
            st = conexao.prepareStatement(sql);
            return st.executeQuery();

        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        }

    }
    
}
