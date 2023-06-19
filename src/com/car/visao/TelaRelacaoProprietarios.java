package com.car.visao;

import com.car.Enumerations.CategoriaCNH;
import com.car.Enumerations.tipoProprietario;
import com.car.Ferramentas.JTableRenderer;
import com.car.Ferramentas.limitaCaracteres;
import com.car.Modelos.Proprietario;
import com.car.persistencia.IProprietariosDAO;
import com.car.persistencia.ProprietariosDAO;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaRelacaoProprietarios extends javax.swing.JFrame {

    String tipoPropri;
    String CatCNH;

    public TelaRelacaoProprietarios() {
        initComponents();

        jTextField1_Nome.setDocument(new limitaCaracteres(55, limitaCaracteres.tipoEntrada.NOME));
        jTextField1_razaoSocial.setDocument(new limitaCaracteres(55, limitaCaracteres.tipoEntrada.DESCRICAO));
        jTextField1_EMAIL.setDocument(new limitaCaracteres(60, limitaCaracteres.tipoEntrada.EMAIL));
        jTextField1_CNH.setDocument(new limitaCaracteres(9, limitaCaracteres.tipoEntrada.NUMEROINTEIRO));

        tipoPropri = tipoProprietario.PF + "";
        CatCNH = CategoriaCNH.A + "";

        carregarComboBox();

        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        int largura = bounds.width;
        int altura = bounds.height;
        setSize(largura, altura);
        setLocation(0, 0);

        jFrame1_ALTERAR.setSize(largura, altura);
        jFrame1_ALTERAR.setLocation(0, 0);

        ProprietariosDAO proprietariosDAO = null;

        jTextField1_cnhSElecionada.setVisible(false);
        jLabel4_PLACASELECIONADA.setVisible(false);
        jButton_Alterar1.setVisible(false);
        jTextField1_cnhSElecionada.setEnabled(false);
        try {
            proprietariosDAO = new ProprietariosDAO();
            imprimirDadosNaGrid(proprietariosDAO.listagemProprietarios());
        } catch (Exception e) {
        }

    }

    private void imprimirDadosNaGrid(ArrayList<Proprietario> listaDeProprietarios) {

        try {
            DefaultTableModel model = (DefaultTableModel) jTable1_proprietarios.getModel();
            JTableRenderer JtableRenderer = new JTableRenderer();
            jTable1_proprietarios.getColumnModel().getColumn(8).setCellRenderer(JtableRenderer);

            model.setNumRows(0);
            Iterator<Proprietario> lista = listaDeProprietarios.iterator();

            while (lista.hasNext()) {
                String[] saida = new String[9];
                Proprietario aux = lista.next();
                saida[0] = aux.getIdProprietarios() + "";
                saida[1] = aux.getTipoDoProprietario() + "";
                saida[2] = aux.getCPF_CNPJ();
                saida[3] = aux.getNome();
                saida[4] = aux.getTelefone();
                saida[5] = aux.getEmail();
                saida[6] = aux.getCNH() + "";
                saida[7] = aux.getCategoriaCNH() + "";

                Object[] dados = {saida[0], saida[1], saida[2], saida[3], saida[4], saida[5], saida[6], saida[7]};
                model.addRow(dados);

            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1_ALTERAR = new javax.swing.JFrame();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextField1_telefone = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1_tipoCNH = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1_TipoDoProprietário = new javax.swing.JComboBox<>();
        jTextField1_Nome = new javax.swing.JTextField();
        jTextField1_razaoSocial = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10_nome = new javax.swing.JLabel();
        jButton_Alterar = new javax.swing.JButton();
        jLabel8_cpf = new javax.swing.JLabel();
        jLabel9_CNPJ = new javax.swing.JLabel();
        jFormattedTextField1_cpf = new javax.swing.JFormattedTextField();
        jFormattedTextField1_CNPJ = new javax.swing.JFormattedTextField();
        jLabel10_razaoSocial = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField1_EMAIL = new javax.swing.JTextField();
        jTextField1_CNH = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_proprietarios = new javax.swing.JTable();
        jButton4_voltar = new javax.swing.JButton();
        jTextField1_cnhSElecionada = new javax.swing.JTextField();
        jLabel4_PLACASELECIONADA = new javax.swing.JLabel();
        jButton_Alterar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1_idEscondido = new javax.swing.JTextField();

        jFrame1_ALTERAR.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/pinkLogoMenorzinha.gif"))); // NOI18N
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        jFrame1_ALTERAR.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_ALTERAR.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 710, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Bodoni MT", 3, 36)); // NOI18N
        jLabel5.setText("ALTERAR CADASTRO PROPRIETÁRIO");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jFrame1_ALTERAR.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 730, 50));

        jFormattedTextField1_telefone.setBackground(new java.awt.Color(153, 153, 153));
        jFormattedTextField1_telefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        try {
            jFormattedTextField1_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_telefone.setFont(new java.awt.Font("Bodoni MT", 3, 28)); // NOI18N
        jFormattedTextField1_telefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFormattedTextField1_telefoneMouseClicked(evt);
            }
        });
        jFrame1_ALTERAR.getContentPane().add(jFormattedTextField1_telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 300, 40));

        jLabel8.setBackground(new java.awt.Color(187, 187, 187));
        jLabel8.setFont(new java.awt.Font("Bodoni MT", 3, 34)); // NOI18N
        jLabel8.setText("EMAIL");
        jFrame1_ALTERAR.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, -1, 40));

        jLabel10.setBackground(new java.awt.Color(187, 187, 187));
        jLabel10.setFont(new java.awt.Font("Bodoni MT", 3, 34)); // NOI18N
        jLabel10.setText("CNH");
        jFrame1_ALTERAR.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 520, -1, 40));

        jComboBox1_tipoCNH.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jComboBox1_tipoCNH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jComboBox1_tipoCNH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jFrame1_ALTERAR.getContentPane().add(jComboBox1_tipoCNH, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 580, 140, 40));

        jLabel9.setFont(new java.awt.Font("Bodoni MT", 3, 34)); // NOI18N
        jLabel9.setText("TIPO CNH");
        jFrame1_ALTERAR.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 580, 190, -1));

        jComboBox1_TipoDoProprietário.setFont(new java.awt.Font("Bodoni MT", 3, 24)); // NOI18N
        jComboBox1_TipoDoProprietário.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jComboBox1_TipoDoProprietário.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1_TipoDoProprietário.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1_TipoDoProprietárioActionPerformed(evt);
            }
        });
        jFrame1_ALTERAR.getContentPane().add(jComboBox1_TipoDoProprietário, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 140, 40));

        jTextField1_Nome.setBackground(new java.awt.Color(153, 153, 153));
        jTextField1_Nome.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jTextField1_Nome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_ALTERAR.getContentPane().add(jTextField1_Nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 350, 40));

        jTextField1_razaoSocial.setBackground(new java.awt.Color(153, 153, 153));
        jTextField1_razaoSocial.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jTextField1_razaoSocial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_ALTERAR.getContentPane().add(jTextField1_razaoSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 350, 40));

        jLabel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "TIPO DE PROPRIETÁRIO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 25))); // NOI18N
        jFrame1_ALTERAR.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 350, 110));

        jLabel10_nome.setBackground(new java.awt.Color(187, 187, 187));
        jLabel10_nome.setFont(new java.awt.Font("Bodoni MT", 3, 34)); // NOI18N
        jLabel10_nome.setText("NOME");
        jFrame1_ALTERAR.getContentPane().add(jLabel10_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, 40));

        jButton_Alterar.setBackground(new java.awt.Color(153, 153, 153));
        jButton_Alterar.setFont(new java.awt.Font("Bodoni MT", 3, 30)); // NOI18N
        jButton_Alterar.setForeground(new java.awt.Color(255, 51, 153));
        jButton_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/CHANGE.png"))); // NOI18N
        jButton_Alterar.setText("  ALTERAR");
        jButton_Alterar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_Alterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AlterarActionPerformed(evt);
            }
        });
        jFrame1_ALTERAR.getContentPane().add(jButton_Alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 290, 240, 60));

        jLabel8_cpf.setBackground(new java.awt.Color(187, 187, 187));
        jLabel8_cpf.setFont(new java.awt.Font("Bodoni MT", 3, 34)); // NOI18N
        jLabel8_cpf.setText("CPF");
        jFrame1_ALTERAR.getContentPane().add(jLabel8_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 80, 40));

        jLabel9_CNPJ.setBackground(new java.awt.Color(187, 187, 187));
        jLabel9_CNPJ.setFont(new java.awt.Font("Bodoni MT", 3, 34)); // NOI18N
        jLabel9_CNPJ.setText("CNPJ");
        jFrame1_ALTERAR.getContentPane().add(jLabel9_CNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 100, 40));

        jFormattedTextField1_cpf.setBackground(new java.awt.Color(153, 153, 153));
        jFormattedTextField1_cpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        try {
            jFormattedTextField1_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_cpf.setFont(new java.awt.Font("Bodoni MT", 3, 30)); // NOI18N
        jFormattedTextField1_cpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFormattedTextField1_cpfMouseClicked(evt);
            }
        });
        jFrame1_ALTERAR.getContentPane().add(jFormattedTextField1_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 300, 40));

        jFormattedTextField1_CNPJ.setBackground(new java.awt.Color(153, 153, 153));
        jFormattedTextField1_CNPJ.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        try {
            jFormattedTextField1_CNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1_CNPJ.setFont(new java.awt.Font("Bodoni MT", 3, 30)); // NOI18N
        jFormattedTextField1_CNPJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFormattedTextField1_CNPJMouseClicked(evt);
            }
        });
        jFrame1_ALTERAR.getContentPane().add(jFormattedTextField1_CNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 300, 40));

        jLabel10_razaoSocial.setBackground(new java.awt.Color(187, 187, 187));
        jLabel10_razaoSocial.setFont(new java.awt.Font("Bodoni MT", 3, 34)); // NOI18N
        jLabel10_razaoSocial.setText("RAZÃO SOCIAL");
        jFrame1_ALTERAR.getContentPane().add(jLabel10_razaoSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 290, 40));

        jLabel12.setBackground(new java.awt.Color(187, 187, 187));
        jLabel12.setFont(new java.awt.Font("Bodoni MT", 3, 34)); // NOI18N
        jLabel12.setText("TELEFONE");
        jFrame1_ALTERAR.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, 40));

        jTextField1_EMAIL.setBackground(new java.awt.Color(153, 153, 153));
        jTextField1_EMAIL.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jTextField1_EMAIL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_ALTERAR.getContentPane().add(jTextField1_EMAIL, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 350, 40));

        jTextField1_CNH.setBackground(new java.awt.Color(153, 153, 153));
        jTextField1_CNH.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jTextField1_CNH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jFrame1_ALTERAR.getContentPane().add(jTextField1_CNH, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 520, 300, 40));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/FundoTelas.png"))); // NOI18N
        jFrame1_ALTERAR.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/pinkLogoMenorzinha.gif"))); // NOI18N
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 20, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Bodoni MT", 3, 36)); // NOI18N
        jLabel2.setText("DADOS DO PROPRIETÁRIO");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 520, 30));

        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 510, -1));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 5, true), "PROPRIETÁRIO", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 36), new java.awt.Color(0, 0, 0))); // NOI18N

        jTable1_proprietarios.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        jTable1_proprietarios.setFont(new java.awt.Font("Bodoni MT", 3, 19)); // NOI18N
        jTable1_proprietarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "TIPO", "DOCUMENTO", "NOME", "TELEFONE", "EMAIL", "CNH", "CAT CNH", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1_proprietarios.setRowHeight(55);
        jTable1_proprietarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_proprietariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1_proprietarios);
        if (jTable1_proprietarios.getColumnModel().getColumnCount() > 0) {
            jTable1_proprietarios.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1_proprietarios.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1_proprietarios.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1_proprietarios.getColumnModel().getColumn(1).setMinWidth(55);
            jTable1_proprietarios.getColumnModel().getColumn(1).setPreferredWidth(55);
            jTable1_proprietarios.getColumnModel().getColumn(1).setMaxWidth(55);
            jTable1_proprietarios.getColumnModel().getColumn(2).setMinWidth(125);
            jTable1_proprietarios.getColumnModel().getColumn(2).setPreferredWidth(125);
            jTable1_proprietarios.getColumnModel().getColumn(2).setMaxWidth(125);
            jTable1_proprietarios.getColumnModel().getColumn(4).setMinWidth(150);
            jTable1_proprietarios.getColumnModel().getColumn(4).setPreferredWidth(150);
            jTable1_proprietarios.getColumnModel().getColumn(4).setMaxWidth(150);
            jTable1_proprietarios.getColumnModel().getColumn(6).setMinWidth(125);
            jTable1_proprietarios.getColumnModel().getColumn(6).setPreferredWidth(125);
            jTable1_proprietarios.getColumnModel().getColumn(6).setMaxWidth(125);
            jTable1_proprietarios.getColumnModel().getColumn(7).setMinWidth(75);
            jTable1_proprietarios.getColumnModel().getColumn(7).setPreferredWidth(75);
            jTable1_proprietarios.getColumnModel().getColumn(7).setMaxWidth(75);
            jTable1_proprietarios.getColumnModel().getColumn(8).setMinWidth(0);
            jTable1_proprietarios.getColumnModel().getColumn(8).setPreferredWidth(0);
            jTable1_proprietarios.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 1190, 270));

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
        getContentPane().add(jButton4_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 680, 140, 40));

        jTextField1_cnhSElecionada.setFont(new java.awt.Font("Bodoni MT", 3, 32)); // NOI18N
        jTextField1_cnhSElecionada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(jTextField1_cnhSElecionada, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 550, 210, 40));

        jLabel4_PLACASELECIONADA.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4_PLACASELECIONADA.setFont(new java.awt.Font("Bodoni MT", 3, 25)); // NOI18N
        jLabel4_PLACASELECIONADA.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "CNH SELECIONADA", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 26), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel4_PLACASELECIONADA, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, 360, 100));

        jButton_Alterar1.setBackground(new java.awt.Color(102, 102, 102));
        jButton_Alterar1.setFont(new java.awt.Font("Bodoni MT", 3, 22)); // NOI18N
        jButton_Alterar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/CHANGE.png"))); // NOI18N
        jButton_Alterar1.setText("ALTERAR");
        jButton_Alterar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_Alterar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Alterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Alterar1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Alterar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 540, 180, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/FundoTelas.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(jTextField1_idEscondido, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 60, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_voltarActionPerformed
        // TODO add your handling code here:
        TelaPrincipal principal = new TelaPrincipal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4_voltarActionPerformed

    private void jTable1_proprietariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_proprietariosMouseClicked
        jTextField1_idEscondido.setText(jTable1_proprietarios.getValueAt(jTable1_proprietarios.getSelectedRow(), 0).toString());

        if (jTable1_proprietarios.getValueAt(jTable1_proprietarios.getSelectedRow(), 1).toString().equals("PF")) {
            jComboBox1_TipoDoProprietário.setSelectedIndex(0);
        } else if (jTable1_proprietarios.getValueAt(jTable1_proprietarios.getSelectedRow(), 1).toString().equals("PJ")) {
            jComboBox1_TipoDoProprietário.setSelectedIndex(1);
        }

        if (jComboBox1_TipoDoProprietário.getSelectedIndex() == 0) {
            jTextField1_Nome.setText(jTable1_proprietarios.getValueAt(jTable1_proprietarios.getSelectedRow(), 3).toString());
        } else if (jComboBox1_TipoDoProprietário.getSelectedIndex() == 1) {
            jTextField1_razaoSocial.setText(jTable1_proprietarios.getValueAt(jTable1_proprietarios.getSelectedRow(), 3).toString());
        }
        jFormattedTextField1_telefone.setText(jTable1_proprietarios.getValueAt(jTable1_proprietarios.getSelectedRow(), 4).toString());
        jTextField1_EMAIL.setText(jTable1_proprietarios.getValueAt(jTable1_proprietarios.getSelectedRow(), 5).toString());
        jTextField1_CNH.setText(jTable1_proprietarios.getValueAt(jTable1_proprietarios.getSelectedRow(), 6).toString());

        if (jTable1_proprietarios.getValueAt(jTable1_proprietarios.getSelectedRow(), 7).toString().equals("A")) {
            jComboBox1_tipoCNH.setSelectedIndex(0);
        } else if (jTable1_proprietarios.getValueAt(jTable1_proprietarios.getSelectedRow(), 7).toString().equals("B")) {
            jComboBox1_tipoCNH.setSelectedIndex(1);
        } else if (jTable1_proprietarios.getValueAt(jTable1_proprietarios.getSelectedRow(), 7).toString().equals("AB")) {
            jComboBox1_tipoCNH.setSelectedIndex(2);
        } else if (jTable1_proprietarios.getValueAt(jTable1_proprietarios.getSelectedRow(), 7).toString().equals("C")) {
            jComboBox1_tipoCNH.setSelectedIndex(3);
        } else if (jTable1_proprietarios.getValueAt(jTable1_proprietarios.getSelectedRow(), 7).toString().equals("D")) {
            jComboBox1_tipoCNH.setSelectedIndex(4);
        } else if (jTable1_proprietarios.getValueAt(jTable1_proprietarios.getSelectedRow(), 7).toString().equals("E")) {
            jComboBox1_tipoCNH.setSelectedIndex(5);
        }

        jTextField1_cnhSElecionada.setText(jTable1_proprietarios.getValueAt(jTable1_proprietarios.getSelectedRow(), 6).toString());
        if (jTextField1_cnhSElecionada.getText().matches("")) {

        } else {
            jTextField1_cnhSElecionada.setVisible(true);
            jLabel4_PLACASELECIONADA.setVisible(true);
            jButton_Alterar1.setVisible(true);
        }

    }//GEN-LAST:event_jTable1_proprietariosMouseClicked

    private void jFormattedTextField1_telefoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextField1_telefoneMouseClicked
        jFormattedTextField1_telefone.setEnabled(true);
    }//GEN-LAST:event_jFormattedTextField1_telefoneMouseClicked

    private void jComboBox1_TipoDoProprietárioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1_TipoDoProprietárioActionPerformed

        if (jComboBox1_TipoDoProprietário.getSelectedIndex() == 0) {
            jLabel10_nome.setVisible(true);
            jTextField1_Nome.setVisible(true);
            jFormattedTextField1_cpf.setVisible(true);
            jLabel8_cpf.setVisible(true);

            jFormattedTextField1_CNPJ.setVisible(false);
            jLabel10_razaoSocial.setVisible(false);
            jLabel9_CNPJ.setVisible(false);
            jTextField1_razaoSocial.setVisible(false);
            jTextField1_razaoSocial.setText("");
            jFormattedTextField1_CNPJ.setText("");

        } else if (jComboBox1_TipoDoProprietário.getSelectedIndex() == 1) {

            jLabel10_nome.setVisible(false);
            jTextField1_Nome.setVisible(false);
            jLabel8_cpf.setVisible(false);
            jFormattedTextField1_cpf.setVisible(false);
            jFormattedTextField1_cpf.setText("");
            jTextField1_Nome.setText("");

            jLabel9_CNPJ.setVisible(true);
            jFormattedTextField1_CNPJ.setVisible(true);
            jLabel10_razaoSocial.setVisible(true);
            jTextField1_razaoSocial.setVisible(true);

        }
    }//GEN-LAST:event_jComboBox1_TipoDoProprietárioActionPerformed

    private void jButton_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AlterarActionPerformed
        try {
            alterarProprietario();
            jFrame1_ALTERAR.dispose();
            jTextField1_cnhSElecionada.setVisible(false);
            jLabel4_PLACASELECIONADA.setVisible(false);
            jButton_Alterar1.setVisible(false);

            IProprietariosDAO proprietariosDAO = new ProprietariosDAO();
            imprimirDadosNaGrid(proprietariosDAO.listagemProprietarios());

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton_AlterarActionPerformed

    private void jFormattedTextField1_cpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextField1_cpfMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1_cpfMouseClicked

    private void jFormattedTextField1_CNPJMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextField1_CNPJMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1_CNPJMouseClicked

    private void jButton_Alterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Alterar1ActionPerformed
        if (jTextField1_cnhSElecionada.getText().matches("")) {
            JOptionPane.showMessageDialog(rootPane, "Nenhum veículo selecionado na tabela!");
        } else {

            jFrame1_ALTERAR.setVisible(true);
        }
    }//GEN-LAST:event_jButton_Alterar1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRelacaoProprietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelacaoProprietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelacaoProprietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelacaoProprietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelacaoProprietarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4_voltar;
    private javax.swing.JButton jButton_Alterar;
    private javax.swing.JButton jButton_Alterar1;
    private javax.swing.JComboBox<tipoProprietario> jComboBox1_TipoDoProprietário;
    private javax.swing.JComboBox<CategoriaCNH> jComboBox1_tipoCNH;
    private javax.swing.JFormattedTextField jFormattedTextField1_CNPJ;
    private javax.swing.JFormattedTextField jFormattedTextField1_cpf;
    private javax.swing.JFormattedTextField jFormattedTextField1_telefone;
    private javax.swing.JFrame jFrame1_ALTERAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel10_nome;
    private javax.swing.JLabel jLabel10_razaoSocial;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel4_PLACASELECIONADA;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel8_cpf;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel9_CNPJ;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1_proprietarios;
    private javax.swing.JTextField jTextField1_CNH;
    private javax.swing.JTextField jTextField1_EMAIL;
    private javax.swing.JTextField jTextField1_Nome;
    private javax.swing.JTextField jTextField1_cnhSElecionada;
    private javax.swing.JTextField jTextField1_idEscondido;
    private javax.swing.JTextField jTextField1_razaoSocial;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        jTextField1_CNH.setText("");
        jTextField1_EMAIL.setText("");
        jTextField1_Nome.setText("");
        jTextField1_razaoSocial.setText("");
        jFormattedTextField1_CNPJ.setText("");
        jFormattedTextField1_cpf.setText("");
        jFormattedTextField1_telefone.setText("");
        jComboBox1_TipoDoProprietário.setSelectedIndex(0);
        jComboBox1_tipoCNH.setSelectedIndex(0);
    }

    private void alterarProprietario() {
        try {

            if (jTextField1_CNH.getText().matches("") || jTextField1_EMAIL.getText().matches("")) {
                JOptionPane.showMessageDialog(rootPane, "Alguns campos não foram preenchidos!");
            } else {

                if (jComboBox1_TipoDoProprietário.getSelectedIndex() == 0) {
                    tipoPropri = tipoProprietario.PF + "";
                } else if (jComboBox1_TipoDoProprietário.getSelectedIndex() == 1) {
                    tipoPropri = tipoProprietario.PJ + "";
                }

                if (jComboBox1_tipoCNH.getSelectedIndex() == 0) {
                    CatCNH = CategoriaCNH.A + "";
                } else if (jComboBox1_tipoCNH.getSelectedIndex() == 1) {
                    CatCNH = CategoriaCNH.B + "";
                } else if (jComboBox1_tipoCNH.getSelectedIndex() == 2) {
                    CatCNH = CategoriaCNH.AB + "";
                } else if (jComboBox1_tipoCNH.getSelectedIndex() == 3) {
                    CatCNH = CategoriaCNH.C + "";
                } else if (jComboBox1_tipoCNH.getSelectedIndex() == 4) {
                    CatCNH = CategoriaCNH.D + "";
                } else if (jComboBox1_tipoCNH.getSelectedIndex() == 5) {
                    CatCNH = CategoriaCNH.E + "";
                }

                if (jComboBox1_TipoDoProprietário.getSelectedIndex() == 0) {
                    ProprietariosDAO proprietariosDAO = new ProprietariosDAO();
                    Proprietario propri = new Proprietario(Integer.parseInt(jTextField1_idEscondido.getText()), tipoProprietario.valueOf(tipoPropri),
                            jFormattedTextField1_cpf.getText(), jTextField1_Nome.getText(), jFormattedTextField1_telefone.getText(),
                            jTextField1_EMAIL.getText(), Integer.parseInt(jTextField1_CNH.getText()), CategoriaCNH.valueOf(CatCNH));
                    proprietariosDAO.alterarProprietario(propri);
                    JOptionPane.showMessageDialog(rootPane, "Proprietário: " + jTextField1_Nome.getText() + ", alterado com sucesso !");

                    limparCampos();

                } else if (jComboBox1_TipoDoProprietário.getSelectedIndex() == 1) {
                    ProprietariosDAO proprietariosDAO = new ProprietariosDAO();
                    Proprietario propri = new Proprietario(Integer.parseInt(jTextField1_idEscondido.getText()), tipoProprietario.valueOf(tipoPropri),
                            jFormattedTextField1_CNPJ.getText(), jTextField1_razaoSocial.getText(), jFormattedTextField1_telefone.getText(),
                            jTextField1_EMAIL.getText(), Integer.parseInt(jTextField1_CNH.getText()), CategoriaCNH.valueOf(CatCNH));
                    proprietariosDAO.alterarProprietario(propri);
                    JOptionPane.showMessageDialog(rootPane, "Proprietário: " + jTextField1_razaoSocial.getText() + ", alterado com sucesso !");
                    limparCampos();

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    private void carregarComboBox() {
        jComboBox1_TipoDoProprietário.setModel(new DefaultComboBoxModel<>(tipoProprietario.values()));
        jComboBox1_tipoCNH.setModel(new DefaultComboBoxModel<>(CategoriaCNH.values()));
    }
}
