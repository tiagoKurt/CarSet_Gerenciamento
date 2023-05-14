/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.car.visao;

import com.car.Ferramentas.JTableRenderer;
import com.car.Modelos.Marcas;
import com.car.Modelos.Modelos;
import com.car.persistencia.IMarcasDAO;
import com.car.persistencia.IModelosDAO;
import com.car.persistencia.MarcasDAO;
import com.car.persistencia.ModelosDAO;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pichau
 */
public class TelaModelos extends javax.swing.JFrame {

    IMarcasDAO marcasBD = null;

    public TelaModelos() {
        initComponents();

        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        int largura = bounds.width;
        int altura = bounds.height;
        setSize(largura, altura);
        setLocation(0, 0);

        try {
            puxarDadosComboBox();
        } catch (Exception ex) {
            Logger.getLogger(TelaModelos.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel3 = new javax.swing.JLabel();
        jButton4_voltar = new javax.swing.JButton();
        BuscarMarcas = new javax.swing.JButton();
        ImagensMarcas1 = new javax.swing.JLabel();
        ImagensMarcas = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton_Remover = new javax.swing.JButton();
        jButton_Alterar = new javax.swing.JButton();
        jButton_iNCLUIR = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_tabelaMarcas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1_IDModelos = new javax.swing.JTextField();
        jTextField1_DescricaoModelo = new javax.swing.JTextField();
        jComboBox1_ListaMarcas = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1_urlImagens = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/LogoDefinitiva.gif"))); // NOI18N
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 204), 3, true));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton4_voltar.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jButton4_voltar.setForeground(new java.awt.Color(0, 0, 0));
        jButton4_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/voltar.png"))); // NOI18N
        jButton4_voltar.setText("VOLTAR");
        jButton4_voltar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton4_voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_voltarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 630, 130, 40));

        BuscarMarcas.setBackground(new java.awt.Color(153, 153, 153));
        BuscarMarcas.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        BuscarMarcas.setForeground(new java.awt.Color(0, 0, 0));
        BuscarMarcas.setText("BUSCAR");
        BuscarMarcas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        BuscarMarcas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BuscarMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarMarcasActionPerformed(evt);
            }
        });
        getContentPane().add(BuscarMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 190, 130, 40));

        ImagensMarcas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/insiraImagem.gif"))); // NOI18N
        ImagensMarcas1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(ImagensMarcas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 190, 230, 190));

        ImagensMarcas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/insiraImagem.gif"))); // NOI18N
        ImagensMarcas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(ImagensMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 190, 230, 190));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Bodoni MT", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CADASTRO DE MODELOS");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 480, 40));

        jButton_Remover.setBackground(new java.awt.Color(153, 153, 153));
        jButton_Remover.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jButton_Remover.setForeground(new java.awt.Color(0, 0, 0));
        jButton_Remover.setText("REMOVER");
        jButton_Remover.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_Remover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RemoverActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Remover, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 340, 130, 40));

        jButton_Alterar.setBackground(new java.awt.Color(153, 153, 153));
        jButton_Alterar.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jButton_Alterar.setForeground(new java.awt.Color(0, 0, 0));
        jButton_Alterar.setText("ALTERAR");
        jButton_Alterar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_Alterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 290, 130, 40));

        jButton_iNCLUIR.setBackground(new java.awt.Color(153, 153, 153));
        jButton_iNCLUIR.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jButton_iNCLUIR.setForeground(new java.awt.Color(0, 0, 0));
        jButton_iNCLUIR.setText("INCLUIR");
        jButton_iNCLUIR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_iNCLUIR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_iNCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_iNCLUIRActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_iNCLUIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 240, 130, 40));

        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, -1, 40));

        jScrollPane1.setBackground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 204)));

        jTable1_tabelaMarcas.setBackground(new java.awt.Color(153, 153, 153));
        jTable1_tabelaMarcas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jTable1_tabelaMarcas.setFont(new java.awt.Font("Bodoni MT", 3, 24)); // NOI18N
        jTable1_tabelaMarcas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "MARCA", "", "MODELO", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1_tabelaMarcas.setRowHeight(60);
        jTable1_tabelaMarcas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_tabelaMarcasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1_tabelaMarcas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 710, 250));

        jLabel5.setFont(new java.awt.Font("Bodoni MT", 3, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("DESCRIÇÃO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, 40));

        jLabel7.setFont(new java.awt.Font("Bodoni MT", 3, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("ID");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, -1, 40));

        jTextField1_IDModelos.setBackground(new java.awt.Color(153, 153, 153));
        jTextField1_IDModelos.setFont(new java.awt.Font("Bodoni MT", 3, 22)); // NOI18N
        jTextField1_IDModelos.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1_IDModelos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jTextField1_IDModelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 130, 40));

        jTextField1_DescricaoModelo.setBackground(new java.awt.Color(153, 153, 153));
        jTextField1_DescricaoModelo.setFont(new java.awt.Font("Bodoni MT", 3, 22)); // NOI18N
        jTextField1_DescricaoModelo.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1_DescricaoModelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jTextField1_DescricaoModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 460, 40));

        getContentPane().add(jComboBox1_ListaMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 140, 50));

        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 94, 480, -1));

        jLabel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 204), 4), "OPÇÕES", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, 390, 220));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/FundoTelas.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTextField1_urlImagens.setText("jTextField1");
        getContentPane().add(jTextField1_urlImagens, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 130, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_voltarActionPerformed
        // TODO add your handling code here:
        TelaPrincipal principal = new TelaPrincipal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4_voltarActionPerformed

    private void BuscarMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarMarcasActionPerformed
        try {
            JFileChooser fc = new JFileChooser("./src/com/car/imagensModelos");
            File buscar = new File(".src/com/car/imagensModelos");

            fc.setCurrentDirectory(buscar);
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.showOpenDialog(this);
            File arquivo = fc.getSelectedFile();
            String nomeDoArquivo = arquivo.getPath();
            jTextField1_urlImagens.setText(nomeDoArquivo);
            ImageIcon iconLogo = new ImageIcon(nomeDoArquivo);
            iconLogo.setImage(iconLogo.getImage().getScaledInstance(
                    ImagensMarcas.getWidth(), ImagensMarcas.getHeight(), 1));
            ImagensMarcas.setIcon(iconLogo);
            ImagensMarcas1.setVisible(false);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
    }//GEN-LAST:event_BuscarMarcasActionPerformed

    private void jButton_RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RemoverActionPerformed
        try {
            IModelosDAO modelosDAO = null;
            modelosDAO = new ModelosDAO();
            modelosDAO.excluir(Integer.parseInt(jTextField1_IDModelos.getText()));
            limparTela();
            imprimirDadosNaGrid(modelosDAO.listagemDeModelos());
            ImagensMarcas1.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton_RemoverActionPerformed

    public void puxarDadosComboBox() throws Exception {
        try {
            MarcasDAO marcasDAO = new MarcasDAO();
            ResultSet rs = marcasDAO.listarMarcas();
            while (rs.next()) {
                jComboBox1_ListaMarcas.addItem(rs.getString(1));
            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "combobox");
        }
    }

    public void limparTela() {
        jTextField1_IDModelos.setText("");
        jTextField1_urlImagens.setText("");
        jTextField1_DescricaoModelo.setText("");
    }

    private void imprimirDadosNaGrid(ArrayList<Modelos> listaDeMarcas) {

        try {
            DefaultTableModel model = (DefaultTableModel) jTable1_tabelaMarcas.getModel();
            JTableRenderer JtableRenderer = new JTableRenderer();
            jTable1_tabelaMarcas.getColumnModel().getColumn(4).setCellRenderer(JtableRenderer);

            model.setNumRows(0);
            Iterator<Modelos> lista = listaDeMarcas.iterator();

            while (lista.hasNext()) {
                String[] saida = new String[3];
                Modelos aux = lista.next();
                saida[0] = aux.getIdModelos() + "";
                saida[1] = aux.getMarca().getDescricao();
                saida[2] = aux.getDescricao();

                ImageIcon iconlogo = new ImageIcon((aux.getUrl()));
                ImageIcon marca = new ImageIcon(aux.getMarca().getUrl());
                Object[] dados = {saida[0], saida[1], marca, saida[2], iconlogo};
                model.addRow(dados);

            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }

    private void jButton_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AlterarActionPerformed

    }//GEN-LAST:event_jButton_AlterarActionPerformed

    private void jButton_iNCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_iNCLUIRActionPerformed
        try {

            IMarcasDAO marcaaaa = null;
            marcaaaa = new MarcasDAO();

            int a = 0;
            File fis = new File(jTextField1_urlImagens.getText());
            Modelos modelo = null;
            modelo = new Modelos(0, marcaaaa.buscar(a),
                    jTextField1_DescricaoModelo.getText(), jTextField1_urlImagens.getText(), fis);

            ArrayList<Marcas> lista = marcaaaa.listaDeMarcas();
            for (int i = 0; i < lista.size(); i++) {
                if (jComboBox1_ListaMarcas.getSelectedItem().equals(lista.get(i).getDescricao())) {
                    modelo.setMarca(lista.get(i));
                }
            }
            IModelosDAO modelosDAO = null;
            modelosDAO = new ModelosDAO();
            modelosDAO.inserirModelos(modelo);
            limparTela();
            ImagensMarcas1.setVisible(true);
            imprimirDadosNaGrid(modelosDAO.listagemDeModelos());

        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, err);
        }
    }//GEN-LAST:event_jButton_iNCLUIRActionPerformed

    private void jTable1_tabelaMarcasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_tabelaMarcasMouseClicked
        jTextField1_IDModelos.setText(jTable1_tabelaMarcas.getValueAt(jTable1_tabelaMarcas.getSelectedRow(), 0).toString());
        jTextField1_DescricaoModelo.setText(jTable1_tabelaMarcas.getValueAt(jTable1_tabelaMarcas.getSelectedRow(), 1).toString());
        jTextField1_urlImagens.setText(jTable1_tabelaMarcas.getValueAt(jTable1_tabelaMarcas.getSelectedRow(), 2).toString());
        String nomeDoArquivo = jTextField1_urlImagens.getText();
        ImageIcon iconLogo = new ImageIcon(nomeDoArquivo);
        iconLogo.setImage(iconLogo.getImage().getScaledInstance(
                ImagensMarcas.getWidth(), ImagensMarcas.getHeight(), 1));
        ImagensMarcas.setIcon(iconLogo);
        ImagensMarcas1.setVisible(false);
    }//GEN-LAST:event_jTable1_tabelaMarcasMouseClicked

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
            java.util.logging.Logger.getLogger(TelaModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaModelos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarMarcas;
    private javax.swing.JLabel ImagensMarcas;
    private javax.swing.JLabel ImagensMarcas1;
    private javax.swing.JButton jButton4_voltar;
    private javax.swing.JButton jButton_Alterar;
    private javax.swing.JButton jButton_Remover;
    private javax.swing.JButton jButton_iNCLUIR;
    private javax.swing.JComboBox<String> jComboBox1_ListaMarcas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1_tabelaMarcas;
    private javax.swing.JTextField jTextField1_DescricaoModelo;
    private javax.swing.JTextField jTextField1_IDModelos;
    private javax.swing.JTextField jTextField1_urlImagens;
    // End of variables declaration//GEN-END:variables
}
