package com.car.visao;

import com.car.Enumerations.CategoriaVeiculos;
import com.car.Enumerations.TipoCombustivel;
import com.car.Enumerations.TipoDoVeiculo;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.car.Ferramentas.ConexaoBD;
import com.car.Ferramentas.JTableRenderer;
import com.car.Ferramentas.limitaCaracteres;
import com.car.Modelos.Modelos;
import com.car.Modelos.Veiculos;
import com.car.persistencia.IModelosDAO;
import com.car.persistencia.MarcasDAO;
import com.car.persistencia.ModelosDAO;
import com.car.persistencia.VeiculosDAO;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TelaRelacaoVeiculos extends javax.swing.JFrame {

    private Connection conexao = null;
    PreparedStatement st;

    String categoriaVeiculo;
    String tipoVeiculo;
    String tipoCombustivel;

    public TelaRelacaoVeiculos() {
        initComponents();

        jTextField1_placa.setDocument(new limitaCaracteres(7, limitaCaracteres.tipoEntrada.PLACA));
        
        
        try {
            conexao = ConexaoBD.getConexao();
        } catch (Exception ex) {
            Logger.getLogger(TelaModelos.class.getName()).log(Level.SEVERE, null, ex);
        }

        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        int largura = bounds.width;
        int altura = bounds.height;
        setSize(largura, altura);
        setLocation(0, 0);

        jFrame1_alterar.setBounds(WIDTH, WIDTH, largura, altura);
        jFrame1_alterar.setLocation(0, 0);

        jTextField1_PlacaSelecionada.setVisible(false);
        jLabel4_PLACASELECIONADA.setVisible(false);
        jTextField1_PlacaSelecionada.setEnabled(false);
        imprimirDadosNaGrid();

        categoriaVeiculo = CategoriaVeiculos.HATCH + "";
        tipoVeiculo = TipoDoVeiculo.PASSEIO + "";
        tipoCombustivel = TipoCombustivel.GASOLINA + "";

        try {
            puxarDadosComboBox();
            carregarComboBox();
            puxarMarcasCBBox();
        } catch (Exception e) {

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

        jFrame1_alterar = new javax.swing.JFrame();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10_imagemModelos = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox2_Marca = new javax.swing.JComboBox<>();
        jButton4_voltar1 = new javax.swing.JButton();
        jComboBox2_TipoDoVeiculo = new javax.swing.JComboBox<>();
        jComboBox1_categoriaVeiculo = new javax.swing.JComboBox<>();
        jComboBox2_Modelo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2_TipoCombustivel = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField1_placa = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField1_quilometragem = new javax.swing.JTextField();
        jButton1_ALTERAR = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField1_idVeiculos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_gastos = new javax.swing.JTable();
        jButton4_voltar = new javax.swing.JButton();
        jButton_Alterar = new javax.swing.JButton();
        jButton_Remover = new javax.swing.JButton();
        jTextField1_PlacaSelecionada = new javax.swing.JTextField();
        jLabel4_PLACASELECIONADA = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jFrame1_alterar.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/pinkLogoMenorzinha.gif"))); // NOI18N
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jFrame1_alterar.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Bodoni MT", 3, 36)); // NOI18N
        jLabel5.setText("ALTERAR VEÍCULO");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jFrame1_alterar.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 370, 30));

        jLabel10_imagemModelos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jFrame1_alterar.getContentPane().add(jLabel10_imagemModelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 310, 200));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Bodoni MT", 3, 25)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("IMAGEM DO MODELO");
        jFrame1_alterar.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 300, 30));

        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_alterar.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 400, -1));

        jLabel14.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jLabel14.setText("MARCA");
        jFrame1_alterar.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, 30));

        jComboBox2_Marca.setFont(new java.awt.Font("Bodoni MT", 3, 22)); // NOI18N
        jComboBox2_Marca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jComboBox2_Marca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox2_Marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2_MarcaActionPerformed(evt);
            }
        });
        jFrame1_alterar.getContentPane().add(jComboBox2_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 310, 40));

        jButton4_voltar1.setBackground(new java.awt.Color(102, 102, 102));
        jButton4_voltar1.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jButton4_voltar1.setForeground(new java.awt.Color(255, 0, 153));
        jButton4_voltar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/voltar.png"))); // NOI18N
        jButton4_voltar1.setText("    VOLTAR");
        jButton4_voltar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton4_voltar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4_voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_voltar1ActionPerformed(evt);
            }
        });
        jFrame1_alterar.getContentPane().add(jButton4_voltar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 690, 160, 40));

        jComboBox2_TipoDoVeiculo.setFont(new java.awt.Font("Bodoni MT", 3, 22)); // NOI18N
        jComboBox2_TipoDoVeiculo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jComboBox2_TipoDoVeiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jFrame1_alterar.getContentPane().add(jComboBox2_TipoDoVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 310, 40));

        jComboBox1_categoriaVeiculo.setFont(new java.awt.Font("Bodoni MT", 3, 22)); // NOI18N
        jComboBox1_categoriaVeiculo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jComboBox1_categoriaVeiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jFrame1_alterar.getContentPane().add(jComboBox1_categoriaVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 310, 40));

        jComboBox2_Modelo.setFont(new java.awt.Font("Bodoni MT", 3, 22)); // NOI18N
        jComboBox2_Modelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jComboBox2_Modelo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox2_Modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2_ModeloActionPerformed(evt);
            }
        });
        jFrame1_alterar.getContentPane().add(jComboBox2_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 310, 40));

        jLabel11.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jLabel11.setText("COMBUSTIVEL");
        jFrame1_alterar.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, -1, 30));

        jComboBox2_TipoCombustivel.setFont(new java.awt.Font("Bodoni MT", 3, 22)); // NOI18N
        jComboBox2_TipoCombustivel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jComboBox2_TipoCombustivel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox2_TipoCombustivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2_TipoCombustivelActionPerformed(evt);
            }
        });
        jFrame1_alterar.getContentPane().add(jComboBox2_TipoCombustivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 310, 40));

        jLabel8.setFont(new java.awt.Font("Bodoni MT", 3, 30)); // NOI18N
        jLabel8.setText("PLACA");
        jFrame1_alterar.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 550, -1, 30));

        jLabel9.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jLabel9.setText("MODELO");
        jFrame1_alterar.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, -1, 30));

        jLabel12.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jLabel12.setText("CATEGORIA");
        jFrame1_alterar.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, -1, 30));

        jLabel13.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jLabel13.setText("TIPO");
        jFrame1_alterar.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 70, 30));

        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true), "SELECIONE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 28), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterar.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 720, 420));

        jTextField1_placa.setFont(new java.awt.Font("Bodoni MT", 3, 24)); // NOI18N
        jTextField1_placa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_alterar.getContentPane().add(jTextField1_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 580, 260, 40));

        jLabel16.setFont(new java.awt.Font("Bodoni MT", 3, 30)); // NOI18N
        jLabel16.setText("KM/s ATUAL");
        jFrame1_alterar.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 550, -1, 30));

        jTextField1_quilometragem.setFont(new java.awt.Font("Bodoni MT", 3, 24)); // NOI18N
        jTextField1_quilometragem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_alterar.getContentPane().add(jTextField1_quilometragem, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 580, 260, 40));

        jButton1_ALTERAR.setBackground(new java.awt.Color(102, 102, 102));
        jButton1_ALTERAR.setFont(new java.awt.Font("Bodoni MT", 3, 28)); // NOI18N
        jButton1_ALTERAR.setForeground(new java.awt.Color(0, 0, 0));
        jButton1_ALTERAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/alterar.png"))); // NOI18N
        jButton1_ALTERAR.setText("   ALTERAR");
        jButton1_ALTERAR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jButton1_ALTERAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_ALTERAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_ALTERARActionPerformed(evt);
            }
        });
        jFrame1_alterar.getContentPane().add(jButton1_ALTERAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 350, 200, 40));

        jLabel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "DIGITE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 28), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterar.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, 720, 140));

        jLabel19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "OPÇÕES", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 28), new java.awt.Color(255, 255, 255))); // NOI18N
        jFrame1_alterar.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 290, 330, 140));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/FundoTelas.png"))); // NOI18N
        jFrame1_alterar.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTextField1_idVeiculos.setText("jTextField1");
        jFrame1_alterar.getContentPane().add(jTextField1_idVeiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 90, 30));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 480, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Bodoni MT", 3, 36)); // NOI18N
        jLabel2.setText("RELAÇÃO DOS VEICULOS");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 480, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/pinkLogoMenorzinha.gif"))); // NOI18N
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "VEÍCULOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Bodoni MT", 3, 36))); // NOI18N

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 1270, 250));

        jButton4_voltar.setBackground(new java.awt.Color(102, 102, 102));
        jButton4_voltar.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jButton4_voltar.setForeground(new java.awt.Color(255, 0, 153));
        jButton4_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/voltar.png"))); // NOI18N
        jButton4_voltar.setText("    VOLTAR");
        jButton4_voltar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton4_voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_voltarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 690, 160, 40));

        jButton_Alterar.setBackground(new java.awt.Color(102, 102, 102));
        jButton_Alterar.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jButton_Alterar.setForeground(new java.awt.Color(255, 0, 153));
        jButton_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/alterar.png"))); // NOI18N
        jButton_Alterar.setText("ALTERAR");
        jButton_Alterar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_Alterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 500, 160, 40));

        jButton_Remover.setBackground(new java.awt.Color(102, 102, 102));
        jButton_Remover.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jButton_Remover.setForeground(new java.awt.Color(255, 0, 153));
        jButton_Remover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/removeriten.png"))); // NOI18N
        jButton_Remover.setText("REMOVER");
        jButton_Remover.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_Remover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RemoverActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Remover, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 550, 160, 40));

        jTextField1_PlacaSelecionada.setFont(new java.awt.Font("Bodoni MT", 3, 32)); // NOI18N
        jTextField1_PlacaSelecionada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(jTextField1_PlacaSelecionada, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 530, 210, 40));

        jLabel4_PLACASELECIONADA.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4_PLACASELECIONADA.setFont(new java.awt.Font("Bodoni MT", 3, 25)); // NOI18N
        jLabel4_PLACASELECIONADA.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "PLACA SELECIONADA", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 26), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel4_PLACASELECIONADA, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, 360, 100));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/FundoTelas.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void puxarMarcasCBBox() throws Exception {
        try {
            MarcasDAO marcas = new MarcasDAO();
            ResultSet rs = marcas.listarMarcas();
            while (rs.next()) {
                jComboBox2_Marca.addItem(rs.getString(1));
            }
        } catch (Exception e) {
        }
    }

    public void puxarDadosComboBox() throws Exception {

        jComboBox2_Marca.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    jComboBox2_Modelo.removeAllItems();
                    try {

                        ModelosDAO mod = new ModelosDAO();
                        ResultSet rs = mod.listarModelos(jComboBox2_Marca.getSelectedItem().toString());
                        while (rs.next()) {
                            jComboBox2_Modelo.addItem(rs.getString(1));
                        }
                    } catch (Exception ex) {

                    }
                }
            }
        });

    }

    private void jTable1_gastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_gastosMouseClicked
        jTextField1_PlacaSelecionada.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 3).toString());
        jTextField1_placa.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 3).toString());
        jTextField1_quilometragem.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 7).toString());

        jComboBox2_Marca.setSelectedItem(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 2));
        jComboBox2_Modelo.setSelectedItem(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 1));

        jComboBox2_TipoCombustivel.setSelectedItem(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 6).toString());
        jComboBox1_categoriaVeiculo.setSelectedItem(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 4).toString());
        jComboBox2_TipoCombustivel.setSelectedItem(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 5).toString());

        jTextField1_idVeiculos.setText(jTable1_gastos.getValueAt(jTable1_gastos.getSelectedRow(), 0).toString());

        if (jTextField1_PlacaSelecionada.getText().matches("")) {

        } else {
            jLabel4_PLACASELECIONADA.setVisible(true);
            jTextField1_PlacaSelecionada.setVisible(true);
        }
    }//GEN-LAST:event_jTable1_gastosMouseClicked

    private void jButton4_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_voltarActionPerformed
        TelaVeiculos veic = new TelaVeiculos();
        veic.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4_voltarActionPerformed

    private void jButton_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AlterarActionPerformed
        if (jTextField1_PlacaSelecionada.getText().matches("")) {
            JOptionPane.showMessageDialog(rootPane, "Nenhum veículo selecionado na tabela!");
        } else {

            TelaRelacaoVeiculos veic = new TelaRelacaoVeiculos();
            jFrame1_alterar.setVisible(true);
        }
    }//GEN-LAST:event_jButton_AlterarActionPerformed

    private void jButton_RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RemoverActionPerformed
        try {
            VeiculosDAO vei = new VeiculosDAO();
            vei.excluir(jTextField1_PlacaSelecionada.getText());
            jTextField1_PlacaSelecionada.setText("");
            jTextField1_PlacaSelecionada.setVisible(false);
            jLabel4_PLACASELECIONADA.setVisible(false);
            imprimirDadosNaGrid();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton_RemoverActionPerformed

    private void jComboBox2_MarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2_MarcaActionPerformed

    }//GEN-LAST:event_jComboBox2_MarcaActionPerformed

    private void jButton4_voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_voltar1ActionPerformed
        jFrame1_alterar.dispose();
    }//GEN-LAST:event_jButton4_voltar1ActionPerformed

    public void puxarImagemMarca() throws Exception {
        try {

            ModelosDAO modelos = new ModelosDAO();
            Modelos mod = new Modelos();

            ArrayList<Modelos> lista = modelos.listagemDeModelos();
            for (int i = 0; i < lista.size(); i++) {
                ImageIcon marca = new ImageIcon(lista.get(i).getUrl());
                if (jComboBox2_Modelo.getSelectedItem().equals(lista.get(i).getDescricao())) {

                    marca.setImage(marca.getImage().getScaledInstance(jLabel10_imagemModelos.getWidth(), jLabel10_imagemModelos.getHeight(), 1));
                    jLabel10_imagemModelos.setIcon(marca);
                }
            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "combobox");
        }
    }

    private void jComboBox2_ModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2_ModeloActionPerformed
        try {
            puxarImagemMarca();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jComboBox2_ModeloActionPerformed

    private void jComboBox2_TipoCombustivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2_TipoCombustivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2_TipoCombustivelActionPerformed

    private void jButton1_ALTERARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_ALTERARActionPerformed
        try {
            if (jTextField1_placa.getText().matches("") || jTextField1_quilometragem.getText().matches("")) {
                JOptionPane.showMessageDialog(rootPane, "Alguns campos não foram preechidos!");
            } else {

                alterarVeiculo();
                imprimirDadosNaGrid();
                JOptionPane.showMessageDialog(rootPane, "O veículo com a placa: '" + jTextField1_PlacaSelecionada.getText()+"' foi alterado com sucesso!");
                jTextField1_PlacaSelecionada.setVisible(false);
                jTextField1_PlacaSelecionada.setText("");
                jLabel4_PLACASELECIONADA.setVisible(false);
                jFrame1_alterar.dispose();
            }
        }catch (Exception ex) {
                Logger.getLogger(TelaRelacaoVeiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_jButton1_ALTERARActionPerformed

    private void alterarVeiculo() {
        try {
            if (jComboBox2_TipoDoVeiculo.getSelectedIndex() == 0) {
                tipoVeiculo = TipoDoVeiculo.PASSEIO + "";
            } else if (jComboBox2_TipoDoVeiculo.getSelectedIndex() == 1) {
                tipoVeiculo = TipoDoVeiculo.CARGA + "";
            } else if (jComboBox2_TipoDoVeiculo.getSelectedIndex() == 2) {
                tipoVeiculo = TipoDoVeiculo.MISTO + "";
            } else if (jComboBox2_TipoDoVeiculo.getSelectedIndex() == 3) {
                tipoVeiculo = TipoDoVeiculo.COMPETICAO + "";
            } else if (jComboBox2_TipoDoVeiculo.getSelectedIndex() == 4) {
                tipoVeiculo = TipoDoVeiculo.TRACAO + "";
            } else if (jComboBox2_TipoDoVeiculo.getSelectedIndex() == 5) {
                tipoVeiculo = TipoDoVeiculo.ESPECIAL + "";
            } else if (jComboBox2_TipoDoVeiculo.getSelectedIndex() == 6) {
                tipoVeiculo = TipoDoVeiculo.COLECAO + "";
            }

            if (jComboBox2_TipoCombustivel.getSelectedIndex() == 0) {
                tipoCombustivel = TipoCombustivel.GASOLINA + "";
            } else if (jComboBox2_TipoCombustivel.getSelectedIndex() == 1) {
                tipoCombustivel = TipoCombustivel.FLEX + "";
            } else if (jComboBox2_TipoCombustivel.getSelectedIndex() == 2) {
                tipoCombustivel = TipoCombustivel.GNV + "";
            } else if (jComboBox2_TipoCombustivel.getSelectedIndex() == 3) {
                tipoCombustivel = TipoCombustivel.ELETRICO + "";
            }

            if (jComboBox1_categoriaVeiculo.getSelectedIndex() == 0) {
                categoriaVeiculo = CategoriaVeiculos.HATCH + "";
            } else if (jComboBox1_categoriaVeiculo.getSelectedIndex() == 1) {
                categoriaVeiculo = CategoriaVeiculos.SEDAN + "";
            } else if (jComboBox1_categoriaVeiculo.getSelectedIndex() == 2) {
                categoriaVeiculo = CategoriaVeiculos.SUV + "";
            } else if (jComboBox1_categoriaVeiculo.getSelectedIndex() == 4) {
                categoriaVeiculo = CategoriaVeiculos.PICAPE + "";
            } else if (jComboBox1_categoriaVeiculo.getSelectedIndex() == 5) {
                categoriaVeiculo = CategoriaVeiculos.UTILITARIO + "";
            }

            IModelosDAO modelooo = null;
            modelooo = new ModelosDAO();

            Veiculos veiculos = new Veiculos(Integer.parseInt(jTextField1_idVeiculos.getText()), jTextField1_placa.getText(),
                    TipoDoVeiculo.valueOf(tipoVeiculo), CategoriaVeiculos.valueOf(categoriaVeiculo), modelooo.listagemDeModelos().get(0),
                    TipoCombustivel.valueOf(tipoCombustivel), Integer.parseInt(jTextField1_quilometragem.getText()));

            ArrayList<Modelos> lista = modelooo.listagemDeModelos();
            for (int i = 0; i < lista.size(); i++) {
                if (jComboBox2_Modelo.getSelectedItem().equals(lista.get(i).getDescricao())) {
                    veiculos.setModelo(lista.get(i));
                }
            }

            VeiculosDAO veiculoss = new VeiculosDAO();
            veiculoss.alterar(veiculos);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, err);
        }
    }

    private void imprimirDadosNaGrid() {

        try {

            DefaultTableModel model = (DefaultTableModel) jTable1_gastos.getModel();
            JTableRenderer JtableRenderer = new JTableRenderer();
            conexao = ConexaoBD.getConexao();
            Statement statement = conexao.createStatement();
            String query = "select veiculos.id as \"Identificador do Veiculo\",\n"
                    + "	   modelos.descricao as \"Modelo do Carro\",\n"
                    + "	   marcas.descricao as \"Marca Do Carro\",\n"
                    + "	   veiculos.placa as \"Placa do veiculo\",\n"
                    + "	   veiculos.categoria_veiculo as \"Categoria\",\n"
                    + "	   veiculos.tipo_veiculo as \"Tipo de veiculo\",\n"
                    + "	   veiculos.tipo_combustivel  as \"Tipo de Combustivel\",\n"
                    + "	   veiculos.quilometragem as \"Quilometragem atual\"\n"
                    + "from veiculos \n"
                    + "inner join modelos on modelos.id = veiculos.id_modelo \n"
                    + "inner join marcas on marcas.id = modelos.id_marca";
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
            resultSet.close();
            statement.close();

            jTable1_gastos.getColumnModel().getColumn(3).setWidth(140);
            jTable1_gastos.getColumnModel().getColumn(3).setMinWidth(140);
            jTable1_gastos.getColumnModel().getColumn(3).setMaxWidth(140);
            jTable1_gastos.getColumnModel().getColumn(0).setWidth(140);
            jTable1_gastos.getColumnModel().getColumn(0).setMinWidth(140);
            jTable1_gastos.getColumnModel().getColumn(0).setMaxWidth(140);
            jTable1_gastos.getColumnModel().getColumn(7).setWidth(130);
            jTable1_gastos.getColumnModel().getColumn(7).setMinWidth(130);
            jTable1_gastos.getColumnModel().getColumn(7).setMaxWidth(130);

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
            java.util.logging.Logger.getLogger(TelaRelacaoVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelacaoVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelacaoVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelacaoVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelacaoVeiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_ALTERAR;
    private javax.swing.JButton jButton4_voltar;
    private javax.swing.JButton jButton4_voltar1;
    private javax.swing.JButton jButton_Alterar;
    private javax.swing.JButton jButton_Remover;
    private javax.swing.JComboBox<CategoriaVeiculos> jComboBox1_categoriaVeiculo;
    private javax.swing.JComboBox<String> jComboBox2_Marca;
    private javax.swing.JComboBox<String> jComboBox2_Modelo;
    private javax.swing.JComboBox<TipoCombustivel> jComboBox2_TipoCombustivel;
    private javax.swing.JComboBox<TipoDoVeiculo> jComboBox2_TipoDoVeiculo;
    private javax.swing.JFrame jFrame1_alterar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel10_imagemModelos;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel4_PLACASELECIONADA;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1_gastos;
    private javax.swing.JTextField jTextField1_PlacaSelecionada;
    private javax.swing.JTextField jTextField1_idVeiculos;
    private javax.swing.JTextField jTextField1_placa;
    private javax.swing.JTextField jTextField1_quilometragem;
    // End of variables declaration//GEN-END:variables
    private void carregarComboBox() {
        jComboBox2_TipoDoVeiculo.setModel(new DefaultComboBoxModel<>(TipoDoVeiculo.values()));
        jComboBox1_categoriaVeiculo.setModel(new DefaultComboBoxModel<>(CategoriaVeiculos.values()));
        jComboBox2_TipoCombustivel.setModel(new DefaultComboBoxModel<>(TipoCombustivel.values()));
    }
}
