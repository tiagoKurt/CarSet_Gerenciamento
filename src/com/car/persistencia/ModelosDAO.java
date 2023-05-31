/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author Pichau
 */
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

            st = conexao.prepareStatement("insert into modelos(idMarcas, descricaomodelos, urlmodelos, imagemmodelo) values (?, ?, ?, ?)");

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
            String sql = "select * from modelos order by idmodelos";
            Statement statement = conexao.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Modelos modelo = new Modelos();
                ModelosDAO modeloo = new ModelosDAO();
                
                MarcasDAO marca = new MarcasDAO();
                
                modelo.setIdModelos(rs.getInt("idmodelos"));
                modelo.setMarca(marca.listaDeMarcas().get(0));   
                modelo.setDescricao(rs.getString("descricaomodelos"));
                modelo.setUrl(rs.getString("urlmodelos"));
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
            st = conexao.prepareStatement("DELETE FROM modelos WHERE idmodelos = ?");
            st.setInt(1, idModelos);
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public Marcas buscar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
