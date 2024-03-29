package com.car.visao;

import com.car.Enumerations.*;
import com.car.Ferramentas.limitaCaracteres;
import com.car.Modelos.Proprietario;
import com.car.persistencia.ProprietariosDAO;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

;

public class TelaProprietarios extends javax.swing.JFrame {

    String tipoPropri;
    String CatCNH;

    public TelaProprietarios() {
        initComponents();

        jTextField1_Nome.setDocument(new limitaCaracteres(55, limitaCaracteres.tipoEntrada.NOME));
        jTextField1_razaoSocial.setDocument(new limitaCaracteres(55, limitaCaracteres.tipoEntrada.DESCRICAO));
        jTextField1_EMAIL.setDocument(new limitaCaracteres(60, limitaCaracteres.tipoEntrada.EMAIL));
        jTextField1_CNH.setDocument(new limitaCaracteres(9, limitaCaracteres.tipoEntrada.NUMEROINTEIRO));

        carregarComboBox();

        tipoPropri = tipoProprietario.PF + "";
        CatCNH = CategoriaCNH.A + "";

        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        int largura = bounds.width;
        int altura = bounds.height;
        setSize(largura, altura);
        setLocation(0, 0);

        jFormattedTextField1_CNPJ.setVisible(false);
        jLabel10_razaoSocial.setVisible(false);
        jLabel10_razaoSocial.setVisible(false);
        jLabel9_CNPJ.setVisible(false);
        jTextField1_razaoSocial.setVisible(false);
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
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextField1_telefone = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1_tipoCNH = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1_TipoDoProprietário = new javax.swing.JComboBox<>();
        jTextField1_Nome = new javax.swing.JTextField();
        jTextField1_razaoSocial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10_nome = new javax.swing.JLabel();
        jButton_iNCLUIR = new javax.swing.JButton();
        jLabel8_cpf = new javax.swing.JLabel();
        jLabel9_CNPJ = new javax.swing.JLabel();
        jFormattedTextField1_cpf = new javax.swing.JFormattedTextField();
        jFormattedTextField1_CNPJ = new javax.swing.JFormattedTextField();
        jLabel10_razaoSocial = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1_EMAIL = new javax.swing.JTextField();
        jTextField1_CNH = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/pinkLogoMenorzinha.gif"))); // NOI18N
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 340, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Bodoni MT", 3, 36)); // NOI18N
        jLabel2.setText("PROPRIETÁRIO");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 300, 50));

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
        getContentPane().add(jFormattedTextField1_telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 300, 40));

        jLabel5.setBackground(new java.awt.Color(187, 187, 187));
        jLabel5.setFont(new java.awt.Font("Bodoni MT", 3, 34)); // NOI18N
        jLabel5.setText("EMAIL");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, -1, 40));

        jLabel10.setBackground(new java.awt.Color(187, 187, 187));
        jLabel10.setFont(new java.awt.Font("Bodoni MT", 3, 34)); // NOI18N
        jLabel10.setText("CNH");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 520, -1, 40));

        jComboBox1_tipoCNH.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jComboBox1_tipoCNH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jComboBox1_tipoCNH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jComboBox1_tipoCNH, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 580, 140, 40));

        jLabel9.setFont(new java.awt.Font("Bodoni MT", 3, 34)); // NOI18N
        jLabel9.setText("TIPO CNH");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 580, 190, -1));

        jComboBox1_TipoDoProprietário.setFont(new java.awt.Font("Bodoni MT", 3, 24)); // NOI18N
        jComboBox1_TipoDoProprietário.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jComboBox1_TipoDoProprietário.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1_TipoDoProprietário.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1_TipoDoProprietárioActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1_TipoDoProprietário, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 140, 40));

        jTextField1_Nome.setBackground(new java.awt.Color(153, 153, 153));
        jTextField1_Nome.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jTextField1_Nome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jTextField1_Nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 350, 40));

        jTextField1_razaoSocial.setBackground(new java.awt.Color(153, 153, 153));
        jTextField1_razaoSocial.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jTextField1_razaoSocial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jTextField1_razaoSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 350, 40));

        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "TIPO DE PROPRIETÁRIO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 25))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 350, 110));

        jLabel10_nome.setBackground(new java.awt.Color(187, 187, 187));
        jLabel10_nome.setFont(new java.awt.Font("Bodoni MT", 3, 34)); // NOI18N
        jLabel10_nome.setText("NOME");
        getContentPane().add(jLabel10_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, 40));

        jButton_iNCLUIR.setBackground(new java.awt.Color(153, 153, 153));
        jButton_iNCLUIR.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jButton_iNCLUIR.setForeground(new java.awt.Color(255, 51, 153));
        jButton_iNCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/skrskrksr.png"))); // NOI18N
        jButton_iNCLUIR.setText("  CADASTRAR");
        jButton_iNCLUIR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_iNCLUIR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_iNCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_iNCLUIRActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_iNCLUIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 290, 290, 60));

        jLabel8_cpf.setBackground(new java.awt.Color(187, 187, 187));
        jLabel8_cpf.setFont(new java.awt.Font("Bodoni MT", 3, 34)); // NOI18N
        jLabel8_cpf.setText("CPF");
        getContentPane().add(jLabel8_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 80, 40));

        jLabel9_CNPJ.setBackground(new java.awt.Color(187, 187, 187));
        jLabel9_CNPJ.setFont(new java.awt.Font("Bodoni MT", 3, 34)); // NOI18N
        jLabel9_CNPJ.setText("CNPJ");
        getContentPane().add(jLabel9_CNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 100, 40));

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
        getContentPane().add(jFormattedTextField1_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 300, 40));

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
        getContentPane().add(jFormattedTextField1_CNPJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 300, 40));

        jLabel10_razaoSocial.setBackground(new java.awt.Color(187, 187, 187));
        jLabel10_razaoSocial.setFont(new java.awt.Font("Bodoni MT", 3, 34)); // NOI18N
        jLabel10_razaoSocial.setText("RAZÃO SOCIAL");
        getContentPane().add(jLabel10_razaoSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 290, 40));

        jLabel8.setBackground(new java.awt.Color(187, 187, 187));
        jLabel8.setFont(new java.awt.Font("Bodoni MT", 3, 34)); // NOI18N
        jLabel8.setText("TELEFONE");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, 40));

        jTextField1_EMAIL.setBackground(new java.awt.Color(153, 153, 153));
        jTextField1_EMAIL.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jTextField1_EMAIL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jTextField1_EMAIL, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 350, 40));

        jTextField1_CNH.setBackground(new java.awt.Color(153, 153, 153));
        jTextField1_CNH.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jTextField1_CNH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jTextField1_CNH, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 520, 300, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/FundoTelas.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton_iNCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_iNCLUIRActionPerformed
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
                    Proprietario propri = new Proprietario(0, tipoProprietario.valueOf(tipoPropri),
                            jFormattedTextField1_cpf.getText(), jTextField1_Nome.getText(), jFormattedTextField1_telefone.getText(),
                            jTextField1_EMAIL.getText(), Integer.parseInt(jTextField1_CNH.getText()), CategoriaCNH.valueOf(CatCNH));
                    proprietariosDAO.incluirProprietario(propri);
                    JOptionPane.showMessageDialog(rootPane, "Proprietário: " + jTextField1_Nome.getText() + ", cadastrado com sucesso !");

                    limparCampos();
                    
                    TelaPrincipal pog = new TelaPrincipal();
                    pog.setVisible(true);
                    this.dispose();
                    
                } else if (jComboBox1_TipoDoProprietário.getSelectedIndex() == 1) {
                    
                    ProprietariosDAO proprietariosDAO = new ProprietariosDAO();
                    Proprietario propri = new Proprietario(0, tipoProprietario.valueOf(tipoPropri),
                            jFormattedTextField1_CNPJ.getText(), jTextField1_razaoSocial.getText(), jFormattedTextField1_telefone.getText(),
                            jTextField1_EMAIL.getText(), Integer.parseInt(jTextField1_CNH.getText()), CategoriaCNH.valueOf(CatCNH));
                    proprietariosDAO.incluirProprietario(propri);
                    JOptionPane.showMessageDialog(rootPane, "Proprietário do tipo: " + jTextField1_razaoSocial.getText() + ", cadastrado com sucesso !");
                    limparCampos();
                    
                    TelaPrincipal pog = new TelaPrincipal();
                    pog.setVisible(true);
                    this.dispose();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButton_iNCLUIRActionPerformed

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

    private void jFormattedTextField1_cpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextField1_cpfMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1_cpfMouseClicked

    private void jFormattedTextField1_CNPJMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextField1_CNPJMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1_CNPJMouseClicked

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
            java.util.logging.Logger.getLogger(TelaProprietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProprietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProprietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProprietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProprietarios().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_iNCLUIR;
    private javax.swing.JComboBox<tipoProprietario> jComboBox1_TipoDoProprietário;
    private javax.swing.JComboBox<CategoriaCNH> jComboBox1_tipoCNH;
    private javax.swing.JFormattedTextField jFormattedTextField1_CNPJ;
    private javax.swing.JFormattedTextField jFormattedTextField1_cpf;
    private javax.swing.JFormattedTextField jFormattedTextField1_telefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel10_nome;
    private javax.swing.JLabel jLabel10_razaoSocial;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel8_cpf;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel9_CNPJ;
    private javax.swing.JTextField jTextField1_CNH;
    private javax.swing.JTextField jTextField1_EMAIL;
    private javax.swing.JTextField jTextField1_Nome;
    private javax.swing.JTextField jTextField1_razaoSocial;
    // End of variables declaration//GEN-END:variables

    private void carregarComboBox() {
        jComboBox1_TipoDoProprietário.setModel(new DefaultComboBoxModel<>(tipoProprietario.values()));
        jComboBox1_tipoCNH.setModel(new DefaultComboBoxModel<>(CategoriaCNH.values()));
    }

}
