package com.car.persistencia;

import com.car.Ferramentas.ConexaoBD;
import com.car.Modelos.Marcas;
import com.car.Modelos.Modelos;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelosDAO implements IModelosDAO {

    private Connection conexao = null;
    PreparedStatement st;

    public ModelosDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
    }

    @Override
    public void inserirModelos(Modelos modelos) throws Exception {
        try {
            FileInputStream fis = new FileInputStream(modelos.getImagemModelo());

            st = conexao.prepareStatement("insert into modelos(id_marca, descricao, url, imagem) values (?, ?, ?, ?)");

            st.setInt(1, modelos.getMarca().getId());
            st.setString(2, modelos.getDescricao());
            st.setString(3, modelos.getUrl());
            st.setBinaryStream(4, fis);
            st.executeUpdate();
            st.close();
            fis.close();
        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        }
    }

    @Override
    public void alterar(Modelos modelos) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Modelos> listagemDeModelos() throws Exception {
        ArrayList<Modelos> listagemDeModelos = new ArrayList<Modelos>();
        try {
            String sql = "select * from modelos order by id";
            Statement statement = conexao.createStatement();

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Modelos modelo = new Modelos();

                MarcasDAO marca = new MarcasDAO();

                modelo.setIdModelos(rs.getInt("id"));
                int idMarca = rs.getInt("id_marca");
                modelo.setMarca(marca.buscar(idMarca));
                modelo.setDescricao(rs.getString("descricao"));
                modelo.setUrl(rs.getString("url"));
                modelo.setImagemModelo(modelo.getImagemModelo());
                listagemDeModelos.add(modelo);
            }

        } catch (Exception e) {
        }
        return listagemDeModelos;
    }

    @Override
    public boolean excluir(int idModelos) throws Exception {
        try {
            st = conexao.prepareStatement("DELETE FROM modelos WHERE id = ?");
            st.setInt(1, idModelos);
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public Modelos buscar(int id) throws Exception {
        String sql = "SELECT * FROM modelos WHERE id = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Modelos objetoModelos = new Modelos();
            objetoModelos.setIdModelos(rs.getInt("id"));
            int idmarca = rs.getInt("id_marca");
            MarcasDAO marca = new MarcasDAO();
            objetoModelos.setMarca(marca.buscar(idmarca));
            objetoModelos.setDescricao(rs.getString("descricao"));
            objetoModelos.setUrl(rs.getString("url"));
            objetoModelos.setImagemModelo(objetoModelos.getImagemModelo());
            return new Modelos(objetoModelos.getIdModelos(), objetoModelos.getMarca(), objetoModelos.getDescricao(), objetoModelos.getUrl(), objetoModelos.getImagemModelo());
        }
        return null;
    }

    public ResultSet listarModelos() throws Exception {
        String sql = "SELECT descricao from modelos ORDER BY descricao";

        try {
            st = conexao.prepareStatement(sql);
            return st.executeQuery();

        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        }
    }
    
    
}
