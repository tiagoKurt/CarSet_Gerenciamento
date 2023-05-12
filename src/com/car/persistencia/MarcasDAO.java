package com.car.persistencia;

import com.car.Ferramentas.ConexaoBD;
import com.car.Modelos.Marcas;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Pichau
 */
public class MarcasDAO implements IMarcasDAO {

    private Connection conexao = null;
    PreparedStatement st;

    public MarcasDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
    }

    @Override
    public void InserirMarca(Marcas marca) throws Exception {
        try {
            FileInputStream fis = new FileInputStream(marca.getImageFile());

            String sql = "insert into marcas(descricao, urlMarcas, imagemMarca) values (?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setString(1, marca.getDescricao());
            preparedStatement.setString(2, marca.getUrl());
            preparedStatement.setBinaryStream(3, fis);
            preparedStatement.executeUpdate();
            fis.close();

            conexao.close();
        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        }
    }

    @Override
    public void alterarMarca(Marcas marca) throws Exception {
        
        try{
        FileInputStream fis = new FileInputStream(marca.getImageFile());
        st = conexao.prepareStatement("UPDATE marcas SET descricao = ?, urlmarcas = ?, imagemmarca = ? WHERE idmarcas = ?");
        st.setString(1, marca.getDescricao());
        st.setString(2, marca.getUrl());
        st.setBinaryStream(3, fis);
        st.setInt(4, marca.getId());
        st.executeUpdate();
        st.close();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null , "ALTERAR" + e);
        }
    }

    @Override
    public boolean excluirMarca(int idmarcas) throws Exception {
        try {
            st = conexao.prepareStatement("DELETE FROM marcas WHERE idmarcas = ?");
            st.setInt(1, idmarcas);
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public ArrayList<Marcas> listaDeMarcas() throws Exception {
        ArrayList<Marcas> listaDeMarcas = new ArrayList<Marcas>();
        String sql = "select * from marcas";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Marcas marca = new Marcas();
                marca.setId(rs.getInt("idMarcas"));
                marca.setDescricao(rs.getString("descricao"));
                marca.setUrl(rs.getString("urlMarcas"));

                listaDeMarcas.add(marca);
            }

        } catch (Exception e) {
        }
        return listaDeMarcas;
    }

}
