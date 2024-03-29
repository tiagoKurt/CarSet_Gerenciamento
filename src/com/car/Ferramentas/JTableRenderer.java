package com.car.Ferramentas;

import java.awt.Component;
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;

public class JTableRenderer extends DefaultTableCellRenderer{
        JLabel JlabelLogo = new JLabel();
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col){
            if(isSelected){
            this.setBackground(table.getBackground());
            this.setForeground(table.getForeground());
            
            }else{
            this.setBackground(table.getBackground());
            this.setForeground(table.getForeground());
            }
            ImageIcon logo = new ImageIcon(table.getValueAt(row, col -1).toString());
            JlabelLogo.setText("");
            logo.setImage(logo.getImage().getScaledInstance(table.getRowHeight(), table.getRowHeight(), 1));
            JlabelLogo.setIcon(logo);
            JlabelLogo.setHorizontalAlignment(CENTER);
            return JlabelLogo;
        }
}