package com.car.persistencia;

import com.car.Enumerations.CategoriaCNH;
import com.car.Enumerations.tipoProprietario;
import com.car.Ferramentas.ConexaoBD;
import com.car.Modelos.Proprietario;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ProprietariosDAO implements IProprietariosDAO {

    private Connection conexao = null;
    PreparedStatement st;

    public ProprietariosDAO() throws Exception {
        conexao = ConexaoBD.getConexao();
    }

    @Override
    public void incluirProprietario(Proprietario proprietario) throws Exception {
        try {

            st = conexao.prepareStatement("insert into proprietario(tipo, documento_identificador, nome, telefone, email, cnh, "
                    + "categoriacnh) values (?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, proprietario.getTipoDoProprietario().toString());
            st.setString(2, proprietario.getCPF_CNPJ());
            st.setString(3, proprietario.getNome());
            st.setString(4, proprietario.getTelefone());
            st.setString(5, proprietario.getEmail());
            st.setInt(6, proprietario.getCNH());
            st.setString(7, proprietario.getCategoriaCNH().toString());
            st.executeUpdate();
            st.close();

        } catch (SQLException erro) {
            throw new Exception("SQL Erro: " + erro.getMessage());
        }
    }

    @Override
    public boolean excluirProprietario(int idProprietario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Proprietario> listagemProprietarios() throws Exception {
        ArrayList<Proprietario> listagemDeProprietario = new ArrayList<Proprietario>();
        try {

            String sql = "select * from proprietario order by id";
            Statement statement = conexao.createStatement();

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Proprietario proprietario = new Proprietario();
                proprietario.setIdProprietarios(rs.getInt("id"));
                proprietario.setTipoDoProprietario(tipoProprietario.valueOf(rs.getString("tipo")));
                proprietario.setCPF_CNPJ(rs.getString("documento_identificador"));
                proprietario.setNome(rs.getString("nome"));
                proprietario.setTelefone(rs.getString("telefone"));
                proprietario.setEmail(rs.getString("email"));
                proprietario.setCNH(rs.getInt("cnh"));
                proprietario.setCategoriaCNH(CategoriaCNH.valueOf(rs.getString("categoriacnh")));
                listagemDeProprietario.add(proprietario);
            }
        } catch (Exception e) {
        }
        return listagemDeProprietario;
    }

    @Override
    public void alterarProprietario(Proprietario proprietario) throws Exception {

    }

    @Override
    public Proprietario buscarProprietario(int id) throws Exception {
        String sql = "SELECT * FROM proprietario WHERE id = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Proprietario objetoProprietario = new Proprietario();
            objetoProprietario.setIdProprietarios(rs.getInt("id"));
            objetoProprietario.setTipoDoProprietario(objetoProprietario.getTipoDoProprietario());
            objetoProprietario.setCPF_CNPJ(rs.getString("documento_identificador"));
            objetoProprietario.setNome(rs.getString("nome"));
            objetoProprietario.setTelefone(rs.getString("telefone"));
            objetoProprietario.setEmail(rs.getString("email"));
            objetoProprietario.setCNH(rs.getInt("cnh"));
            objetoProprietario.setCategoriaCNH(objetoProprietario.getCategoriaCNH());

            return new Proprietario(objetoProprietario.getIdProprietarios(), objetoProprietario.getTipoDoProprietario(),
                    objetoProprietario.getCPF_CNPJ(), objetoProprietario.getNome(), objetoProprietario.getTelefone(),
                    objetoProprietario.getEmail(), objetoProprietario.getCNH(), objetoProprietario.getCategoriaCNH());

        }
        return null;
    }

    public tipoProprietario buscarTipo(int id) {

        try {
            String sql = "SELECT * FROM proprietario WHERE id = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Proprietario objetoProprietario = new Proprietario();
                objetoProprietario.setIdProprietarios(rs.getInt("id"));
                objetoProprietario.setTipoDoProprietario(tipoProprietario.valueOf(rs.getString("tipo")));
                objetoProprietario.setCPF_CNPJ(rs.getString("documento_identificador"));
                objetoProprietario.setNome(rs.getString("nome"));
                objetoProprietario.setTelefone(rs.getString("telefone"));
                objetoProprietario.setEmail(rs.getString("email"));
                objetoProprietario.setCNH(rs.getInt("cnh"));
                objetoProprietario.setCategoriaCNH(CategoriaCNH.valueOf(rs.getString("categoriacnh")));
            }
        } catch (Exception e) {

        }

        return null;
    }

}
