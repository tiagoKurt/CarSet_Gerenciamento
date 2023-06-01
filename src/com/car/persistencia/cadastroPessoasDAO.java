/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.car.persistencia;

import com.car.Ferramentas.ConexaoBD;
import com.car.Modelos.cadastroPessoas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pichau
 */
public class cadastroPessoasDAO {
    private Connection conexao = null;
    PreparedStatement st;

    public cadastroPessoasDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
    }
    
    public void cadastrarPessoas(cadastroPessoas pessoas) throws SQLException, Exception{
        try {
            
            st = conexao.prepareStatement("insert into pessoasCadastradas(nomeDeUsuario, email, senha) values(?,?,?)");
            st.setString(1, pessoas.getNomeUsuario());
            st.setString(2, pessoas.getEmail());
            st.setString(3, pessoas.getSenha());
            st.executeUpdate();
            st.close();
            
        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        }
    }
}
