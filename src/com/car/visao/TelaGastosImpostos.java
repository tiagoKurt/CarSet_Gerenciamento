package com.car.visao;

import com.car.Enumerations.ClassificacaoGastos;
import com.car.Ferramentas.limitaCaracteres;
import com.car.Modelos.GastosImposto;
import com.car.persistencia.GastosImpostosDao;
import com.car.persistencia.VeiculosDAO;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaGastosImpostos extends javax.swing.JFrame {

    public TelaGastosImpostos() {
        try {
            initComponents();
            
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Rectangle bounds = env.getMaximumWindowBounds();
            setLocationRelativeTo(null);
            int largura = bounds.width;
            int altura = bounds.height;
            setSize(largura, altura);
            setLocation(0, 0);
            
            jTextField1_ValoGastoImposto.setDocument(new limitaCaracteres(10, limitaCaracteres.tipoEntrada.PRECO));
            
            puxarDadosComboBox();
        } catch (Exception ex) {
            Logger.getLogger(TelaGastosImpostos.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextField1_dataVisitaMecanico = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jComboBox1_veiculos = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextField1_TipoDoVeiculo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField1_descricaoServico = new javax.swing.JTextField();
        jTextField1_ValoGastoImposto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton_iNCLUIR = new javax.swing.JButton();
        jButton4_voltar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/pinkLogoMenorzinha.gif"))); // NOI18N
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Bodoni MT", 3, 36)); // NOI18N
        jLabel2.setText("IMPOSTOS");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 230, 50));

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
        getContentPane().add(jFormattedTextField1_dataVisitaMecanico, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 570, 210, 50));

        jLabel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "DATA DO GASTO", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 530, 300, 110));

        jComboBox1_veiculos.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jComboBox1_veiculos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jComboBox1_veiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1_veiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1_veiculosActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1_veiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 570, 220, 50));

        jLabel9.setFont(new java.awt.Font("Bodoni MT", 3, 25)); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "PLACA DO VEÍCULO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 22), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, 380, 110));

        jTextField1_TipoDoVeiculo.setFont(new java.awt.Font("Bodoni MT", 3, 20)); // NOI18N
        jTextField1_TipoDoVeiculo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(jTextField1_TipoDoVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 320, 50));

        jLabel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "TIPO DO VEÍCULO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 380, 110));

        jTextField1_descricaoServico.setFont(new java.awt.Font("Bodoni MT", 3, 20)); // NOI18N
        jTextField1_descricaoServico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(jTextField1_descricaoServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 650, 50));

        jTextField1_ValoGastoImposto.setFont(new java.awt.Font("Bodoni MT", 3, 20)); // NOI18N
        jTextField1_ValoGastoImposto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        getContentPane().add(jTextField1_ValoGastoImposto, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 430, 180, 50));

        jLabel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "VALOR GASTO", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 390, 300, 110));

        jLabel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "DESCRIÇÃO DO SERVIÇO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 21), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 710, 110));

        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "PREENCHA AS INFORMAÇÕES", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 28), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 780, 490));

        jButton_iNCLUIR.setBackground(new java.awt.Color(102, 102, 102));
        jButton_iNCLUIR.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jButton_iNCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/skrskrksr.png"))); // NOI18N
        jButton_iNCLUIR.setText("    CADASTRAR");
        jButton_iNCLUIR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jButton_iNCLUIR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_iNCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_iNCLUIRActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_iNCLUIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 330, 290, 60));

        jButton4_voltar.setBackground(new java.awt.Color(102, 102, 102));
        jButton4_voltar.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jButton4_voltar.setForeground(new java.awt.Color(255, 0, 153));
        jButton4_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/voltar.png"))); // NOI18N
        jButton4_voltar.setText("VOLTAR");
        jButton4_voltar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jButton4_voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4_voltarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4_voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 630, 140, 40));

        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 220, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/FundoTelas.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void puxarDadosComboBox() throws Exception {

        try {
            VeiculosDAO veic = new VeiculosDAO();
            ResultSet rs = veic.listarVeiculos();

            while (rs.next()) {
                jComboBox1_veiculos.addItem(rs.getString(1));
            }
        } catch (Exception ex) {

        }
    }
    
    private void jFormattedTextField1_dataVisitaMecanicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1_dataVisitaMecanicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1_dataVisitaMecanicoActionPerformed

    private void jComboBox1_veiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1_veiculosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1_veiculosActionPerformed

    private void jButton_iNCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_iNCLUIRActionPerformed
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
            
            limparCampos();
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, err);
        }
    }//GEN-LAST:event_jButton_iNCLUIRActionPerformed

    public void limparCampos() {
        jComboBox1_veiculos.setSelectedIndex(0);
        jTextField1_TipoDoVeiculo.setText("");
        jTextField1_descricaoServico.setText("");
        jTextField1_ValoGastoImposto.setText("");
        jFormattedTextField1_dataVisitaMecanico.setText("");
    }

    private void jButton4_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4_voltarActionPerformed
        // TODO add your handling code here:
        TelaDeGastos principal = new TelaDeGastos();
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
            java.util.logging.Logger.getLogger(TelaGastosImpostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGastosImpostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGastosImpostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGastosImpostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGastosImpostos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4_voltar;
    private javax.swing.JButton jButton_iNCLUIR;
    private javax.swing.JComboBox<String> jComboBox1_veiculos;
    private javax.swing.JFormattedTextField jFormattedTextField1_dataVisitaMecanico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1_TipoDoVeiculo;
    private javax.swing.JTextField jTextField1_ValoGastoImposto;
    private javax.swing.JTextField jTextField1_descricaoServico;
    // End of variables declaration//GEN-END:variables
}
