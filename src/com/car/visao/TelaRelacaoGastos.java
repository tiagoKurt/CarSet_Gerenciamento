package com.car.visao;

import com.car.Enumerations.CategoriaVeiculos;
import com.car.Enumerations.ClassificacaoGastos;
import com.car.Enumerations.TipoCombustivel;
import com.car.Enumerations.TipoDoVeiculo;
import com.car.Enumerations.TiposCombustiveisGastos;
import com.car.Ferramentas.ConexaoBD;
import com.car.Ferramentas.JTableRenderer;
import com.car.Modelos.Gastos;
import com.car.Modelos.GastosAvulsos;
import com.car.Modelos.GastosCombustivel;
import com.car.Modelos.GastosImposto;
import com.car.Modelos.GastosMecanico;
import com.car.Modelos.GastosSeguro;
import com.car.persistencia.GastosAvulsosDao;
import com.car.persistencia.GastosCombustivelDao;
import com.car.persistencia.GastosDao;
import com.car.persistencia.GastosImpostosDao;
import com.car.persistencia.GastosMecanicoDao;
import com.car.persistencia.GastosSeguroDao;
import com.car.persistencia.IGastosAvulsosDao;
import com.car.persistencia.IGastosCombustivelDao;
import com.car.persistencia.IGastosDao;
import com.car.persistencia.IGastosMecanicoDao;
import com.car.persistencia.IGastosSeguroDao;
import com.car.persistencia.VeiculosDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class TelaRelacaoGastos extends javax.swing.JFrame {

    private Connection conexao = null;
    PreparedStatement st;
    String classGastos;
    String tipoCombustivel;
    float gastosGraficoCombustivel = 0;
    float gastosSeguro = 0;
    float gastosMecanico = 0;
    float gastosImposto = 0;
    float outrosGastos = 0;
    float gastosGerais = 0;

    public TelaRelacaoGastos() {
        try {
            initComponents();
            imprimirDadosNaGrid();
            try {
                conexao = ConexaoBD.getConexao();
            } catch (Exception ex) {
                Logger.getLogger(TelaModelos.class.getName()).log(Level.SEVERE, null, ex);
            }
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Rectangle bounds = env.getMaximumWindowBounds();
            setLocationRelativeTo(null);
            int largura = bounds.width;
            int altura = bounds.height;
            setSize(largura, altura);
            setLocation(0, 0);
            classGastos = ClassificacaoGastos.COMBUSTIVEL + "";
            carregarComboBox();
            carregarComboBox2();
            criarGraficoGERAL();
            puxarDadosComboBox();
            jComboBox_Filtro.setEnabled(false);
            jPanel1_Combustivel.setVisible(false);
            jPanel1_mecanico.setVisible(false);
            jPanel1_Seguro.setVisible(false);
            jPanel1_Imposto.setVisible(false);
            jPanel1_outrosGastos.setVisible(false);
            jPanel1_gastosGeral.setVisible(false);
            jLabel7_graficos.setVisible(true);
            
            jComboBox1_tipoDoGastoGraficos.setVisible(false);
            jLabel4_PLACASELECIONADA.setVisible(false);
            jTextField1_PlacaSelecionada.setVisible(false);
            jLabel4_tipoDoGasto.setVisible(false);
            jTextField1_TipoDoGasto.setVisible(false);
            jTextField1_idAlterar_Deletar.setVisible(false);
            jButton_Alterar.setVisible(false);
            jButton_Remover.setVisible(false);
            jFrame1_gasolinaAlterar.setSize(largura, altura);
            jFrame1_gasolinaAlterar.setLocation(0, 0);
            jFrame1_seguroAlterar.setSize(largura, altura);
            jFrame1_seguroAlterar.setLocation(0, 0);
            jFrame1_alterarImposto.setSize(largura, altura);
            jFrame1_alterarImposto.setLocation(0, 0);
            jFrame1_alterarOutros.setSize(largura, altura);
            jFrame1_alterarOutros.setLocation(0, 0);
            jFrame1_alterarMecanico.setSize(largura, altura);
            jFrame1_alterarMecanico.setLocation(0, 0);

        } catch (Exception ex) {
            Logger.getLogger(TelaRelacaoGastos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1_gasolinaAlterar = new javax.swing.JFrame();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton4_voltar1 = new javax.swing.JButton();
        jComboBox1_tipoDeCombustivel = new javax.swing.JComboBox<>();
        jTextField1_LitrosColocados = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField1_precoLitro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField1_kmsPercorridosLItro = new javax.swing.JTextField();
        jFormattedTextField1_dataAbastecimento = new javax.swing.JFormattedTextField();
        jComboBox1_veiculos = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton_iNCLUIR = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jFrame1_seguroAlterar = new javax.swing.JFrame();
        jLabel20 = new javax.swing.JLabel();
        jTextField1_valorDaFranquia = new javax.swing.JTextField();
        jTextField1_descricaoServico = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jFormattedTextField1_dataDoPagamento = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jComboBox1_veiculos1 = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButton_alterarTelaComb = new javax.swing.JButton();
        jButton4_voltar3 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jFrame1_alterarImposto = new javax.swing.JFrame();
        jTextField1_descricaoServico1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTextField1_ValoGastoImposto = new javax.swing.JTextField();
        jTextField1_TipoDoVeiculo = new javax.swing.JTextField();
        jFormattedTextField1_dataVisitaMecanico = new javax.swing.JFormattedTextField();
        jComboBox1_veiculos2 = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jButton_alterarTelaComb1 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jButton4_voltar4 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jFrame1_alterarOutros = new javax.swing.JFrame();
        jLabel37 = new javax.swing.JLabel();
        jTextField1_DescricaoDoGasto = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jFormattedTextField1_dataDoGasto = new javax.swing.JFormattedTextField();
        jLabel40 = new javax.swing.JLabel();
        jComboBox1_veiculos3 = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jTextField1_ValorDoGasto = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jButton4_voltar5 = new javax.swing.JButton();
        jButton_alterarTelaComb2 = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jFrame1_alterarMecanico = new javax.swing.JFrame();
        jTextField1_ValorDoItem = new javax.swing.JTextField();
        jTextField2_valorMaoDeObra = new javax.swing.JTextField();
        jTextField3_qntDeItens = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jFormattedTextField1_dataVisitaMecanico1 = new javax.swing.JFormattedTextField();
        jTextField1_item_manutencao = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jComboBox1_veiculos4 = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        jTextField1_descricaoServico2 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jButton4_voltar6 = new javax.swing.JButton();
        jButton_alterarTelaComb3 = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_gastos = new javax.swing.JTable();
        jButton4_voltar = new javax.swing.JButton();
        jComboBox1_tipoDoGasto = new javax.swing.JComboBox<>();
        jComboBox_Filtro = new javax.swing.JComboBox<>();
        jLabelFiltro = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1_tipoDoGastoGraficos = new javax.swing.JComboBox<>();
        jLabel7_graficos = new javax.swing.JLabel();
        jComboBox1_itemRelacao = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jPanel1_mecanico = new javax.swing.JPanel();
        jPanel1_Combustivel = new javax.swing.JPanel();
        jPanel1_Seguro = new javax.swing.JPanel();
        jPanel1_Imposto = new javax.swing.JPanel();
        jPanel1_outrosGastos = new javax.swing.JPanel();
        jPanel1_gastosGeral = new javax.swing.JPanel();
        jTextField1_PlacaSelecionada = new javax.swing.JTextField();
        jLabel4_PLACASELECIONADA = new javax.swing.JLabel();
        jTextField1_TipoDoGasto = new javax.swing.JTextField();
        jLabel4_tipoDoGasto = new javax.swing.JLabel();
        jButton_Alterar = new javax.swing.JButton();
        jButton_Remover = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1_idAlterar_Deletar = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();

        jFrame1_gasolinaAlterar.setUndecorated(true);
        jFrame1_gasolinaAlterar.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/pinkLogoMenorzinha.gif"))); // NOI18N
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jFrame1_gasolinaAlterar.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Bodoni MT", 3, 36)); // NOI18N
        jLabel8.setText("ALTERAR COMBUSTÍVEL");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jFrame1_gasolinaAlterar.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 480, 30));

        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_gasolinaAlterar.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 480, -1));

        jButton4_voltar1.setBackground(new java.awt.Color(102, 102, 102));
        jButton4_voltar1.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jButton4_voltar1.setForeground(new java.awt.Color(255, 0, 153));
        jButton4_voltar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/voltar.png"))); // NOI18N
        jButton4_voltar1.setText("VOLTAR");
        jButton4_voltar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton4_voltar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4_voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_voltar1ActionPerformed(evt);
            }
        });
        jFrame1_gasolinaAlterar.getContentPane().add(jButton4_voltar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 630, 140, 40));

        jComboBox1_tipoDeCombustivel.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jComboBox1_tipoDeCombustivel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jComboBox1_tipoDeCombustivel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1_tipoDeCombustivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1_tipoDeCombustivelActionPerformed(evt);
            }
        });
        jFrame1_gasolinaAlterar.getContentPane().add(jComboBox1_tipoDeCombustivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 220, 50));

        jTextField1_LitrosColocados.setFont(new java.awt.Font("Bodoni MT", 3, 28)); // NOI18N
        jTextField1_LitrosColocados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_gasolinaAlterar.getContentPane().add(jTextField1_LitrosColocados, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 230, 50));

        jLabel10.setFont(new java.awt.Font("Bodoni MT", 3, 21)); // NOI18N
        jLabel10.setText("COMBUSTÍVEL ABASTECIDO");
        jFrame1_gasolinaAlterar.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        jLabel11.setFont(new java.awt.Font("Bodoni MT", 3, 21)); // NOI18N
        jLabel11.setText("LITROS ABASTECIDOS");
        jFrame1_gasolinaAlterar.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, -1, -1));

        jLabel12.setFont(new java.awt.Font("Bodoni MT", 3, 21)); // NOI18N
        jLabel12.setText("PLACA DO VEÍCULO");
        jFrame1_gasolinaAlterar.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 570, -1, -1));

        jTextField1_precoLitro.setFont(new java.awt.Font("Bodoni MT", 3, 28)); // NOI18N
        jTextField1_precoLitro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_gasolinaAlterar.getContentPane().add(jTextField1_precoLitro, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, 230, 50));

        jLabel13.setFont(new java.awt.Font("Bodoni MT", 3, 21)); // NOI18N
        jLabel13.setText("KM/s PERCORRIDOS POR LITRO");
        jFrame1_gasolinaAlterar.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, -1, -1));

        jTextField1_kmsPercorridosLItro.setFont(new java.awt.Font("Bodoni MT", 3, 28)); // NOI18N
        jTextField1_kmsPercorridosLItro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_gasolinaAlterar.getContentPane().add(jTextField1_kmsPercorridosLItro, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 230, 50));

        jFormattedTextField1_dataAbastecimento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        try {
            jFormattedTextField1_dataAbastecimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_dataAbastecimento.setFont(new java.awt.Font("Bodoni MT", 3, 28)); // NOI18N
        jFormattedTextField1_dataAbastecimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1_dataAbastecimentoActionPerformed(evt);
            }
        });
        jFrame1_gasolinaAlterar.getContentPane().add(jFormattedTextField1_dataAbastecimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, 150, 50));

        jComboBox1_veiculos.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jComboBox1_veiculos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jComboBox1_veiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1_veiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1_veiculosActionPerformed(evt);
            }
        });
        jFrame1_gasolinaAlterar.getContentPane().add(jComboBox1_veiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 610, 220, 50));

        jLabel14.setFont(new java.awt.Font("Bodoni MT", 3, 21)); // NOI18N
        jLabel14.setText("DATA DO ABASTECIMENTO");
        jFrame1_gasolinaAlterar.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 460, -1, -1));

        jLabel15.setFont(new java.awt.Font("Bodoni MT", 3, 21)); // NOI18N
        jLabel15.setText("PREÇO DO LITRO");
        jFrame1_gasolinaAlterar.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, -1, -1));

        jButton_iNCLUIR.setBackground(new java.awt.Color(102, 102, 102));
        jButton_iNCLUIR.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jButton_iNCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/CHANGE.png"))); // NOI18N
        jButton_iNCLUIR.setText("   ALTERAR");
        jButton_iNCLUIR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_iNCLUIR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_iNCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_iNCLUIRActionPerformed(evt);
            }
        });
        jFrame1_gasolinaAlterar.getContentPane().add(jButton_iNCLUIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 330, 230, 60));

        jLabel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "PREENCHA AS INFORMAÇÕES", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 28), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_gasolinaAlterar.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 720, 500));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/FundoTelas.png"))); // NOI18N
        jFrame1_gasolinaAlterar.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jFrame1_seguroAlterar.setUndecorated(true);
        jFrame1_seguroAlterar.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Bodoni MT", 3, 36)); // NOI18N
        jLabel20.setText("ALTERAR SEGURO");
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jFrame1_seguroAlterar.getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 370, 30));

        jTextField1_valorDaFranquia.setFont(new java.awt.Font("Bodoni MT", 3, 20)); // NOI18N
        jTextField1_valorDaFranquia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jFrame1_seguroAlterar.getContentPane().add(jTextField1_valorDaFranquia, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 240, 50));

        jTextField1_descricaoServico.setFont(new java.awt.Font("Bodoni MT", 3, 20)); // NOI18N
        jTextField1_descricaoServico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jFrame1_seguroAlterar.getContentPane().add(jTextField1_descricaoServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 650, 50));

        jLabel21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "DESCRIÇÃO DO SERVIÇO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_seguroAlterar.getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 710, 110));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/pinkLogoMenorzinha.gif"))); // NOI18N
        jLabel18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jFrame1_seguroAlterar.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jFormattedTextField1_dataDoPagamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        try {
            jFormattedTextField1_dataDoPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_dataDoPagamento.setFont(new java.awt.Font("Bodoni MT", 3, 32)); // NOI18N
        jFormattedTextField1_dataDoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1_dataDoPagamentoActionPerformed(evt);
            }
        });
        jFrame1_seguroAlterar.getContentPane().add(jFormattedTextField1_dataDoPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 380, 210, 50));

        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_seguroAlterar.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 370, -1));

        jLabel22.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "VALOR DA FRANQUIA", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_seguroAlterar.getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 350, 110));

        jLabel23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "DATA DO PAGAMENTO", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_seguroAlterar.getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 340, 110));

        jComboBox1_veiculos1.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jComboBox1_veiculos1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jComboBox1_veiculos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jFrame1_seguroAlterar.getContentPane().add(jComboBox1_veiculos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 520, 220, 50));

        jLabel24.setFont(new java.awt.Font("Bodoni MT", 3, 25)); // NOI18N
        jLabel24.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "PLACA DO VEÍCULO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 22), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_seguroAlterar.getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 480, 390, 110));

        jLabel25.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "PREENCHA AS INFORMAÇÕES", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 28), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_seguroAlterar.getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 770, 500));

        jButton_alterarTelaComb.setBackground(new java.awt.Color(102, 102, 102));
        jButton_alterarTelaComb.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jButton_alterarTelaComb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/CHANGE.png"))); // NOI18N
        jButton_alterarTelaComb.setText("   ALTERAR");
        jButton_alterarTelaComb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_alterarTelaComb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_alterarTelaComb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_alterarTelaCombActionPerformed(evt);
            }
        });
        jFrame1_seguroAlterar.getContentPane().add(jButton_alterarTelaComb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 330, 230, 60));

        jButton4_voltar3.setBackground(new java.awt.Color(102, 102, 102));
        jButton4_voltar3.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jButton4_voltar3.setForeground(new java.awt.Color(255, 0, 153));
        jButton4_voltar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/voltar.png"))); // NOI18N
        jButton4_voltar3.setText("VOLTAR");
        jButton4_voltar3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton4_voltar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4_voltar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_voltar3ActionPerformed(evt);
            }
        });
        jFrame1_seguroAlterar.getContentPane().add(jButton4_voltar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 630, 140, 40));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/FundoTelas.png"))); // NOI18N
        jFrame1_seguroAlterar.getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jFrame1_alterarImposto.setUndecorated(true);
        jFrame1_alterarImposto.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1_descricaoServico1.setFont(new java.awt.Font("Bodoni MT", 3, 20)); // NOI18N
        jTextField1_descricaoServico1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jFrame1_alterarImposto.getContentPane().add(jTextField1_descricaoServico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 650, 50));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/pinkLogoMenorzinha.gif"))); // NOI18N
        jLabel31.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jFrame1_alterarImposto.getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jTextField1_ValoGastoImposto.setFont(new java.awt.Font("Bodoni MT", 3, 20)); // NOI18N
        jTextField1_ValoGastoImposto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jFrame1_alterarImposto.getContentPane().add(jTextField1_ValoGastoImposto, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 430, 180, 50));

        jTextField1_TipoDoVeiculo.setFont(new java.awt.Font("Bodoni MT", 3, 20)); // NOI18N
        jTextField1_TipoDoVeiculo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jFrame1_alterarImposto.getContentPane().add(jTextField1_TipoDoVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 320, 50));

        jFormattedTextField1_dataVisitaMecanico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        try {
            jFormattedTextField1_dataVisitaMecanico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_dataVisitaMecanico.setFont(new java.awt.Font("Bodoni MT", 3, 32)); // NOI18N
        jFormattedTextField1_dataVisitaMecanico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1_dataVisitaMecanicoActionPerformed(evt);
            }
        });
        jFrame1_alterarImposto.getContentPane().add(jFormattedTextField1_dataVisitaMecanico, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 570, 210, 50));

        jComboBox1_veiculos2.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jComboBox1_veiculos2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jComboBox1_veiculos2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1_veiculos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1_veiculos2ActionPerformed(evt);
            }
        });
        jFrame1_alterarImposto.getContentPane().add(jComboBox1_veiculos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 570, 220, 50));

        jLabel36.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "VALOR GASTO", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterarImposto.getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 390, 300, 110));

        jLabel35.setFont(new java.awt.Font("Bodoni MT", 3, 25)); // NOI18N
        jLabel35.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "PLACA DO VEÍCULO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 22), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterarImposto.getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, 380, 110));

        jLabel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "DATA DO GASTO", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterarImposto.getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 530, 300, 110));

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Bodoni MT", 3, 36)); // NOI18N
        jLabel27.setText("ALTERAR IMPOSTOS");
        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jFrame1_alterarImposto.getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 410, 50));

        jLabel34.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "TIPO DO VEÍCULO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterarImposto.getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 380, 110));

        jLabel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "DESCRIÇÃO DO SERVIÇO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterarImposto.getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 710, 110));

        jLabel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_alterarImposto.getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 410, -1));

        jButton_alterarTelaComb1.setBackground(new java.awt.Color(102, 102, 102));
        jButton_alterarTelaComb1.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jButton_alterarTelaComb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/CHANGE.png"))); // NOI18N
        jButton_alterarTelaComb1.setText("   ALTERAR");
        jButton_alterarTelaComb1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_alterarTelaComb1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_alterarTelaComb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_alterarTelaComb1ActionPerformed(evt);
            }
        });
        jFrame1_alterarImposto.getContentPane().add(jButton_alterarTelaComb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 400, 230, 60));

        jLabel29.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "PREENCHA AS INFORMAÇÕES", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 28), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterarImposto.getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 780, 490));

        jButton4_voltar4.setBackground(new java.awt.Color(102, 102, 102));
        jButton4_voltar4.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jButton4_voltar4.setForeground(new java.awt.Color(255, 0, 153));
        jButton4_voltar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/voltar.png"))); // NOI18N
        jButton4_voltar4.setText("VOLTAR");
        jButton4_voltar4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton4_voltar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4_voltar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_voltar4ActionPerformed(evt);
            }
        });
        jFrame1_alterarImposto.getContentPane().add(jButton4_voltar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 630, 140, 40));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/FundoTelas.png"))); // NOI18N
        jFrame1_alterarImposto.getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jFrame1_alterarOutros.setUndecorated(true);
        jFrame1_alterarOutros.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/pinkLogoMenorzinha.gif"))); // NOI18N
        jLabel37.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jFrame1_alterarOutros.getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jTextField1_DescricaoDoGasto.setFont(new java.awt.Font("Bodoni MT", 3, 20)); // NOI18N
        jTextField1_DescricaoDoGasto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jFrame1_alterarOutros.getContentPane().add(jTextField1_DescricaoDoGasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 650, 50));

        jLabel38.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "DESCRIÇÃO DO GASTO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterarOutros.getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 710, 110));

        jLabel39.setBackground(new java.awt.Color(0, 0, 0));
        jLabel39.setFont(new java.awt.Font("Bodoni MT", 3, 36)); // NOI18N
        jLabel39.setText("ALTERAR GASTOS AVULSOS");
        jLabel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jFrame1_alterarOutros.getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 550, 30));

        jFormattedTextField1_dataDoGasto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        try {
            jFormattedTextField1_dataDoGasto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_dataDoGasto.setFont(new java.awt.Font("Bodoni MT", 3, 32)); // NOI18N
        jFormattedTextField1_dataDoGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1_dataDoGastoActionPerformed(evt);
            }
        });
        jFrame1_alterarOutros.getContentPane().add(jFormattedTextField1_dataDoGasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 380, 210, 50));

        jLabel40.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "DATA DO PAGAMENTO", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterarOutros.getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 340, 110));

        jComboBox1_veiculos3.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jComboBox1_veiculos3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jComboBox1_veiculos3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jFrame1_alterarOutros.getContentPane().add(jComboBox1_veiculos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 520, 220, 50));

        jLabel41.setFont(new java.awt.Font("Bodoni MT", 3, 25)); // NOI18N
        jLabel41.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "PLACA DO VEÍCULO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 22), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterarOutros.getContentPane().add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 480, 410, 110));

        jTextField1_ValorDoGasto.setFont(new java.awt.Font("Bodoni MT", 3, 20)); // NOI18N
        jTextField1_ValorDoGasto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jFrame1_alterarOutros.getContentPane().add(jTextField1_ValorDoGasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 240, 50));

        jLabel42.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "VALOR GASTO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterarOutros.getContentPane().add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 350, 110));

        jLabel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_alterarOutros.getContentPane().add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 540, -1));

        jLabel44.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "PREENCHA AS INFORMAÇÕES", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 28), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterarOutros.getContentPane().add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 770, 490));

        jButton4_voltar5.setBackground(new java.awt.Color(102, 102, 102));
        jButton4_voltar5.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jButton4_voltar5.setForeground(new java.awt.Color(255, 0, 153));
        jButton4_voltar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/voltar.png"))); // NOI18N
        jButton4_voltar5.setText("VOLTAR");
        jButton4_voltar5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton4_voltar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4_voltar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_voltar5ActionPerformed(evt);
            }
        });
        jFrame1_alterarOutros.getContentPane().add(jButton4_voltar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 630, 140, 40));

        jButton_alterarTelaComb2.setBackground(new java.awt.Color(102, 102, 102));
        jButton_alterarTelaComb2.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jButton_alterarTelaComb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/CHANGE.png"))); // NOI18N
        jButton_alterarTelaComb2.setText("   ALTERAR");
        jButton_alterarTelaComb2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_alterarTelaComb2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_alterarTelaComb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_alterarTelaComb2ActionPerformed(evt);
            }
        });
        jFrame1_alterarOutros.getContentPane().add(jButton_alterarTelaComb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 400, 230, 60));

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/FundoTelas.png"))); // NOI18N
        jFrame1_alterarOutros.getContentPane().add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jFrame1_alterarMecanico.setUndecorated(true);
        jFrame1_alterarMecanico.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1_ValorDoItem.setFont(new java.awt.Font("Bodoni MT", 3, 20)); // NOI18N
        jTextField1_ValorDoItem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jFrame1_alterarMecanico.getContentPane().add(jTextField1_ValorDoItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 380, 180, 50));

        jTextField2_valorMaoDeObra.setFont(new java.awt.Font("Bodoni MT", 3, 20)); // NOI18N
        jTextField2_valorMaoDeObra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jFrame1_alterarMecanico.getContentPane().add(jTextField2_valorMaoDeObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 510, 320, 50));

        jTextField3_qntDeItens.setFont(new java.awt.Font("Bodoni MT", 3, 20)); // NOI18N
        jTextField3_qntDeItens.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jFrame1_alterarMecanico.getContentPane().add(jTextField3_qntDeItens, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 510, 180, 50));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/pinkLogoMenorzinha.gif"))); // NOI18N
        jLabel46.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jFrame1_alterarMecanico.getContentPane().add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel47.setBackground(new java.awt.Color(0, 0, 0));
        jLabel47.setFont(new java.awt.Font("Bodoni MT", 3, 36)); // NOI18N
        jLabel47.setText("MECÂNICO");
        jLabel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jFrame1_alterarMecanico.getContentPane().add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 230, 50));

        jLabel48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_alterarMecanico.getContentPane().add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 230, -1));

        jFormattedTextField1_dataVisitaMecanico1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        try {
            jFormattedTextField1_dataVisitaMecanico1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_dataVisitaMecanico1.setFont(new java.awt.Font("Bodoni MT", 3, 32)); // NOI18N
        jFormattedTextField1_dataVisitaMecanico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1_dataVisitaMecanico1ActionPerformed(evt);
            }
        });
        jFrame1_alterarMecanico.getContentPane().add(jFormattedTextField1_dataVisitaMecanico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 640, 210, 50));

        jTextField1_item_manutencao.setFont(new java.awt.Font("Bodoni MT", 3, 20)); // NOI18N
        jTextField1_item_manutencao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jFrame1_alterarMecanico.getContentPane().add(jTextField1_item_manutencao, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 320, 50));

        jLabel49.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "DATA DO GASTO", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterarMecanico.getContentPane().add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 600, 300, 110));

        jLabel50.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "VALOR DO  ITEM(OPC.)", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterarMecanico.getContentPane().add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, 300, 110));

        jLabel51.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "QNT DE ITENS(OPC.)", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterarMecanico.getContentPane().add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, 300, 110));

        jComboBox1_veiculos4.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jComboBox1_veiculos4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jComboBox1_veiculos4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1_veiculos4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1_veiculos4ActionPerformed(evt);
            }
        });
        jFrame1_alterarMecanico.getContentPane().add(jComboBox1_veiculos4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 640, 220, 50));

        jLabel52.setFont(new java.awt.Font("Bodoni MT", 3, 25)); // NOI18N
        jLabel52.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "PLACA DO VEÍCULO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 22), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterarMecanico.getContentPane().add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 600, 380, 110));

        jTextField1_descricaoServico2.setFont(new java.awt.Font("Bodoni MT", 3, 20)); // NOI18N
        jTextField1_descricaoServico2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jFrame1_alterarMecanico.getContentPane().add(jTextField1_descricaoServico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 650, 50));

        jLabel53.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "DESCRIÇÃO DO SERVIÇO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterarMecanico.getContentPane().add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 710, 110));

        jLabel54.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "ITEM COMPRADO/TROCADO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterarMecanico.getContentPane().add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 380, 110));

        jLabel55.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "VALOR MÃO DE OBRA(OPC.)", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterarMecanico.getContentPane().add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 380, 110));

        jLabel56.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4), "PREENCHA AS INFORMAÇÕES", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 28))); // NOI18N
        jFrame1_alterarMecanico.getContentPane().add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 780, 600));

        jButton4_voltar6.setBackground(new java.awt.Color(102, 102, 102));
        jButton4_voltar6.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jButton4_voltar6.setForeground(new java.awt.Color(255, 0, 153));
        jButton4_voltar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/voltar.png"))); // NOI18N
        jButton4_voltar6.setText("VOLTAR");
        jButton4_voltar6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton4_voltar6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4_voltar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_voltar6ActionPerformed(evt);
            }
        });
        jFrame1_alterarMecanico.getContentPane().add(jButton4_voltar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 630, 140, 40));

        jButton_alterarTelaComb3.setBackground(new java.awt.Color(102, 102, 102));
        jButton_alterarTelaComb3.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jButton_alterarTelaComb3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/CHANGE.png"))); // NOI18N
        jButton_alterarTelaComb3.setText("   ALTERAR");
        jButton_alterarTelaComb3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_alterarTelaComb3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_alterarTelaComb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_alterarTelaComb3ActionPerformed(evt);
            }
        });
        jFrame1_alterarMecanico.getContentPane().add(jButton_alterarTelaComb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 400, 230, 60));

        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/FundoTelas.png"))); // NOI18N
        jFrame1_alterarMecanico.getContentPane().add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTable1_gastos.setBackground(new java.awt.Color(153, 153, 153));
        jTable1_gastos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jTable1_gastos.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jTable1_gastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "DESCRIÇÃO", "", "LOGO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1_gastos.setRowHeight(60);
        jTable1_gastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_gastosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1_gastos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 1190, 250));

        jButton4_voltar.setBackground(new java.awt.Color(102, 102, 102));
        jButton4_voltar.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jButton4_voltar.setForeground(new java.awt.Color(255, 0, 153));
        jButton4_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/voltar.png"))); // NOI18N
        jButton4_voltar.setText("VOLTAR");
        jButton4_voltar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton4_voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_voltarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 730, 180, 50));

        jComboBox1_tipoDoGasto.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jComboBox1_tipoDoGasto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jComboBox1_tipoDoGasto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1_tipoDoGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1_tipoDoGastoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1_tipoDoGasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, 280, 50));

        jComboBox_Filtro.setFont(new java.awt.Font("Comic Sans MS", 3, 26)); // NOI18N
        jComboBox_Filtro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jComboBox_Filtro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_FiltroItemStateChanged(evt);
            }
        });
        jComboBox_Filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_FiltroActionPerformed(evt);
            }
        });
        jComboBox_Filtro.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox_FiltroPropertyChange(evt);
            }
        });
        getContentPane().add(jComboBox_Filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 130, 200, -1));

        jLabelFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "FILTRO", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 26), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabelFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 90, 250, 120));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/pinkLogoMenorzinha.gif"))); // NOI18N
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 180, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Bodoni MT", 3, 36)); // NOI18N
        jLabel4.setText("GASTOS");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 160, 30));

        jComboBox1_tipoDoGastoGraficos.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jComboBox1_tipoDoGastoGraficos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jComboBox1_tipoDoGastoGraficos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1_tipoDoGastoGraficos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1_tipoDoGastoGraficosActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1_tipoDoGastoGraficos, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, 280, 50));

        jLabel7_graficos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "TIPO DO GASTO", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 26), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel7_graficos, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 380, 120));

        jComboBox1_itemRelacao.setFont(new java.awt.Font("Bodoni MT", 3, 24)); // NOI18N
        jComboBox1_itemRelacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TABELAS", "GRÁFICOS" }));
        jComboBox1_itemRelacao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jComboBox1_itemRelacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1_itemRelacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1_itemRelacaoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1_itemRelacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 220, 50));

        jLabel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "VER GASTOS EM", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 26), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 310, 120));

        jPanel1_mecanico.setBackground(new java.awt.Color(255, 51, 153));
        getContentPane().add(jPanel1_mecanico, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 680, 430));

        jPanel1_Combustivel.setBackground(new java.awt.Color(255, 51, 153));
        getContentPane().add(jPanel1_Combustivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 680, 430));

        jPanel1_Seguro.setBackground(new java.awt.Color(255, 51, 153));
        getContentPane().add(jPanel1_Seguro, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 680, 430));

        jPanel1_Imposto.setBackground(new java.awt.Color(255, 51, 153));
        getContentPane().add(jPanel1_Imposto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 680, 430));

        jPanel1_outrosGastos.setBackground(new java.awt.Color(255, 51, 153));
        getContentPane().add(jPanel1_outrosGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 680, 430));

        jPanel1_gastosGeral.setBackground(new java.awt.Color(255, 51, 153));
        getContentPane().add(jPanel1_gastosGeral, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 680, 430));

        jTextField1_PlacaSelecionada.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jTextField1_PlacaSelecionada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(jTextField1_PlacaSelecionada, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 610, 230, 40));

        jLabel4_PLACASELECIONADA.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4_PLACASELECIONADA.setFont(new java.awt.Font("Bodoni MT", 3, 25)); // NOI18N
        jLabel4_PLACASELECIONADA.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "PLACA SELECIONADA", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 22), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel4_PLACASELECIONADA, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 570, 330, 100));

        jTextField1_TipoDoGasto.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jTextField1_TipoDoGasto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(jTextField1_TipoDoGasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 610, 230, 40));

        jLabel4_tipoDoGasto.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4_tipoDoGasto.setFont(new java.awt.Font("Bodoni MT", 3, 25)); // NOI18N
        jLabel4_tipoDoGasto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "TIPO DO GASTO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 22), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel4_tipoDoGasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 330, 100));

        jButton_Alterar.setBackground(new java.awt.Color(102, 102, 102));
        jButton_Alterar.setFont(new java.awt.Font("Bodoni MT", 3, 22)); // NOI18N
        jButton_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/CHANGE.png"))); // NOI18N
        jButton_Alterar.setText("ALTERAR");
        jButton_Alterar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_Alterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 560, 180, 50));

        jButton_Remover.setBackground(new java.awt.Color(102, 102, 102));
        jButton_Remover.setFont(new java.awt.Font("Bodoni MT", 3, 22)); // NOI18N
        jButton_Remover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/removeriten.png"))); // NOI18N
        jButton_Remover.setText("REMOVER");
        jButton_Remover.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_Remover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RemoverActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Remover, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 620, 180, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/FundoTelas.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(jTextField1_idAlterar_Deletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 710, -1, -1));

        jLabel58.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "TIPO DO GASTO", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 26), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 380, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1_gastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_gastosMouseClicked
        if (jComboBox1_tipoDoGasto.getSelectedIndex() == 0) {
            jTextField1_PlacaSelecionada.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 2).toString());
            jTextField1_TipoDoGasto.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 1).toString());
            jTextField1_idAlterar_Deletar.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 0).toString());

            jTextField1_LitrosColocados.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 4).toString());
            jTextField1_precoLitro.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 5).toString());
            jTextField1_kmsPercorridosLItro.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 6).toString());
            jComboBox1_veiculos.setSelectedItem(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 2).toString());

            jTextField1_PlacaSelecionada.setVisible(true);
            jLabel4_PLACASELECIONADA.setVisible(true);
            jTextField1_TipoDoGasto.setVisible(true);
            jLabel4_tipoDoGasto.setVisible(true);
            jButton_Alterar.setVisible(true);
            jButton_Remover.setVisible(true);
        } else if (jComboBox1_tipoDoGasto.getSelectedIndex() == 1) {
            jTextField1_PlacaSelecionada.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 2).toString());
            jTextField1_TipoDoGasto.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 1).toString());
            jTextField1_idAlterar_Deletar.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 0).toString());

            jComboBox1_veiculos.setSelectedItem(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 2).toString());
            jTextField1_descricaoServico2.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 3).toString());
            jTextField1_item_manutencao.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 4).toString());
            jTextField3_qntDeItens.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 5).toString());
            jTextField1_ValorDoItem.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 6).toString());
            jTextField2_valorMaoDeObra.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 7).toString());
            
            
            jTextField1_PlacaSelecionada.setVisible(true);
            jLabel4_PLACASELECIONADA.setVisible(true);
            jTextField1_TipoDoGasto.setVisible(true);
            jLabel4_tipoDoGasto.setVisible(true);
            jButton_Alterar.setVisible(true);
            jButton_Remover.setVisible(true);
        } else if (jComboBox1_tipoDoGasto.getSelectedIndex() == 2) {
            jTextField1_PlacaSelecionada.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 2).toString());
            jTextField1_TipoDoGasto.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 1).toString());
            jTextField1_idAlterar_Deletar.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 0).toString());

            jTextField1_descricaoServico.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 3).toString());
            jTextField1_valorDaFranquia.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 4).toString());
            jComboBox1_veiculos1.setSelectedItem(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 2).toString());

            jTextField1_PlacaSelecionada.setVisible(true);
            jLabel4_PLACASELECIONADA.setVisible(true);
            jTextField1_TipoDoGasto.setVisible(true);
            jLabel4_tipoDoGasto.setVisible(true);
            jButton_Alterar.setVisible(true);
            jButton_Remover.setVisible(true);
        } else if (jComboBox1_tipoDoGasto.getSelectedIndex() == 3) {
            jTextField1_PlacaSelecionada.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 2).toString());
            jTextField1_TipoDoGasto.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 1).toString());
            jTextField1_idAlterar_Deletar.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 0).toString());

            jComboBox1_veiculos2.setSelectedItem(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 2).toString());
            jTextField1_descricaoServico1.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 3).toString());
            jTextField1_TipoDoVeiculo.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 4).toString());
            jTextField1_ValoGastoImposto.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 5).toString());

            jTextField1_PlacaSelecionada.setVisible(true);
            jLabel4_PLACASELECIONADA.setVisible(true);
            jTextField1_TipoDoGasto.setVisible(true);
            jLabel4_tipoDoGasto.setVisible(true);
            jButton_Alterar.setVisible(true);
            jButton_Remover.setVisible(true);

        } else if (jComboBox1_tipoDoGasto.getSelectedIndex() == 4) {
            jTextField1_PlacaSelecionada.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 2).toString());
            jTextField1_TipoDoGasto.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 1).toString());
            jTextField1_idAlterar_Deletar.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 0).toString());

            jTextField1_DescricaoDoGasto.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 3).toString());
            jTextField1_ValorDoGasto.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 4).toString());
            jComboBox1_veiculos3.setSelectedItem(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 2).toString());

            jTextField1_PlacaSelecionada.setVisible(true);
            jLabel4_PLACASELECIONADA.setVisible(true);
            jTextField1_TipoDoGasto.setVisible(true);
            jLabel4_tipoDoGasto.setVisible(true);
            jButton_Alterar.setVisible(true);
            jButton_Remover.setVisible(true);
        } else if (jComboBox1_tipoDoGasto.getSelectedIndex() == 5) {
            jTextField1_PlacaSelecionada.setVisible(false);
            jLabel4_PLACASELECIONADA.setVisible(false);
            jTextField1_TipoDoGasto.setVisible(false);
            jLabel4_tipoDoGasto.setVisible(false);
            jButton_Alterar.setVisible(false);
            jButton_Remover.setVisible(false);
        }
    }//GEN-LAST:event_jTable1_gastosMouseClicked

    private void jButton4_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_voltarActionPerformed
        // TODO add your handling code here:
        TelaPrincipal principal = new TelaPrincipal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4_voltarActionPerformed

    private void jComboBox1_itemRelacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1_itemRelacaoActionPerformed
        if (jComboBox1_itemRelacao.getSelectedIndex() == 0) {
            jScrollPane1.setVisible(true);
            jComboBox1_tipoDoGasto.setSelectedIndex(0);
            jLabelFiltro.setVisible(true);
            jComboBox1_tipoDoGasto.setVisible(true);
            jComboBox1_tipoDoGastoGraficos.setSelectedIndex(0);

            jPanel1_Combustivel.setVisible(false);
            jPanel1_mecanico.setVisible(false);
            jPanel1_Seguro.setVisible(false);
            jPanel1_Imposto.setVisible(false);
            jPanel1_outrosGastos.setVisible(false);
            jPanel1_gastosGeral.setVisible(false);

            jLabel7_graficos.setVisible(false);
            jComboBox1_tipoDoGastoGraficos.setVisible(false);
        } else if (jComboBox1_itemRelacao.getSelectedIndex() == 1) {
            try {
                jLabel7_graficos.setVisible(true);
                jComboBox1_tipoDoGastoGraficos.setVisible(true);
                jScrollPane1.setVisible(false);
                jComboBox1_tipoDoGasto.setSelectedIndex(0);
                jComboBox1_tipoDoGasto.setVisible(false);
                jComboBox_Filtro.setEnabled(true);
                jComboBox_Filtro.addItem("POR ANO");
                jComboBox_Filtro.addItem("POR MES");
                jComboBox_Filtro.addItem("POR DIA");
                jPanel1_Combustivel.setVisible(true);

                jLabel4_tipoDoGasto.setVisible(false);
                jTextField1_TipoDoGasto.setVisible(false);
                jTextField1_PlacaSelecionada.setVisible(false);
                jTextField1_PlacaSelecionada.setVisible(false);
                jLabel4_PLACASELECIONADA.setVisible(false);
                jButton_Alterar.setVisible(false);
                jButton_Remover.setVisible(false);

            } catch (Exception ex) {
                Logger.getLogger(TelaRelacaoGastos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox1_itemRelacaoActionPerformed

    public void criarGraficos() {
        try {
            DefaultCategoryDataset barra = new DefaultCategoryDataset();
            IGastosDao objetoDao = new GastosDao();

            ArrayList<Gastos> listaDeGastos = objetoDao.listaDeGastos();

            for (int i = 0; i < listaDeGastos.size(); i++) {
                if (listaDeGastos.get(i).getIdentificadorGasto() == ClassificacaoGastos.COMBUSTIVEL) {

                    gastosGraficoCombustivel += listaDeGastos.get(i).getGastoTotal();
                    barra.setValue(gastosGraficoCombustivel, "COMBUSTIVEL", "");
                    System.out.println(listaDeGastos.get(i).getGastoTotal());
                }
            }
            JFreeChart grafico1 = ChartFactory.createBarChart3D("GASTOS COM COMBUSTIVEL", "DATA", "TOTAL GASTO", barra, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot plot1 = grafico1.getCategoryPlot();
            BarRenderer renderer1 = (BarRenderer) plot1.getRenderer();
            Color barColor1 = new Color(0, 0, 153);
            renderer1.setSeriesPaint(0, barColor1);
            ChartPanel painel = new ChartPanel(grafico1);

            jPanel1_Combustivel.add(painel);

            DefaultCategoryDataset barra2 = new DefaultCategoryDataset();

            ArrayList<Gastos> listaDeGastos2 = objetoDao.listaDeGastos();

            for (int i = 0; i < listaDeGastos2.size(); i++) {
                if (listaDeGastos2.get(i).getIdentificadorGasto() == ClassificacaoGastos.SEGURO) {

                    gastosSeguro += listaDeGastos2.get(i).getGastoTotal();
                    barra2.setValue(gastosSeguro, "SEGURO", "");
                }
            }
            JFreeChart grafico2 = ChartFactory.createBarChart3D("GASTOS COM SEGURO", "DATA", "TOTAL GASTO", barra2, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot plot2 = grafico2.getCategoryPlot();
            BarRenderer renderer2 = (BarRenderer) plot2.getRenderer();
            Color barColor2 = new Color(153, 153, 153);
            renderer2.setSeriesPaint(0, barColor2);

            ChartPanel painel2 = new ChartPanel(grafico2);
            jPanel1_Seguro.add(painel2);

            DefaultCategoryDataset barra3 = new DefaultCategoryDataset();
            ArrayList<Gastos> listaDeGastos3 = objetoDao.listaDeGastos();
            for (int i = 0; i < listaDeGastos3.size(); i++) {
                if (listaDeGastos3.get(i).getIdentificadorGasto() == ClassificacaoGastos.IMPOSTO) {

                    gastosImposto += listaDeGastos3.get(i).getGastoTotal();
                    barra3.setValue(gastosImposto, "IMPOSTO", "");
                }
            }
            JFreeChart grafico3 = ChartFactory.createBarChart3D("GASTOS COM IMPOSTO", "DATA", "TOTAL GASTO", barra3, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot plot3 = grafico3.getCategoryPlot();
            BarRenderer renderer3 = (BarRenderer) plot3.getRenderer();
            Color barColor3 = new Color(0, 0, 0);
            renderer3.setSeriesPaint(0, barColor3);

            ChartPanel painel3 = new ChartPanel(grafico3);
            jPanel1_Imposto.add(painel3);
            //
            DefaultCategoryDataset barra4 = new DefaultCategoryDataset();
            ArrayList<Gastos> listaDeGastos4 = objetoDao.listaDeGastos();

            for (int i = 0; i < listaDeGastos4.size(); i++) {
                if (listaDeGastos4.get(i).getIdentificadorGasto() == ClassificacaoGastos.OUTROS) {

                    outrosGastos += listaDeGastos4.get(i).getGastoTotal();
                    barra4.setValue(outrosGastos, "OUTROS GASTOS", "");
                }
            }
            JFreeChart grafico4 = ChartFactory.createBarChart3D("OUTROS GASTOS", "DATA", "TOTAL GASTO", barra4, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot plot4 = grafico4.getCategoryPlot();
            BarRenderer renderer4 = (BarRenderer) plot4.getRenderer();
            Color barColor4 = new Color(255, 255, 0);
            renderer4.setSeriesPaint(0, barColor4);

            ChartPanel painel4 = new ChartPanel(grafico4);
            jPanel1_outrosGastos.add(painel4);
            //

            DefaultCategoryDataset barraa = new DefaultCategoryDataset();
            ArrayList<Gastos> listaDeGastoss = objetoDao.listaDeGastos();

            for (int i = 0; i < listaDeGastoss.size(); i++) {
                if (listaDeGastoss.get(i).getIdentificadorGasto() == ClassificacaoGastos.MECANICO) {

                    gastosMecanico += listaDeGastoss.get(i).getGastoTotal();
                    barraa.setValue(gastosMecanico, "MECÂNICO", "");
                }
            }
            JFreeChart graficos = ChartFactory.createBarChart3D("GASTOS COM MECÂNICO", "DATA", "TOTAL GASTO", barraa, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot plot = graficos.getCategoryPlot();
            BarRenderer renderer = (BarRenderer) plot.getRenderer();
            Color barColor = new Color(0, 128, 0);
            renderer.setSeriesPaint(0, barColor);

            ChartPanel painell = new ChartPanel(graficos);
            jPanel1_mecanico.add(painell);

            //
        } catch (Exception e) {

        }
    }

    public void criarGraficoGERAL() {
        try {
            gastosGraficoCombustivel = 0;
            gastosMecanico = 0;
            gastosImposto = 0;
            outrosGastos = 0;
            gastosSeguro = 0;

            DefaultCategoryDataset barra5 = new DefaultCategoryDataset();
            IGastosDao objetoDao = new GastosDao();
            ArrayList<Gastos> listaDeGastos5 = objetoDao.listaDeGastos();

            for (int i = 0; i < listaDeGastos5.size(); i++) {
                if (listaDeGastos5.get(i).getIdentificadorGasto() == ClassificacaoGastos.COMBUSTIVEL) {

                    gastosGraficoCombustivel += listaDeGastos5.get(i).getGastoTotal();
                    barra5.setValue(gastosGraficoCombustivel, "COMBUSTIVEL", "");
                }
                if (listaDeGastos5.get(i).getIdentificadorGasto() == ClassificacaoGastos.MECANICO) {
                    gastosMecanico += listaDeGastos5.get(i).getGastoTotal();
                    barra5.setValue(gastosMecanico, "MECANICO", "");
                }
                if (listaDeGastos5.get(i).getIdentificadorGasto() == ClassificacaoGastos.IMPOSTO) {
                    gastosImposto += listaDeGastos5.get(i).getGastoTotal();
                    barra5.setValue(gastosImposto, "IMPOSTO", "");
                }
                if (listaDeGastos5.get(i).getIdentificadorGasto() == ClassificacaoGastos.OUTROS) {

                    outrosGastos += listaDeGastos5.get(i).getGastoTotal();
                    barra5.setValue(outrosGastos, "OUTROS", "");
                }
                if (listaDeGastos5.get(i).getIdentificadorGasto() == ClassificacaoGastos.SEGURO) {
                    gastosSeguro += listaDeGastos5.get(i).getGastoTotal();
                    barra5.setValue(gastosSeguro, "SEGURO", "");
                }

            }

            JFreeChart grafico = ChartFactory.createBarChart3D("SOMA DE TODOS OS GASTOS POR TIPO", "TIPOS DE GASTOS", "TOTAL GASTOS", barra5, PlotOrientation.VERTICAL, true, true, false);
            ChartPanel painel5 = new ChartPanel(grafico);
            jPanel1_gastosGeral.add(painel5);
        } catch (Exception ex) {
            Logger.getLogger(TelaRelacaoGastos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void criarGraficoCombustivel(){
        try{
            
            DefaultCategoryDataset barra = new DefaultCategoryDataset();
            IGastosDao objetoDao = new GastosDao();
            int cont = 0;
            ArrayList<Gastos> listaDeGastos = objetoDao.listaDeGastos();
            String[] meses = {"janeiro", "fevereiro", "março", "abril", "maio" ,"junho", "julho" ,"agosto" ,"setembro" ,"outubro", "novembro" ,"dezembro"};
            if(jComboBox_Filtro.getSelectedIndex() == 0){
                jPanel1_Combustivel.removeAll();
                for (int i = 0; i < listaDeGastos.size(); i++) {
                if (listaDeGastos.get(i).getIdentificadorGasto() == ClassificacaoGastos.COMBUSTIVEL) {
                   String[] data = listaDeGastos.get(i).getDataGasto().toString().split("-");

                        
                           if(data[1].equals("01")){
                                barra.setValue(listaDeGastos.get(i).getGastoTotal(), meses[0], "");
                           }
                           if(data[1].equals("02")){
                                System.out.println("Entrou no fevereiro");
                                System.out.println(listaDeGastos.get(i).getGastoTotal());
                                barra.setValue(listaDeGastos.get(i).getGastoTotal(), "Fevereiro", "");
                           }
                       
                }
            }
                        
                
            }if(jComboBox_Filtro.getSelectedIndex() == 1){
                jPanel1_Combustivel.removeAll();
                barra.setValue(listaDeGastos.get(0).getGastoTotal(), "Cu", "");
                           
                       }
        JFreeChart grafico1 = ChartFactory.createBarChart3D("GASTOS COM COMBUSTIVEL", "DATA", "TOTAL GASTO", barra, PlotOrientation.VERTICAL, true, true, false);
                    ChartPanel painel = new ChartPanel(grafico1); 
                    jPanel1_Combustivel.add(painel);
            
            
    }catch(Exception e){
            System.out.println(e);
    }
    }

    private void jComboBox1_tipoDoGastoGraficosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1_tipoDoGastoGraficosActionPerformed
        if (jComboBox1_tipoDoGastoGraficos.getSelectedIndex() == 0) {
            jPanel1_mecanico.setVisible(false);
            jPanel1_Seguro.setVisible(false);
            jPanel1_Imposto.setVisible(false);
            jPanel1_Combustivel.setVisible(true);
        } else if (jComboBox1_tipoDoGastoGraficos.getSelectedIndex() == 1) {
            jPanel1_Combustivel.setVisible(false);
            jPanel1_Seguro.setVisible(false);
            jPanel1_Imposto.setVisible(false);
            jPanel1_mecanico.setVisible(true);
        } else if (jComboBox1_tipoDoGastoGraficos.getSelectedIndex() == 2) {
            jPanel1_Combustivel.setVisible(false);
            jPanel1_mecanico.setVisible(false);
            jPanel1_Imposto.setVisible(false);

            jPanel1_Seguro.setVisible(true);
        } else if (jComboBox1_tipoDoGastoGraficos.getSelectedIndex() == 3) {
            jPanel1_mecanico.setVisible(false);
            jPanel1_Seguro.setVisible(false);
            jPanel1_Combustivel.setVisible(false);

            jPanel1_Imposto.setVisible(true);
        } else if (jComboBox1_tipoDoGastoGraficos.getSelectedIndex() == 4) {
            jPanel1_mecanico.setVisible(false);
            jPanel1_Seguro.setVisible(false);
            jPanel1_Combustivel.setVisible(false);
            jPanel1_gastosGeral.setVisible(false);
            jPanel1_Imposto.setVisible(false);

            jPanel1_outrosGastos.setVisible(true);
        } else if (jComboBox1_tipoDoGastoGraficos.getSelectedIndex() == 5) {
            jPanel1_outrosGastos.setVisible(false);
            jPanel1_mecanico.setVisible(false);
            jPanel1_Seguro.setVisible(false);
            jPanel1_Combustivel.setVisible(false);
            jPanel1_Imposto.setVisible(false);

            jPanel1_gastosGeral.setVisible(true);
        }
    }//GEN-LAST:event_jComboBox1_tipoDoGastoGraficosActionPerformed

    private void jComboBox1_tipoDoGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1_tipoDoGastoActionPerformed
        if (jComboBox1_tipoDoGasto.getSelectedIndex() == 5) {
            jTextField1_PlacaSelecionada.setVisible(false);
            jLabel4_PLACASELECIONADA.setVisible(false);
            jTextField1_TipoDoGasto.setVisible(false);
            jLabel4_tipoDoGasto.setVisible(false);
            jButton_Alterar.setVisible(false);
            jButton_Remover.setVisible(false);
        }
    }//GEN-LAST:event_jComboBox1_tipoDoGastoActionPerformed

    private void jButton_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AlterarActionPerformed
        if (jTextField1_TipoDoGasto.getText().equals("COMBUSTIVEL")) {
            jFrame1_gasolinaAlterar.setVisible(true);
        } else if (jTextField1_TipoDoGasto.getText().equals("SEGURO")) {
            jFrame1_seguroAlterar.setVisible(true);
        } else if (jTextField1_TipoDoGasto.getText().equals("IMPOSTO")) {
            jFrame1_alterarImposto.setVisible(true);
        } else if (jTextField1_TipoDoGasto.getText().equals("OUTROS")) {
            jFrame1_alterarOutros.setVisible(true);
        } else if (jTextField1_TipoDoGasto.getText().equals("MECANICO")) {
            jFrame1_alterarMecanico.setVisible(true);
        }
    }//GEN-LAST:event_jButton_AlterarActionPerformed

    private void jButton_RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RemoverActionPerformed
        try {

            imprimirDadosNaGrid();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton_RemoverActionPerformed

    private void jButton4_voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_voltar1ActionPerformed

        jFrame1_gasolinaAlterar.dispose();

    }//GEN-LAST:event_jButton4_voltar1ActionPerformed

    private void jComboBox1_tipoDeCombustivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1_tipoDeCombustivelActionPerformed
        if (jComboBox1_tipoDeCombustivel.getSelectedIndex() == 0) {
            tipoCombustivel = TiposCombustiveisGastos.Gasolina + "";
        }
        if (jComboBox1_tipoDeCombustivel.getSelectedIndex() == 1) {
            tipoCombustivel = TiposCombustiveisGastos.Gasolina_Aditivada + "";
        }
        if (jComboBox1_tipoDeCombustivel.getSelectedIndex() == 2) {
            tipoCombustivel = TiposCombustiveisGastos.Gasolina_Premium + "";
        }
        if (jComboBox1_tipoDeCombustivel.getSelectedIndex() == 3) {
            tipoCombustivel = TiposCombustiveisGastos.Etanol + "";
        }
        if (jComboBox1_tipoDeCombustivel.getSelectedIndex() == 4) {
            tipoCombustivel = TiposCombustiveisGastos.Etanol_aditivado + "";
        }
        if (jComboBox1_tipoDeCombustivel.getSelectedIndex() == 5) {
            tipoCombustivel = TiposCombustiveisGastos.GNV + "";
        }
        if (jComboBox1_tipoDeCombustivel.getSelectedIndex() == 6) {
            tipoCombustivel = TiposCombustiveisGastos.Diesel + "";
        }

        System.out.println(tipoCombustivel);
    }//GEN-LAST:event_jComboBox1_tipoDeCombustivelActionPerformed

    private void jFormattedTextField1_dataAbastecimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1_dataAbastecimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1_dataAbastecimentoActionPerformed

    private void jButton_iNCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_iNCLUIRActionPerformed
        try {

            if (jComboBox1_tipoDeCombustivel.getSelectedIndex() == 0) {
                tipoCombustivel = TiposCombustiveisGastos.Gasolina + "";
            }
            if (jComboBox1_tipoDeCombustivel.getSelectedIndex() == 1) {
                tipoCombustivel = TiposCombustiveisGastos.Gasolina_Aditivada + "";
            }
            if (jComboBox1_tipoDeCombustivel.getSelectedIndex() == 2) {
                tipoCombustivel = TiposCombustiveisGastos.Gasolina_Premium + "";
            }
            if (jComboBox1_tipoDeCombustivel.getSelectedIndex() == 3) {
                tipoCombustivel = TiposCombustiveisGastos.Etanol + "";
            }
            if (jComboBox1_tipoDeCombustivel.getSelectedIndex() == 4) {
                tipoCombustivel = TiposCombustiveisGastos.Etanol_aditivado + "";
            }
            if (jComboBox1_tipoDeCombustivel.getSelectedIndex() == 5) {
                tipoCombustivel = TiposCombustiveisGastos.GNV + "";
            }
            if (jComboBox1_tipoDeCombustivel.getSelectedIndex() == 6) {
                tipoCombustivel = TiposCombustiveisGastos.Diesel + "";
            }

            VeiculosDAO veiculos = new VeiculosDAO();

            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date data = null;
            data = new java.sql.Date(formatter.parse(jFormattedTextField1_dataAbastecimento.getText()).getTime());

            IGastosCombustivelDao comb = new GastosCombustivelDao();
            GastosCombustivel gastos = new GastosCombustivel(Integer.parseInt(jTextField1_idAlterar_Deletar.getText()),
                    ClassificacaoGastos.COMBUSTIVEL,
                    TiposCombustiveisGastos.valueOf(tipoCombustivel), Float.parseFloat(jTextField1_LitrosColocados.getText()),
                    Float.parseFloat(jTextField1_precoLitro.getText()), Float.parseFloat(jTextField1_kmsPercorridosLItro.getText()), (java.sql.Date) data,
                    veiculos.buscarVeiculos(jComboBox1_veiculos.getSelectedItem().toString()));

            comb.InserirGastos(gastos);

        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, err);
        }
    }//GEN-LAST:event_jButton_iNCLUIRActionPerformed

    private void jComboBox1_veiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1_veiculosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1_veiculosActionPerformed

    private void jFormattedTextField1_dataDoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1_dataDoPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1_dataDoPagamentoActionPerformed

    private void jButton_alterarTelaCombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_alterarTelaCombActionPerformed
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date data = null;
            data = new java.sql.Date(formatter.parse(jFormattedTextField1_dataDoPagamento.getText()).getTime());
            VeiculosDAO veiculo = new VeiculosDAO();
            GastosSeguro seguro = new GastosSeguro(Integer.parseInt(jTextField1_idAlterar_Deletar.getText()), ClassificacaoGastos.SEGURO, jTextField1_descricaoServico.getText(),
                    Float.parseFloat(jTextField1_valorDaFranquia.getText()), data,
                    veiculo.buscarVeiculos(jComboBox1_veiculos.getSelectedItem().toString()));

            IGastosSeguroDao seguroDAO = new GastosSeguroDao();
        } catch (Exception ex) {
            Logger.getLogger(TelaRelacaoGastos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton_alterarTelaCombActionPerformed

    private void jButton4_voltar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_voltar3ActionPerformed
        jFrame1_seguroAlterar.dispose();
    }//GEN-LAST:event_jButton4_voltar3ActionPerformed

    private void jFormattedTextField1_dataVisitaMecanicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1_dataVisitaMecanicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1_dataVisitaMecanicoActionPerformed

    private void jComboBox1_veiculos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1_veiculos2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1_veiculos2ActionPerformed

    private void jButton_alterarTelaComb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_alterarTelaComb1ActionPerformed
        try {

            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date data = null;
            data = new java.sql.Date(formatter.parse(jFormattedTextField1_dataVisitaMecanico.getText()).getTime());

            VeiculosDAO veiculo = new VeiculosDAO();
            GastosImpostosDao impostoDAO = new GastosImpostosDao();
            GastosImposto imposto = new GastosImposto(0, ClassificacaoGastos.IMPOSTO, jTextField1_descricaoServico.getText(),
                    jTextField1_TipoDoVeiculo.getText(), Float.parseFloat(jTextField1_ValoGastoImposto.getText()), data,
                    veiculo.buscarVeiculos(jComboBox1_veiculos.getSelectedItem().toString()));

            impostoDAO.InserirGastos(imposto);

        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, err);
        }
    }//GEN-LAST:event_jButton_alterarTelaComb1ActionPerformed

    private void jButton4_voltar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_voltar4ActionPerformed
        jFrame1_alterarImposto.dispose();
    }//GEN-LAST:event_jButton4_voltar4ActionPerformed

    private void jFormattedTextField1_dataDoGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1_dataDoGastoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1_dataDoGastoActionPerformed

    private void jButton4_voltar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_voltar5ActionPerformed
        jFrame1_alterarOutros.setVisible(false);
    }//GEN-LAST:event_jButton4_voltar5ActionPerformed

    private void jButton_alterarTelaComb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_alterarTelaComb2ActionPerformed

        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date data = null;
            data = new java.sql.Date(formatter.parse(jFormattedTextField1_dataDoGasto.getText()).getTime());

            VeiculosDAO veiculo = new VeiculosDAO();

            GastosAvulsos avulsos = new GastosAvulsos(Integer.parseInt(jTextField1_idAlterar_Deletar.getText()), ClassificacaoGastos.OUTROS, jTextField1_DescricaoDoGasto.getText(),
                    Float.parseFloat(jTextField1_ValorDoGasto.getText()), data,
                    veiculo.buscarVeiculos(jComboBox1_veiculos.getSelectedItem().toString()));

            IGastosAvulsosDao avulsosDAO = new GastosAvulsosDao();
            avulsosDAO.InserirGastos(avulsos);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, err);
        }

    }//GEN-LAST:event_jButton_alterarTelaComb2ActionPerformed

    private void jFormattedTextField1_dataVisitaMecanico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1_dataVisitaMecanico1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1_dataVisitaMecanico1ActionPerformed

    private void jComboBox1_veiculos4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1_veiculos4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1_veiculos4ActionPerformed

    private void jButton4_voltar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_voltar6ActionPerformed
        jFrame1_alterarMecanico.dispose();
    }//GEN-LAST:event_jButton4_voltar6ActionPerformed

    private void jButton_alterarTelaComb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_alterarTelaComb3ActionPerformed
        try {

            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date data = null;
            data = new java.sql.Date(formatter.parse(jFormattedTextField1_dataVisitaMecanico.getText()).getTime());

            if (jTextField1_ValorDoItem.getText().matches("")) {
                jTextField1_ValorDoItem.setText("0");
            }
            if (jTextField1_item_manutencao.getText().matches("")) {
                jTextField1_item_manutencao.setText("N/A");
            }
            if (jTextField2_valorMaoDeObra.getText().matches("")) {
                jTextField2_valorMaoDeObra.setText("0");
            }
            if (jTextField3_qntDeItens.getText().matches("")) {
                jTextField3_qntDeItens.setText("0");
            }

            VeiculosDAO veiculos = new VeiculosDAO();
            IGastosMecanicoDao mecanic = new GastosMecanicoDao();
            GastosMecanico mecanico = new GastosMecanico(Integer.parseInt(jTextField1_idAlterar_Deletar.getText()), ClassificacaoGastos.MECANICO,
                    jTextField1_descricaoServico.getText(), jTextField1_item_manutencao.getText(),
                    Integer.parseInt(jTextField3_qntDeItens.getText()), Float.parseFloat(jTextField1_ValorDoItem.getText()),
                    Float.parseFloat(jTextField2_valorMaoDeObra.getText()), data,
                    veiculos.buscarVeiculos(jComboBox1_veiculos.getSelectedItem().toString()));

            mecanic.InserirGastos(mecanico);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, err);
        }


    }//GEN-LAST:event_jButton_alterarTelaComb3ActionPerformed

    private void jComboBox_FiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_FiltroActionPerformed
      criarGraficoCombustivel();
            
    }//GEN-LAST:event_jComboBox_FiltroActionPerformed

    private void jComboBox_FiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_FiltroItemStateChanged
    }//GEN-LAST:event_jComboBox_FiltroItemStateChanged

    private void jComboBox_FiltroPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox_FiltroPropertyChange
    
    }//GEN-LAST:event_jComboBox_FiltroPropertyChange

    private void imprimirDadosNaGrid() {

        try {

            DefaultTableModel model = (DefaultTableModel) jTable1_gastos.getModel();
            JTableRenderer JtableRenderer = new JTableRenderer();
            conexao = ConexaoBD.getConexao();
            Statement statement = conexao.createStatement();
            String query = "select gastos_combustivel.id as identificador, tipogasto as \"Tipo do gasto\", veiculos.placa as Veiculo, descgasto as \"Tipo de Combustivel\" ,\n"
                    + "                    qtdlcomb as \"Litros colocados\", valorlitrocomb as \"Preço do Litro\", kmplcarro as \"KM/s por litro\",\n"
                    + "                    dataabast as \"Data Abastecimento\" from gastos_combustivel inner join veiculos on gastos_combustivel.id_veiculo = veiculos.id";
            ResultSet resultSet = statement.executeQuery(query);

            DefaultTableModel tableModel = new DefaultTableModel();
            jTable1_gastos.setModel(tableModel);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(row);
            }
            jTable1_gastos.getColumnModel().getColumn(0).setWidth(0);
            jTable1_gastos.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1_gastos.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1_gastos.getColumnModel().getColumn(2).setWidth(140);
            jTable1_gastos.getColumnModel().getColumn(2).setMinWidth(140);
            jTable1_gastos.getColumnModel().getColumn(2).setMaxWidth(140);
            jTable1_gastos.getColumnModel().getColumn(7).setWidth(175);
            jTable1_gastos.getColumnModel().getColumn(7).setMinWidth(175);
            jTable1_gastos.getColumnModel().getColumn(7).setMaxWidth(175);
            jTable1_gastos.getColumnModel().getColumn(4).setWidth(105);
            jTable1_gastos.getColumnModel().getColumn(4).setMinWidth(105);
            jTable1_gastos.getColumnModel().getColumn(4).setMaxWidth(105);
            jTable1_gastos.getColumnModel().getColumn(5).setWidth(100);
            jTable1_gastos.getColumnModel().getColumn(5).setMinWidth(100);
            jTable1_gastos.getColumnModel().getColumn(5).setMaxWidth(100);
            jTable1_gastos.getColumnModel().getColumn(6).setWidth(100);
            jTable1_gastos.getColumnModel().getColumn(6).setMinWidth(100);
            jTable1_gastos.getColumnModel().getColumn(6).setMaxWidth(100);

            resultSet.close();
            statement.close();

            jComboBox1_tipoDoGasto.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            if (jComboBox1_tipoDoGasto.getSelectedIndex() == 0) {
                                DefaultTableModel model = (DefaultTableModel) jTable1_gastos.getModel();
                                JTableRenderer JtableRenderer = new JTableRenderer();
                                conexao = ConexaoBD.getConexao();
                                Statement statement = conexao.createStatement();
                                String query = "select gastos_combustivel.id as identificador, tipogasto as \"Tipo do gasto\", veiculos.placa as Veiculo, descgasto as \"Tipo de Combustivel\" ,\n"
                                        + "                    qtdlcomb as \"Litros colocados\", valorlitrocomb as \"Preço do Litro\", kmplcarro as \"KM/s por litro\",\n"
                                        + "                    dataabast as \"Data Abastecimento\" from gastos_combustivel inner join veiculos on gastos_combustivel.id_veiculo = veiculos.id";
                                ResultSet resultSet = statement.executeQuery(query);

                                DefaultTableModel tableModel = new DefaultTableModel();
                                jTable1_gastos.setModel(tableModel);

                                ResultSetMetaData metaData = resultSet.getMetaData();
                                int columnCount = metaData.getColumnCount();

                                for (int i = 1; i <= columnCount; i++) {
                                    tableModel.addColumn(metaData.getColumnName(i));
                                }

                                while (resultSet.next()) {
                                    Object[] row = new Object[columnCount];
                                    for (int i = 1; i <= columnCount; i++) {
                                        row[i - 1] = resultSet.getObject(i);
                                    }
                                    tableModel.addRow(row);
                                }
                                jTable1_gastos.getColumnModel().getColumn(0).setWidth(0);
                                jTable1_gastos.getColumnModel().getColumn(0).setMinWidth(0);
                                jTable1_gastos.getColumnModel().getColumn(0).setMaxWidth(0);
                                jTable1_gastos.getColumnModel().getColumn(2).setWidth(140);
                                jTable1_gastos.getColumnModel().getColumn(2).setMinWidth(140);
                                jTable1_gastos.getColumnModel().getColumn(2).setMaxWidth(140);
                                jTable1_gastos.getColumnModel().getColumn(7).setWidth(175);
                                jTable1_gastos.getColumnModel().getColumn(7).setMinWidth(175);
                                jTable1_gastos.getColumnModel().getColumn(7).setMaxWidth(175);
                                jTable1_gastos.getColumnModel().getColumn(4).setWidth(105);
                                jTable1_gastos.getColumnModel().getColumn(4).setMinWidth(105);
                                jTable1_gastos.getColumnModel().getColumn(4).setMaxWidth(105);
                                jTable1_gastos.getColumnModel().getColumn(5).setWidth(100);
                                jTable1_gastos.getColumnModel().getColumn(5).setMinWidth(100);
                                jTable1_gastos.getColumnModel().getColumn(5).setMaxWidth(100);
                                jTable1_gastos.getColumnModel().getColumn(6).setWidth(100);
                                jTable1_gastos.getColumnModel().getColumn(6).setMinWidth(100);
                                jTable1_gastos.getColumnModel().getColumn(6).setMaxWidth(100);
                                resultSet.close();
                                statement.close();
                            }
                            if (jComboBox1_tipoDoGasto.getSelectedIndex() == 1) {
                                DefaultTableModel model = (DefaultTableModel) jTable1_gastos.getModel();
                                JTableRenderer JtableRenderer = new JTableRenderer();
                                conexao = ConexaoBD.getConexao();
                                Statement statement = conexao.createStatement();
                                String query = "select gastos_mecanico.id as Identificador, gastos_mecanico.tipogasto as \"Tipo do Gasto\",\n"
                                        + "veiculos.placa as Veiculo, gastos_mecanico.descgasto as Descrição, descitemman as \"Item/Serviço\",\n"
                                        + "qtditemman as \"Qnt Item\", valoritemman as \"Valor do Item\", valormaoobra as \"Valor mão de obra\",\n"
                                        + "datamanutencao as \"Data do gasto\" from gastos_mecanico inner join veiculos on \n"
                                        + "gastos_mecanico.id_veiculo = veiculos.id";

                                ResultSet resultSet = statement.executeQuery(query);

                                DefaultTableModel tableModel = new DefaultTableModel();
                                jTable1_gastos.setModel(tableModel);

                                ResultSetMetaData metaData = resultSet.getMetaData();
                                int columnCount = metaData.getColumnCount();

                                for (int i = 1; i <= columnCount; i++) {
                                    tableModel.addColumn(metaData.getColumnName(i));
                                }

                                while (resultSet.next()) {
                                    Object[] row = new Object[columnCount];
                                    for (int i = 1; i <= columnCount; i++) {
                                        row[i - 1] = resultSet.getObject(i);
                                    }
                                    tableModel.addRow(row);
                                }
                                jTable1_gastos.getColumnModel().getColumn(0).setWidth(0);
                                jTable1_gastos.getColumnModel().getColumn(0).setMinWidth(0);
                                jTable1_gastos.getColumnModel().getColumn(0).setMaxWidth(0);
                                jTable1_gastos.getColumnModel().getColumn(5).setWidth(90);
                                jTable1_gastos.getColumnModel().getColumn(5).setMinWidth(90);
                                jTable1_gastos.getColumnModel().getColumn(5).setMaxWidth(90);
                                jTable1_gastos.getColumnModel().getColumn(8).setWidth(175);
                                jTable1_gastos.getColumnModel().getColumn(8).setMinWidth(175);
                                jTable1_gastos.getColumnModel().getColumn(8).setMaxWidth(175);
                                jTable1_gastos.getColumnModel().getColumn(7).setWidth(100);
                                jTable1_gastos.getColumnModel().getColumn(7).setMinWidth(100);
                                jTable1_gastos.getColumnModel().getColumn(7).setMaxWidth(100);
                                jTable1_gastos.getColumnModel().getColumn(2).setWidth(140);
                                jTable1_gastos.getColumnModel().getColumn(2).setMinWidth(140);
                                jTable1_gastos.getColumnModel().getColumn(2).setMaxWidth(140);
                                resultSet.close();
                                statement.close();

                            } else if (jComboBox1_tipoDoGasto.getSelectedIndex() == 2) {

                                DefaultTableModel model = (DefaultTableModel) jTable1_gastos.getModel();
                                JTableRenderer JtableRenderer = new JTableRenderer();
                                conexao = ConexaoBD.getConexao();
                                Statement statement = conexao.createStatement();
                                String query = "select gastos_seguro.id as Identificador, gastos_seguro.tipogasto as \"Tipo do Gasto\",\n"
                                        + "veiculos.placa as Veículo,\n"
                                        + "descgasto as Descrição, valorfranquia as \"Valor da Franquia\", datapagamento as \"Data do Pagamento\"\n"
                                        + "from gastos_seguro inner join veiculos on gastos_seguro.id_veiculo = veiculos.id";
                                ResultSet resultSet = statement.executeQuery(query);

                                DefaultTableModel tableModel = new DefaultTableModel();
                                jTable1_gastos.setModel(tableModel);

                                ResultSetMetaData metaData = resultSet.getMetaData();
                                int columnCount = metaData.getColumnCount();

                                for (int i = 1; i <= columnCount; i++) {
                                    tableModel.addColumn(metaData.getColumnName(i));
                                }

                                while (resultSet.next()) {
                                    Object[] row = new Object[columnCount];
                                    for (int i = 1; i <= columnCount; i++) {
                                        row[i - 1] = resultSet.getObject(i);
                                    }
                                    tableModel.addRow(row);
                                }
                                jTable1_gastos.getColumnModel().getColumn(0).setWidth(0);
                                jTable1_gastos.getColumnModel().getColumn(0).setMinWidth(0);
                                jTable1_gastos.getColumnModel().getColumn(0).setMaxWidth(0);
                                jTable1_gastos.getColumnModel().getColumn(1).setWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(1).setMinWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(1).setMaxWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(2).setWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(2).setMinWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(2).setMaxWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(4).setWidth(165);
                                jTable1_gastos.getColumnModel().getColumn(4).setMinWidth(165);
                                jTable1_gastos.getColumnModel().getColumn(4).setMaxWidth(165);
                                jTable1_gastos.getColumnModel().getColumn(5).setWidth(165);
                                jTable1_gastos.getColumnModel().getColumn(5).setMinWidth(165);
                                jTable1_gastos.getColumnModel().getColumn(5).setMaxWidth(165);
                                resultSet.close();
                                statement.close();

                            } else if (jComboBox1_tipoDoGasto.getSelectedIndex() == 4) {

                                DefaultTableModel model = (DefaultTableModel) jTable1_gastos.getModel();
                                JTableRenderer JtableRenderer = new JTableRenderer();
                                conexao = ConexaoBD.getConexao();
                                Statement statement = conexao.createStatement();
                                String query = "select gastos_avulsos.id as Identificador, gastos_avulsos.tipogasto as \"Tipo Do Gasto\", \n"
                                        + "veiculos.placa as Veículo,\n"
                                        + "gastos_avulsos.descgasto as \"Descrição do gasto\", valorgasto as \"Valor do Gasto\",\n"
                                        + "datarealizacao as \"Data do Pagamento\" from gastos_avulsos inner join veiculos on \n"
                                        + "gastos_avulsos.id_veiculo = veiculos.id";
                                ResultSet resultSet = statement.executeQuery(query);

                                DefaultTableModel tableModel = new DefaultTableModel();
                                jTable1_gastos.setModel(tableModel);

                                ResultSetMetaData metaData = resultSet.getMetaData();
                                int columnCount = metaData.getColumnCount();

                                for (int i = 1; i <= columnCount; i++) {
                                    tableModel.addColumn(metaData.getColumnName(i));
                                }

                                while (resultSet.next()) {
                                    Object[] row = new Object[columnCount];
                                    for (int i = 1; i <= columnCount; i++) {
                                        row[i - 1] = resultSet.getObject(i);
                                    }
                                    tableModel.addRow(row);
                                }
                                jTable1_gastos.getColumnModel().getColumn(0).setWidth(0);
                                jTable1_gastos.getColumnModel().getColumn(0).setMinWidth(0);
                                jTable1_gastos.getColumnModel().getColumn(0).setMaxWidth(0);
                                jTable1_gastos.getColumnModel().getColumn(1).setWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(1).setMinWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(1).setMaxWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(2).setWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(2).setMinWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(2).setMaxWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(4).setWidth(165);
                                jTable1_gastos.getColumnModel().getColumn(4).setMinWidth(165);
                                jTable1_gastos.getColumnModel().getColumn(4).setMaxWidth(165);
                                jTable1_gastos.getColumnModel().getColumn(5).setWidth(165);
                                jTable1_gastos.getColumnModel().getColumn(5).setMinWidth(165);
                                jTable1_gastos.getColumnModel().getColumn(5).setMaxWidth(165);
                                resultSet.close();
                                statement.close();

                            } else if (jComboBox1_tipoDoGasto.getSelectedIndex() == 3) {

                                DefaultTableModel model = (DefaultTableModel) jTable1_gastos.getModel();
                                JTableRenderer JtableRenderer = new JTableRenderer();
                                conexao = ConexaoBD.getConexao();
                                Statement statement = conexao.createStatement();
                                String query = "select gastos_impostos.id as \"Numero pedido\", tipogasto as \"Tipo do gasto\",\n"
                                        + "veiculos.placa as \"Veículo\",\n"
                                        + "descgasto as \"Descrição do gasto\", tipocarro as \"Tipo Veículo\", valorpago as \"Valor Pago\",\n"
                                        + "datapagamento as \"Data do pagamento\"\n"
                                        + "from gastos_impostos inner join veiculos on gastos_impostos.id_veiculo = veiculos.id";
                                ResultSet resultSet = statement.executeQuery(query);

                                DefaultTableModel tableModel = new DefaultTableModel();
                                jTable1_gastos.setModel(tableModel);

                                ResultSetMetaData metaData = resultSet.getMetaData();
                                int columnCount = metaData.getColumnCount();

                                for (int i = 1; i <= columnCount; i++) {
                                    tableModel.addColumn(metaData.getColumnName(i));
                                }

                                while (resultSet.next()) {
                                    Object[] row = new Object[columnCount];
                                    for (int i = 1; i <= columnCount; i++) {
                                        row[i - 1] = resultSet.getObject(i);
                                    }
                                    tableModel.addRow(row);
                                }
                                jTable1_gastos.getColumnModel().getColumn(0).setWidth(0);
                                jTable1_gastos.getColumnModel().getColumn(0).setMinWidth(0);
                                jTable1_gastos.getColumnModel().getColumn(0).setMaxWidth(0);
                                jTable1_gastos.getColumnModel().getColumn(1).setWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(1).setMinWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(1).setMaxWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(2).setWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(2).setMinWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(2).setMaxWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(5).setWidth(165);
                                jTable1_gastos.getColumnModel().getColumn(5).setMinWidth(165);
                                jTable1_gastos.getColumnModel().getColumn(5).setMaxWidth(165);
                                jTable1_gastos.getColumnModel().getColumn(6).setWidth(165);
                                jTable1_gastos.getColumnModel().getColumn(6).setMinWidth(165);
                                jTable1_gastos.getColumnModel().getColumn(6).setMaxWidth(165);
                                resultSet.close();
                                statement.close();

                            } else if (jComboBox1_tipoDoGasto.getSelectedIndex() == 5) {

                                DefaultTableModel model = (DefaultTableModel) jTable1_gastos.getModel();
                                JTableRenderer JtableRenderer = new JTableRenderer();
                                conexao = ConexaoBD.getConexao();
                                Statement statement = conexao.createStatement();
                                String query = "select gastosgeral.id as Identificador, gastosgeral.tipogasto as \"Tipo do Gasto\", \n"
                                        + "veiculos.placa as Veiculo,\n"
                                        + "gastosgeral.descgasto as \"Descrição do gasto\", gastosgeral.valortotal as \"Valor do gasto\",\n"
                                        + "gastosgeral.datagasto as \"Data do gasto\" from gastosgeral inner join veiculos on \n"
                                        + "gastosgeral.id_veiculo = veiculos.id";
                                ResultSet resultSet = statement.executeQuery(query);

                                DefaultTableModel tableModel = new DefaultTableModel();
                                jTable1_gastos.setModel(tableModel);

                                ResultSetMetaData metaData = resultSet.getMetaData();
                                int columnCount = metaData.getColumnCount();

                                for (int i = 1; i <= columnCount; i++) {
                                    tableModel.addColumn(metaData.getColumnName(i));
                                }

                                while (resultSet.next()) {
                                    Object[] row = new Object[columnCount];
                                    for (int i = 1; i <= columnCount; i++) {
                                        row[i - 1] = resultSet.getObject(i);
                                    }
                                    tableModel.addRow(row);
                                }
                                jTable1_gastos.getColumnModel().getColumn(0).setWidth(0);
                                jTable1_gastos.getColumnModel().getColumn(0).setMinWidth(0);
                                jTable1_gastos.getColumnModel().getColumn(0).setMaxWidth(0);
                                jTable1_gastos.getColumnModel().getColumn(1).setWidth(225);
                                jTable1_gastos.getColumnModel().getColumn(1).setMinWidth(225);
                                jTable1_gastos.getColumnModel().getColumn(1).setMaxWidth(225);
                                jTable1_gastos.getColumnModel().getColumn(2).setWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(2).setMinWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(2).setMaxWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(4).setWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(4).setMinWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(4).setMaxWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(5).setWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(5).setMinWidth(150);
                                jTable1_gastos.getColumnModel().getColumn(5).setMaxWidth(150);

                                resultSet.close();
                                statement.close();

                            }
                        } catch (Exception ex) {
                            Logger.getLogger(TelaRelacaoGastos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        } catch (Exception e) {

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRelacaoGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelacaoGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelacaoGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelacaoGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelacaoGastos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4_voltar;
    private javax.swing.JButton jButton4_voltar1;
    private javax.swing.JButton jButton4_voltar3;
    private javax.swing.JButton jButton4_voltar4;
    private javax.swing.JButton jButton4_voltar5;
    private javax.swing.JButton jButton4_voltar6;
    private javax.swing.JButton jButton_Alterar;
    private javax.swing.JButton jButton_Remover;
    private javax.swing.JButton jButton_alterarTelaComb;
    private javax.swing.JButton jButton_alterarTelaComb1;
    private javax.swing.JButton jButton_alterarTelaComb2;
    private javax.swing.JButton jButton_alterarTelaComb3;
    private javax.swing.JButton jButton_iNCLUIR;
    private javax.swing.JComboBox<String> jComboBox1_itemRelacao;
    private javax.swing.JComboBox<TiposCombustiveisGastos> jComboBox1_tipoDeCombustivel;
    private javax.swing.JComboBox<ClassificacaoGastos> jComboBox1_tipoDoGasto;
    private javax.swing.JComboBox<ClassificacaoGastos> jComboBox1_tipoDoGastoGraficos;
    private javax.swing.JComboBox<String> jComboBox1_veiculos;
    private javax.swing.JComboBox<String> jComboBox1_veiculos1;
    private javax.swing.JComboBox<String> jComboBox1_veiculos2;
    private javax.swing.JComboBox<String> jComboBox1_veiculos3;
    private javax.swing.JComboBox<String> jComboBox1_veiculos4;
    private javax.swing.JComboBox<String> jComboBox_Filtro;
    private javax.swing.JFormattedTextField jFormattedTextField1_dataAbastecimento;
    private javax.swing.JFormattedTextField jFormattedTextField1_dataDoGasto;
    private javax.swing.JFormattedTextField jFormattedTextField1_dataDoPagamento;
    private javax.swing.JFormattedTextField jFormattedTextField1_dataVisitaMecanico;
    private javax.swing.JFormattedTextField jFormattedTextField1_dataVisitaMecanico1;
    private javax.swing.JFrame jFrame1_alterarImposto;
    private javax.swing.JFrame jFrame1_alterarMecanico;
    private javax.swing.JFrame jFrame1_alterarOutros;
    private javax.swing.JFrame jFrame1_gasolinaAlterar;
    private javax.swing.JFrame jFrame1_seguroAlterar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel4_PLACASELECIONADA;
    private javax.swing.JLabel jLabel4_tipoDoGasto;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel7_graficos;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFiltro;
    private javax.swing.JPanel jPanel1_Combustivel;
    private javax.swing.JPanel jPanel1_Imposto;
    private javax.swing.JPanel jPanel1_Seguro;
    private javax.swing.JPanel jPanel1_gastosGeral;
    private javax.swing.JPanel jPanel1_mecanico;
    private javax.swing.JPanel jPanel1_outrosGastos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1_gastos;
    private javax.swing.JTextField jTextField1_DescricaoDoGasto;
    private javax.swing.JTextField jTextField1_LitrosColocados;
    private javax.swing.JTextField jTextField1_PlacaSelecionada;
    private javax.swing.JTextField jTextField1_TipoDoGasto;
    private javax.swing.JTextField jTextField1_TipoDoVeiculo;
    private javax.swing.JTextField jTextField1_ValoGastoImposto;
    private javax.swing.JTextField jTextField1_ValorDoGasto;
    private javax.swing.JTextField jTextField1_ValorDoItem;
    private javax.swing.JTextField jTextField1_descricaoServico;
    private javax.swing.JTextField jTextField1_descricaoServico1;
    private javax.swing.JTextField jTextField1_descricaoServico2;
    private javax.swing.JTextField jTextField1_idAlterar_Deletar;
    private javax.swing.JTextField jTextField1_item_manutencao;
    private javax.swing.JTextField jTextField1_kmsPercorridosLItro;
    private javax.swing.JTextField jTextField1_precoLitro;
    private javax.swing.JTextField jTextField1_valorDaFranquia;
    private javax.swing.JTextField jTextField2_valorMaoDeObra;
    private javax.swing.JTextField jTextField3_qntDeItens;
    // End of variables declaration//GEN-END:variables

    private void carregarComboBox() {
        jComboBox1_tipoDoGasto.setModel(new DefaultComboBoxModel<>(ClassificacaoGastos.values()));
        jComboBox1_tipoDoGastoGraficos.setModel(new DefaultComboBoxModel<>(ClassificacaoGastos.values()));
    }

    private void carregarComboBox2() {
        jComboBox1_tipoDeCombustivel.setModel(new DefaultComboBoxModel<>(TiposCombustiveisGastos.values()));

    }

    public void puxarDadosComboBox() throws Exception {

        try {
            VeiculosDAO veic = new VeiculosDAO();
            ResultSet rs = veic.listarVeiculos();

            while (rs.next()) {
                jComboBox1_veiculos.addItem(rs.getString(1));
                jComboBox1_veiculos1.addItem(rs.getString(1));
                jComboBox1_veiculos2.addItem(rs.getString(1));
                jComboBox1_veiculos3.addItem(rs.getString(1));
                jComboBox1_veiculos4.addItem(rs.getString(1));
            }
        } catch (Exception ex) {

        }
    }
}
