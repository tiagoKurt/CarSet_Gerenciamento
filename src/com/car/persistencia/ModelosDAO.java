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
public class ModelosDAO implements IModelosDAO{
    
    private Connection conexao = null; 
    PreparedStatement st;
    
    public ModelosDAO()throws Exception{
        conexao = ConexaoBD.getConexao();
    }
    
    
    
    
    @Override
    public void inserirModelos(Modelos modelos) throws Exception {
        try {
            FileInputStream fis = new FileInputStream(modelos.getImagemModelo());
            String sql = "Insert into modelos(nomemarcas, descricaomodelos, urlmodelos, imagemmodelo) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setString(1, modelos.getMarca().getDescricao());
            preparedStatement.setString(2, modelos.getDescricao());
            preparedStatement.setString(3, modelos.getUrl());
            preparedStatement.setBinaryStream(4, fis);
            preparedStatement.close();
            fis.close();
            conexao.close();
            
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
        try{
        String sql = "select * from modelos";
        
        Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Modelos modelo = new Modelos();
                modelo.setIdModelos(rs.getInt("idmodelos"));
                modelo.setMarca((Marcas) rs.getObject(modelo.getMarca().getDescricao()));
                modelo.setDescricao(rs.getString("descricaomodelos"));
                modelo.setUrl(rs.getString("urlmodelos"));
                listagemDeModelos.add(modelo);
            }
        
        }catch (Exception e) {
        }
        return listagemDeModelos;
    }

    @Override
    public boolean excluir(int idModelos) throws Exception {
           try {
            st = conexao.prepareStatement("DELETE FROM marcas WHERE idmarcas = ?");
            st.setInt(1, idModelos);
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    
    
}
