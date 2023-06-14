package com.car.visao;

import com.car.Ferramentas.ConexaoBD;
import com.car.Ferramentas.JTableRenderer;
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
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaDeGastos extends javax.swing.JFrame {

    private Connection conexao = null;
    PreparedStatement st;

    public TelaDeGastos() {
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

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_gastos = new javax.swing.JTable();
        jButton4_voltar = new javax.swing.JButton();
        jComboBox1_tipoDoGasto = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 204)));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 710, 250));

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
        getContentPane().add(jButton4_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 630, 140, 40));

        jComboBox1_tipoDoGasto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", " " }));
        getContentPane().add(jComboBox1_tipoDoGasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 160, 50));

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "TIPO DO GASTO", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 26))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 260, 120));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/FundoTelas.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1_gastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_gastosMouseClicked

    }//GEN-LAST:event_jTable1_gastosMouseClicked

    private void jButton4_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_voltarActionPerformed
        // TODO add your handling code here:
        TelaPrincipal principal = new TelaPrincipal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4_voltarActionPerformed

    private void imprimirDadosNaGrid() {

        try {

            DefaultTableModel model = (DefaultTableModel) jTable1_gastos.getModel();
            JTableRenderer JtableRenderer = new JTableRenderer();
            conexao = ConexaoBD.getConexao();
            Statement statement = conexao.createStatement();
            String query = "select * from gastos_combustivel";
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

            jComboBox1_tipoDoGasto.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            if (jComboBox1_tipoDoGasto.getSelectedIndex() == 0) {
                                DefaultTableModel model = (DefaultTableModel) jTable1_gastos.getModel();
                                JTableRenderer JtableRenderer = new JTableRenderer();
                                conexao = ConexaoBD.getConexao();
                                Statement statement = conexao.createStatement();
                                String query = "select * from gastos_combustivel";
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
                            }
                            if (jComboBox1_tipoDoGasto.getSelectedIndex() == 1) {
                                DefaultTableModel model = (DefaultTableModel) jTable1_gastos.getModel();
                                JTableRenderer JtableRenderer = new JTableRenderer();
                                conexao = ConexaoBD.getConexao();
                                Statement statement = conexao.createStatement();
                                String query = "select * from modelos";
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
                                jTable1_gastos.getColumnModel().getColumn(4).setCellRenderer(JtableRenderer);
                                resultSet.close();
                                statement.close();
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(TelaDeGastos.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(TelaDeGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeGastos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4_voltar;
    private javax.swing.JComboBox<String> jComboBox1_tipoDoGasto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1_gastos;
    // End of variables declaration//GEN-END:variables
}
