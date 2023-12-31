/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Controller.JDBC;
import Controller.ScreenData;
import static Controller.ScreenData.tabeltersedia;
import static Controller.ScreenData.tabeltersewa;
import Model.Mobil;
import Model.Motor;
import com.mycompany.tubes_gorentt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Holanta
 */
public class Homepage extends javax.swing.JPanel {
    ScreenData sd = new ScreenData();
    
    Object idValue;
    Object tipe_kendaraan;
    Object pengembalian;
    /**
     * Creates new form Homepage
     */
    public Homepage() {
        initComponents();
        sd.setarrMobil();
        sd.setarrMotor();
        sd.settabeltersedia();
        sd.settabeltersewa();
        
        jTable1.setModel(tabeltersedia);
        jTable2.setModel(tabeltersewa);
        
//        show_tableTersedia();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")

    public void show_tableTersedia(javax.swing.JTable jt1,javax.swing.JTable jt2){
        sd.setarrMobil();
        sd.setarrMotor();
        sd.settabeltersedia();
        sd.settabeltersewa();
        jt1.setModel(tabeltersedia);
        jt2.setModel(tabeltersewa);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("GoRent");

        jTable2.setModel(sd.tabeltersewa);
        jTable2.setRowHeight(30);
        jTable2.setShowGrid(true);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setText("Data Ketersediaan Kendaraan");

        jTable1.setModel(sd.tabeltersedia
        );
        jTable1.setRowHeight(30);
        jTable1.setShowGrid(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText("Data Kendaraan Tersewa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        Main_Menu mn = new Main_Menu();
        int selectedRow = jTable1.getSelectedRow();
        System.out.println("selected "+ selectedRow);
        if (selectedRow != -1){
            idValue = jTable1.getValueAt(selectedRow, 1);
            tipe_kendaraan  = jTable1.getValueAt(selectedRow, 2);
        }
        TransaksiDialog trs = new TransaksiDialog(mn, true, idValue.toString(), tipe_kendaraan.toString(),selectedRow);
        trs.setVisible(true);
         
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        Main_Menu main = new Main_Menu();
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow != -1){
            idValue = jTable2.getValueAt(selectedRow, 1);
            pengembalian = jTable2.getValueAt(selectedRow, 4);
        }
        PengembalianDialog pgd = new PengembalianDialog(main, true,idValue.toString(),pengembalian.toString(),selectedRow,jTable1,jTable2);
        pgd.setVisible(true);
    }//GEN-LAST:event_jTable2MouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
