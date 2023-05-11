package com.car.persistencia;

import com.car.Ferramentas.ConexaoBD;
import com.car.Modelos.Marcas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Pichau
 */
public class MarcasDAO implements IMarcasDAO{

    private Connection conexao = null;
    PreparedStatement st;
    
    public MarcasDAO() throws Exception{
        conexao = ConexaoBD.getConexao();
    }
    
    @Override
    public void InserirMarca(Marcas marca) throws Exception {
        try {
            String sql = "insert into marcas(descricao, urlMarcas, imagemMarca) values (?, ?, ?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setString(1, marca.getDescricao());
            preparedStatement.setString(2, marca.getUrl());
            preparedStatement.executeUpdate();
        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage()); 
        }
    }

    @Override
    public void alterarMarca(Marcas marca) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluirMarca(Marcas marca) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Marcas> listaDeMarcas() throws Exception {
        ArrayList<Marcas> listaDeMarcas = new ArrayList<Marcas>();
        String sql = "select * from marcas";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
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
