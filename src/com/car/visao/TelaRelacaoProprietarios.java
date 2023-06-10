package com.car.visao;

import com.car.Ferramentas.JTableRenderer;
import com.car.Modelos.Proprietario;
import com.car.persistencia.ProprietariosDAO;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaRelacaoProprietarios extends javax.swing.JFrame {

    
    public TelaRelacaoProprietarios() {
        initComponents();
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        int largura = bounds.width;
        int altura = bounds.height;
        setSize(largura, altura);
        setLocation(0, 0);
        
        ProprietariosDAO proprietariosDAO = null;
        
        try {
            proprietariosDAO = new ProprietariosDAO();
            imprimirDadosNaGrid(proprietariosDAO.listagemProprietarios());
        } catch (Exception e) {
        }
        
    }

    
    private void imprimirDadosNaGrid(ArrayList<Proprietario> listaDeMarcas) {

        try {
            DefaultTableModel model = (DefaultTableModel) jTable1_proprietarios.getModel();
            JTableRenderer JtableRenderer = new JTableRenderer();
            jTable1_proprietarios.getColumnModel().getColumn(8).setCellRenderer(JtableRenderer);

            model.setNumRows(0);
            Iterator<Proprietario> lista = listaDeMarcas.iterator();

            while (lista.hasNext()) {
                String[] saida = new String[9];
                Proprietario aux = lista.next();
                saida[0] = aux.getIdProprietarios() + "";
                saida[1] = aux.getTipoDoProprietario()+"";
                saida[2] = aux.getCPF_CNPJ();
                saida[3] = aux.getNome();
                saida[4] = aux.getTelefone();
                saida[5] = aux.getEmail();
                saida[6] = aux.getCNH()+"";
                saida[7] = aux.getCategoriaCNH()+"";
               
                

                
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

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_proprietarios = new javax.swing.JTable();
        jButton4_voltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/pinkLogoMenorzinha.gif"))); // NOI18N
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Bodoni MT", 3, 36)); // NOI18N
        jLabel2.setText("RELAÇÃO DE PROPRIETARIOS");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 580, 30));

        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 570, -1));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 5, true), "PROPRIETÁRIOS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 0, 36), new java.awt.Color(0, 0, 0))); // NOI18N

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
        jScrollPane1.setViewportView(jTable1_proprietarios);
        if (jTable1_proprietarios.getColumnModel().getColumnCount() > 0) {
            jTable1_proprietarios.getColumnModel().getColumn(0).setMinWidth(55);
            jTable1_proprietarios.getColumnModel().getColumn(0).setPreferredWidth(55);
            jTable1_proprietarios.getColumnModel().getColumn(0).setMaxWidth(55);
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 1230, 320));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/FundoTelas.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_voltarActionPerformed
        // TODO add your handling code here:
        TelaPrincipal principal = new TelaPrincipal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4_voltarActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1_proprietarios;
    // End of variables declaration//GEN-END:variables
}
