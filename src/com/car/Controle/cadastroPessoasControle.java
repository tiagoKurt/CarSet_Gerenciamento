/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.car.Controle;

import com.car.Ferramentas.ConexaoBD;
import com.car.persistencia.cadastroPessoasDAO;
import com.car.visao.telaLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pichau
 */
public class cadastroPessoasControle {
    private java.sql.Connection conexao = null;
    PreparedStatement st;
    
    
    public boolean loginUsuario(telaLogin tela){
        try {
            conexao = ConexaoBD.getConexao();
            cadastroPessoasDAO pessoas = new cadastroPessoasDAO();
            if(pessoas.Login(tela.getjTextField1_nomeUsuario().getText(), tela.getjTextField2_senha().getText()) == true){
                return true;
            }else{
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(cadastroPessoasControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
}
