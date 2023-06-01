/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.car.visao;

import com.car.Modelos.cadastroPessoas;
import com.car.persistencia.cadastroPessoasDAO;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pichau
 */
public class TelaCadastro extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastro
     */
    public TelaCadastro() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jTextField3_senha = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField4_nomeUsuario = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton4_voltar = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jTextField5_email = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/instagram.png"))); // NOI18N
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 570, 40, 30));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/linkedin.png"))); // NOI18N
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 570, 40, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/LogoTelaPrincipalGIFF.gif"))); // NOI18N
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel13.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jLabel13VetoableChange(evt);
            }
        });
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 350, 320));

        jLabel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "COLABORADORES DO PROJETO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 22), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 430, 100));

        jLabel15.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("INSTAGRAM");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 580, -1, 20));

        jLabel16.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("LINKEDIN");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 580, -1, 20));

        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, 540));

        jLabel18.setFont(new java.awt.Font("Bodoni MT", 3, 28)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("CADASTRAR");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 540, 190, 30));

        jButton9.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/botaoLogin.jpg"))); // NOI18N
        jButton9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 530, 280, 50));

        jTextField3_senha.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jTextField3_senha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jTextField3_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3_senhaActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, 280, 50));

        jLabel19.setFont(new java.awt.Font("Bodoni MT", 3, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("SENHA");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 100, -1));

        jTextField4_nomeUsuario.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jTextField4_nomeUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jTextField4_nomeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4_nomeUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4_nomeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 280, 50));

        jLabel20.setFont(new java.awt.Font("Bodoni MT", 3, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("EMAIL");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, 90, -1));

        jLabel21.setFont(new java.awt.Font("Bodoni MT", 3, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("CADASTRO");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, -1, -1));

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
        getContentPane().add(jButton4_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 630, 140, 40));

        jLabel22.setFont(new java.awt.Font("Bodoni MT", 3, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("NOME DE USUÁRIO");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 250, -1));

        jTextField5_email.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jTextField5_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jTextField5_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5_emailActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, 280, 50));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/FundoTelas.png"))); // NOI18N
        jLabel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            URI link = new URI("https://linktr.ee/TLTLInstagram");
            Desktop.getDesktop().browse(link);
        } catch (URISyntaxException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            URI link = new URI("https://linktr.ee/TLTL?utm_source=linktree_profile_share&ltsid=87c4e197-183d-4dbe-aaef-6e4bffeb4d11");
            Desktop.getDesktop().browse(link);
        } catch (URISyntaxException ex) {
            java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(telaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jLabel13VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jLabel13VetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13VetoableChange

    private void jTextField3_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3_senhaActionPerformed

    private void jTextField4_nomeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4_nomeUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4_nomeUsuarioActionPerformed

    private void jButton4_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_voltarActionPerformed
        
        telaLogin log = new telaLogin();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4_voltarActionPerformed

    private void jTextField5_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5_emailActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            cadastroPessoasDAO pessoa = new cadastroPessoasDAO();
            cadastroPessoas pessoinha = new cadastroPessoas(jTextField4_nomeUsuario.getText(), jTextField5_email.getText(), jTextField3_senha.getText());
            pessoa.cadastrarPessoas(pessoinha);
            limparCampos();
        } catch (Exception ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton9ActionPerformed

    public void limparCampos(){
        jTextField3_senha.setText("");
        jTextField4_nomeUsuario.setText("");
        jTextField5_email.setText("");
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
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4_voltar;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JTextField jTextField3_senha;
    private javax.swing.JTextField jTextField4_nomeUsuario;
    private javax.swing.JTextField jTextField5_email;
    // End of variables declaration//GEN-END:variables
}
