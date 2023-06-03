package com.car.persistencia;

import com.car.Ferramentas.ConexaoBD;
import com.car.Modelos.Servico;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class ServicosDAO implements IServicosDAO{
    private Connection conexao = null;
    PreparedStatement st;
    
    public ServicosDAO() throws Exception{
        conexao = ConexaoBD.getConexao();
    }
    
    @Override
    public void InserirServico(Servico servico) throws Exception {
        try {
            FileInputStream fis = new FileInputStream(servico.getImagemServico());

            st = conexao.prepareStatement("insert into servicos( descricaoServico, urlServico, imagemServico) values (?, ?, ?)");
            st.setString(1, servico.getDescricao());
            st.setString(2, servico.getUrl());
            st.setBinaryStream(3, fis);
            st.executeUpdate();
            st.close();
            fis.close();
        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        }
        
    }

    @Override
    public void AlterarServico(Servico servico) throws Exception {
        try {
            FileInputStream fis = new FileInputStream(servico.getImagemServico());
            st = conexao.prepareStatement("UPDATE servicos SET descricaoServico = ?, urlServico = ?, imagemServico = ? WHERE idServicos = ?");
            st.setString(1, servico.getDescricao());
            st.setString(2, servico.getUrl());
            st.setBinaryStream(3, fis);
            st.setInt(4, servico.getId());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ALTERAR" + e);
        }
    }

    @Override
    public boolean excluirServico(int idServico) throws Exception {
        try {
            st = conexao.prepareStatement("DELETE FROM servicos WHERE idServicos = ?");
            st.setInt(1, idServico);
            st.executeUpdate();
            st.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public ArrayList<Servico> listagemServicos() throws Exception {
        ArrayList<Servico> listaDeMarcas = new ArrayList<Servico>();

        try {
            String sql = "select * from servicos";
            Statement statement = conexao.createStatement();

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Servico serv = new Servico();
                serv.setId(rs.getInt("idServicos"));
                serv.setDescricao(rs.getString("descricaoServico"));
                serv.setUrl(rs.getString("urlServico"));
                serv.setImagemServico(serv.getImagemServico());
                listaDeMarcas.add(serv);
            }

        } catch (Exception e) {
        }
        return listaDeMarcas;
    }
    
}
