/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.rawat.rawatjalan;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import main.Koneksi;
import main.cetak.CetakDataRawatJalan;

/**
 *
 * @author User
 */
public class DataRawatJalanForm extends javax.swing.JInternalFrame {

    private void tampilkanData(){ 
        DefaultTableModel tableModel;
        tableModel = (DefaultTableModel)tblrawatjalan.getModel();
        tableModel.getDataVector().removeAllElements();
        
        try{
            int no = 1;
            String sql = "SELECT * FROM rawat_jalan "
                    + "INNER JOIN pemeriksaan ON pemeriksaan.kode_periksa=rawat_jalan.kode_periksa "
                    + "INNER JOIN pasien ON pasien.id_pasien=pemeriksaan.id_pasien "
                    + "INNER JOIN obat ON obat.kode_obat=rawat_jalan.kode_obat ";
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                tableModel.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(13),res.getString(20),res.getString(19), res.getString(21), res.getString(4), res.getString(5)});    
            }
            
        }catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public DataRawatJalanForm() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)getUI()).setNorthPane(null);
        tampilkanData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDataRawatJalan = new javax.swing.JPanel();
        jScrollPane47 = new javax.swing.JScrollPane();
        tblrawatjalan = new javax.swing.JTable();
        jLabel77 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        btnformrawatjalan = new javax.swing.JButton();
        btnrefresh = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        panelDataRawatJalan.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane47.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        tblrawatjalan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode Rawat", "Kode Pemeriksaan", "Nama Pasien", "Tipe Obat", "Nama Obat", "Harga Obat", "Jumlah Obat", "Total Harga"
            }
        ));
        tblrawatjalan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane47.setViewportView(tblrawatjalan);

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(102, 102, 255));
        jLabel77.setText("Data Rawat Jalan");

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Group.png"))); // NOI18N
        jButton21.setText(" Print");
        jButton21.setFocusable(false);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        btnformrawatjalan.setText("Kelola Data Rawat Jalan");
        btnformrawatjalan.setFocusable(false);
        btnformrawatjalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnformrawatjalanActionPerformed(evt);
            }
        });

        btnrefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Group 2803.png"))); // NOI18N
        btnrefresh.setText(" Refresh");
        btnrefresh.setFocusable(false);
        btnrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDataRawatJalanLayout = new javax.swing.GroupLayout(panelDataRawatJalan);
        panelDataRawatJalan.setLayout(panelDataRawatJalanLayout);
        panelDataRawatJalanLayout.setHorizontalGroup(
            panelDataRawatJalanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataRawatJalanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnrefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnformrawatjalan)
                .addGap(18, 18, 18)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addGroup(panelDataRawatJalanLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelDataRawatJalanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane47, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelDataRawatJalanLayout.setVerticalGroup(
            panelDataRawatJalanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataRawatJalanLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel77)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane47, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelDataRawatJalanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnformrawatjalan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnrefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelDataRawatJalan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelDataRawatJalan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnformrawatjalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnformrawatjalanActionPerformed
        RawatJalanForm rawatJalan = new RawatJalanForm();
        this.getDesktopPane().add(rawatJalan);
        Dimension gs = this.getDesktopPane().getSize();
        Dimension cs = rawatJalan.getSize();

        rawatJalan.setLocation((gs.width - cs.width) / 2, (gs.height - cs.height) / 2);

        rawatJalan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnformrawatjalanActionPerformed

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
        tampilkanData();
    }//GEN-LAST:event_btnrefreshActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        CetakDataRawatJalan dataRawatJalan = new CetakDataRawatJalan();
        dataRawatJalan.setVisible(true);
    }//GEN-LAST:event_jButton21ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnformrawatjalan;
    private javax.swing.JButton btnrefresh;
    private javax.swing.JButton jButton21;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JScrollPane jScrollPane47;
    private javax.swing.JPanel panelDataRawatJalan;
    private javax.swing.JTable tblrawatjalan;
    // End of variables declaration//GEN-END:variables
}
