/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.cetak;

import com.mysql.jdbc.PreparedStatement;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.EditorKit;
import javax.swing.text.html.HTMLEditorKit;
import main.Koneksi;

public class CetakDataPasien extends javax.swing.JFrame {

    public void Cetak(){
        String html = "<H4><center>Laporan Data Pasien Puskesmas</center></h4>"+
                "<table width='98%' border='0' align='center' cellpadding='5' cellspacing='1'>"+
                    "<tr>"+
                        "<td bgcolor='#CCCCCC' align='center'><strong>Kode Pasien</Strong></td>"+
                        "<td bgcolor='#CCCCCC' align='center'><strong>Nama Pasien</Strong></td>"+
                        "<td bgcolor='#CCCCCC' align='center'><strong>Jenis Kelamin</Strong></td>"+
                        "<td bgcolor='#CCCCCC' align='center'><strong>Umur</Strong></td>"+
                        "<td bgcolor='#CCCCCC' align='center'><strong>Alamat</Strong></td>"+
                        "<td bgcolor='#CCCCCC' align='center'><strong>No HP</Strong></td>"+
                    "<tr>";
        
        try{
            String sql = "SELECT * FROM pasien";
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                html = html + 
                    "<tr>" +
                        "<td bgcolor='#EEEEEE'>"+res.getString("id_pasien")+"</td>"+
                        "<td bgcolor='#F8F8F8'>"+res.getString("nama_pasien")+"</td>"+
                        "<td bgcolor='#F8F8F8'>"+res.getString("jenis_kelamin")+"</td>"+
                        "<td bgcolor='#F8F8F8'>"+res.getString("umur")+"</td>"+
                        "<td bgcolor='#F8F8F8'>"+res.getString("alamat")+"</td>"+
                        "<td bgcolor='#F8F8F8'>"+res.getString("no_hp")+"</td>"+
                    "</tr>";
            }
            
            EditorKit x = new HTMLEditorKit();
            tampilcetak.setEditorKit(x);
            tampilcetak.setText(html);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public CetakDataPasien() {
        initComponents();
        Cetak();
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
        tampilcetak = new javax.swing.JEditorPane();
        btPrint = new javax.swing.JButton();
        btClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tampilcetak.setEditable(false);
        jScrollPane1.setViewportView(tampilcetak);

        btPrint.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btPrint.setText("Cetak");
        btPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrintActionPerformed(evt);
            }
        });

        btClose.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btClose.setText("Close");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(btPrint)
                        .addGap(31, 31, 31)
                        .addComponent(btClose)
                        .addGap(0, 113, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPrint)
                    .addComponent(btClose))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrintActionPerformed
        // TODO add your handling code here:
        try{
            tampilcetak.print();
        } catch (PrinterException ex){
            Logger.getLogger(CetakBuktiPembayaran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btPrintActionPerformed

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btCloseActionPerformed

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
            java.util.logging.Logger.getLogger(CetakDataPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CetakDataPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CetakDataPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CetakDataPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CetakDataPasien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btPrint;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane tampilcetak;
    // End of variables declaration//GEN-END:variables
}
