/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Rene Jose
 */
public class RedimensionadorDeColumnas {
    public static void ajustarAnchoColumnas(JTable table) {
        TableColumnModel columnModel = table.getColumnModel();
        for (int col = 0; col < table.getColumnCount(); col++) {

            int maxwidth = 0;
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer rend= table.getCellRenderer(row, col);
                Object value = table.getValueAt(row, col);
                Component comp= rend.getTableCellRendererComponent(table,
                                value,
                                false,
                                false,
                                row,
                                col);
                maxwidth = Math.max(comp.getPreferredSize().width, maxwidth);
            } // para fila
            TableColumn column = columnModel.getColumn(col);
            column.setPreferredWidth(maxwidth);
        } // para columnas 
    }

     static class Render extends DefaultTableCellRenderer {

        JLabel l = new JLabel("");
  
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            table.setFont(new java.awt.Font("Tahoma", 0, 13));
            table.getTableHeader().setFont(new Font("Cooper Black", 0, 12));
            table.getTableHeader().setBackground(new java.awt.Color(14, 14, 162));
            table.getTableHeader().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 14, 162)));

            table.getTableHeader().setForeground(Color.white);
            if (value instanceof JButton) {
                JButton btn = (JButton) value;
                return btn;
            }
            if (value instanceof JLabel) {
                Border blackline = BorderFactory.createLineBorder(Color.black);
                JLabel lbl = (JLabel) value;
                lbl.setOpaque(true);
                lbl.setBorder(blackline);
                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                return lbl;
            }     
            table.setRowHeight(24);
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        }
     
        
    }
     
      public static void centrar_datos(JTable tabla){
 
           DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
            modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);            
            for (int i = 0; i < tabla.getColumnModel().getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
        }

                    
        }
      
      public static void estilo_tabla(JTable tabla){  
       tabla.setDefaultRenderer(Object.class, new Render());
      }
     
      public static void ganafoco(JTable table) {
       // table.setFont(new java.awt.Font("Arial Black", 0, 13));
        table.getTableHeader().setFont(new Font("Arial Black", 1, 14));
        table.getTableHeader().setBackground(new java.awt.Color(14, 14, 162));
        table.getTableHeader().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 14, 162)));
        table.getTableHeader().setForeground(new java.awt.Color(255,255, 255));
        //table.setRowHeight(30);

    }
      public static void pierdefoco(JTable table){
        table.setFont(new java.awt.Font("Tahoma", 0, 13));
        table.getTableHeader().setFont(new Font("Cooper Black", 0, 12));
        table.getTableHeader().setBackground(new java.awt.Color(231, 231,253));
        table.getTableHeader().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(14, 14, 162)));
        table.getTableHeader().setForeground(Color.BLACK);
    }
      
     class Renderizar_tablaproduc extends DefaultTableCellRenderer{

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            
          return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);  
        }
     
     }
      
    public static void dar_estilo_busqueda(JTable table) {
        table.getTableHeader().setFont(new Font("Arial Black", 0, 14));
        table.getTableHeader().setSize(table.getWidth(), 60);
        
        table.getTableHeader().setForeground(Color.BLACK);
        table.getTableHeader().setBackground(new java.awt.Color(227, 227, 227));
        // table.getTableHeader().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,217,217)));
        table.getTableHeader().setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        table.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        table.setIntercellSpacing(new Dimension(0, 0));

        table.setRowHeight(35);
        table.getTableHeader().setAlignmentX(13);
        
        //para el borde
        // table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(227,227,227)));
    }
     
    
    class miRender implements javax.swing.table.TableCellRenderer{
    TableCellRenderer tcr;
//    public miRender(TableCellRenderer tcr){
//        this.tcr = tcr;
//    }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
           javax.swing.JComponent wth = (javax.swing.JComponent) tcr.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        javax.swing.JLabel label = (javax.swing.JLabel)wth;
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        return wth;
        }
}
    
   

}





