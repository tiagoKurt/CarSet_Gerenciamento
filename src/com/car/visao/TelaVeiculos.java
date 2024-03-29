package com.car.visao;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import com.car.Enumerations.CategoriaVeiculos;
import com.car.Enumerations.TipoCombustivel;
import com.car.Enumerations.TipoDoVeiculo;
import com.car.Ferramentas.limitaCaracteres;
import com.car.Modelos.Modelos;
import com.car.Modelos.Veiculos;
import com.car.persistencia.IModelosDAO;
import com.car.persistencia.MarcasDAO;
import com.car.persistencia.ModelosDAO;
import com.car.persistencia.VeiculosDAO;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TelaVeiculos extends javax.swing.JFrame {

    String categoriaVeiculo;
    String tipoVeiculo;
    String tipoCombustivel;

    public TelaVeiculos() {
        initComponents();

        VeiculosDAO veiculosDAO = null;
        
        try {
            carregarComboBox();
            puxarMarcasCBBox();
        } catch (Exception e) {

        }
        jTextField1_placa.setDocument(new limitaCaracteres(7, limitaCaracteres.tipoEntrada.PLACA));
        jTextField1_quilometragem.setDocument(new limitaCaracteres(15, limitaCaracteres.tipoEntrada.PRECO));

        categoriaVeiculo = CategoriaVeiculos.HATCH + "";
        tipoVeiculo = TipoDoVeiculo.PASSEIO + "";
        tipoCombustivel = TipoCombustivel.GASOLINA + "";

        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        int largura = bounds.width;
        int altura = bounds.height;
        setSize(largura, altura);
        setLocation(0, 0);

        try {
            puxarDadosComboBox();
        } catch (Exception e) {
        }

    }

    public void puxarDadosComboBox() throws Exception {

        try {
            ModelosDAO mod = new ModelosDAO();
            ResultSet rs = mod.listarModelos(jComboBox2_Marca.getSelectedItem().toString());
            while (rs.next()) {
                jComboBox2_Modelo.addItem(rs.getString(1));
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jComboBox2_Marca.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1_OpcaoProprietario = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10_imagemModelos = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox2_Marca = new javax.swing.JComboBox<>();
        jButton4_voltar = new javax.swing.JButton();
        jComboBox2_TipoDoVeiculo = new javax.swing.JComboBox<>();
        jComboBox1_categoriaVeiculo = new javax.swing.JComboBox<>();
        jComboBox2_Modelo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2_TipoCombustivel = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1_placa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField1_quilometragem = new javax.swing.JTextField();
        jButton_iNCLUIR = new javax.swing.JButton();
        jButton_iNCLUIR1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1_OpcaoProprietarioLayout = new javax.swing.GroupLayout(jDialog1_OpcaoProprietario.getContentPane());
        jDialog1_OpcaoProprietario.getContentPane().setLayout(jDialog1_OpcaoProprietarioLayout);
        jDialog1_OpcaoProprietarioLayout.setHorizontalGroup(
            jDialog1_OpcaoProprietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1_OpcaoProprietarioLayout.setVerticalGroup(
            jDialog1_OpcaoProprietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/pinkLogoMenorzinha.gif"))); // NOI18N
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Bodoni MT", 3, 36)); // NOI18N
        jLabel2.setText("CADASTRO DE VEÍCULOS");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 480, 30));

        jLabel10_imagemModelos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        getContentPane().add(jLabel10_imagemModelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 310, 200));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Bodoni MT", 3, 25)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("IMAGEM DO MODELO");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 300, 30));

        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 480, -1));

        jLabel14.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jLabel14.setText("MARCA");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, 30));

        jComboBox2_Marca.setFont(new java.awt.Font("Bodoni MT", 3, 22)); // NOI18N
        jComboBox2_Marca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jComboBox2_Marca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox2_Marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2_MarcaActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2_Marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 310, 40));

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

        jComboBox2_TipoDoVeiculo.setFont(new java.awt.Font("Bodoni MT", 3, 22)); // NOI18N
        jComboBox2_TipoDoVeiculo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jComboBox2_TipoDoVeiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jComboBox2_TipoDoVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 310, 40));

        jComboBox1_categoriaVeiculo.setFont(new java.awt.Font("Bodoni MT", 3, 22)); // NOI18N
        jComboBox1_categoriaVeiculo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jComboBox1_categoriaVeiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jComboBox1_categoriaVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 310, 40));

        jComboBox2_Modelo.setFont(new java.awt.Font("Bodoni MT", 3, 22)); // NOI18N
        jComboBox2_Modelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jComboBox2_Modelo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox2_Modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2_ModeloActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 310, 40));

        jLabel11.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jLabel11.setText("COMBUSTIVEL");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, -1, 30));

        jComboBox2_TipoCombustivel.setFont(new java.awt.Font("Bodoni MT", 3, 22)); // NOI18N
        jComboBox2_TipoCombustivel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jComboBox2_TipoCombustivel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox2_TipoCombustivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2_TipoCombustivelActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2_TipoCombustivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 310, 40));

        jLabel8.setFont(new java.awt.Font("Bodoni MT", 3, 30)); // NOI18N
        jLabel8.setText("PLACA");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 550, -1, 30));

        jLabel9.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jLabel9.setText("MODELO");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, -1, 30));

        jLabel5.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jLabel5.setText("CATEGORIA");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, -1, 30));

        jLabel7.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jLabel7.setText("TIPO");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 70, 30));

        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true), "SELECIONE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 28), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 720, 420));

        jTextField1_placa.setFont(new java.awt.Font("Bodoni MT", 3, 24)); // NOI18N
        jTextField1_placa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jTextField1_placa, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 580, 260, 40));

        jLabel12.setFont(new java.awt.Font("Bodoni MT", 3, 30)); // NOI18N
        jLabel12.setText("KM/s ATUAL");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 550, -1, 30));

        jTextField1_quilometragem.setFont(new java.awt.Font("Bodoni MT", 3, 24)); // NOI18N
        jTextField1_quilometragem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        getContentPane().add(jTextField1_quilometragem, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 580, 260, 40));

        jButton_iNCLUIR.setBackground(new java.awt.Color(102, 102, 102));
        jButton_iNCLUIR.setFont(new java.awt.Font("Bodoni MT", 3, 26)); // NOI18N
        jButton_iNCLUIR.setForeground(new java.awt.Color(0, 0, 0));
        jButton_iNCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/skrskrksr.png"))); // NOI18N
        jButton_iNCLUIR.setText("    CADASTRAR");
        jButton_iNCLUIR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton_iNCLUIR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_iNCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_iNCLUIRActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_iNCLUIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 330, 290, 60));

        jButton_iNCLUIR1.setBackground(new java.awt.Color(102, 102, 102));
        jButton_iNCLUIR1.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jButton_iNCLUIR1.setForeground(new java.awt.Color(255, 51, 153));
        jButton_iNCLUIR1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/car/visao/icons/candidato (1).png"))); // NOI18N
        jButton_iNCLUIR1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "VEICULOS CADASTRADOS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_BOTTOM, new java.awt.Font("Bodoni MT", 3, 19), new java.awt.Color(0, 0, 0))); // NOI18N
        jButton_iNCLUIR1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_iNCLUIR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_iNCLUIR1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_iNCLUIR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 400, 290, 70));

        jLabel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "OPÇÕES", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 28), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 290, 330, 210));

        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "DIGITE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Bodoni MT", 3, 28), new java.awt.Color(255, 255, 255))); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, 720, 140));

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

    private void jComboBox2_ModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2_ModeloActionPerformed
        try {
            puxarImagemMarca();
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_jComboBox2_ModeloActionPerformed

    private void jComboBox2_TipoCombustivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2_TipoCombustivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2_TipoCombustivelActionPerformed

    private void jButton_iNCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_iNCLUIRActionPerformed
        try {
            if(jTextField1_placa.getText().matches("") || jTextField1_quilometragem.getText().matches("")){
                JOptionPane.showMessageDialog(rootPane, "Alguns campos não foram preechidos!");
            }else{
            if(jComboBox2_TipoDoVeiculo.getSelectedIndex() == 0){
                tipoVeiculo = TipoDoVeiculo.PASSEIO+"";
            }else if(jComboBox2_TipoDoVeiculo.getSelectedIndex() == 1){
                tipoVeiculo = TipoDoVeiculo.CARGA+"";
            }else if(jComboBox2_TipoDoVeiculo.getSelectedIndex() == 2){
                tipoVeiculo = TipoDoVeiculo.MISTO+"";
            }else if(jComboBox2_TipoDoVeiculo.getSelectedIndex() == 3){
                tipoVeiculo = TipoDoVeiculo.COMPETICAO+"";
            }else if(jComboBox2_TipoDoVeiculo.getSelectedIndex() == 4){
                tipoVeiculo = TipoDoVeiculo.TRACAO+"";
            }else if (jComboBox2_TipoDoVeiculo.getSelectedIndex() == 5){
                tipoVeiculo = TipoDoVeiculo.ESPECIAL+"";
            }else if(jComboBox2_TipoDoVeiculo.getSelectedIndex() == 6){
                tipoVeiculo = TipoDoVeiculo.COLECAO+"";
            }
            
            if(jComboBox2_TipoCombustivel.getSelectedIndex() == 0 ){
                tipoCombustivel = TipoCombustivel.GASOLINA+"";
            }else if(jComboBox2_TipoCombustivel.getSelectedIndex() == 1){
                tipoCombustivel = TipoCombustivel.FLEX+"";
            }else if(jComboBox2_TipoCombustivel.getSelectedIndex() == 2){
                tipoCombustivel = TipoCombustivel.GNV+"";
            }else if(jComboBox2_TipoCombustivel.getSelectedIndex() == 3){
                tipoCombustivel = TipoCombustivel.ELETRICO+"";
            }
            
            if(jComboBox1_categoriaVeiculo.getSelectedIndex() == 0){
                categoriaVeiculo = CategoriaVeiculos.HATCH+"";
            }else if(jComboBox1_categoriaVeiculo.getSelectedIndex() == 1){
                categoriaVeiculo = CategoriaVeiculos.SEDAN+"";
            }else if(jComboBox1_categoriaVeiculo.getSelectedIndex() == 2){
                categoriaVeiculo = CategoriaVeiculos.SUV+"";
            }else if(jComboBox1_categoriaVeiculo.getSelectedIndex() == 4){
                categoriaVeiculo = CategoriaVeiculos.PICAPE+"";
            }else if(jComboBox1_categoriaVeiculo.getSelectedIndex() == 5){
                categoriaVeiculo = CategoriaVeiculos.UTILITARIO+"";
            }
            
            
           
            IModelosDAO modelooo = null;
            modelooo = new ModelosDAO();
            
            Veiculos veic = new Veiculos(0, jTextField1_placa.getText(), TipoDoVeiculo.valueOf(tipoVeiculo),
                    CategoriaVeiculos.valueOf(categoriaVeiculo),
                    modelooo.listagemDeModelos().get(0), 
                    TipoCombustivel.valueOf(tipoCombustivel), 
                    Integer.parseInt(jTextField1_quilometragem.getText()));
          
            ArrayList<Modelos> lista = modelooo.listagemDeModelos();
            for (int i = 0; i < lista.size(); i++) {
                if (jComboBox2_Modelo.getSelectedItem().equals(lista.get(i).getDescricao())) {
                    veic.setModelo(lista.get(i));
                }
            }
             VeiculosDAO veiculosDAO = null;    
            veiculosDAO = new VeiculosDAO();
            veiculosDAO.inserirVeiculos(veic);
            limparTela();
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, err);
        }
        
    }//GEN-LAST:event_jButton_iNCLUIRActionPerformed

    private void jComboBox2_MarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2_MarcaActionPerformed

    }//GEN-LAST:event_jComboBox2_MarcaActionPerformed

    private void jButton_iNCLUIR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_iNCLUIR1ActionPerformed
        TelaRelacaoVeiculos veic = new TelaRelacaoVeiculos();
        veic.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton_iNCLUIR1ActionPerformed

    public void limparTela(){
        jTextField1_placa.setText("");
        jTextField1_quilometragem.setText("");
        jComboBox1_categoriaVeiculo.setSelectedIndex(0);
        jComboBox2_Marca.setSelectedIndex(0);
        jComboBox2_TipoCombustivel.setSelectedIndex(0);
        jComboBox2_Modelo.setSelectedIndex(0);
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
            java.util.logging.Logger.getLogger(TelaVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVeiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4_voltar;
    private javax.swing.JButton jButton_iNCLUIR;
    private javax.swing.JButton jButton_iNCLUIR1;
    private javax.swing.JComboBox<CategoriaVeiculos> jComboBox1_categoriaVeiculo;
    private javax.swing.JComboBox<String> jComboBox2_Marca;
    private javax.swing.JComboBox<String> jComboBox2_Modelo;
    private javax.swing.JComboBox<TipoCombustivel> jComboBox2_TipoCombustivel;
    private javax.swing.JComboBox<TipoDoVeiculo> jComboBox2_TipoDoVeiculo;
    private javax.swing.JDialog jDialog1_OpcaoProprietario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel10_imagemModelos;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1_placa;
    private javax.swing.JTextField jTextField1_quilometragem;
    // End of variables declaration//GEN-END:variables

    private void carregarComboBox() {
        jComboBox2_TipoDoVeiculo.setModel(new DefaultComboBoxModel<>(TipoDoVeiculo.values()));
        jComboBox1_categoriaVeiculo.setModel(new DefaultComboBoxModel<>(CategoriaVeiculos.values()));
        jComboBox2_TipoCombustivel.setModel(new DefaultComboBoxModel<>(TipoCombustivel.values()));
    }

}
